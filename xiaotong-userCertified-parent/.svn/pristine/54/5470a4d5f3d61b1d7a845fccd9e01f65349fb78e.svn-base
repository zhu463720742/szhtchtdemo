package com.xiaotong.certified.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaotong.certified.service.RedisService;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 远程Session的提供类
 * 
 * @author lx
 *
 */
@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private ShardedJedisPool shardedJedisPool;

	private ShardedJedis shardedJedis;
	// 分钟
	private Integer exp = 30;
	private String tokenName = "TOTAL_SHOPPING_SESSION:";
	private String randomcode = "CODE:";

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	// 获取redis连接
	private ShardedJedis getRedisClient() {
		try {
			ShardedJedis shardJedis = shardedJedisPool.getResource();
			return shardJedis;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void setToken(Integer key,  int time) {
		shardedJedis = getRedisClient();
		try {
			if (shardedJedis != null) {
				String csessionid = UUID.randomUUID().toString().replaceAll("-", "");
				shardedJedis.set(tokenName+key, csessionid);
				shardedJedis.expire(tokenName+key , time * exp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 业务操作完成，将连接返回给连接池
			if (null != shardedJedis) {
				shardedJedisPool.returnResource(shardedJedis);
			}
		}
	}

	@Override
	public String getToken(Integer key) {
		String username = null;
		try {
			shardedJedis = getRedisClient();
			if (shardedJedis == null) {
				return username;
			}
			 username = shardedJedis.get(tokenName+key);
			if (null != username) {
				// 重新计时
				shardedJedis.expire(tokenName+key , 1296000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 业务操作完成，将连接返回给连接池
			if (null != shardedJedis) {
				shardedJedisPool.returnResource(shardedJedis);
			}
		}
		return username;
	}

	@Override
	public void delToken(Integer key) {
		shardedJedis = getRedisClient();
		try {
			if (shardedJedis != null) {
				shardedJedis.del(tokenName+key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 业务操作完成，将连接返回给连接池
			if (null != shardedJedis) {
				shardedJedisPool.returnResource(shardedJedis);
			}
		}
	}
//验证码
	@Override
	public void setRandomcode(String key, String csessionid,int time) {
		shardedJedis = getRedisClient();
		try {
			if (shardedJedis != null) {
				shardedJedis.set(randomcode+key, csessionid);
				shardedJedis.expire(randomcode+key , time * exp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 业务操作完成，将连接返回给连接池
			if (null != shardedJedis) {
				shardedJedisPool.returnResource(shardedJedis);
			}
		}
		
	}

	@Override
	public String getRandomcode(String key) {
		String username = null;
		try {
			shardedJedis = getRedisClient();
			if (shardedJedis == null) {
				return username;
			}
			 username = shardedJedis.get(randomcode+key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 业务操作完成，将连接返回给连接池
			if (null != shardedJedis) {
				shardedJedisPool.returnResource(shardedJedis);
			}
		}
		return username;
	}

	@Override
	public void delRandomcode(String key) {
		shardedJedis = getRedisClient();
		try {
			if (shardedJedis != null) {
				shardedJedis.del(randomcode+key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 业务操作完成，将连接返回给连接池
			if (null != shardedJedis) {
				shardedJedisPool.returnResource(shardedJedis);
			}
		}		
	}

}
