<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
		function addSortSecond(){
			window.location.href = "${pageContext.request.contextPath}/admin/adminSortSecond_addPage";
		}
		function edit(sortsecond_id) {
			window.location.href = "${pageContext.request.contextPath}/admin/adminSortSecond_edit?sortsecond_id="+sortsecond_id;
		}
		function deletecs(sortsecond_id) {
			window.location.href ="${pageContext.request.contextPath}/admin/adminSortSecond_delete?sortsecond_id="+sortsecond_id;
		}
		</script>
</head>
<body>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tr>
			<td align="center" bgColor="#afd1f3"><strong>二级分类 列表</strong></td>
		</tr>
		<tr>
			<td align="right">
				<button type="button" onclick="addSortSecond()">添加</button>
			</td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe">
				<table cellspacing="0" cellpadding="0" rules="all" border="1"
					style="WIDTH: 100%;">
					<tr
						style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
						<td align="center" width="18%">序号</td>

						<td align="center" width="17%">二级分类名称</td>
						<td width="7%" align="center">编辑</td>
						<td width="7%" align="center">删除</td>
					</tr>
					<c:forEach items="${sessionScope.csPageBean.list}" var="sortsecond" >
						<tr onmouseover="this.style.backgroundColor = 'white'"
							onmouseout="this.style.backgroundColor = '#F5FAFE';">
							<td align="center">${sortsecond.sortsecond_id}</td>
							<td align="center">${sortsecond.sortsecond_name}</td>
							<td align="center">
								<button type="button" onclick="edit(${sortsecond.sortsecond_id})">编辑</button>
							</td>
							<td align="center">
								<button type="button" onclick="deletecs(${sortsecond.sortsecond_id})">删除</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr align="center">
			<td colspan="4"> <c:if test="${sessionScope.csPageBean.page!= 1}">
					<a
						href="${pageContext.request.contextPath }/admin/adminSortSecond_findAllByPage?page=1">首页</a>|
			     	<a
						href="${pageContext.request.contextPath }/admin/adminSortSecond_findAllByPage?page=${sessionScope.csPageBean.page-1}">上一页</a>
				</c:if>
				 <c:forEach begin="1" end="${sessionScope.csPageBean.totlePage}" var="i">
					<c:choose>
						<c:when test="${sessionScope.csPageBean.page!=i}">
							<a
								href="${ pageContext.request.contextPath }/admin/adminSortSecond_findAllByPage?page=${i}">${i}</a>
						</c:when>
						<c:otherwise>
							<span class="currentPage">${i}</span>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<c:if test="${sessionScope.csPageBean.page!=sessionScope.csPageBean.totlePage}">
					<a
						href="${pageContext.request.contextPath }/admin/adminSortSecond_findAllByPage?page=${sessionScope.csPageBean.page+1}">下一页</a> |
							<a
						href="${pageContext.request.contextPath }/admin/adminSortSecond_findAllByPage?page=${sessionScope.csPageBean.totlePage}">尾页</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<td><a class="button button-primary" href="${pageContext.request.contextPath}/admin/return">返回</a></td>
		</tr>
	</table>
</body>
</HTML>

