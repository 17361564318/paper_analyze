<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>试题</title>

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

				<td width="180">标题</td>
				<td>${map.biaoti}</td>

				<td width="180">类型</td>
				<td>${map.leixing}</td>
			</tr>
			<tr>

				<td width="180">难度</td>
				<td>${map.nandu}</td>

				<td width="180">答案</td>
				<td></td>
			</tr>
			<tr>

				<td width="180">发布人</td>
				<td>${map.faburen}</td>

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
