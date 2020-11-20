<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>题库</title>

<link rel="stylesheet" href="css.css">
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>


</head>
<body>


	<form action="tikuinsert.do" method="post" name="form1" id="form1">
		添加题库: <br>
		<br>
		<table width="100%" class="table table-insert" border="1"
			align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF"
			style="border-collapse: collapse">
			<tr>
				<td width="200">题库编号：</td>
				<td><input style="width: 150px;" readonly="readonly"
					id="tikubianhao" name="tikubianhao" value="${ssm:Info_getID()}"
					type="text" /></td>
			</tr>
			<tr>
				<td width="200">题库名称：</td>
				<td><input style="width: 250px;" id="tikumingcheng"
					name="tikumingcheng" value="" type="text" /></td>
			</tr>
			<tr>
				<td width="200">班级：</td>
				<td><select data-value="" id="banji" name="banji"
					class="class_banji14"><ssm:sql var="select" type="select">SELECT * FROM banjixinxi ORDER BY id desc</ssm:sql>
						<c:forEach items="${select}" var="m">
							<option value="${m.banji}">${m.banji}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width="200">发布人：</td>
				<td><input style="width: 150px;" 
					id="faburen" name="faburen" value="${sessionScope.username}"
					type="text" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="Submit" value="提交"
					style='border: solid 1px #000000; color: #666666' /> <input
					type="reset" name="Submit2" value="重置"
					style='border: solid 1px #000000; color: #666666' /></td>
			</tr>
		</table>
	</form>


	<script>
		$(function() {
			$('#form1').validate();
		})
	</script>


</body>
</html>
