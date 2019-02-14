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
 * 请求ajax查询最近的博客
 *
 */
$(function(){
	//默认查询第一页
	moodPage(1);
})

//分页点击调用函数
function pageClick(index){
	moodPage(index);
}


function moodPage(index){
	//设置每页显示7个数据
	var size = 7;
	$.get("mood/selectMoodList",{pageNo:index,pageSize:size},function(data){
		console.log(data);
		showMood(data);
	},"json")
}

//主页展示最新的一条心情记忆
function showMood(data){
	var moods = data.list;
	let memoryStr = "";
	//--------------每页的心情说说的显示开始---------------
	for(let i = 0; i<moods.length; i++){
		if(i==0){
			memoryStr+=`<div class="quaint-middle-bgII" id="quaint-live-new">
							<div class="quaint-new-label"></div>
							<p class="quaint-bottomLine">
							<span class="glyphicon glyphicon-time"></span>
								${format(moods[i].moodTime,'yyyy-MM-dd HH:mm:ss')}
							</p>
							<p class="quaint-indent">
								${moods[i].moodContent}
							</p>
							</div>
							`;
		}else{
			memoryStr+=`<div class="quaint-middle-bgII">
							<p class="quaint-bottomLine">
							<span class="glyphicon glyphicon-time"></span>
								${format(moods[i].moodTime,'yyyy-MM-dd HH:mm:ss')}
							</p>
							<p class="quaint-indent">
								${moods[i].moodContent}
							</p>
							</div>
							`;
		}
	}
	//在quaint-live-mood后面添加生成的记忆
	$("#mood-div").html(memoryStr);
	//--------------每页的心情说说的显示结束---------------
	//----------分页数字拼接处理开始--------------
	let pageStr = `<li onclick="pageClick(${data.fastPage})">&lt;&lt;</li><li onclick="pageClick(${data.prePage})">&lt;</li>`;
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
	pageStr+=`<li onclick="pageClick(${data.nextPage==0?data.lastPage:data.nextPage})">&gt;</li><li onclick="pageClick(${data.lastPage})">&gt;&gt;</li>`;
	//-----------分页数字拼接处理开始--------------
	$("#page-div").html(pageStr);

	// ajax请求后需要 刷新一下ifream的高度  否则可能出现问题
	iframeHeight();
}

//封装时间格式  ${format(moods[i].moodTime,'yyyy-MM-dd HH:mm:ss')}
function format(time, format) {
	var t = new Date(time);
	var tf = function (i) {
		return (i < 10 ? '0' : '') + i
	};
	return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function (a) {
		switch (a) {
			case 'yyyy':
				return tf(t.getFullYear());
				break;
			case 'MM':
				return tf(t.getMonth() + 1);
				break;
			case 'mm':
				return tf(t.getMinutes());
				break;
			case 'dd':
				return tf(t.getDate());
				break;
			case 'HH':
				return tf(t.getHours());
				break;
			case 'ss':
				return tf(t.getSeconds());
				break;
		}
	})
}





