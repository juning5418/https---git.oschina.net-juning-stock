<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>股票</title>

<link href="assets/css/login-box.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div style="padding: 100px 0 0 250px;">


<div id="login-box">

<H2>注册</H2>
<br/>
<br/>
	 <form id="J_registerForm" method="post" action="./doRegister" role="form">
	 
		<div id="login-box-name" style="margin-top:0px;">用户名:</div>
		<div id="login-box-field" style="margin-top:0px;">
			<input name="username" placeholder="注册用户名" id="username" class="form-login" title="手机" value="" size="30" maxlength="2048" required/>
			<span>*</span>
		</div>
		<div id="login-box-name" style="margin-top:0px;" >手机:</div>
		<div id="login-box-field" style="margin-top:0px;">
			<input name="mobile" id="mobile" placeholder="注册手机" class="form-login" title="手机" value="" size="30" maxlength="2048"   required pattern="^(1(([35][0-9])|(47)|[8][01236789]))\d{8}$"/>
			<span>*</span>
		</div>
		<div id="login-box-name" style="margin-top:0px;" for="email">邮件:</div>
		<div id="login-box-field" style="margin-top:0px;">
			<input name="email" placeholder="注册邮箱" id="email" class="form-login" title="邮箱" value=""  type="email" size="30" maxlength="2048"  required/>
			<span>*</span>
		</div>
		<div id="login-box-name">密码:</div>
		<div id="login-box-field">
			<input name="password" id="password" type="password" class="form-login" title="密码" value="" size="30" maxlength="2048" required/>
			<span>*</span>
		</div>
		<div id="login-box-name">再次输入密码:</div>
		<div id="login-box-field">
			<input name="confirmPassword" id="confirmPassword" type="password" class="form-login" title="次输入密码" value="" size="30" maxlength="2048" required/>
			<span>*</span>
		</div>
		<br/>
		<br/>
		    <button type="submit" value="" >注册</button>
		    <a href="./index">返回登入界面</a>
	</form>
</div>

</div>
</body>
 <script src="assets/js/jquery/jquery-1.9.1.min.js"></script>
  <script src="assets/js/jquery/jquery.html5Validate.min.js"></script>
   <script src="assets/js/user/regist.js"></script>
</html>