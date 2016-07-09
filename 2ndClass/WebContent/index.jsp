<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>第二课堂-给你充电的课堂</title>
    <!-- 设置网页头部图标 -->
	<link href="images/logo.ico" type="image/x-icon" rel="shortcut icon">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/uikit.min.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- 让低版本IE支持HTML5和响应式设计 -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
   	<link rel="stylesheet" type="text/css" href="css/my.css">
</head>
<body id="top">
    <%@include file="WEB-INF/page/user/html/header.html" %>
    
    <!-- Carousel插件 -->
	<div id="myCarousel" class="carousel slide">
   <!-- 轮播（Carousel）小圆圈 -->
   <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
   </ol>   
   <!-- 轮播（Carousel）项目 -->
   <div class="carousel-inner" role="listbox">
      <div class="item active">
         <img src="images/slide1.jpg" alt="First slide">
      </div>
      <div class="item">
         <a href="#"><img src="images/slide2.jpg" alt="Second slide"></a>
         <div class="carousel-caption">
         </div>
      </div>
      <div class="item">
         <a href="#"><img src="images/slide3.jpg" alt="Third slide"></a>
         <div class="carousel-caption">
         </div>
      </div>
      <div class="item">
         <img src="images/slide4.jpg" alt="Fourth slide">
      </div>
   </div>
   <!-- 轮播（Carousel）导航 -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">上一张</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">下一张</span>
  </a>
</div>

<div class="" id="myContainer"  data-uk-scrollspy="{cls:'uk-animation-slide-bottom uk-animation-fade', target:'.my-class'}">
	<div class="row">

	    <!-- 无延时 -->
	    <div class="col-md-4 my-class">
	    	<img class="img-circle" src="images/video.jpg" />
	    	<h3>海量专业视频</h3>
	    </div>

	    <!-- 300ms 延时 -->
	    <div class="col-md-4 my-class">
			<img class="img-circle" src="images/plan.jpg">
	    	<h3>量身定做计划</h3>
	    </div>

	    <!-- 600ms 延时 -->
	    <div class="col-md-4 my-class">
	    	<img class="img-circle" src="images/alarm.jpg">
	    	<h3>实时提醒学习</h3>
	    </div>
	</div>
	<br><br>
	<div class="row">
		<div class="col-md-6 my-class">
	    	<img class="img-circle" src="images/thinking.jpg" />
	    </div>

	    <div class="col-md-6 my-class">
	    	<img class="img-circle" src="images/text-one.jpg" />
	    </div>
	</div>
	
	<div class="row">
	    <div class="col-md-6 my-class">
	    	<img class="img-circle" src="images/text-two.jpg" />
	    </div>
	    <div class="col-md-6 my-class">
	    	<img class="img-circle" src="images/practice.jpg" />
	    </div>
	</div>

	<div class="row">
		<div class="col-md-6 my-class">
	    	<img class="img-circle" src="images/online.jpg" />
	    </div>

	    <div class="col-md-6 my-class">
	    	<img class="img-circle" src="images/text-three.jpg" />
	    </div>
	</div>

	<div class="row">
	    <div class="col-md-6 my-class">
	    	<img class="img-circle" src="images/text-four.jpg" />
	    </div>
	    <div class="col-md-6 my-class">
	    	<img class="img-circle" src="images/exchange.jpg" />
	    </div>
	</div>
</div>
<!-- 课程列表 -->
<div class="course" id="myContainer">
	<hr>
	<h2 class="uk-text-center uk-text-primary uk-text-bold">课程</h2>
	<div class="row">

	    <div class="col-md-2 my-class">
	    </div>
	    
        <c:forEach items="${courseslist}" var="course" begin="0" end="3" step="1">
	    
	    <div class="col-md-2 my-class">
	    	<a href="sectionDetail?cid=${course.cid}">
				<div class="uk-thumbnail uk-thumbnail-large  uk-overlay-hover">
	    			<img class="uk-overlay-scale" src="${course.pic}" alt="213">
	    			<br>
	    			<div class="introduce uk-animation-slide-bottom">
	    				<h6>${course.cdesc}</h6>
	    				<span class="uk-text-small uk-text-left uk-text-primary">更新完毕</span> |
	    				<span class="uk-text-small uk-text-right uk-text-warning">章节数：${course.chapter_num}</span>
	    			</div>
	    			<div class="uk-thumbnail-caption info">
	    				<h5>${course.cname}</h5>
	    				<span class="uk-text-small uk-text-left uk-text-primary">难度：${course.level}</span> |
	    				<span class="uk-text-small uk-text-right uk-text-warning">${course.stu_num}人学习</span>
	    			</div>
				</div>
			</a>
	    </div>
		
		</c:forEach>
		
	    <div class="col-md-2 my-class">
	    </div>
	</div>
	<br>
	<div class="row">

	    <div class="col-md-2 my-class">
	    </div>
      
	     <c:forEach items="${courseslist}" var="course" begin="4" end="7" step="1">
	    
	    <div class="col-md-2 my-class">
	    	<a href="sectionDetail?cid=${course.cid}">
				<div class="uk-thumbnail uk-thumbnail-large  uk-overlay-hover">
	    			<img class="uk-overlay-scale" src="${course.pic}" alt="213">
	    			<br>
	    			<div class="introduce uk-animation-slide-bottom">
	    				<h6>${course.cdesc}</h6>
	    				<span class="uk-text-small uk-text-left uk-text-primary">更新完毕</span> |
	    				<span class="uk-text-small uk-text-right uk-text-warning">章节数：${course.chapter_num}</span>
	    			</div>
	    			<div class="uk-thumbnail-caption info">
	    				<h5>${course.cname}</h5>
	    				<span class="uk-text-small uk-text-left uk-text-primary">难度：${course.level}</span> |
	    				<span class="uk-text-small uk-text-right uk-text-warning">${course.stu_num}人学习</span>
	    			</div>
				</div>
			</a>
	    </div>
		
		</c:forEach>

	    <div class="col-md-2 my-class">
	    </div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		
		<div class="col-md-8">
			<a href="getCourseAndInfoByType"><button class="uk-button uk-width-1-1 uk-button-primary">全部课程</button></a>
		</div>
		<div class="col-md-2"></div>
	</div>
</div>

<footer class="footer">
	<div class="row">
		<div class="col-md-4"></div>
		
		<div class="col-md-1 link-logo uk-animation-hover uk-text-center">
			<a class="uk-animation-fade" href="#"><img src="images/facebook.jpg" alt="facebook" title="facebook"></a>
		</div>
		<div class="col-md-1 link-logo uk-animation-hover uk-text-center">
			<a class="uk-animation-fade" href="#"><img src="images/weichat.jpg" alt="微信" title="微信">
		</div>
		<div class="col-md-1 link-logo uk-animation-hover uk-text-center">
			<a class="uk-animation-fade" href="#"><img src="images/twitter.jpg" alt="twitter" title="twitter"></a>
		</div>
		<div class="col-md-1 link-logo uk-animation-hover uk-text-center">
			<a class="uk-animation-fade" href="#"><img src="images/google.jpg" alt="google" title="google"></a>
		</div>
		<div class="col-md-4"></div>
	</div>
	<br>
	<div class="footer-link uk-text-center">
		<a class="uk-text-middle uk-text-muted" href="#">友情链接</a>
		<a class="uk-text-middle uk-text-muted" href="#">人才招募</a>
		<a class="uk-text-middle uk-text-muted" href="#">讲师招募</a>
		<a class="uk-text-middle uk-text-muted" href="#">联系我们</a>
		<a class="uk-text-middle uk-text-muted" href="#">意见反馈</a>
	</div>
	<br>
	<p class="uk-text-center uk-text-muted">Copyright © 2015 2ndClass.com All Rights Reserved | 莫家和的期末作业</p>
	<br>
</footer>

<p id="back-to-top">
	<a href="#top" onfocus="this.blur();">
		<img src="images/top.png">
	</a>
</p>



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.13.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/uikit.min.js"></script>
    <script src="js/lightbox.js"></script>
    <script src="js/my.js"></script>
  </body>
</html>