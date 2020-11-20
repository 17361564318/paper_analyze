<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>教师</title>

<link rel="stylesheet" href="css.css">
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>


</head>
<body>



	<h3 class="route-postion">
		<span class="module-name"> 教师</span> <span>列表</span>
	</h3>

	<div class="form-search">
		<form name="form1" id="formSearch" method="get" action="">
			搜索: 教师工号：<input type="text" style="" name="jiaoshigonghao"
				value="${param.jiaoshigonghao}" /> 教师姓名：<input type="text" style=""
				name="jiaoshixingming" value="${param.jiaoshixingming}" /> <select
				name="order" id="orderby">
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
					<th>教师工号</th>
					<th>教师姓名</th>
					<th>性别</th>
					<th>所带班级</th>
					<th>教师照片</th>
					<th>联系电话</th>
					<th>身份证</th>
					<th width="180" align="center" bgcolor="CCFFFF">添加时间</th>
					<th width="120" align="center" bgcolor="CCFFFF">操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="map">
					<tr>
						<td width="30" align="center"><label> ${map.id} </label></td>
						<td>${map.jiaoshigonghao}</td>
						<td>${map.jiaoshixingming}</td>
						<td>${map.xingbie}</td>
						<td>${map.suodaibanji}</td>
						<td><c:choose>
								<c:when test="${'' == map.jiaoshizhaopian }">
-</c:when>
								<c:otherwise>
									<img width="100" src="${map.jiaoshizhaopian}" />
								</c:otherwise>
							</c:choose></td>
						<td>${map.lianxidianhua}</td>
						<td>${map.shenfenzheng}</td>
						<td align="center">${map.addtime}</td>
						<td align="center"><a href="jiaoshi_updt.do?id=${map.id}">修改</a>
							<a href="jiaoshi_delete.do?id=${map.id}"
							onClick="return confirm('真的要删除？')">删除</a> </td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	${ page.info }



</body>
</html>
