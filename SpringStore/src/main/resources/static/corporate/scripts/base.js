$(function() {
	initPages(); //初始化头部和尾部
})
function initPages() {
	$("#header").load("/header");
	$("#footer").load("/footer");
}

