// 子类对父类 的 微调
//导航条 active
$(function(){
	for (var i=0;i<4;i++) {
		$("ul#get-nav li",parent.document).eq(i).removeClass("quaint-active");
		$("ul#show-nav li",parent.document).eq(i).slideUp(21);
	}
	$("ul#get-nav li",parent.document).eq(2).addClass("quaint-active");
	$("ul#show-nav li",parent.document).eq(2).slideDown(521);
})

/*
 * 请求ajax查询最近的心情
 *
 */
$(function(){

	//ajax请求控制器,查询所有记忆,获取json
	$.post("getMemoryList",{},function(data){
		showMemory(data);
	},"json")
	//主页展示最新的一条心情记忆  TODO  需要修改 为Mood
	function showMemory(data){
		let memoryStr = "";
		for(let i = 0; i<data.length; i++){
			if(i==0){
				memoryStr+=`<div class="quaint-middle-bgII" id="quaint-live-new">
							<div class="quaint-new-label"></div>
							<p class="quaint-bottomLine">
							<span class="glyphicon glyphicon-time"></span>
								${data[i].memoryTime}
							</p>
							<p class="quaint-indent">
								${data[i].title}
							</p>
							<p class="quaint-indent">
								${data[i].content}
							</p>
							</div>
							`;
			}else{
				memoryStr+=`<div class="quaint-middle-bgII">
							<p class="quaint-bottomLine">
							<span class="glyphicon glyphicon-time"></span>
								${data[i].memoryTime}
							</p>
							<p class="quaint-indent">
								${data[i].title}
							</p>
							<p class="quaint-indent">
								${data[i].content}
							</p>
							</div>
							`;
			}
		}
		//在quaint-live-mood后面添加生成的记忆
		$("#quaint-live-mood").after(memoryStr);
		// ajax请求后需要 刷新一下ifream的高度  否则可能出现问题
		iframeHeight();
	}
})






