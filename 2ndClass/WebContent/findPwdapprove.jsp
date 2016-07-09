<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>身份认证</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/index-normalize.css" />
<link rel="stylesheet" type="text/css" href="css/index-default.css">
<link rel="stylesheet" type="text/css" href="css/index-styles.css">
</head>
<body>
	<div class="htmleaf-container">
	 <div class="wrapper">
	   <div class="container">
		 <h1>身份认证</h1>
		 <h5 id="message" style="display:none">${message }</h5>
		 <form class="form" method="post" action="managerAction!findManagerPwd">
			<input type="text" required="required" name="manager.mname" placeholder="您的帐号">
			<input type="text" required="required" name="manager.tel" placeholder="您绑定的手机号">
			<button type="submit" id="login-button">确认</button>
          <a href="managerlogin.jsp">返回登录</a>
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
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
	<script src="js/jquery.js"></script>
	<script src="js/alertMessage.js"></script>
	<script>
	 $(document.body).css({
	   "overflow-x":"hidden",
	   "overflow-y":"hidden"
	 });
	</script>
</body>
</html>