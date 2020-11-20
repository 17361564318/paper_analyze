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


	<form action="kaoshijieguoinsert.do" method="post" name="form1"
		id="form1">
		添加考试结果: <br>
		<br>
		<table width="100%" class="table table-insert" border="1"
			align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF"
			style="border-collapse: collapse">
			<tr>
				<td width="200">题库编号：</td>
				<td>${readMap.tikubianhao}<input type="hidden" id="tikubianhao"
					name="tikubianhao" value="${readMap.tikubianhao}" />
				</td>
			</tr>
			<tr>
				<td width="200">题库名称：</td>
				<td>${readMap.tikumingcheng}<input type="hidden"
					id="tikumingcheng" name="tikumingcheng"
					value="${readMap.tikumingcheng}" />
				</td>
			</tr>
			<tr>
				<td width="200">班级：</td>
				<td>${readMap.banji}<input type="hidden" id="banji"
					name="banji" value="${readMap.banji}" />
				</td>
			</tr>
			<tr>
				<td width="200">发布人：</td>
				<td>${readMap.faburen}<input type="hidden" id="faburen"
					name="faburen" value="${readMap.faburen}" />
				</td>
			</tr>
			<tr>
				<td width="200">考试编号：</td>
				<td><input style="width: 150px;" readonly="readonly"
					id="kaoshibianhao" name="kaoshibianhao" value="${ssm:Info_getID()}"
					type="text" /></td>
			</tr>
			<tr>
				<td width="200">单选题得分：</td>
				<td><input style="width: 150px;" id="danxuantidefen"
					name="danxuantidefen" value="" type="text" /></td>
			</tr>
			<tr>
				<td width="200">简答题得分：</td>
				<td><input style="width: 150px;" id="jiandatidefen"
					name="jiandatidefen" value="" type="text" /></td>
			</tr>
			<tr>
				<td width="200">填空题得分：</td>
				<td><input style="width: 150px;" id="tiankongtidefen"
					name="tiankongtidefen" value="" type="text" /></td>
			</tr>
			<tr>
				<td width="200">总得分：</td>
				<td><input style="width: 150px;" id="zongdefen"
					name="zongdefen" value="" type="text" /></td>
			</tr>
			<tr>
				<td width="200">考试人：</td>
				<td><input style="width: 150px;" readonly="readonly"
					id="kaoshiren" name="kaoshiren" value="${sessionScope.username}"
					type="text" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="tikuid" value="${param.id}" />
					<input name="referer" value="<%=request.getHeader("referer")%>"
					type="hidden" /> &nbsp;</td>
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
