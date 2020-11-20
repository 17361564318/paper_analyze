<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>考试结果</title>

<link rel="stylesheet" href="css.css">
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>


</head>
<body>


	<h3 class="route-postion">
		<span class="module-name"> 考试结果</span> <span>列表</span>
	</h3>

	<div class="form-search">
		<form name="form1" id="formSearch" method="get" action="">
			搜索: 题库编号：<input type="text" style="" name="tikubianhao"
				value="${param.tikubianhao}" /> 题库名称：<input type="text" style=""
				name="tikumingcheng" value="${param.tikumingcheng}" /> 考试编号：<input
				type="text" style="" name="kaoshibianhao"
				value="${param.kaoshibianhao}" /> 单选题得分：<input type="text" style=""
				name="danxuantidefen" value="${param.danxuantidefen}" /> <select
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
					<th>题库编号</th>
					<th>题库名称</th>
					<th>班级</th>
					<th>发布人</th>
					<th>考试编号</th>
					<th>单选题得分</th>
					<th>简答题得分</th>
					<th>填空题得分</th>
					<th>总得分</th>
					<th>考试人</th>
					<th width="180" align="center" bgcolor="CCFFFF">考试时间</th>
					<th width="120" align="center" bgcolor="CCFFFF">操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="map">
					<tr>
						<td width="30" align="center"><label> ${map.id} </label></td>
						<td>${map.tikubianhao}</td>
						<td>${map.tikumingcheng}</td>
						<td>${map.banji}</td>
						<td>${map.faburen}</td>
						<td>${map.kaoshibianhao}</td>
						<td>${map.danxuantidefen}</td>
						<td>${map.jiandatidefen}</td>
						<td>${map.tiankongtidefen}</td>
						<td>${map.zongdefen}</td>
						<td>${map.kaoshiren}</td>
						<td align="center">${map.addtime}</td>
						<td align="center"><a
							href="kaoshijieguo_detail.do?id=${map.id}"> 详细 </a> <!--qiatnalijne-->
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	${ page.info }


</body>
</html>