<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
	<script type="text/javascript">

		function filename() {
			var file = $("#file").val();
			var parame = encodeURI(file);
			alert(parame)
			$.ajax({
				type: 'POST',
				dataType: 'text',
				url: '${pageContext.request.contextPath}/file/filename?filename=' + parame,
			});
		}
	</script>

</HEAD>

<body>
	<!--  -->
	<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/admin/adminProduct_save"
		 method="post"	enctype="multipart/form-data">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加商品</STRONG> </strong></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品名称：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="product_name" value="" id="userAction_save_do_logonName" class="bg" />
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					是否热门：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="product_popular">
							<option value="1">是</option>
							<option value="0">否</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					原价格：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="product_originalprice" value=""  class="bg" />
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					优惠价格：
				</td>
				<td class="ta_01" bgColor="#ffffff">
				<input type="text" name="product_specialprice" value=""  class="bg" />
					</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				<input type="file" name="file"  multiple="multiple" />

				</td>



			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					所属的二级分类：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
					<select name="sortsecond_id">
							<c:forEach items="${sessionScope.sortSecondList}" var="sortsecond">
								<option value="${sortsecond.sortsecond_id}">${sortsecond.sortsecond_name}</option>
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