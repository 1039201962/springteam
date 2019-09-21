$(".button-payment-address").click(function(){

	var register_form = document.getElementById('register_form');
	var params = {
			
		username : document.getElementById("userName").value,
		email : document.getElementById("email").value,
		mobile : document.getElementById("mobile").value,
		password : document.getElementById("password").value,
		passwordConfirm : document.getElementById("password-confirm").value,
		address1 : document.getElementById("address1").value,
		address2 : document.getElementById("address2").value,
		city : document.getElementById("city").value,
		postCode : document.getElementById("post-code").value,
		country : document.getElementById("country").value,
		regionState : document.getElementById("region-state").value,
	}
	if(username == "" ){
		alert("用户名不能为空！");
		return false;
	}
	if(email == "" ){
		alert("电子邮件不能为空！");
		return false;
	}
	if(mobile == "" ){
		alert("电话不能为空！");
		return false;
	}

	if(password == "" ){
		alert("密码不能为空！");
		return false;
	}
	if(passwordConfirm !== password){
		alert("两次密码不一致！！");
		return false;
	}

	else{
		button-payment-address.submit();

		return true;
	}
	$.post(url,params,function(result){
		if(result.state==1){
			//跳转到indexUI对应的页面
			location.href="doIndex?t="+Math.random();
		 }else{
			/*$(".login-box-msg").html(result.message);*/ 
		 }
		 return false;//防止刷新时重复提交
	});

})