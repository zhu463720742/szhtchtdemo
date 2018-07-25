$(function(){
	$('.modifyShop').click(function(){
        $('.shadow').show()
        $('#add').show()
    })
    
    $('.cancel').click(function(){
        $('.appAdd').hide();
        $('.index1Wrap').show();
    })

    $('.allLi').click(function(){
        $('.index1Wrap').hide()
        $('.allDiv').show()
    });
    $('.jinYong').click(function(){
        $(this).parent().parent().addClass('trBg')
    })
    $('.jieJin').click(function(){
        $(this).parent().parent().removeClass('trBg')
    })
    $('.del').click(function(){
        $(this).parent().parent().remove();
       
    })
     $(document).on('click','.delImg',function(){
     	$(this).parent().remove()
     });
    $('.Offline').click(function(){
        $(this).parent().parent().css('background','#ebebeb')
        $(this).children('img').attr('src','images/app2-1.png')
        $(this).next().children('img').attr('src','images/app3-1.png')
    })
    $('.goLine').click(function(){
        if(!$(this).hasClass('checked')){
            $(this).addClass('checked')
            $(this).children('img').attr('src','images/app1.png')
        }else{
            $(this).removeClass('checked')
            $(this).children('img').attr('src','images/app1-1.png')
        }
    })
    $('#strLAddEdit button').click(function(){
        $('#strLAddEdit').prepend('<strong><input type="text" name="packageOrGoodsId1" placeholder="科学素材包"><img src="images/del.png" alt="" class="delImg"></strong>')
    })
    $('#strLAddApp button').click(function(){
        $('#strLAddApp').prepend('<strong><input type="text" placeholder="科学素材包" name="packageOrGoodsId"><img src="images/del.png" alt="" class="delImg"></strong>')
    })
    $('.newAdd').click(function(){
        $('#appAdd').show();
        $('.index1Wrap').hide();
    })
    //$('.editAdd').click(function(){
    //    $('#appEdit').show();
    //    $('.index1Wrap').hide();
    //})
    $('.app2EditAdd').click(function(){
        $('#app2Edit').show();
        $('.index1Wrap').hide();
    })
    //$('.sure').click(function(){
    //    $('.appAdd').hide();
    //    $('.index1Wrap').show();
    //})
    $('.newAdvertisement').click(function(){
        $('#appAddAppAddWrap').show();
        $('.index1Wrap').hide();
        queryAllGoods();
    })
    $('.pSpanColor span').click(function(){
        $(this).addClass('spanColor').siblings().removeClass('spanColor')
    })
})
function getObj(obj) {
    return document.getElementById(obj);
}
function app(n) {
    for (var i = 1; i <= 2; i++) {
        if (i == n) {
            getObj('app' + i).style.display = "block"
        } else {
            getObj('app' + i).style.display = "none"
        }
    }
};
//$(function(){
//    $('.layui-table tbody tr').click(function(){
//        $(this).children().children('i').addClass('tdImgB').parents().parents().siblings().children().children('i').removeClass('tdImgB')
//    })
//})

function xmTanUploadImg(obj){
    var file = obj.files[0];
    var reader = new FileReader();
    //读取文件过程方法
    reader.onload = function (e) {
        var img = document.getElementById("bannerImg");
        img.src = this.result;
        //或者 img.src = this.result;  //e.target == this
    };
    reader.readAsDataURL(file)
}