<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/admin/adminProduct_addPage";
			}
			function edit(product_id) {
				window.location.href = "${pageContext.request.contextPath}/admin/adminProduct_edit?product_id="+product_id;
			}
			function deletecs(product_id) {
				window.location.href = "${pageContext.request.contextPath}/admin/adminProduct_deletecs?product_id="+product_id;
			}
		</script>
</HEAD>
<body>
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<TBODY>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
				</TD>
			</tr>
			<tr>
				<td align="right">
					<button type="button" onclick="addProduct()">添加</button>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

							<td align="center" width="7%">序号</td>

							<td align="center" width="17%">商品名称</td>
							<td align="center" width="14%">商品原价</td>
							<td align="center" width="14%">商品特价</td>
							<td align="center" width="17%">商品图片</td>
							<td align="center" width="7%">是否热门</td>
							<td align="center" width="10%">上架时间</td>
							<td width="7%" align="center">编辑</td>
							<td width="7%" align="center">删除</td>
						</tr>
						<c:forEach items="${sessionScope.allProPageBean.list }" var="product">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="7%">${product.product_id }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${product.product_name }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="14%">${product.product_originalprice}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="14%">${product.product_specialprice}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%"><img width="40" height="45"
									src="${ pageContext.request.contextPath }/${product.product_image}"></td>



								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%"><c:choose>
										<c:when test="${product.product_popular==1 }">
														是
										</c:when>
										<c:otherwise>
														否
										</c:otherwise>
									</c:choose></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="10%">${product.product_date}</td>
								<td align="center">
									<button type="button" onclick="edit(${product.product_id})">编辑</button>
								</td>
								<td align="center">
									<button type="button" onclick="deletecs(${product.product_id})">删除</button>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr align="center">
				<td colspan="5">第 ${sessionScope.allProPageBean.page}/${sessionScope.allProPageBean.totlePage }页
					<c:if test="${sessionScope.allProPageBean.page != 1 }">
						<a
							href="${pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=1">首页</a>|
			     	<a
							href="${pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=${sessionScope.allProPageBean.page-1}">上一页</a>
					</c:if> 
					<c:forEach begin="1" end="${sessionScope.allProPageBean.totlePage }" var="i">
						<c:choose>
							<c:when test=" ${sessionScope.allProPageBean.page!=i}">
								<a
									href="${ pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=${i}">${i}</a>
							</c:when>
							<c:otherwise>
								<span class="currentPage">${i}</span>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${sessionScope.allProPageBean.page!= sessionScope.allProPageBean.totlePage }">
						<a
							href="${pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=${sessionScope.allProPageBean.page+1}">下一页</a> |
							<a
							href="${pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=${sessionScope.allProPageBean.totlePage }">尾页</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<td><a class="button button-primary" href="${pageContext.request.contextPath}/admin/return">返回</a></td>
			</tr>
		</TBODY>
	</table>
</body>
</HTML>

