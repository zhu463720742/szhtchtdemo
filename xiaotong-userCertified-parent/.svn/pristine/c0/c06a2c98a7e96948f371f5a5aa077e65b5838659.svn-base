function  setToken (key,value) {
    $.post(
        setTokenUrl,
        {
            key:key,
            value:value
        },
        function (data) {
            console.log(data)

        }


    )

}

function  getToken (key) {
    var value;
   /* $.post(
        getTokenUrl,
        {
            key:key
        },
        function (data) {
            console.log(data);
            console.log('--key '+data.data);
               value=data.data;
            alert(value+"-")
                return value;
        }
    )*/
    $.ajax({
        type : "post",
        url : getTokenUrl,
        data : {
            key:key
        },
        async : false,
        success : function(data){
            console.log(data);
            console.log('--key '+data.data);
            value=data.data;
            return value;
        }
    });
    return value;
}

function  delToken (key) {
    $.post(
        delTokenUrl,
        {
            key:key
        },
        function (data) {
            console.log(data)
        }


    )

}