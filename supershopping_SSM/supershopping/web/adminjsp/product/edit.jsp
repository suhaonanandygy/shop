<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<body>
	<!--  -->
	<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/admin/adminProduct_update"
		 method="post"	enctype="multipart/form-data">
		&nbsp;<input type="hidden" name="product_id" value="${sessionScope.findProductByPid.product_id}"/>
		<input type="hidden" name="product_image" value="${sessionScope.findProductByPid.product_image}">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品名称：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="product_name" value="${sessionScope.findProductByPid.product_name}"  class="bg" />
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					是否热门：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="product_popular">
						<c:if test="${sessionScope.findProductByPid.product_popular==1}">
							<option value="1" selected>是</option>
							<option value="0" >否</option>
						</c:if>
						<c:if test="${sessionScope.findProductByPid.product_popular==0}">
							<option value="1" >是</option>
							<option value="0" selected>否</option>
						</c:if>
							
					</select>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					原价格：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="product_originalprice" value="${sessionScope.findProductByPid.product_originalprice}"  class="bg" />
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					优惠价格：
				</td>
				<td class="ta_01" bgColor="#ffffff">
				<input type="text" name="product_specialprice" value="${sessionScope.findProductByPid.product_specialprice}"  class="bg" />
					</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				<input type="file" name="file" />&nbsp;<br/>
				<img src="../${sessionScope.findProductByPid.product_image}" width="400px" height="350px"/>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					所属的二级分类：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
					<select name="sortsecond_id">
							<c:forEach items="${sessionScope.sortSecondList}" var="sortsecond">
								<c:if test="${sortsecond.sortsecond_id == sessionScope.findProductByPid.product_sort}">
									<option value="${sortsecond.sortsecond_id}" selected>${sortsecond.sortsecond_name}</option>
								</c:if>
								<c:if test="${sortsecond.sortsecond_id != sessionScope.findProductByPid.product_sort}">
									<option value="${sortsecond.sortsecond_id}">${sortsecond.sortsecond_name}</option>
								</c:if>
							</c:forEach>
					</select>
				</td>
			</tr>

			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<button type="submit" id="userAction_save_do_submit" value="确定"
						class="button_ok">&#30830;&#23450;</button> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>