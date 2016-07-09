<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员后台登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/index-normalize.css" />
<link rel="stylesheet" type="text/css" href="css/index-default.css">
<link rel="stylesheet" type="text/css" href="css/index-styles.css">
<script src="js/jquery.js"></script>
</head>
<body>
	<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<h1>Welcome</h1>
		
				<h5 id="message" style="display:none">${message}</h5>
				<form id="form" class="form" method="post" action="managerAction!login">
					<input type="text" required="required" name="manager.mname" placeholder="帐号">
					<input type="password" required="required" name="manager.password" placeholder="密码">
					<button type="submit" id="login-button">登录</button>
					<a href="findPwdapprove.jsp">找回密码</a>
				</form>
			</div>
			<ul class="bg-bubbles">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
		
	</div>
	
	
	<script>
	 $(document.body).css({
	   "overflow-x":"hidden",
	   "overflow-y":"hidden"
	 });
	 $(document).ready(function(){
		if($('#message').text()!=""){ //Trim自定义的方法
		 alert($('#message').text());//可以用jQuery的消息框
		}
	});
	</script>
</body>
</html>