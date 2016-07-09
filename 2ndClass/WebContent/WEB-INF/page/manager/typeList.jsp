<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>我的后台--课程类别列表</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link href="jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/style.css">
	<script src="js/jquery.js"></script>
	<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-paginator.min.js"></script>
</head>
<body>
	<div class="contents">
	<%@include file="html/header.html" %>
	<%@include file="html/typeList.html" %>
	</div>
	
	<span id="message">${message}</span>
	<%@include file="html/modal.html" %>
	
	<script src="js/bootstrap.min.js"></script>
	<script src="js/myJs.js"></script>
	<script type="text/javascript">
		$('#collapseFour').addClass('in');
		$('#caret4 #icon').addClass('glyphicon-menu-down').removeClass('glyphicon-menu-right');
		$('#collapseFour').on('hide.bs.collapse', function () {
			$('#caret4 #icon').removeClass('glyphicon-menu-down').addClass('glyphicon-menu-right');
		});
		
		 $(document).ready(function(){
			if($('#message').text()!=""){ //Trim自定义的方法
				alert($('#message').text());//可以用jQuery的消息框
			}
		});
	 </script>
	
</body>
</html>