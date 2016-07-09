(function($) {
	$(document).ready(function() {
		$(".controller").mCustomScrollbar();
	});
})(jQuery);

(function($) {
	$(document).ready(function() {
		$(".contents").mCustomScrollbar();
	});
})(jQuery);

// 设置当前时间
var date = new Date();
var time = date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
		+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
		+ ":" + date.getSeconds();
$('.time').text(time);

var curr, last;
// 一个打开时其他全部关闭
$(
		'#collapseOne,#collapseTwo,#collapseThree,#collapseFour,#collapseFive,#collapseSix,#collapseSeven')
		.on(
				'show.bs.collapse',
				function() {
					// alert('调用show方法是触发'+this.id);
					$(
							'#collapseOne,#collapseTwo,#collapseThree,#collapseFour,#collapseFive,#collapseSix,#collapseSeven')
							.collapse('hide');
					// $(this).collapse('show');
					if (last != curr)
						$(last).removeClass('glyphicon-menu-down').addClass(
								'glyphicon-menu-right');
				});
// 关闭时执行
$(
		'#collapseOne,#collapseTwo,#collapseThree,#collapseFour,#collapseFive,#collapseSix,#collapseSeven')
		.on(
				'hide.bs.collapse',
				function() {
					$(last).removeClass('glyphicon-menu-down').addClass(
							'glyphicon-menu-right');
				});
// 手风琴头
$('#body #accordion .panel > a').click(
		function() {
			last = curr;
			curr = '#' + this.id + ' #icon';
			// alert(last+',' + curr);
			if ($(curr).hasClass('glyphicon-menu-down'))
				$(curr).removeClass('glyphicon-menu-down').addClass(
						'glyphicon-menu-right');
			else
				$(curr).removeClass('glyphicon-menu-right').addClass(
						'glyphicon-menu-down');
		});
// 面包屑中点击路径
$('.content .content-header li .myCollapse').click(
		function() {
			last = curr;
			curr = '#' + this.id + ' #icon';
			// alert(last+',' + curr);
			if ($(curr).hasClass('glyphicon-menu-down'))
				$(curr).removeClass('glyphicon-menu-down').addClass(
						'glyphicon-menu-right');
			else
				$(curr).removeClass('glyphicon-menu-right').addClass(
						'glyphicon-menu-down');
		});

// 头像预览
function showPreview(source) {
	var file = source.files[0];
	if (window.FileReader) {
		var fr = new FileReader();
		fr.onloadend = function(e) {
			document.getElementById("pic").src = e.target.result;
		};
		fr.readAsDataURL(file);
	}
}
// function showImg(obj){
// var p=obj.value;

// document.getElementById("pic").src=p;
// //alert(p);
// }

$('#tooltip').tooltip({
	trigger : 'hover,click',
});

// 验证密码一致
function check() {
	var comfire = $("#finalPwd").val().trim();
	var password = $("#password").val().trim();

	if (comfire != password) {
		alert('两次密码不一致！');
		return false;
	}
}

// 日期控件
$('.form_date').datetimepicker({
	language : 'fr',
	weekStart : 1,
	todayBtn : 1,
	autoclose : 1,
	todayHighlight : 1,
	startView : 2,
	minView : 2,
	forceParse : 0
});

$('.form_datetime').datetimepicker({
	// language: 'fr',
	weekStart : 1,
	todayBtn : 1,
	autoclose : 1,
	todayHighlight : 1,
	startView : 2,
	forceParse : 0,
	showMeridian : 1
});
// 设置默认初始值
document.getElementById("resetBtn").onclick = function() {
	var myInput1 = document.getElementById("time1");
	var myInput2 = document.getElementById("time2");
	myInput1.defaultValue = myInput1.value;
	myInput2.defaultValue = myInput2.value;
	document.forms[0].reset()
}


