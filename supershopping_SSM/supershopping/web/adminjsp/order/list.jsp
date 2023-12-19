<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>订单</title>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>

</head>
<body>
<br>
<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/adminjsp/order/list.jsp" method="post">
    <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
        <TBODY>
        <tr>
            <td class="ta_01" align="center" bgColor="#afd1f3">
                <strong>订单列表</strong>
            </TD>
        </tr>

        <tr>
            <td class="ta_01" align="center" bgColor="#f5fafe">
                <table cellspacing="0" cellpadding="1" rules="all"
                       bordercolor="gray" border="1" id="DataGrid1"
                       style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                    <tr
                            style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">


                        <td align="center" width="4%">
                            订单编号
                        </td>
                        <td align="center" width="6%">
                            订单总价
                        </td>
                        <td align="center" width="10%">
                            订单状态
                        </td>
                        <td align="center" width="18%">
                            收货地址
                        </td>
                        <td align="center" width="10%">
                            收货电话
                        </td>
                        <td align="center" width="10%">
                            收货人
                        </td>
                        <td align="center" width="10%">
                            下单时间
                        </td>
                        <td align="center" width="40%">
                            订单详情
                        </td>
                    </tr>
                    <c:forEach items="${sessionScope.pageBean.list}" var="order" varStatus="status">
                        <tr onmouseover="this.style.backgroundColor = 'white'"
                            onmouseout="this.style.backgroundColor = '#F5FAFE';">
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="4%">
                                    ${order.order_id}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="6%">
                                    ${order.order_totalprice}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="10%">
                                <c:if test="${order.order_state==0}">
                                    订单未付款
                                </c:if>
                                <c:if test="${order.order_state==1}">
                                    订单未发货<a href="${ pageContext.request.contextPath }/admin/adminOrder_updateState?order_id=${order.order_id}&status=2"><font color="blue">发货</font></a>
                                </c:if>
                                <c:if test="${order.order_state==2}">
                                    等待确认收货
                                </c:if>
                                <c:if test="${order.order_state==3}">
                                    订单已完成
                                </c:if>

                            </td>

                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="10%">
                                    ${order.order_receiveaddr}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="10%">
                                    ${order.order_receivephone}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="10%">
                                    ${order.order_accepter}
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="10%">
                                    ${order.order_time}
                            </td>
                            <td align="center" style="HEIGHT: 22px">
                                <div id="div${order.order_id}">
                                    <table width="100%">
                                        <c:forEach items="${order.oiList}" var="orderitem">
                                            <tr>
                                                <td><img width="40" height="45" src="${ pageContext.request.contextPath }/${orderitem.product.product_image}"></td>
                                                <td>商品名称：${orderitem.product.product_name}</td>
                                                <td>商品数量：${orderitem.orderitem_count}</td>
                                                <td>商品单价：${orderitem.orderitem_unitprice}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </td>

                        </tr>
                    </c:forEach>


                </table>
            </td>
        </tr>
        <tr align="center">
        <td colspan="4">

            <c:if test="${sessionScope.pageBean.page != 1}">
                <a href="${ pageContext.request.contextPath }/admin/adminOrder_findAllByPage.action?page=1">首页</a>|
                <a href="${ pageContext.request.contextPath }/admin/adminOrder_findAllByPage.action?page=${sessionScope.pageBean.page-1}">上一页</a>|
            </c:if>
            <c:if test="${sessionScope.pageBean.page != sessionScope.pageBean.totlePage}">
                <a href="${ pageContext.request.contextPath }/admin/adminOrder_findAllByPage.action?page=${sessionScope.pageBean.page+1}">下一页</a>|
                <a href="${ pageContext.request.contextPath }/admin/adminOrder_findAllByPage.action?page=${sessionScope.pageBean.totlePage}">尾页</a>|
            </c:if>
        </td>
        </tr>
        <tr>
            <td><a class="button button-primary" href="${pageContext.request.contextPath}/admin/return">返回</a></td>
        </tr>
        </TBODY>
    </table>
</form>
</body>
</html>


