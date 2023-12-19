
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="statics/layui/layui.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>管理员登录</small>
                </h1>
            </div>
        </div>
        <span style="color: red; font-size: large"> ${LOGIN_MSG} </span>
        <form action=" ${pageContext.request.contextPath}/admin/adminLogin" >
            <div class="form-group">
                <label for="admin_account">管理员账户</label>
                <input type="text" class="form-control" id="admin_account" name="admin_account" required>
            </div>
            <div class="form-group">
                <label for="admin_password">管理员密码</label>
                <input type="text" class="form-control" id="admin_password" name="admin_password">
            </div>



            <div class="form-group">
                <button type="submit" class="btn btn-default">登陆</button>
            </div>

            <div class="remember">
                <input type="checkbox" name="remember" id="check" value="1"/>记住我
            </div>



        </form>
    </div>




</div>
</body>
</html>
