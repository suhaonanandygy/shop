<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2022/7/1
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购物商城</title>
    <link href="${pageContext.request.contextPath}/css/common.css"
          rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/product.css"
          rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container header">
    <div class="span5">
        <div class="logo">
            <a href="http://localhost:8080/shop/"> <img
                    src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif"
                    alt=""></a>
        </div>
    </div>
    <div class="span9">
        <div class="headerAd">
            <img src="${pageContext.request.contextPath}/image/header.jpg"
                 width="320" height="50" alt="正品保障" title="正品保障">
        </div>
    </div>
    <%@ include file="menu.jsp"%>
    <div class="container productList">
        <div class="span6">
            <div class="hotProductCategory">
                <c:forEach var="c" items="${sessionScope.cList}">
                    <dl>
                        <dt>
                            <a
                                    href="${pageContext.request.contextPath}/findSortFirst?cid=${c.sortfirst_id}&page=1">
                                    ${c.sortfirst_name} </a>
                        </dt>
                        <c:forEach items="${c.csList}" var="cs">
                            <dd>
                                <a
                                        href="${pageContext.request.contextPath}/findSortSecond?csid=${cs.sortsecond_id}&page=1">
                                        ${cs.sortsecond_name}</a>
                            </dd>
                        </c:forEach>
                    </dl>
                </c:forEach>
            </div>
        </div>

        <div class="span18 last">
            <div id="result" class="result table clearfix">
                <ul>
                    <c:forEach items="${pageBean.list}" var="pro">
                        <li><a
                                href="${pageContext.request.contextPath}/productFindById?pid=${pro.product_id}">
                            <img src="${pageContext.request.contextPath}/${pro.product_image}"
                                 width="170" height="170" style="display: inline-block;" /> <span
                                style='color: green'>${pro.product_name}</span> <span class="price">
										商城价： ￥${pro.product_specialprice}/份 </span>
                        </a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="pagination">
                <span>第${pageBean.page}/${pageBean.totlePage}页</span>
                <c:if test="${pageBean.page!=1}">
                    <a
                            href="${ pageContext.request.contextPath }/findSortFirst?sortfirst_id=${sortfirst_id}&page=1"
                            class="firstPage">&nbsp;</a>
                    <a
                            href="${ pageContext.request.contextPath }/findSortFirst?sortfirst_id=${sortfirst_id}&page=${pageBean.page-1}"
                            class="previousPage">&nbsp;</a>
                </c:if>
                <c:forEach var="i" begin="1" end="${pageBean.totlePage}">
                    <c:choose>
                        <c:when test="${pageBean.page!=i}">
                            <a
                                    href="${ pageContext.request.contextPath }/findSortFirst?sortfirst_id=${sortfirst_id}&page=${i}">${i}</a>
                        </c:when>
                        <c:otherwise>
                            <span class="currentPage">${i}</span>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${pageBean.page!=pageBean.totlePage}">
                    <a class="nextPage"
                       href="${ pageContext.request.contextPath }/findSortFirst?sortfirst_id=${sortfirst_id}&page=${pageBean.page+1}">&nbsp;</a>
                    <a class="lastPage"
                       href="${ pageContext.request.contextPath }/findSortFirst?sortfirst_id=${sortfirst_id}&page=${pageBean.totlePage}">&nbsp;</a>
                </c:if>
            </div>
        </div>
        <div class="container footer">
            <div class="span24">
                <div class="footerAd">
                    <img src="${pageContext.request.contextPath}/image/footer.jpg"
                         width="950" height="52" alt="我们的优势" title="我们的优势">
                </div>
            </div>
            <div class="span24">
                <ul class="bottomNav">
                    <li><hr></hr></li>
                </ul>
            </div>

        </div>
    </div>
</body>
</html>