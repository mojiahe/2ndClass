$(document).ready(function() {

	// ���Ƚ�#back-to-top����

	$("#back-to-top").hide();

	$(function() {
		$(window).scroll(function() {
			if ($(window).scrollTop() > 300) {
				$("#back-to-top").fadeIn(1500);
			} else {
				$("#back-to-top").fadeOut(1500);
			}
			
		});

		// �������ת���Ӻ󣬻ص�ҳ�涥��λ��

		$("#back-to-top").click(function() {
			$('body,html').animate({
				scrollTop : 0
			}, 1000);
			return false;
		});
	});

	$('#isRemember').click(function(e){
		if (true == $(this).is(':checked')){
			$('#rememberOrNot').val('true');
		}
		if (false == $(this).is(':checked')){
			$('#rememberOrNot').attr("value","false");
		}
	
	});
	//登录按钮点击事件
	$('button#btn_login').click(function(event){
	
		if($('#form_login input[type=text]').val() == ''){
			return;
		}
		if($('#form_login input[type=password]').val() == ''){
			return;
		}
		/*alert($('form#form_login').serialize());*/
		 $.ajax( {    
		        url:'userAction!login',// 跳转到 action    
		        data:$('form#form_login').serialize(),   
		        type:'post',   
		        success:function(data) {
		            if(data.trim()=='success'){
		            	location.href = "index.jsp";
		            }else{
		            	$("#div_login_msg").show();
		            	$("#msg").html(data);
		            }
		         },     
		         error:function(data){
		        	 alert('异步请求出错...');
		         }
		    });
		event.preventDefault();
	});
	
	//注册按钮点击事件
	$('button#btn_register').click(function(e){
		if($('#reg_username').val() == ''){
			return;
		}
		if($('#reg_pwd').val() == ''){
			return;
		}
		if($('#reg_tel').val() == ''){
			return;
		}
		
		//alert($('form#form_register').serialize());
		
		 $.ajax( {    
		        url:'userAction!register',// 跳转到 action    
		        data:$('form#form_register').serialize(),   
		        type:'post',   
		        success:function(data) {
		            if(data.trim()=='success'){
		            	location.href = "index.jsp";
		            }else{
		            	$("#div_reg_msg").show();
		            	$("#reg_msg").html(data);
		            }
		         },     
		         error:function(data){
		        	 alert('异步请求出错...');
		         }
		    });
		
		e.preventDefault();
	});
});