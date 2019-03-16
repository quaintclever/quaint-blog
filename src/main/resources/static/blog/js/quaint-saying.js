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
	var login_view = document.getElementById("login_view");
	var register_view = document.getElementById("register_view");
	$("#quaintUser").on("click",".login",function(){
		hidebg.style.display = "block"; //显示隐藏层
		hidebg.style.height = document.body.clientHeight + "px"; //设置隐藏层的高度为当前页面高度
		login_view.style.display = "block"; //显示弹出层
		register_view.style.display = "none";
	})
	$("#quaintBack").click(function(){
		login_view.style.display = "block"; //显示弹出层
		register_view.style.display = "none";
	})
	$("#register").click(function(){
		register_view.style.display = "block"; //显示弹出层
		login_view.style.display = "none";
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
//提示信息框
function quaintAlert(msg){
	//先停止之前动画,然后展示提示信息1s后隐藏
	$("#msgDiv",parent.document).html(msg).stop(true,true).show().delay(721).hide(210);
}
//-----------------------业务逻辑开始------------------------------

//分页显示留言开始

/*
 * 请求ajax查询最近的心情
 *
 */
$(function(){
	//默认查询第一页
	stayMessagePage(1);
	//刷新页面时 判断subject中是否有用户
	$.get("isLogin",{},function(data){
		if(data.userId>0){
			var str = `欢迎用户：${data.userNickName}！
						<button id="cancel" class="quaint-btn-rediusC30 btn btn-warning">注销</button>
						<button id="update" class="quaint-btn-rediusC30 btn btn-success">修改信息</button>`;
			$("#quaintUser").html(str);
		}else{
			$("#quaintUser").html("<button class='login quaint-btn-rediusB30 btn btn-success'>登录</button>");
		}

	},"json")
})
//当回复留言的时候
function reUserSay(sid){
	//1.先判断用户是否登陆
	$.get("isLogin",{},function(data){
		if(data.userId>0){
			//2.如果登陆判断留言是否为空,或者空字符串
			var reStr = $("#reText"+sid).val();
			if($.trim(reStr)==""){
				quaintAlert("亲,随便说两句再点吧!");
				return;
			}
			//执行回复留言逻辑
			$.ajax({
				url:"/stayMessage/data",
				type: "POST",
				contentType: 'application/json; charset=UTF-8',
				data:JSON.stringify({stayId:sid,messageContent:reStr}),
				dataType:"json",
				success:function(data){
					if(data.userId>0){
						quaintAlert("回复留言成功!");
						setInterval(function(){
							location.href="/quaint-sayingYK";
						},1000);
					}else{
						quaintAlert("回复留言失败!");
					}
				}
			});
		}else{
			quaintAlert("请先登陆在回复!");
		}
	},"json")
}
//当点击留言的时候
function userSay(){
	$.get("isLogin",{},function(data){
		if(data.userId>0){
			//执行留言操作
			var message = $("#quaintsUserSay").val();
			if($.trim(message)==""){
				quaintAlert("亲,随便说两句再点吧!");
				return;
			}else{
				$.ajax({
					url:"/stayMessage/data",
					type: "POST",
					contentType: 'application/json; charset=UTF-8',
					data:JSON.stringify({messageContent:message}),
					dataType:"json",
					success:function(data){
						if(data.userId>0){
							quaintAlert("留言成功!");
							setInterval(function(){
								location.href="/quaint-sayingYK";
							},1212);
						}else{
							quaintAlert("留言失败!");
						}
					}
				});
			}
		}else{
			hidebg.style.display = "block"; //显示隐藏层
			hidebg.style.height = document.body.clientHeight + "px"; //设置隐藏层的高度为当前页面高度
			document.getElementById("login_view").style.display = "block"; //显示弹出层
			document.getElementById("register_view").style.display = "none";

			quaintAlert("请先登陆在留言!");
		}

	},"json")
}

//分页点击调用函数
function pageClick(index){
	stayMessagePage(index);
}
//展示当指定页数据
function stayMessagePage(index){
	//设置每页显示7个数据
	var size = 7;
	$.get("stayMessage/selectStayMessageList",{pageNo:index,pageSize:size},function(data){
		showStayMessage(data);
	},"json")
}
//分页展示留言
function showStayMessage(data){
	// console.log(data);
	var stayMessages = data.list;
	let stayMessagesStr = `
			<div class="quaint-saying-box">
				<div class="quaint-f-right quaint-lineh40">
					共&nbsp;${data.total}&nbsp;条留言
				</div>
				<div class="quaint-saying-logo">留言展示</div>
			</div>
			<div class="new-saying"><span class="glyphicon glyphicon-send">&nbsp;最新留言</span></div>`;

	//--------------分页的留言的显示开始---------------
	$.ajaxSettings.async = false;
	for(let i = 0; i<stayMessages.length; i++){
		stayMessagesStr+=
			`<div class="quaint-user-saying">
				<div class="row quaint-saying-margin">
					<div class="col-sm-12">
						<div class="row">
							<div class="icon iconStr">${stayMessages[i].userNickName[0]}</div>
							<p class="quaint-indent3 quaint-say-time">
								<span>${stayMessages[i].messageStayTime}</span>
								${stayMessages[i].userNickName}
							</p>
						</div>
						<div class="row quaint-position-relative">
							<button onclick="reUserSay(${stayMessages[i].sid})" class="quaint-re-btn btn btn-sm btn-success">回复</button>
							<p class="quaint-indent3 quaint-say-content">${stayMessages[i].messageContent}</p>
							<div class="quaint-indent"><input class="reText" id="reText${stayMessages[i].sid}" type="text"></div>
						</div>
						`;
		//这里是回复添加
		$.get("stayMessage/selectReMessageList",{sid:stayMessages[i].sid},function(data){
			if (data.length>0){
				stayMessagesStr+=`
						<div class="row">
							<div class="quaint-re-div">
								<div class="col-sm-12">`;
				for(let i_r=0;i_r<data.length;i_r++){
					stayMessagesStr+=`									
									<div class="row quaint-position-relative">
										<div class="icon iconStr">${data[i_r].userNickName[0]}</div>
										<p class="quaint-indent3 quaint-say-time">
											<span>${data[i_r].messageStayTime}</span>
											${data[i_r].userNickName}
										</p>
									</div>
									<div class="row">
										<p class="quaint-indent3 quaint-say-content">${data[i_r].messageContent}</p>
									</div>`;
				}
				stayMessagesStr+=`							
								</div>
							</div>
						</div>`;
			}
		},"json");
		//回复添加结束

		stayMessagesStr+=`
						
					</div>
				</div>
				<div class="quaint-saying-hr"></div>
			</div>`;
	}
	$.ajaxSettings.async = true;
	//在quaint-live-mood后面添加生成的记忆
	$("#sayingDiv").html(stayMessagesStr);
	//--------------每页的心情说说的显示结束---------------
	//----------分页数字拼接处理开始--------------
	let pageStr = `<li onclick="pageClick(1)">&lt;&lt;</li><li onclick="pageClick(${data.prePage==0?1:data.prePage})">&lt;</li>`;
	//循环生成分页的数字
	if(data.pages<=5){
		for(let i = 1;i<=data.pages;i++){
			if(i==data.pageNum) {
				pageStr+=`<li class="on" onclick="pageClick(${i})">${i}</li>`;
			}else {
				pageStr+=`<li onclick="pageClick(${i})">${i}</li>`;
			}
		}
	} else if(data.pageNum<3){
		for(let i = 1;i<=5;i++){
			if(i==data.pageNum) {
				pageStr+=`<li class="on" onclick="pageClick(${i})">${i}</li>`;
			}else {
				pageStr+=`<li onclick="pageClick(${i})">${i}</li>`;
			}
		}
	}else if(data.pages-data.pageNum<3){
		for(let i = data.pages-4;i<=data.pages;i++){
			if(i==data.pageNum) {
				pageStr+=`<li class="on" onclick="pageClick(${i})">${i}</li>`;
			}else {
				pageStr+=`<li onclick="pageClick(${i})">${i}</li>`;
			}
		}
	}else{
		for(let i = data.pageNum-2;i<=data.pageNum+2;i++){
			if(i==data.pageNum) {
				pageStr+=`<li class="on" onclick="pageClick(${i})">${i}</li>`;
			}else {
				pageStr+=`<li onclick="pageClick(${i})">${i}</li>`;
			}
		}
	}
	pageStr+=`<li onclick="pageClick(${data.nextPage==0?data.lastPage:data.nextPage})">&gt;</li><li onclick="pageClick(${data.pages})">&gt;&gt;</li>`;
	//-----------分页数字拼接处理开始--------------
	$("#page-div").html(pageStr);

	// ajax请求后需要 刷新一下ifream的高度  否则可能出现问题
	iframeHeight();
}

//分页显示留言结束


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
	//邮箱格式验证
	var emailReg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(uemail==""){
		quaintAlert("邮箱不能为空!");
		return;
	}else if(!emailReg.test(uemail)){
		quaintAlert("邮箱格式错误!");
		return;
	}else{
		//通过ajax发送验证码到邮箱
		$.ajax({
			url:"/sendCode/"+uemail,
			type: "POST",
			contentType: 'application/json; charset=UTF-8',
			dataType:"json",
			success:function(data){
				//console.log(data);
				if(data.userId=="-200"){
					quaintAlert("验证码已发送!");
				}else if(data.userId=="-701"){
					quaintAlert("请检查邮箱是否为可用QQ邮箱！")
				}else{
					quaintAlert("发送失败!");
				}

			}
		});
		//60s倒计时开始
		setTime($("#getCodeBtn"));
	}
}
//拦截form 注册提交 用 ajax 提交 根据返回内容提示用户
function register_form_submit() {
	//先进行表单验证 1. 用户名密码不能为空  2. 密码长度大于6位
	var uname = $("#r-unameInput").val();
	var upwd = $("#r-pwdInput").val();
	var uemail = $("#emailInput").val();
	var ucode = $("#codeInput").val();

	if(uname==""){
		quaintAlert("用户名不能为空!");
		return false;
	}
	if(upwd==""){
		quaintAlert("密码不能为空!");
		return false;
	}else if (upwd.length<6){
		quaintAlert("密码长度必须大于6位!");
		return false;
	}
	if(uemail==""){
		quaintAlert("邮箱不能为空!");
		return false;
	}
	//邮箱格式验证
	var emailReg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(!emailReg.test(uemail)){
		quaintAlert("邮箱格式错误!");
		return false;
	}
	if(ucode==""){
		quaintAlert("验证码不能为空!");
		return false;
	}
	$.ajax({
		url:"/register",
		type: "POST",
		contentType: 'application/json; charset=UTF-8',
		data:JSON.stringify($('#register_form').serializeJSON()),
		dataType:"json",
		success:function(data){
			//console.log(data);
			if(data.userId<0){
				quaintAlert(data.code);
			}else{
				quaintAlert("注册成功!游客更多功能正在开发中...");
				closeWindow();
				var str = `欢迎用户：${data.userNickName}！
					<button id="cancel" class="quaint-btn-rediusC30 btn btn-warning">注销</button>
					<button id="update" class="quaint-btn-rediusC30 btn btn-success">修改信息</button>`;
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
		quaintAlert("用户名不可为空!");
		return false;
	}
	if(upwd==""){
		quaintAlert("密码不可为空!");
		return false;
	}else if (upwd.length<6){
		quaintAlert("密码长度必须大于6位!");
		return false;
	}
	$.ajax({
		url:"/login",
		type: "POST",
		data:$('#login_form').serialize(),
		dataType:"json",
		success:function(data){
			if(data.userId=="-404"){
				quaintAlert("用户名不存在!");
				return false;
			}else if(data.userId=="-500"){
				quaintAlert("用户密码错误!");
				return false;
			}else{
				quaintAlert("登陆成功!");
				closeWindow();
				var str = `欢迎用户：${data.userNickName}！
						<button id="cancel" class="quaint-btn-rediusC30 btn btn-warning">注销</button>
						<button id="update" class="quaint-btn-rediusC30 btn btn-success">修改信息</button>`;
				$("#quaintUser").html(str);
			}
			//console.log(data);
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
				//console.log(data);
				$("#quaintUser").html("<button class='login quaint-btn-rediusB30 btn btn-success'>登录</button>");
			}
		});
	})
	//当用户点击修改信息时
	$("#quaintUser").on("click","#update",function(){
		location.href="/quaint-user";
	})
})
