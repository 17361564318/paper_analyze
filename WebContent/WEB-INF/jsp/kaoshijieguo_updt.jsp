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


	<form action="kaoshijieguoupdate.do" method="post" name="form1"
		id="form1">
		编辑考试结果: <br>
		<br>
		<table width="100%" class="table table-insert" border="1"
			align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF"
			style="border-collapse: collapse">
			<tr>
				<td width="200">题库编号：</td>
				<td>${mmm.tikubianhao}<input type="hidden" id="tikubianhao"
					name="tikubianhao" value="${mmm.tikubianhao}" />
				</td>
			</tr>
			<tr>
				<td width="200">题库名称：</td>
				<td>${mmm.tikumingcheng}<input type="hidden" id="tikumingcheng"
					name="tikumingcheng" value="${mmm.tikumingcheng}" />
				</td>
			</tr>
			<tr>
				<td width="200">班级：</td>
				<td>${mmm.banji}<input type="hidden" id="banji" name="banji"
					value="${mmm.banji}" />
				</td>
			</tr>
			<tr>
				<td width="200">发布人：</td>
				<td>${mmm.faburen}<input type="hidden" id="faburen"
					name="faburen" value="${mmm.faburen}" />
				</td>
			</tr>
			<tr>
				<td width="200">考试编号：</td>
				<td><input style="width: 150px;" readonly="readonly"
					id="kaoshibianhao" name="kaoshibianhao"
					value="${ssm:Info_html(mmm.kaoshibianhao)}" type="text" /></td>
			</tr>
			<tr>
				<td width="200">单选题得分：</td>
				<td><input style="width: 150px;" id="danxuantidefen"
					name="danxuantidefen" value="${ssm:Info_html(mmm.danxuantidefen)}"
					type="text" /></td>
			</tr>
			<tr>
				<td width="200">简答题得分：</td>
				<td><input style="width: 150px;" id="jiandatidefen"
					name="jiandatidefen" value="${ssm:Info_html(mmm.jiandatidefen)}"
					type="text" /></td>
			</tr>
			<tr>
				<td width="200">填空题得分：</td>
				<td><input style="width: 150px;" id="tiankongtidefen"
					name="tiankongtidefen"
					value="${ssm:Info_html(mmm.tiankongtidefen)}" type="text" /></td>
			</tr>
			<tr>
				<td width="200">总得分：</td>
				<td><input style="width: 150px;" id="zongdefen"
					name="zongdefen" value="${ssm:Info_html(mmm.zongdefen)}"
					type="text" /></td>
			</tr>
			<tr>
				<td width="200">考试人：</td>
				<td><input style="width: 150px;" readonly="readonly"
					id="kaoshiren" name="kaoshiren" value="${mmm.kaoshiren}"
					type="text" /></td>
			</tr>
			<tr>
				<td><input name="id" value="${mmm.id}" type="hidden" /> <input
					name="referer" value="<%=request.getHeader("referer")%>"
					type="hidden" /> <input name="updtself" value="${updtself}"
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
