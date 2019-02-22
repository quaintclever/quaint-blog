// 子类对父类 的 微调
	//导航条 active 
$(function(){
	for (var i=0;i<4;i++) {
		$("ul#get-nav li",parent.document).eq(i).removeClass("quaint-active");
		$("ul#show-nav li",parent.document).eq(i).slideUp(21);
	}
	$("ul#get-nav li",parent.document).eq(0).addClass("quaint-active");
	$("ul#show-nav li",parent.document).eq(0).slideDown(521);
})

/*
 * 	ajax 开始
 *	
 *	生成跳转到新页面的标签
 * 
 * */
$(function(){
	//ajax请求控制器,查询最新的一条记忆,获取json
	$.get("mood/selectNewMood",{},function(data){
		show_skip(data);
	},"json")
	//主页展示最新的一条心情记忆
	function show_skip(data){
		var skip_new_str = "";
		skip_new_str += `<span class="glyphicon glyphicon-time"></span>
						 ${data.moodTime}
						 <p class="quaint-indent">
						 ${data.moodContent}
						 </p>`;
		document.getElementById("skip_new").innerHTML=skip_new_str;
		// ajax请求后需要 刷新一下ifream的高度  否则可能出现问题
		iframeHeight();
	}
	
})