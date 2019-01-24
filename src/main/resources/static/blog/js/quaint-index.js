//  导航  浮出提示开始
//$(function(){
//	if ($("#show-nav li").eq(0).is(":hidden")) {
//		$("#get-nav li").eq(0).hover(function(){
//			$("#show-nav li").eq(0).slideDown(521);
//		},function(){
//			$("#show-nav li").eq(0).slideUp(21);
//		})
//	}
//	if ($("#show-nav li").eq(1).is(":hidden")) {
//		$("#get-nav li").eq(1).hover(function(){
//			$("#show-nav li").eq(1).slideDown(521);
//		},function(){
//			$("#show-nav li").eq(1).slideUp(21);
//		})
//	}
//	if ($("#show-nav li").eq(2).is(":hidden")) {
//		$("#get-nav li").eq(2).hover(function(){
//			$("#show-nav li").eq(2).slideDown(521);
//		},function(){
//			$("#show-nav li").eq(2).slideUp(21);
//		})
//	}
//	if ($("#show-nav li").eq(3).is(":hidden")) {
//		$("#get-nav li").eq(3).hover(function(){
//			$("#show-nav li").eq(3).slideDown(521);
//		},function(){
//			$("#show-nav li").eq(3).slideUp(21);
//		})
//	}
//})
//  导航  浮出提示结束

$(function(){
	//  烟花开始~
	var fireworks = `<div class="quaint-fireworks"></div>`;
	$(".quaint-hide-text").after(fireworks);
	//	流星开始
	var meteors =`<div class="quaint-meteor"></div>
		<div class="quaint-meteor1 hidden-xs"></div>
		<div class="quaint-meteor2 hidden-xs"></div>
		<div class="quaint-meteor3 hidden-xs"></div>`; 
	$(".quaint-hide-text").after(meteors);
	//飘落物开始		手机端专属
	var fluttered = `<div class="quaint-flutteredI quaint-fluttered-PI visible-xs"></div>
			<div class="quaint-flutteredII quaint-fluttered-PI visible-xs"></div>`;
	$(".quaint-hide-text").after(fluttered);
	//三天一循环 每天都自动换飘落物
	var quaintDate = new Date;
	switch (quaintDate.getDate()%3){
		case 0:
			$("div.quaint-flutteredI").removeClass("quaint-fluttered-PI").addClass("quaint-fluttered-PI");
			$("div.quaint-flutteredII").removeClass("quaint-fluttered-PI").addClass("quaint-fluttered-PI");
			break;
		case 1:
			$("div.quaint-flutteredI").removeClass("quaint-fluttered-PI").addClass("quaint-fluttered-PII");
			$("div.quaint-flutteredII").removeClass("quaint-fluttered-PI").addClass("quaint-fluttered-PII");
			break;
		case 2:
			$("div.quaint-flutteredI").removeClass("quaint-fluttered-PI").addClass("quaint-fluttered-PIII");
			$("div.quaint-flutteredII").removeClass("quaint-fluttered-PI").addClass("quaint-fluttered-PIII");
			break;
		default:
			break;
	}

})


