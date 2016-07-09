<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/jquery.mCustomScrollbar.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="contents">
		<%@include file="html/header.html"%>
		<%@include file="html/home.html"%>
	</div>

	<span id="message">${message}</span>
	<%@include file="html/modal.html"%>

	<script src="js/jquery.js"></script>
	<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/myJs.js"></script>
	<script>
	 $(document).ready(function(){
		 if($('#message').text()!=""){ //Trim自定义的方法
			 alert($('#message').text());//可以用jQuery的消息框
		 }
	});
	</script>
</body>
</html>