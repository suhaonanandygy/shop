<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2022/6/28
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购物车</title>
    <link href="${ pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css">
    <link href="${ pageContext.request.contextPath }/css/cart.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function checkDel() {
            return window.confirm("您确定要删除吗?");
        }
        function checkClear() {
            return window.confirm("确定要清空购物车吗?");
        }
    </script>

</head>
<body>
<div class="container header">
    <div class="span5">
        <div class="logo">
            <a href="http://localhost:8080/mango/"> <img
                    src="${ pageContext.request.contextPath }/image/r___________renleipic_01/logo.gif"
                    alt=""></a>
        </div>
    </div>
    <div class="span9">
        <div class="headerAd">
            <img src="${ pageContext.request.contextPath }/image/header.jpg"
                 width="320" height="50" alt="正品保障" title="正品保障">
        </div>
    </div>
    <%@ include file="menu.jsp"%>
</div>
<div class="container cart">
    <c:choose>
    <c:when test="${sessionScope.cart.size()>='1'}">
    <div class="span24">
        <div class="step step1"></div>
        <table>
            <tbody>
            <tr>
                <th>图片</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            <c:forEach var="entry" items="${sessionScope.cart}">
                <tr>
                    <!-- 商品图片 -->
                    <td width="60">
                        <input type="hidden" name="id" value="22">
                        <img src="${ pageContext.request.contextPath }/${entry.shoppingcart_pimage}"></td>
                    <!-- 商品名称 -->
                    <td><a target="_blank"> ${entry.shoppingcart_pname}</a></td>
                    <!-- 商品单价 -->
                    <td>${entry.shoppingcart_pprice }</td>
                    <!-- 商品数量 -->
                    <td class="quantity" width="60">${entry.shoppingcart_pcount }</td>
                    <!-- 小计 -->
                    <td class="quantity" width="60">${entry.shoppingcart_ptotal}</td>
                    <td><a href="${ pageContext.request.contextPath }/deleteCartShop?pid=${entry.shoppingcart_pid}"
                           class="delete" onclick="return checkDel();">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
      <div class="total">
            <em id="promotion"></em> <em> 登录后确认是否享有优惠 </em> 赠送积分: <em
                id="effectivePoint">${sessionScope.total}</em> 商品金额: <strong
                id="effectivePrice">${sessionScope.total}</strong>
        </div>
        <div class="bottom">
            <a href="${ pageContext.request.contextPath }/deleteAllCart"
               id="clear" class="clear" onclick="return checkClear();">清空购物车</a>
            <a
                    href="${ pageContext.request.contextPath }/addOrder"
                    id="submit" class="submit">提交订单</a>
        </div>
    </div>
</div>
</c:when>
<c:otherwise>
    <div class="span24">
        <div class="step step1">
            <span><h2>已添加入购物车~</h2></span>
        </div>
    </div>
</c:otherwise>
</c:choose>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="${ pageContext.request.contextPath }/image/footer.jpg"
                 width="950" height="52" alt="我们的优势" title="我们的优势">
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
