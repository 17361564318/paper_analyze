<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>班级信息</title>

<link rel="stylesheet" href="css.css">
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>


</head>
<body>



	<h3 class="route-postion">
		<span class="module-name"> 班级信息</span> <span>列表</span>
	</h3>

	<div class="form-search">
		<form name="form1" id="formSearch" method="get" action="">
			搜索: 班级：<input type="text" style="" name="banji"
				value="${param.banji}" /> <select name="order" id="orderby">
				<option value="id">按发布时间</option>
			</select> <select name="sort" id="sort">
				<option value="desc">倒序</option>
				<option value="asc">升序</option>
			</select>
			<script>
				$("#orderby").val("${orderBy}");
				$("#sort").val("${sort}");
			</script>
			<input type="submit" class="btn btn-search" name="Submit" value="查找" />


		</form>
	</div>
	<div class="list-table">
		<table width="100%" border="1"
			class="table table-list table-bordered table-hover">
			<thead>
				<tr align="center">
					<th width="60" align="center" bgcolor="CCFFFF">序号</th>
					<th>班级</th>
					<th width="180" align="center" bgcolor="CCFFFF">添加时间</th>
					<th width="120" align="center" bgcolor="CCFFFF">操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="map">
					<tr>
						<td width="30" align="center"><label> ${map.id} </label></td>
						<td>${map.banji}</td>
						<td align="center">${map.addtime}</td>
						<td align="center"><a href="banjixinxi_updt.do?id=${map.id}">修改</a>
							<a href="banjixinxi_delete.do?id=${map.id}"
							onClick="return confirm('真的要删除？')">删除</a> <!--qiatnalijne--></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	${ page.info }



</body>
</html>
