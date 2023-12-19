<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

	<head>
		<title>登录</title>
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>
</head>
<html>
<body>
<div class="container">

	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					<small>欢迎使用网上购物系统</small>
				</h1>
			</div>
		</div>
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					<small>您还没有登录，请选择您需要的操作</small>
				</h1>
			</div>
		</div>

		<span style="color: red; font-size: large"> ${LOGIN_MSG} </span>
		<button type="button" class="btn btn-lg btn-primary" id="userRegister" onclick="window.location.href='http://localhost:8080/supershopping/user/register'">用户注册</button>
		<button type="button" class="btn btn-lg btn-primary" id="userLogin" onclick="window.location.href='http://localhost:8080/supershopping/user/login'">用户登录</button>
		<button type="button" class="btn btn-lg btn-primary" id="adminLogin" onclick="window.location.href='http://localhost:8080/supershopping/main'">首页</button>

	</div>

</div>

</body>

</html>

