<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript">
		function edit(sortfirst_id) {
			window.location.href = "${pageContext.request.contextPath}/admin/adminSortFirst_edit?sortfirst_id="+sortfirst_id;
		}
		function addSortFirst(){
				window.location.href = "${pageContext.request.contextPath}/admin/adminSortFirst_add";
		}
		function deletec(sortfirst_id) {
			window.location.href ="${pageContext.request.contextPath}/admin/adminSortFirst_delete?sortfirst_id="+sortfirst_id;
		}
		</script>
	</head>
	<body>
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
					<tr>
						<td  align="center"  bgColor="#afd1f3">
							<strong>一级分类 列表</strong>
						</td>
					</tr>
					<tr>
						<td  align="right">
							<button type="button" onclick="addSortFirst()">添加</button>
						</td>
					</tr>
					<tr>
						<td align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="0" rules="all" border="1" style="WIDTH: 100%;">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
									<td align="center" width="18%">
										序号
									</td>
									
									<td align="center" width="17%">
										一级分类名称
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<c:forEach items="${sessionScope.sortFirstList}" var="sortfirst">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td align="center">
												${sortfirst.sortfirst_id}
											</td>
											<td align="center">
												${sortfirst.sortfirst_name}
											</td>
											<td align="center">
												<button type="button" onclick="edit(${sortfirst.sortfirst_id})">编辑</button>
											</td>
											<td align="center">
												<button type="button" onclick="deletec(${sortfirst.sortfirst_id})">删除</button>
											</td>
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
				<tr>
					<td><a class="button button-primary" href="${pageContext.request.contextPath}/admin/return">返回</a></td>
				</tr>
			</table>
	</body>
</HTML>

