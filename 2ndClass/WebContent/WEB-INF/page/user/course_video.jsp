<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${courseCustom.cname}-在线视频</title>
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
 	<style type="text/css">
		
		.section-one{
   			color: #ddd;
   			background: #000 url("images/background.jpg") repeat;
   		}
		.mybreadcrumb{
			margin-left: 10%;
			
		}
		.section-two{
			width: 100%;
			height: 430px;
			background-color: #000;
		}
		#tips{
			position: relative;
			top: 50%;
		}
		.operation{
			position: absolute;
			top: 35%;
			display: inline-block;
		}
		.operation li{
			list-style: none;
			padding: 10px;
			background-color: gray;
		}
		.operation li a{
			text-decoration: none;
			color: #fff;
		}
		.operation li:hover{
			background-color: orange;
		}
	     .text-ellipsis{
			overflow: hidden;
    		white-space: nowrap;
    		text-overflow: ellipsis;
    		color: #787D82;
		}

		#myoffcanvas ul li a{
			text-decoration: none;
		}
		#myoffcanvas ul li a:hover .text-ellipsis{
			color: orange;
		}
		.footer{
			margin-top: 0;
			background-color: #fff;
		}
 	</style>
</head>
<body id="top">

   <div class="section-one">
	<br>
	<div class="mybreadcrumb">
		<ul class="uk-breadcrumb">
		    <li><a href="index.html"><span class="glyphicon glyphicon-home"></span> 第二课堂</a></li>
		    <li><a href="course.html">课程</a></li>
		      <li><a href="course_html.html">${courseCustom.cname}</a></li>
		    <li class="uk-active"><span>${courseCustom.cname}-在线视频</span></li>

		</ul>
	<div class="row">
		<div class="col-md-1 my-class uk-text-bold uk-text-center uk-text-muted">讲师</div>
		<div class="col-md-1 my-class uk-text-bold uk-text-center uk-text-muted">难度</div>
		<div class="col-md-1 my-class  uk-text-bold uk-text-center uk-text-muted">章节数</div>
		<div class="col-md-1 my-class uk-text-bold uk-text-center uk-text-muted" >学习人数</div>
		<div class="col-md-1 my-class"></div>
		<div class="col-md-1 my-class"></div>
		<div class="col-md-1 my-class">	</div>
		<div class="col-md-1 my-class"></div>
		<div class="col-md-1 my-class"></div>
		<div class="col-md-1 my-class  uk-text-bold uk-text-center uk-text-muted">关注</div>
		<div class="col-md-1 my-class  uk-text-bold uk-text-center uk-text-muted">分享</div>
	</div>
	<div class="row">
		<div class="col-md-1 my-class uk-text-center">莫某人</div>
		<div class="col-md-1 my-class uk-text-center">${courseCustom.level}</div>
		<div class="col-md-1 my-class  uk-text-center">${courseCustom.chapter_num}</div>
		<div class="col-md-1 my-class uk-text-center" >${courseCustom.stu_num}</div>
		<div class="col-md-1 my-class"></div>
		<div class="col-md-1 my-class"></div>
		<div class="col-md-1 my-class">	</div>
		<div class="col-md-1 my-class"></div>
		<div class="col-md-1 my-class"></div>
		<div class="col-md-1 my-class uk-text-center"><a class="glyphicon glyphicon-heart" style="color:red" title="已关注"></a></div>
		<div class="col-md-1 my-class uk-text-center">
			<a><img src="images/weixin.png" title="分享到微信"></a>
			<a><img src="images/weibo.png" title="分享到微博"></a>
			<a><img src="images/qq.png" title="分享到QQ"></a>
		</div>
	</div>
	<br>
	</div><!-- end of mybreadcrumb-->
	</div><!-- end of section-one-->

	<div class="section-two">
		<div class="video">
			<video id="media" class="uk-align-center"src="http://v1.mukewang.com/0be17f3f-7952-4ad2-bc5c-f95b17a8a6f8/L.mp4" controls="controls" autoplay="false">您的浏览器不支持 video 标签。</video>
			
		</div>

		<div id="tips" class="uk-text-center" style="display: none">
			<a href="course_video.html" id="replay" class="uk-button">重新播放</a>
			<a href="course_video.html" id="next" class="uk-button">下一节</a>
		</div>
		<!-- 章节、笔记按钮 -->
		<div class="operation">
			<ul>
				<li>
					<a href="#myoffcanvas" data-uk-offcanvas title="查看或选择章节"><span class="glyphicon glyphicon-list"></span><span> 章节</span>
					</a>
				</li>
			</ul>
			<ul>
				<li>
					<a data-toggle="modal" data-target="#note" title="记下疑惑或收获"><span class="glyphicon glyphicon-pencil"></span><span> 笔记</span>
					</a>
				</li>
			</ul>
			<ul>
				<li>
					<a data-toggle="modal" data-target="#evaluation" title="对课程或老师进入评价"><span class="glyphicon glyphicon-comment"></span><span> 评价</span>
					</a>
				</li>
			</ul>
			<ul>
				<li>
					<a href="community_question.html"  title="进入社区寻求帮助"><span class="glyphicon glyphicon-question-sign"></span><span> 社区</span>
					</a>
				</li>
			</ul>
		</div>
		<!-- 章节列表 -->
				<div id="myoffcanvas" class="uk-offcanvas">
                             <div class="uk-offcanvas-bar">
                                    <div class="uk-panel">
                                    	<h4 class="uk-h5 uk-text-bold">${courseCustom.cname}</h4>
                                    	<ul >
                                    		<li><h5 class="uk-h5 uk-text-primary">${onesection.sname}</h5></li>
                                    		<li class="uk-text-small">
                                    			<a href="course_video.html">
                                    				<p class="text-ellipsis">
                                    					<span class="glyphicon glyphicon-book"></span>
                                    					 ${onesection.sdesc}
                                    				</p>
                                    			</a>
                                    		</li>
                                    		
                                    		 <c:forEach items="${sectionlist}" var="section" begin="0" end="3" step="1">

                                    		<li><h5 class="uk-h5 uk-text-primary">4${section.sname}</h5></li>
                                    		<li class="uk-text-small"><a href="#"><p class="text-ellipsis"><span class="glyphicon glyphicon-book"></span> ${section.sdesc}</p></a>
                                    			</li>
                                    			
                               
                                    		</c:forEach>
                                    			
                                    	</ul>
                                    </div>
                            </div>
                </div>

		<!-- 笔记模态弹出窗内容 -->
			    <div class="modal fade" id="note" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
								<h5 class="modal-title">我的笔记</h5>
							</div>
							<div class="modal-body">
								<textarea maxlength="500" rows="5" cols="35" style="resize: none" placeholder="请输入笔记内容..."></textarea>
							</div>
							<div class="modal-footer text-middle">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary">保存</button>
							</div>
						</div>
					</div>
				</div>
		<!-- 评价模态弹出窗内容 -->
		 <div class="modal fade" id="evaluation" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
								<h5 class="modal-title">我的评价</h5>
							</div>
							<div class="modal-body">
								<textarea maxlength="500" rows="5" cols="35" placeholder="请输入笔记内容..."></textarea>
							</div>
							<div class="modal-footer text-middle">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary">提交</button>
							</div>
						</div>
					</div>
				</div>
	</div>

<footer class="footer">
	<p class="uk-text-center uk-text-muted">上第二课堂，让你的汗水替代你的泪水。</p>
	<div class="footer-link uk-text-center">
		<a class="uk-text-middle uk-text-muted" href="#">友情链接</a>
		<a class="uk-text-middle uk-text-muted" href="#">人才招募</a>
		<a class="uk-text-middle uk-text-muted" href="#">讲师招募</a>
		<a class="uk-text-middle uk-text-muted" href="#">联系我们</a>
		<a class="uk-text-middle uk-text-muted" href="#">意见反馈</a>
	</div>
	<p class="uk-text-center uk-text-muted">Copyright © 2015 2ndClass.com All Rights Reserved | 莫家和的期末作业</p>
	<br>
</footer>

	<script src="js/jquery-1.13.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
   <script src="js/uikit.min.js"></script>
	<script type="text/javascript">
	var Media = document.getElementById("media"); 
	var Tips = document.getElementById("tips");
	var Replay = document.getElementById("replay");
	var Next = document.getElementById("next");
	Media.onended = function(){
		Media.style.display = 'none';
		Tips.style.display = 'block';
	}
	Replay.addEventListener('click',function() {
		Tips.style.display = 'none';
		Media.style.display = 'block';
		Media.play();
	});
	</script>
</body>
</html>