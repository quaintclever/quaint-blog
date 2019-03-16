//页面初始化
$(function () {
    //判断用户是否登陆，如果未登录，则返回留言界面
    $.get("isLogin",{},function(data){
        if(data.userId<=0){
            //用户未登录，异常访问修改信息界面
            location.href="/quaint-sayingYK";
        }
    },"json")

    //当用户点击返回时
    $("#back").click(function(){
        location.href="/quaint-sayingYK";
    })
    //回显用户信息
    $.get("user/getLoginUser",{},function (data) {
        // console.log(data)
        $("#u-unicknameInput").val(data.userNickName)
        $("#u-address").val(data.userAddress)
        $("#u-description").val(data.userDescription)
        $("#u-says").val(data.userSays)
        $("#userId").val(data.userId)
    })

})

//修改用户信息
function update_form_submit() {
    var userNickName = $("#u-unicknameInput").val();
    var userPwd = $("#u-pwdInput").val();
    var userAddress = $("#u-address").val();
    var userDescription = $("#u-description").val();
    var userSays = $("#u-says").val();
    var userId = $("#userId").val();
    var updateJson = {userNickName:userNickName,userAddress:userAddress,userPwd:userPwd,
        userDescription:userDescription,userSays:userSays,userId:userId};
    if(userNickName==""){
        quaintAlert("昵称不可为空！")
        return false;
    }else if(userPwd.length<6){
        quaintAlert("密码至少为6位！")
        return false;
    }else{
        $.ajax({
            url:"/user/dataById",
            type: "PUT",
            contentType: 'application/json; charset=UTF-8',
            dataType:"json",
            data:JSON.stringify(updateJson),
            success:function(data){
                quaintAlert(data.text);
                setInterval(function(){
                    location.href="/quaint-sayingYK";
                },1000);
            }
        });
    }
    return false;
}

//提示信息框
function quaintAlert(msg){
    //先停止之前动画,然后展示提示信息1s后隐藏
    $("#msgDiv",parent.document).html(msg).stop(true,true).show().delay(721).hide(210);
}