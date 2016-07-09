<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>第二课堂-精品课程</title>
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
.uk-grid ul li a {
	color: #000;
}

.mybreadcrumb {
	margin-left: 10%;
}

.face ul li {
	list-style: none;
	float: left;
}

.face ul li a {
	margin: 0 30%;
}

.course-type div, .course-level div {
	font-size: 1.3rem;
}

.course-type div a, .course-level div a {
	text-decoration: none;
	padding: 5%;
}

.course-type div a:hover, .course-level div a:hover {
	color: orange;
}

.course-active {
	color: #000;
	background-color: #6495ED;
	border-radius: 7px;
}

.page-hidden {
	display: none;
}

.page-show {
	display: block;
}

.text-ellipsis {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

.text-background {
	background-color: #000;
	opacity: 0.5;
}
</style>
</head>
<body id="top">
	<%@include file="html/header.html"%>
<s:debug></s:debug>
	<br>
	<!-- 中间内容 -->
	<ul class="uk-breadcrumb mybreadcrumb">
		<li><a href="index.html"><span
				class="glyphicon glyphicon-home"></span> 第二课堂</a></li>
		<li class="uk-active"><span>课程</span></li>
	</ul>
	<div class="uk-margin uk-grid" data-uk-grid-margin>
		<div class="uk-width-medium-8-10 uk-align-center">
			<div class="uk-tab-center">
				<ul class="uk-tab "
					data-uk-tab="{connect:'#tab-content',animation:'slide-bottom'}">
					<li class="uk-active"><a href="#">全部</a></li>
					<c:forEach items="${parType}" var="partype" begin="0" end="7"
						step="1">
						<li><a href="#">${partype.tname}</a></li>
					</c:forEach>
				</ul>
			</div>
			<br>
			<div>
				<ul id="tab-content" class="uk-switcher uk-margin">
					<li class="uk-active">
						<div class="course-type row">
							<div class="col-sm-1"></div>
							<div class="col-sm-1 uk-text-center">分类：</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#" class="course-active">全部</a>
							</div>
							<c:forEach items="${subType}" var="type" begin="0" end="7"
								step="1">
								<div class="col-sm-1 uk-text-center">
									<a href="#">${type.tname}</a>
								</div>
							</c:forEach>

						</div> <br>
						<div class="course-type row">
							<div class="col-sm-2"></div>

							<c:forEach items="${subType}" var="type" begin="8" end="16"
								step="1">
								<div class="col-sm-1 uk-text-center">
									<a href="#">${type.tname}</a>
								</div>
							</c:forEach>

						</div> <br>
						<div class="course-type row">
							<div class="col-sm-2"></div>

							<c:forEach items="${subType}" var="type" begin="17" end="24"
								step="1">
								<div class="col-sm-1 uk-text-center">
									<a href="#">${type.tname}</a>
								</div>
							</c:forEach>
						</div> <br>
						<div class="course-level row">
							<div class="col-sm-1"></div>

							<div class="col-sm-1 uk-text-center">难度：</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#" class="course-active">全部</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">初级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">中级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">高级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">大师</a>
							</div>
						</div>
						<hr style="border-color: #DDDDDD;">


						<div class="page">
							<!-- 第一页 -->
							<div class="page1 page-show mypage">
								<div class="course" id="myContainer">
									<div class="row">

										<c:forEach items="${courseslist}" var="course" begin="0"
											end="3" step="1">

											<div class="col-md-3 my-class">
												<a href="sectionDetail?cid=${course.cid}">
													<div
														class="uk-thumbnail uk-thumbnail-small uk-overlay-hover">
														<img class="uk-overlay-scale" src="${course.pic}"
															alt="213"> <br>
														<figcaption
															class="uk-overlay-panel uk-overlay-slide-right">
														<span class="uk-text-small text-background">${course.level}</span>
														<br>
														<span class="uk-text-small text-background">章节数：${course.chapter_num}</span>
														</figcaption>
														<div class="uk-thumbnail-caption ">
															<h5 class="uk-text-bold">${course.cname}</h5>
															<p class="text-ellipsis uk-text-muted uk-text-small">${course.cdesc}</p>
															<span class="uk-text-small">更新完毕</span> | <span
																class="uk-text-small">${course.stu_num}人学习</span>
														</div>
													</div>
												</a>
											</div>
										</c:forEach>

									</div>
									<br>
									<div class="row">

										<c:forEach items="${courseslist}" var="course" begin="4"
											end="7" step="1">

											<div class="col-md-3 my-class">
												<a href="sectionDetail?cid=${course.cid}">
													<div
														class="uk-thumbnail uk-thumbnail-small uk-overlay-hover">
														<img class="uk-overlay-scale" src="${course.pic}"
															alt="213"> <br>
														<figcaption
															class="uk-overlay-panel uk-overlay-slide-right">
														<span class="uk-text-small text-background">${course.level}</span>
														<br>
														<span class="uk-text-small text-background">章节数：${course.chapter_num}</span>
														</figcaption>
														<div class="uk-thumbnail-caption ">
															<h5 class="uk-text-bold">${course.cname}</h5>
															<p class="text-ellipsis uk-text-muted uk-text-small">${course.cdesc}</p>
															<span class="uk-text-small">更新完毕</span> | <span
																class="uk-text-small">${course.stu_num}人学习</span>
														</div>
													</div>
												</a>
											</div>
										</c:forEach>
									</div>

								</div>

							</div>
							<div class="page2 page-hidden mypage">2</div>
							<div class="page3 page-hidden mypage">3</div>
							<div class="page4 page-hidden mypage">4</div>
							<div class="page5 page-hidden mypage">5</div>
							<div class="page6 page-hidden mypage">6</div>
							<div class="page7 page-hidden mypage">7</div>
							<div class="page8 page-hidden mypage">8</div>
							<div class="page9 page-hidden mypage">9</div>
							<div class="page10 page-hidden mypage">10</div>
						</div>
					</li>
					<li>
						<div class="course-type row">
							<div class="col-sm-1"></div>
							<div class="col-sm-1 uk-text-center">分类：</div>

							<c:forEach items="${subType1001}" var="type" begin="0" end="7"
								step="1">
								<div class="col-sm-1 uk-text-center">
									<a href="#">${type.tname}</a>
								</div>
							</c:forEach>
						</div> <br>
						<div class="course-level row">
							<div class="col-sm-1"></div>

							<div class="col-sm-1 uk-text-center">难度：</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#" class="course-active">全部</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">初级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">中级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">高级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">大师</a>
							</div>
						</div>
						<hr style="border-color: #DDDDDD;">


						<div class="page">
							<!-- 第一页 -->
							<div class="page1 page-show mypage">
								<div class="course" id="myContainer">
									<div class="row">
										<c:forEach items="${coursesMap['1001']}" var="course">
												<div class="col-md-3 my-class">
													<a href="sectionDetail?cid=${course.cid}">
														<div class="uk-thumbnail uk-thumbnail-small uk-overlay-hover">
															<img class="uk-overlay-scale" src="${course.pic}"
																alt="213"> <br>
															<figcaption
																class="uk-overlay-panel uk-overlay-slide-right">
															<span class="uk-text-small text-background">${course.level}</span>
															<br>
															<span class="uk-text-small text-background">章节数：${course.chapter_num}</span>
															</figcaption>
															<div class="uk-thumbnail-caption ">
																<h5 class="uk-text-bold">${course.cname}</h5>
																<p class="text-ellipsis uk-text-muted uk-text-small">${course.cdesc}</p>
																<span class="uk-text-small">更新完毕</span> | <span
																	class="uk-text-small">${course.stu_num}人学习</span>
															</div>
														</div>
													</a>
												</div>
											</c:forEach>

									</div>
									<br>
									<div class="row"></div>

								</div>
								<div class="page2 page-hidden mypage">2</div>
								<div class="page3 page-hidden mypage">3</div>
								<div class="page4 page-hidden mypage">4</div>
								<div class="page5 page-hidden mypage">5</div>
								<div class="page6 page-hidden mypage">6</div>
								<div class="page7 page-hidden mypage">7</div>
								<div class="page8 page-hidden mypage">8</div>
								<div class="page9 page-hidden mypage">9</div>
								<div class="page10 page-hidden mypage">10</div>
								<!-- 分页，页码 -->

							</div>
					</li>
					<li>
						<div class="course-type row">
							<div class="col-sm-1"></div>
							<div class="col-sm-1 uk-text-center">分类：</div>

							<c:forEach items="${subType1002}" var="type" begin="0" end="7"
								step="1">
								<div class="col-sm-1 uk-text-center">
									<a href="#">${type.tname}</a>
								</div>
							</c:forEach>
						</div> <br>
						<div class="course-level row">
							<div class="col-sm-1"></div>

							<div class="col-sm-1 uk-text-center">难度：</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#" class="course-active">全部</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">初级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">中级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">高级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">大师</a>
							</div>
						</div>
						<hr style="border-color: #DDDDDD;">


						<div class="page">
							<!-- 第一页 -->
							<div class="page1 page-show mypage">
								<div class="course" id="myContainer">
									<div class="row">
										<c:forEach items="${coursesMap['1002']}" var="course">
												<div class="col-md-3 my-class">
													<a href="sectionDetail?cid=${course.cid}">
														<div class="uk-thumbnail uk-thumbnail-small uk-overlay-hover">
															<img class="uk-overlay-scale" src="${course.pic}"
																alt="213"> <br>
															<figcaption
																class="uk-overlay-panel uk-overlay-slide-right">
															<span class="uk-text-small text-background">${course.level}</span>
															<br>
															<span class="uk-text-small text-background">章节数：${course.chapter_num}</span>
															</figcaption>
															<div class="uk-thumbnail-caption ">
																<h5 class="uk-text-bold">${course.cname}</h5>
																<p class="text-ellipsis uk-text-muted uk-text-small">${course.cdesc}</p>
																<span class="uk-text-small">更新完毕</span> | <span
																	class="uk-text-small">${course.stu_num}人学习</span>
															</div>
														</div>
													</a>
												</div>
											</c:forEach>

									</div>
									<br>
									<div class="row"></div>

								</div>
								<div class="page2 page-hidden mypage">2</div>
								<div class="page3 page-hidden mypage">3</div>
								<div class="page4 page-hidden mypage">4</div>
								<div class="page5 page-hidden mypage">5</div>
								<div class="page6 page-hidden mypage">6</div>
								<div class="page7 page-hidden mypage">7</div>
								<div class="page8 page-hidden mypage">8</div>
								<div class="page9 page-hidden mypage">9</div>
								<div class="page10 page-hidden mypage">10</div>
								<!-- 分页，页码 -->

							</div>
					</li>
					<li>
						<div class="course-type row">
							<div class="col-sm-1"></div>
							<div class="col-sm-1 uk-text-center">分类：</div>

							<c:forEach items="${subType1003}" var="type" begin="0" end="7"
								step="1">
								<div class="col-sm-1 uk-text-center">
									<a href="#">${type.tname}</a>
								</div>
							</c:forEach>
						</div> <br>
						<div class="course-level row">
							<div class="col-sm-1"></div>

							<div class="col-sm-1 uk-text-center">难度：</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#" class="course-active">全部</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">初级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">中级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">高级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">大师</a>
							</div>
						</div>
						<hr style="border-color: #DDDDDD;">


						<div class="page">
							<!-- 第一页 -->
							<div class="page1 page-show mypage">
								<div class="course" id="myContainer">
									<div class="row">
										<c:forEach items="${coursesMap['1003']}" var="course">
												<div class="col-md-3 my-class">
													<a href="sectionDetail?cid=${course.cid}">
														<div class="uk-thumbnail uk-thumbnail-small uk-overlay-hover">
															<img class="uk-overlay-scale" src="${course.pic}"
																alt="213"> <br>
															<figcaption
																class="uk-overlay-panel uk-overlay-slide-right">
															<span class="uk-text-small text-background">${course.level}</span>
															<br>
															<span class="uk-text-small text-background">章节数：${course.chapter_num}</span>
															</figcaption>
															<div class="uk-thumbnail-caption ">
																<h5 class="uk-text-bold">${course.cname}</h5>
																<p class="text-ellipsis uk-text-muted uk-text-small">${course.cdesc}</p>
																<span class="uk-text-small">更新完毕</span> | <span
																	class="uk-text-small">${course.stu_num}人学习</span>
															</div>
														</div>
													</a>
												</div>
											</c:forEach>

									</div>
									<br>
									<div class="row"></div>

								</div>
								<div class="page2 page-hidden mypage">2</div>
								<div class="page3 page-hidden mypage">3</div>
								<div class="page4 page-hidden mypage">4</div>
								<div class="page5 page-hidden mypage">5</div>
								<div class="page6 page-hidden mypage">6</div>
								<div class="page7 page-hidden mypage">7</div>
								<div class="page8 page-hidden mypage">8</div>
								<div class="page9 page-hidden mypage">9</div>
								<div class="page10 page-hidden mypage">10</div>
								<!-- 分页，页码 -->

							</div>
					</li>
					<li>
						<div class="course-type row">
							<div class="col-sm-1"></div>
							<div class="col-sm-1 uk-text-center">分类：</div>

							<c:forEach items="${subType1004}" var="type" begin="0" end="7"
								step="1">
								<div class="col-sm-1 uk-text-center">
									<a href="#">${type.tname}</a>
								</div>
							</c:forEach>
						</div> <br>
						<div class="course-level row">
							<div class="col-sm-1"></div>

							<div class="col-sm-1 uk-text-center">难度：</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#" class="course-active">全部</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">初级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">中级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">高级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">大师</a>
							</div>
						</div>
						<hr style="border-color: #DDDDDD;">


						<div class="page">
							<!-- 第一页 -->
							<div class="page1 page-show mypage">
								<div class="course" id="myContainer">
									<div class="row">
										<c:forEach items="${coursesMap['1004']}" var="course">
												<div class="col-md-3 my-class">
													<a href="sectionDetail?cid=${course.cid}">
														<div class="uk-thumbnail uk-thumbnail-small uk-overlay-hover">
															<img class="uk-overlay-scale" src="${course.pic}"
																alt="213"> <br>
															<figcaption
																class="uk-overlay-panel uk-overlay-slide-right">
															<span class="uk-text-small text-background">${course.level}</span>
															<br>
															<span class="uk-text-small text-background">章节数：${course.chapter_num}</span>
															</figcaption>
															<div class="uk-thumbnail-caption ">
																<h5 class="uk-text-bold">${course.cname}</h5>
																<p class="text-ellipsis uk-text-muted uk-text-small">${course.cdesc}</p>
																<span class="uk-text-small">更新完毕</span> | <span
																	class="uk-text-small">${course.stu_num}人学习</span>
															</div>
														</div>
													</a>
												</div>
											</c:forEach>

									</div>
									<br>
									<div class="row"></div>

								</div>
								<div class="page2 page-hidden mypage">2</div>
								<div class="page3 page-hidden mypage">3</div>
								<div class="page4 page-hidden mypage">4</div>
								<div class="page5 page-hidden mypage">5</div>
								<div class="page6 page-hidden mypage">6</div>
								<div class="page7 page-hidden mypage">7</div>
								<div class="page8 page-hidden mypage">8</div>
								<div class="page9 page-hidden mypage">9</div>
								<div class="page10 page-hidden mypage">10</div>
								<!-- 分页，页码 -->

							</div>
					</li>
					<li>
						<div class="course-type row">
							<div class="col-sm-1"></div>
							<div class="col-sm-1 uk-text-center">分类：</div>

							<c:forEach items="${subType1005}" var="type" begin="0" end="7"
								step="1">
								<div class="col-sm-1 uk-text-center">
									<a href="#">${type.tname}</a>
								</div>
							</c:forEach>
						</div> <br>
						<div class="course-level row">
							<div class="col-sm-1"></div>

							<div class="col-sm-1 uk-text-center">难度：</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#" class="course-active">全部</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">初级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">中级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">高级</a>
							</div>
							<div class="col-sm-1 uk-text-center">
								<a href="#">大师</a>
							</div>
						</div>
						<hr style="border-color: #DDDDDD;">


						<div class="page">
							<!-- 第一页 -->
							<div class="page1 page-show mypage">
								<div class="course" id="myContainer">
									<div class="row">
										<c:forEach items="${coursesMap['1005']}" var="course">
												<div class="col-md-3 my-class">
													<a href="sectionDetail?cid=${course.cid}">
														<div class="uk-thumbnail uk-thumbnail-small uk-overlay-hover">
															<img class="uk-overlay-scale" src="${course.pic}"
																alt="213"> <br>
															<figcaption
																class="uk-overlay-panel uk-overlay-slide-right">
															<span class="uk-text-small text-background">${course.level}</span>
															<br>
															<span class="uk-text-small text-background">章节数：${course.chapter_num}</span>
															</figcaption>
															<div class="uk-thumbnail-caption ">
																<h5 class="uk-text-bold">${course.cname}</h5>
																<p class="text-ellipsis uk-text-muted uk-text-small">${course.cdesc}</p>
																<span class="uk-text-small">更新完毕</span> | <span
																	class="uk-text-small">${course.stu_num}人学习</span>
															</div>
														</div>
													</a>
												</div>
											</c:forEach>

									</div>
									<br>
									<div class="row"></div>

								</div>
								<div class="page2 page-hidden mypage">2</div>
								<div class="page3 page-hidden mypage">3</div>
								<div class="page4 page-hidden mypage">4</div>
								<div class="page5 page-hidden mypage">5</div>
								<div class="page6 page-hidden mypage">6</div>
								<div class="page7 page-hidden mypage">7</div>
								<div class="page8 page-hidden mypage">8</div>
								<div class="page9 page-hidden mypage">9</div>
								<div class="page10 page-hidden mypage">10</div>
								<!-- 分页，页码 -->

							</div>
					</li>
				</ul>
				<br>
				<!-- 分页，页码 -->
				<ul class="uk-pagination"
					data-uk-pagination="{items:10, itemsOnPage:1, currentPage:0}"></ul>
			</div>
		</div>
	</div>
	<!-- 脚部 -->
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
	<script type="text/javascript">
		$(function() {
			$(".course-type a").click(function() {
				$(".course-type a").removeClass("course-active");
				$(this).addClass("course-active");
			});
			$(".course-level a").click(function() {
				$(".course-level a").removeClass("course-active");
				$(this).addClass("course-active");
			});
		});
		$('[data-uk-pagination]').on('select.uk.pagination',
				function(e, pageIndex) {
					var cur = '.page' + (pageIndex + 1);
					//var cur = '.page1'
					$(".page .mypage").removeClass("page-show");
					$(".page .mypage").addClass("page-hidden");
					$(cur).removeClass("page-hidden");
					$(cur).addClass("page-show");
				});
	</script>
</body>
</html>