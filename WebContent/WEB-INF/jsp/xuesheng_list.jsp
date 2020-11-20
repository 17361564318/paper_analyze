<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学生</title>

<link rel="stylesheet" href="css.css">
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>


</head>
<body>


	<h3 class="route-postion">
		<span class="module-name"> 学生</span> <span>列表</span>
	</h3>

	<div class="form-search">
		<form name="form1" id="formSearch" method="get" action="">
			搜索: 学生学号：<input type="text" style="" name="xueshengxuehao"
				value="${param.xueshengxuehao}" /> 学生姓名：<input type="text" style=""
				name="xueshengxingming" value="${param.xueshengxingming}" /> 所在班级：<select
				data-value="${param.suozaibanji}" data-rule-required="true"
				data-msg-required="请填写所在班级" id="suozaibanji" name="suozaibanji"
				class="class_suozaibanji7">
				<option value="">请选择</option>
				<ssm:sql var="select" type="select">SELECT * FROM banjixinxi ORDER BY id desc</ssm:sql>
				<c:forEach items="${select}" var="m">
					<option value="${m.banji}">${m.banji}</option>
				</c:forEach>
			</select>
			<script>
				$(".class_suozaibanji7").val(
						$(".class_suozaibanji7").attr("data-value"))
			</script>

			<select name="order" id="orderby">
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
					<th>学生学号</th>
					<th>学生姓名</th>
					<th>性别</th>
					<th>学生照片</th>
					<th>所在班级</th>
					<th>联系电话</th>
					<th width="120" align="center" bgcolor="CCFFFF">操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="map">
					<tr>
						<td width="30" align="center"><label> ${map.id} </label></td>
						<td>${map.xueshengxuehao}</td>
						<td>${map.xueshengxingming}</td>
						<td>${map.xingbie}</td>
						<td><c:choose>
								<c:when test="${'' == map.xueshengzhaopian }">
                        -</c:when>
								<c:otherwise>
									<img width="100" src="${map.xueshengzhaopian}" />
								</c:otherwise>
							</c:choose></td>
						<td>${map.suozaibanji}</td>
						<td>${map.lianxidianhua}</td>

						<td align="center"><c:choose>
								<c:when test="${'管理员' == sessionScope.cx }">

									<a href="xuesheng_updt.do?id=${map.id}">修改</a>
									<a href="xuesheng_delete.do?id=${map.id}"
										onClick="return confirm('真的要删除？')">删除</a>
								</c:when>
							</c:choose> <!--qiatnalijne--></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	${ page.info }


</body>
</html>
