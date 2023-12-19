<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <title>购物商城</title>

    <link rel="stylesheet" href="./statics/layui/css/layui.css">
    <script src="./statics/layui/layui.js"></script>
</head>
<body class="layui-layout-body" style="overflow: hidden">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">购物商城</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href=""></a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="">欢迎</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child"> <!-- 二级菜单 -->
                        <dd><a href="${pageContext.request.contextPath}/admin/find_allUser">查看用户信息</a></dd>
                    </dl>
                    <a href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child"> <!-- 二级菜单 -->
                        <dd><a href="${pageContext.request.contextPath}/admin/adminSortFirst_findAll">一级分类管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/adminSortSecond_findAllByPage">二级分类管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/adminProduct_findAllByPage">商品管理</a></dd>
                    </dl>
                    <a href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child"> <!-- 二级菜单 -->
                        <dd><a href="${pageContext.request.contextPath}/admin/adminOrder_findAllOrderByPage">所有订单</a></dd>
<%--                        <dd><a href="${ pageContext.request.contextPath }/admin/adminOrder_findByState?order_state=1">已发货订单</a></dd>--%>
<%--                        <dd><a href="${ pageContext.request.contextPath }/admin/adminOrder_findByState?order_state=2">未发货订单</a></dd>--%>
<%--                        <dd><a href="${ pageContext.request.contextPath }/admin/adminOrder_findByState?order_state=3">已签收订单</a></dd>--%>
                    </dl>

                    <a href="javascript:;">注销退出</a>
                    <dl class="layui-nav-child"> <!-- 二级菜单 -->
                        <dd><a href="${pageContext.request.contextPath}/admin/exit">退出登入</a></dd>
                    </dl>

                </li>


            </ul>
        </div>
    </div>

    <div class="layui-body" >
        <!-- 内容主体区域 -->
        <iframe src="https://www.bilibili.com/" frameborder="0" height="100%" width="100%"></iframe>
    </div>


</div>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</body>
</html>