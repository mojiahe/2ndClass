<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第二课堂-个人中心</title>
<!-- 设置网页头部图标 -->
<link href="images/logo.ico" type="image/x-icon" rel="shortcut icon">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/my.css">

<style>
.list-group-item.active, .list-group-item.active:focus, .list-group-item.active:hover
	{
	background-color: inherit;
}
img{
	margin: 0 auto;
}
</style>
</head>
<body>

	<%@include file="html/header.html"%>

<s:debug></s:debug>
	<div class="row" style="padding: 20px 0px 0px 0px">
		<!-- 左侧导航条 -->
		<div class="col-md-3 ">
			<ul class="list-group nav" role="tab" style="text-align: center">
				<li class="list-group-item"><a href="#userInfo"
					aria-controls="settings" role="tab" data-toggle="tab">个人资料</a></li>
				<li class="list-group-item"><a href="#header"
					aria-controls="settings" role="tab" data-toggle="tab">头像设置</a></li>
				<li class="list-group-item"><a href="#modify"
					aria-controls="settings" role="tab" data-toggle="tab">修改密码</a></li>
				<li class="list-group-item"><a href="#telphone"
					aria-controls="settings" role="tab" data-toggle="tab">绑定手机</a></li>
				<li class="list-group-item"><a href="#plan"
					aria-controls="settings" role="tab" data-toggle="tab">我的计划</a></li>
			</ul>
		</div>
		<!-- 右侧主体内容 -->
		<div class="col-md-8 tab-content">
			<div id="userInfo" class="tab-pane active" role="tabpanel">

				<form class="form-horizontal" method="post"
					action="${pageContext.request.contextPath}/userAction!updateInfo">
					<div class="form-group">
						<label class="col-sm-3 control-label">昵称：</label>
						<div class="col-sm-4">
							<input type="text" name="user.nickname" class="form-control"
								value="${sessionScope.user.nickname}">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">性别：</label>
						<div class="col-sm-4 radio">
							<c:if test="${sessionScope.user.sex == 0}">
								<label class="col-sm-3"> <input type="radio"
									name="user.sex" value="1">男
								</label>
								<label class="col-sm-3"> <input type="radio"
									name="user.sex" value="2">女
								</label>
							</c:if>
							<c:if test="${sessionScope.user.sex == 1}">
								<label class="col-sm-3"> <input type="radio"
									name="user.sex" value="1" checked>男
								</label>
								<label class="col-sm-3"> <input type="radio"
									name="user.sex" value="2">女
								</label>
							</c:if>
							<c:if test="${sessionScope.user.sex == 2}">
								<label class="col-sm-3"> <input type="radio"
									name="user.sex" value="1">男
								</label>
								<label class="col-sm-3"> <input type="radio"
									name="user.sex" value="2" checked>女
								</label>
							</c:if>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">地址：</label>
						<div class="col-sm-4">
							<input type="text" name="user.addr" class="form-control"
								value="${sessionScope.user.addr}">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">职业：</label>
						<div class="col-sm-4">
							<input type="text" name="user.job" class="form-control"
								value="${sessionScope.user.job}">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">个性签名：</label>
						<div class="col-sm-4">
							<textarea rows="5" cols="10" name="user.intro"
								class="form-control" style="resize: none;">${sessionScope.user.intro}</textarea>
						</div>
					</div>

					<div class="form-group">
						<p class="col-sm-4 col-sm-offset-3 control-label">
							<input type="reset" class="btn btn-warning btn-sm" value="重置"></input>
							<input type="submit" class="btn btn-primary btn-sm" value="修改信息"></input>
						</p>
					</div>
				</form>
			</div>

			<div id="header" class="tab-pane" role="tabpanel">

				<form class="form-horizontal" method="post" enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/userAction!updateInfo">

					<div class="form-group">
						<label class="col-sm-6 col-sm-offset-2 control-label"> <c:if
								test="${sessionScope.user.pic != null and sessionScope.user.pic != ''}">
								<p class="col-sm-6 col-sm-offset-2 control-label">
									<img src="/2ndClassPic/${sessionScope.user.pic}"
										class="img-circle img-responsive" width="120" id="pic"
										alt="picture">
								</p>
							</c:if> <c:if test="${sessionScope.user.pic == null or sessionScope.user.pic == ''}">
								<p class="col-sm-6 col-sm-offset-2 control-label">
									<img src="/2ndClassPic/default.jpg" class="img-circle img-responsive"
										width="120" id="pic" alt="picture">
								</p>
								<!-- <p clas="manager_name" >[ 待完善 ]</p> -->
							</c:if>
						</label>

					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">更换头像：</label>
						<div class="col-sm-4">
							<input class="btn btn-default btn-sm col-sm-12" type="file"
								name="user.file" required onchange="showPreview(this)">
						</div>
					</div>

					<div class="form-group">
						<p class="col-sm-4 col-sm-offset-1 control-label">
							<input type="submit" class="btn btn-primary btn-sm" value="上传头像"></input>
						</p>
					</div>
				</form>
			</div>
			<div id="modify" class="tab-pane" role="tabpanel">
				<form id="form_pwd" class="form-horizontal" method="post"
					action="${pageContext.request.contextPath}/userAction!updateInfo">

					<div class="row form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label">旧密码：</label>
						<div class="col-sm-4">
							<input type="password" id="oldPwd" name="user.oldPwd" required class="form-control">
						</div>
					</div>

					<div class="row form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label">新密码：</label>
						<div class="col-sm-4">
							<input type="password" id="newPwd" name="user.newPwd" required class="form-control">
						</div>
					</div>

					<div class="row form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label">确认新密码：</label>
						<div class="col-sm-4">
							<input type="password" id="comfirePwd" name="user.comfirePwd" required class="form-control">
						</div>
					</div>

					<div class="row form-group">
						<p class="col-sm-4 col-sm-offset-4 control-label">
							<input type="reset" class="btn btn-warning btn-sm" value="重置"></input>
							<input type="submit" id="modPwd" class="btn btn-primary btn-sm" value="修改信息"></input>
						</p>
					</div>
				</form>
			</div>
			<div id="telphone" class="tab-pane" role="tabpanel">
				<form class="form-horizontal" method="post"
					action="${pageContext.request.contextPath}/userAction!updateInfo">
					<div class="form-group">
						<label class="col-sm-3 control-label">手机号码：</label>
						<div class="col-sm-4">
							<input type="text" name="user.tel" required class="form-control"
								value="${sessionScope.user.tel}">
						</div>
					</div>



					<div class="form-group">
						<p class="col-sm-4 col-sm-offset-3 control-label">
							<input type="reset" class="btn btn-warning btn-sm" value="重置"></input>
							<input type="submit" class="btn btn-primary btn-sm" value="修改信息"></input>
						</p>
					</div>
				</form>
			</div>
			<div id="plan" class="tab-pane" role="tabpanel">无</div>
		</div>
	</div>
	<input type="hidden" value="${requestScope.message }">
	<script src="js/jquery-1.13.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
	//头像预览
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
	$('#modPwd').click(function(e){
		//alert('modepassword');
		
		var oldPwd = $('#oldPwd').val();
		var newPwd = $('#newPwd').val();
		var comfirePwd = $('#comfirePwd').val();
		
		//alert(oldPwd+'' + newPwd + ''+comfirePwd);
		
		if(newPwd != comfirePwd){
			alert('两次密码不一致！');
			e.preventDefault();
		}
	})
	var msg = $('input[type=hidden]').val();
	if(msg != ''){
		alert(msg);
	}
	</script>
</body>
</html>