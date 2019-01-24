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
		document.getElementById("hidebg").style.display = "none";
		document.getElementById("login_view").style.display = "none";
		document.getElementById("register_view").style.display = "none";
	})
})
