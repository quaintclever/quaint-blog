//---------------------------页面操作开始----------------------------------
// 子类对父类 的 微调
	//导航条 active 
$(function(){
	for (var i=0;i<4;i++) {
		$("ul#get-nav li",parent.document).eq(i).removeClass("quaint-active");
		$("ul#show-nav li",parent.document).eq(i).slideUp(21);
	}
	$("ul#get-nav li",parent.document).eq(3).addClass("quaint-active");
	$("ul#show-nav li",parent.document).eq(3).slideDown(521);
})
$(function(){
//	实现登录弹出窗口
	$("#quaintUser").on("click",".login",function(){
		var login_view = document.getElementById("login_view");
		hidebg.style.display = "block"; //显示隐藏层
		hidebg.style.height = document.body.clientHeight + "px"; //设置隐藏层的高度为当前页面高度
		login_view.style.display = "block"; //显示弹出层
		document.getElementById("register_view").style.display = "none";
	})
	$("#register").click(function(){
		var register_view = document.getElementById("register_view");
		register_view.style.display = "block"; //显示弹出层
		document.getElementById("login_view").style.display = "none";
	})
	$(".hidden_view").click(function(){
		closeWindow();
	})

})
//关闭登录窗口
function closeWindow(){
	document.getElementById("hidebg").style.display = "none";
	document.getElementById("login_view").style.display = "none";
	document.getElementById("register_view").style.display = "none";
}

//-----------------------业务逻辑开始------------------------------

//60s倒计时实现逻辑
var countdown = 60;
function setTime(obj) {
	if (countdown <= 0) {
		obj.attr('href','javascript:sendCode();');
		obj.html("获取验证码");
		countdown = 60;//60秒过后button上的文字初始化,计时器初始化;
		return;
	} else {
		obj.attr('href','#');
		obj.html("("+countdown+"s)后重新发送") ;
		countdown--;
	}
	setTimeout(function() { setTime(obj) },1000) //每1000毫秒执行一次
}
//往邮箱发送验证码
function sendCode(){
	var uemail = $("#emailInput").val();
	if(uemail==""){
		alert("邮箱不能为空!");
		return false;
	}
	//邮箱格式验证
	var emailReg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(!emailReg.test(uemail)){
		alert("邮箱格式错误!");
		return false;
	}
	//TODO 通过ajax发送验证码到邮箱
	$.ajax({
		url:"/sendCode/"+uemail,
		type: "POST",
		contentType: 'application/json; charset=UTF-8',
		dataType:"json",
		success:function(data){
			console.log(data);
			if(data.userId=="-200"){
				alert("验证码已发送!");
			}else{
				alert("发送失败!");
			}

		}
	});
	//60s倒计时开始
	setTime($("#getCodeBtn"));
}
//拦截form 注册提交 用 ajax 提交 根据返回内容提示用户
function register_form_submit() {
	//先进行表单验证 1. 用户名密码不能为空  2. 密码长度大于6位
	var uname = $("#r-unameInput").val();
	var upwd = $("#r-pwdInput").val();
	var uemail = $("#emailInput").val();
	var ucode = $("#codeInput").val();

	if(uname==""){
		alert("用户名不能为空!");
		return false;
	}
	if(upwd==""){
		alert("密码不能为空!");
		return false;
	}else if (upwd.length<6){
		alert("密码长度必须大于6位!");
		return false;
	}
	if(uemail==""){
		alert("邮箱不能为空!");
		return false;
	}
	//邮箱格式验证
	var emailReg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(!emailReg.test(uemail)){
		alert("邮箱格式错误!");
		return false;
	}
	if(ucode==""){
		alert("验证码不能为空!");
		return false;
	}
	$.ajax({
		url:"/register",
		type: "POST",
		contentType: 'application/json; charset=UTF-8',
		data:JSON.stringify($('#register_form').serializeJSON()),
		dataType:"json",
		success:function(data){
			console.log(data);
			if(data.userId=="-501"){
				alert("验证码输入错误!");
			}else{
				alert("注册成功!");
				closeWindow();
				var str = `欢迎用户：${data.userName}！
					<button id="cancel" class="quaint-btn-rediusC30 btn btn-warning">注销</button>`;
				$("#quaintUser").html(str);
			}
		}
	});
	return false;
}

//拦截form 登录提交 用 ajax 提交 根据返回内容提示用户
function login_form_submit() {
	//先进行表单验证 1. 用户名密码不能为空  2. 密码长度大于6位
	var uname = $("#l-unameInput").val();
	var upwd = $("#l-pwdInput").val();
	if(uname==""){
		alert("用户名不可为空!");
		return false;
	}
	if(upwd==""){
		alert("密码不可为空!");
		return false;
	}else if (upwd.length<6){
		alert("密码长度必须大于6位!");
		return false;
	}
	$.ajax({
		url:"/login",
		type: "POST",
		data:$('#login_form').serialize(),
		dataType:"json",
		success:function(data){
			if(data.userId=="-404"){
				alert("用户名不存在!");
				return false;
			}else if(data.userId=="-500"){
				alert("用户密码错误!");
				return false;
			}else{
				alert("登陆成功!");
				closeWindow();
				var str = `欢迎用户：${data.userName}！
						<button id="cancel" class="quaint-btn-rediusC30 btn btn-warning">注销</button>`;
				$("#quaintUser").html(str);
			}
			console.log(data);
		}
	});
	return false;
}
$(function(){
	//当用户注销时
	$("#quaintUser").on("click","#cancel",function(){
		$.ajax({
			url:"/exit",
			type: "GET",
			dataType:"json",
			success:function(data){
				console.log(data);
				$("#quaintUser").html("<button class='login quaint-btn-rediusB30 btn btn-success'>登录</button>");
			}
		});
	})
})
