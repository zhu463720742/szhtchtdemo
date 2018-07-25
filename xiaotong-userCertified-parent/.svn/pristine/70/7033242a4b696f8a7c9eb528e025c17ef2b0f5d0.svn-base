package com.xiaotong.certified.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 肖小龙
 * @create 2018-02-05 17:40
 * @desc 返回数据
 **/
public class ReturnUtils {
    /**
     *
     * @param code 状态码
     * @param msg 描述
     * @param data 数据
     * @return map
     */
    public static Map<Object, Object> returnApp(Integer code, String msg, Object data) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public static Map<Object, Object> ajaxReturn(Integer success, String message) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("code", success);
        map.put("msg", message);
        return map;
    }
}
