<%--
  Created by IntelliJ IDEA.
  User: sun
  Date: 2022/6/29
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <title>订单页面</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="container header">
    <div class="span5">
        <div class="logo">
            <a>
                <img src="${ pageContext.request.contextPath }/image/r___________renleipic_01/logo.gif" alt=""/>
            </a>
        </div>
    </div>
    <div class="span9">
        <div class="headerAd">
            <img src="${ pageContext.request.contextPath }/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
        </div>
    </div>
    <%@ include file="menu.jsp"%>
    <!-- 菜单栏 -->
</div>

<div class="container cart">
    <div class="span24">
        <div class="step step1">
            <ul>
                <li  class="current"></li>
                <li>生成订单成功</li>
            </ul>
        </div>
        <table>
            <tbody>
            <th colspan="5">订单编号:${sessionScope.orders.order_id}&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <tr>
                <th>图片</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
            </tr>
            <c:forEach items="${sessionScope.cart}" var="orderItem">
                <tr>
                    <td width="60">
                        <input type="hidden" name="id" value="22"/>
                        <img src="${pageContext.request.contextPath }/${orderItem.shoppingcart_pimage}">
                    </td>
                    <td>
                        <a target="_blank"> ${orderItem.shoppingcart_pname}</a>
                    </td>
                    <td>
                            ${orderItem.shoppingcart_pprice}
                    </td>
                    <td class="quantity" width="60">
                            ${orderItem.shoppingcart_pcount}
                    </td>
                    <td width="140">
                        <span class="subtotal">${orderItem.shoppingcart_ptotal}</span>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <div class="total">
            <em id="promotion"></em>
            商品金额: <strong id="effectivePrice">${sessionScope.orders.order_totalprice}</strong>
        </div>
        <form id="orderForm" action="${pageContext.request.contextPath}/payOrder" method="post">
            <input type="hidden" name="oid" value="${sessionScope.orders.order_id}"/>
            <div class="span24">
                <p>
                    收货地址：<input name="o_receiveaddr" type="text" value=""  style="width:350px" />
                    <br />
                    收货人&nbsp;&nbsp;&nbsp;：<input name="o_accepter" type="text" value="" style="width:150px" />
                    <br />
                    联系方式：<input name="o_receivephone" type="text" value="" style="width:150px" />
                </p>
                <hr />
                <p>
                    选择银行：<br/>
                    <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
                    <img src="${ pageContext.request.contextPath }/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
                    <img src="${ pageContext.request.contextPath }/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
                    <img src="${ pageContext.request.contextPath }/bank_img/abc.bmp" align="middle"/>
                    <br/>
                    <input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
                    <img src="${ pageContext.request.contextPath }/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
                    <img src="${ pageContext.request.contextPath }/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
                    <img src="${ pageContext.request.contextPath }/bank_img/ccb.bmp" align="middle"/>
                    <br/>
                    <input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
                    <img src="${ pageContext.request.contextPath }/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
                    <img src="${ pageContext.request.contextPath }/bank_img/cmb.bmp" align="middle"/>
                </p>
                <hr />
                <p style="text-align:right">
                    <!-- 在超链接中添加javascript:document.getElementById('orderForm').submit();代码 功能就相当于提交表单 -->
                    <a href="javascript:document.getElementById('orderForm').submit();">
                        <img src="${ pageContext.request.contextPath }/images/finalbutton.gif" width="204" height="51" border="0" />
                    </a>
                </p>
            </div>
        </form>
    </div>

</div>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
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