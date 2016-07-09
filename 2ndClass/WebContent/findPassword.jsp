<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/index-normalize.css" />
<link rel="stylesheet" type="text/css" href="css/index-default.css">
<link rel="stylesheet" type="text/css" href="css/index-styles.css">
<script type="text/javascript">
		function clickthis(){
			var text1 = document.getElementById('password1').value;
			var text2 = document.getElementById('password2').value;
			if(text1 != text2){
				document.getElementById('password1').value = "";
				document.getElementById('password2').value = "";
				alert("两次密码不一致！");
				return false;
			}
				return true;
			
		}
</script>
</head>
<body>
	<div class="htmleaf-container">
	 <div class="wrapper">
	   <div class="container">
		 <h1>密码重置</h1>
		 <h5 id="message" style="display:none">${message }</h5>
		 <form class="form" method="post" action="managerAction!resetManagerPwd">
			<input required="required" type="password" id="password1" name="manager.password" placeholder="新密码">
			<input required="required" type="password" id="password2"  placeholder="确认新密码">
			<button type="submit" onclick=" return clickthis()" id="login-button">重置密码</button>
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