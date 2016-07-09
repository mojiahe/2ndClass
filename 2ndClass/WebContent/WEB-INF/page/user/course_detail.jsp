<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8utf-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>HTML入门基本</title>
<!-- 设置网页头部图标 -->
<link href="images/logo.ico" type="image/x-icon" rel="shortcut icon">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/uikit.min.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- 让低版本IE支持HTML5和响应式设计 -->3
<!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" type="text/css" href="css/my.css">
<link rel="stylesheet" type="text/css" href="css/accordion.css">
<style type="text/css">
.section-one {
	color: #ddd;
	background: #000 url("images/background.jpg") repeat;
}

.mybreadcrumb {
	margin-left: 10%;
}

.section-two {
	width: 80%;
	margin-left: 10%;
}

.uk-accordion-content a {
	text-decoration: none;
	font-size: 1.1rem;
}

.text-indent {
	margin-left: 10%
}

.course_section {
	padding: 5px 0px;
}
</style>
</head>
<body id="top">
	<%@include file="html/header.html"%>
	
	
	<!-- 中间内容 -->
	<div class="my-context">
		<div class="section-one">
			<br>
			<div class="mybreadcrumb">
				<ul class="uk-breadcrumb">
					<li><a href="index.html"><span
							class="glyphicon glyphicon-home"></span> 第二课堂</a></li>
					<li><a href="course.html">课程</a></li>
					<li class="uk-active"><span>${courseCustom.cname}</span></li>

				</ul>
				<h2>${courseCustom.cname}</h2>
				<br>
				<br>
				<div class="row">
					<div
						class="col-md-1 my-class uk-text-bold uk-text-center uk-text-muted">讲师</div>
					<div
						class="col-md-1 my-class uk-text-bold uk-text-center uk-text-muted">难度</div>
					<div
						class="col-md-1 my-class  uk-text-bold uk-text-center uk-text-muted">章节数</div>
					<div
						class="col-md-1 my-class uk-text-bold uk-text-center uk-text-muted">学习人数</div>
					<div class="col-md-1 my-class"></div>
					<div class="col-md-1 my-class"></div>
					<div class="col-md-1 my-class"></div>
					<div class="col-md-1 my-class"></div>
					<div class="col-md-1 my-class"></div>
					<div
						class="col-md-1 my-class  uk-text-bold uk-text-center uk-text-muted">关注</div>
					<div
						class="col-md-1 my-class  uk-text-bold uk-text-center uk-text-muted">分享</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-1 my-class uk-text-center">${courseCustom.teacher.tea_name}</div>
					<div class="col-md-1 my-class uk-text-center">${courseCustom.level}</div>
					<div class="col-md-1 my-class  uk-text-center">${courseCustom.chapter_num}</div>
					<div class="col-md-1 my-class uk-text-center">${courseCustom.stu_num}</div>
					<div class="col-md-1 my-class"></div>
					<div class="col-md-1 my-class"></div>
					<div class="col-md-1 my-class"></div>
					<div class="col-md-1 my-class"></div>
					<div class="col-md-1 my-class"></div>
					<div class="col-md-1 my-class uk-text-center">
						<a class="glyphicon glyphicon-heart" style="color: red"
							title="已关注"></a>
					</div>
					<div class="col-md-1 my-class uk-text-center">
						<a><img src="images/weixin.png" title="分享到微信"></a> <a><img
							src="images/weibo.png" title="分享到微博"></a> <a><img
							src="images/qq.png" title="分享到QQ"></a>
					</div>

				</div>
				<br>
			</div>
		</div>
		<br>
		<br>
		<div class="section-two">

			<div class="row">
				<div class="col-md-7">
					<!-- 课程介绍 -->
					<h4 class="uk-text-warning uk-text-bold">课程介绍</h4>
					<p class="uk-text-small">${courseCustom.cdesc}</p>
					<hr style="border-color: #DDDDDD;">
					<!-- 课程大纲 -->
					<h4 class="uk-text-warning uk-text-bold">课程大纲</h4>
					<br>
					<br>

					<div class="uk-accordion" data-uk-accordion="{collapse:false}">
						<c:forEach items="${sectionlist}" var="se">

							<!-- 传入视频路径 -->
							<a href="${pageContext.request.contextPath}/courseViedo?cid=${courseCustom.cid}&&sid=${se.sid}"
								class="course_section"> <span
								class="glyphicon glyphicon-list-alt"></span> ${se.sname}
								<p class="uk-text-small uk-text-muted">${se.sdesc}</p>
							</a>
						</c:forEach>
					</div>

					<hr style="border-color: #DDDDDD;">
					<!-- 课程评价 -->
					<h4 class="uk-text-warning uk-text-bold">课程评价</h4>

					<ul class="uk-comment-list">
						<li><article class="uk-comment uk-comment-primary">
							<header class="uk-comment-header"> <img
								class="uk-comment-avatar img-circle" src="images/user1.jpg"
								width="50" height="50">
							<h4 class="uk-comment-title uk-text-small">
								<span class="uk-text-primary">评价星级：</span><span
									class="uk-text-warning">★★★★★</span>
							</h4>
							<div class="uk-comment-meta">两天前 | 传说中的小明 |</div>
							</header>
							<div class="uk-comment-body">
								<div class="text-indent">
									<p>总体上来说，非常满意，基本上讲解的简洁明了，容易懂。</p>
								</div>
							</div>
							</article></li>
						<hr style="border-color: #DDDDDD; border-style: dashed;">
						<li><article class="uk-comment uk-comment-primary">
							<header class="uk-comment-header"> <img
								class="uk-comment-avatar img-circle" src="images/user2.jpg"
								width="50" height="50">
							<h4 class="uk-comment-title uk-text-small">
								<span class="uk-text-primary">评价星级：</span><span
									class="uk-text-warning">★★★★★</span>
							</h4>
							<div class="uk-comment-meta">两天前 | 传说中的小白 |</div>
							</header>
							<div class="uk-comment-body">
								<div class="text-indent">
									<p>这是我目前在网络上看到的最好的html+css基础课程，目前没有之一。</p>
								</div>
							</div>
							</article></li>
						<hr style="border-color: #DDDDDD; border-style: dashed;">
						<li><article class="uk-comment uk-comment-primary">
							<header class="uk-comment-header"> <img
								class="uk-comment-avatar img-circle" src="images/user3.jpg"
								width="50" height="50">
							<h4 class="uk-comment-title uk-text-small">
								<span class="uk-text-primary">评价星级：</span><span
									class="uk-text-warning">★★★★★</span>
							</h4>
							<div class="uk-comment-meta">两天前 | 传说中的小黑 |</div>
							</header>
							<div class="uk-comment-body">
								<div class="text-indent">
									<p>入门来说很好，可以实际操作。很好！</p>
								</div>
							</div>
							</article></li>
						<hr style="border-color: #DDDDDD; border-style: dashed;">
						<li><article class="uk-comment uk-comment-primary">
							<header class="uk-comment-header"> <img
								class="uk-comment-avatar img-circle" src="images/user4.jpg"
								width="50" height="50">
							<h4 class="uk-comment-title uk-text-small">
								<span class="uk-text-primary">评价星级：</span><span
									class="uk-text-warning">★★★★</span>
							</h4>
							<div class="uk-comment-meta">两天前 | 传说中的小李 |</div>
							</header>
							<div class="uk-comment-body">
								<div class="text-indent">
									<p>nice！学习起来挺清晰的，感觉不错!</p>
								</div>
							</div>
							</article></li>
						<hr style="border-color: #DDDDDD; border-style: dashed;">
					</ul>
					<a href="#"><button
							class="uk-button uk-width-1-1 uk-button-primary ">更多评价</button></a>
				</div>

				<div class="col-md-1"></div>
				<!-- 第二栏 -->
				<div class="col-md-4">
					<a href="course_video.html"><button
							class="uk-button-large uk-width-1-1 uk-button-danger uk-margin-small-bottom">马上学习</button></a>
					<hr>
					<div>
						<p class="uk-text-bold">讲师资料</p>
						<div class="text-indent">
							<p class="uk-text-small uk-text-warning">
								昵称：<span class="uk-text-muted">${courseCustom.teacher.tea_name}</span>
							</p>
							<p class="uk-text-small uk-text-warning">
								职业：<span class="uk-text-muted">
									${courseCustom.teacher.job}</span>
							</p>
							<p class="uk-text-small uk-text-warning">
								经历：<span class="uk-text-muted">${courseCustom.teacher.exp}</span>
							</p>
							<p class="text-indent">
								<img class="text-indent img-circle"
									src="${courseCustom.teacher.pic}" width="100" height="100">
							</p>
						</div>
						<hr style="border-color: #DDDDDD; border-style: dashed;">
						<p class="uk-text-bold">讲师提示</p>
						<div class="text-indent">
							<p class="uk-text-small uk-text-warning">
								课程适合范围：<span class="uk-text-muted">${courseCustom.courseInfo.scope}</span>
							</p>
							<p class="uk-text-small uk-text-warning">
								课程学习方法：<span class="uk-text-muted">
									${courseCustom.courseInfo.method}</span>
							</p>
							<p class="uk-text-small uk-text-warning">
								课程最终收获：<span class="uk-text-muted">
									${courseCustom.courseInfo.harvest}</span>
							</p>
						</div>
						<hr style="border-color: #DDDDDD; border-style: dashed;">
						<p class="uk-text-bold">资料下载</p>
						<div class="text-indent">
							<a href=""> <span class="glyphicon glyphicon-folder-open">
									第一章讲解</span></a><br> <a href=""> <span
								class="glyphicon glyphicon-folder-open"> 第二章讲解</span></a><br> <a
								href=""> <span class="glyphicon glyphicon-folder-open">
									第三章讲解</span></a>
						</div>
						<br>
					</div>

				</div>

			</div>
		</div>
	</div>

	<footer class="footer">
	<p class="uk-text-center uk-text-muted">上第二课堂，让你的汗水替代你的泪水。</p>
	<div class="footer-link uk-text-center">
		<a class="uk-text-middle uk-text-muted" href="#">友情链接</a> <a
			class="uk-text-middle uk-text-muted" href="#">人才招募</a> <a
			class="uk-text-middle uk-text-muted" href="#">讲师招募</a> <a
			class="uk-text-middle uk-text-muted" href="#">联系我们</a> <a
			class="uk-text-middle uk-text-muted" href="#">意见反馈</a>
	</div>
	<p class="uk-text-center uk-text-muted">Copyright © 2015
		2ndClass.com All Rights Reserved | 莫家和的期末作业</p>
	<br>
	</footer>

	<p id="back-to-top">
		<a href="#top" onfocus="this.blur();"> <img src="images/top.png">
		</a>
	</p>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.13.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/uikit.min.js"></script>
	<script src="js/lightbox.js"></script>
	<script src="js/pagination.js"></script>
	<script src="js/my.js"></script>
	<script src="js/accordion.min.js"></script>
</body>
</html>