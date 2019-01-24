//获取页面高度并调整
function iframeHeight(){
	var iframe = parent.document.getElementById("indexIframe");
	iframe.height = document.getElementById("iframeH").scrollHeight;
}
window.onload = function(){
	iframeHeight();
}
//浏览器改变宽高  调整一下父页面iframe 高度
window.onresize = function(){
	iframeHeight();
}
