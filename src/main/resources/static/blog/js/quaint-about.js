// 子类对父类 的 微调
	//导航条 active 
$(function(){
	for (var i=0;i<4;i++) {
		$("ul#get-nav li",parent.document).eq(i).removeClass("quaint-active");
		$("ul#show-nav li",parent.document).eq(i).slideUp(21);
	}
	$("ul#get-nav li",parent.document).eq(1).addClass("quaint-active");
	$("ul#show-nav li",parent.document).eq(1).slideDown(521);
})
