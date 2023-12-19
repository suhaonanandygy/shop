<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员登录</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

</script>
</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="http://localhost:8080/shop/"> <img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="">
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障"
					title="正品保障">
			</div>
		</div>
		<%@ include file="menu.jsp"%>

	</div>
	<div class="container login">
		<div class="span12">
			<div class="ad">
				<img src="${pageContext.request.contextPath}/image/login.jpg" width="500" height="330" alt="会员登录"
					title="会员登录">
			</div>
		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN
					</div>
					<span style="color: red; font-size: large"> ${LOGIN_MSG} </span>
					<form id="loginForm" method="post" 
					action="${pageContext.request.contextPath}/user/login" novalidate="novalidate">
						<table>
							<tbody>
								<tr>
									<th>用户名:</th>
									<td>
										<input type="text" id="user_name" name="user_name"
										class="text" maxlength="20"  onblur="checkUsername()">
										<span id="span1" style="color:green;"></span>
									</td>
								</tr>
								<tr>
									<th>密&nbsp;&nbsp;码:</th>
									<td><input type="password" id="user_password" name="user_password"
										class="text" maxlength="20" autocomplete="off"></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><label> <input type="checkbox"
											id="isRememberUsername" name="isRememberUsername"
											value="true">记住用户名
									</label> <label> &nbsp;&nbsp;<a>找回密码</a>
									</label></td>
								</tr>
								<tr>
									<th></th>
									<td style="color:#ff0000;"><input type="submit" class="submit" value="登 录">
									&nbsp;${message}
									</td>
								</tr>
								<tr class="register">
									<th>&nbsp;</th>
									<td>
										<dl>
											<dt>还没有注册账号？</dt>
											<dd>
												立即注册即可体验在线购物！ <a href="${pageContext.request.contextPath}/register">立即注册</a>
											</dd>
										</dl>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势"
					title="我们的优势" />
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><hr></hr></li>
			</ul>
		</div>

	</div>
</body>
</html>