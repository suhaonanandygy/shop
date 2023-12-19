<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2022/6/28
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span10 last">
    <div class="topNav clearfix">
        <ul>
            <c:choose>
                <c:when test="${sessionScope.USER_SESSION==null}">
                    <li id="headerLogin" class="headerLogin" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/login">登录</a>|
                    </li>
                    <li id="headerRegister" class="headerRegister" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/register">注册</a>|</li>
                    <li id="headerLogin" class="headerLogin" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/messageList?page=1" style="color: red;">留言板</a>
                        |</li>
                </c:when>
                <c:otherwise>
                    <li id="headerLogin" class="headerLogin" style="display: list-item;">
                            ${sessionScope.USER_SESSION.user_name}
                    </li>
                    <li id="headerLogin" class="headerLogin" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/myOrder?page=1" style="color: red;">我的订单</a>
                        |</li>
                    <li id="headerLogin" class="headerLogin" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/messageList?page=1" style="color: red;">留言板</a>
                        |</li>
                    <div class="cart">
                        <a href="${pageContext.request.contextPath}/myCart">购物车</a>
                    </div>
                    <li id="headerLogout" class="headerLogout" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/userExit">退出</a>|</li>
                </c:otherwise>
            </c:choose>

            <li><a href="${pageContext.request.contextPath}/admin/adminLogin">后台登录</a></li>
        </ul>
    </div>

    <div class="phone">
        <form method="post" action="${pageContext.request.contextPath}/searchProduct" >
            <input id="condition" name="condition" type="text" value="请输入关键词" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = '请输入关键词';}">
            <input id="searchSub" type="submit" value="搜">
        </form>
    </div>
</div>
<div class="span24">
    <ul class="mainNav">
        <li><a href="${pageContext.request.contextPath}/main">首页</a> |</li>
        <c:forEach var="c" items="${sessionScope.cList}">
            <li><a href="${pageContext.request.contextPath}/findSortFirst?sortfirst_id=${c.sortfirst_id}&page=1">${c.sortfirst_name}</a> |</li>
        </c:forEach>
    </ul>
</div>

