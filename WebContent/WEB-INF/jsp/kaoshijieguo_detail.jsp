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

	<div class="admin-detail">
		<table class="table table-detail">
			<tr>

				<td width="180">题库编号</td>
				<td>${map.tikubianhao}</td>

				<td width="180">题库名称</td>
				<td>${map.tikumingcheng}</td>
			</tr>
			<tr>

				<td width="180">班级</td>
				<td>${map.banji}</td>

				<td width="180">发布人</td>
				<td>${map.faburen}</td>
			</tr>
			<tr>

				<td width="180">考试编号</td>
				<td>${map.kaoshibianhao}</td>

				<td width="180">单选题得分</td>
				<td>${map.danxuantidefen}</td>
			</tr>
			<tr>

				<td width="180">简答题得分</td>
				<td>${map.jiandatidefen}</td>

				<td width="180">填空题得分</td>
				<td>${map.tiankongtidefen}</td>
			</tr>
			<tr>

				<td width="180">总得分</td>
				<td>${map.zongdefen}</td>

				<td width="180">考试人</td>
				<td>${map.kaoshiren}</td>
			</tr>
			<tr>

			</tr>
		</table>
	</div>


	<div class="button-list">
		<div class="">
			<button class="btn btn-history" onclick="history.go(-1);">返回
			</button>
			<button onclick="window.print()" class="btn btn-print">打印本页
			</button>
		</div>
	</div>


</body>
</html>
