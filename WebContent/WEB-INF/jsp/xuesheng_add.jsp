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
<link rel="stylesheet" href="js/layer/theme/default/layer.css" />
<script src="js/layer/layer.js"></script>


</head>
<body>


	<form action="xueshenginsert.do" method="post" name="form1" id="form1">
		添加学生: <br>
		<br>
		<table width="100%" class="table table-insert" border="1"
			align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF"
			style="border-collapse: collapse">
			<tr>
				<td width="200">学生学号：</td>
				<td><input style="width: 150px;" data-rule-required="true"
					data-msg-required="请填写学生学号"
					remote="checkno.do?checktype=insert&table=xuesheng&col=xueshengxuehao"
					data-msg-remote="内容重复了" id="xueshengxuehao" name="xueshengxuehao"
					value="" type="text" /> <span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">密码：</td>
				<td><input style="width: 150px;" data-rule-required="true"
					data-msg-required="请填写密码" id="mima" name="mima" value=""
					type="password" /> <span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">学生姓名：</td>
				<td><input style="width: 150px;" data-rule-required="true"
					data-msg-required="请填写学生姓名" id="xueshengxingming"
					name="xueshengxingming" value="" type="text" /> <span
					style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">性别：</td>
				<td><select data-value="" data-rule-required="true"
					data-msg-required="请填写性别" id="xingbie" name="xingbie"
					class="class_xingbie8"><option value="男">男</option>
						<option value="女">女</option>
				</select> <span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">学生照片：</td>
				<td><input type="text" data-rule-required="true"
					data-msg-required="请填写学生照片" id="xueshengzhaopian"
					name="xueshengzhaopian" value="" /> <input type="button"
					onclick="layer.open({type:2,title:'上传图片',fixed:true,shadeClose:true,shade:0.5,area:['320px','150px'],content:'upload.html?result=xueshengzhaopian'})"
					value="上传" /> <span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">所在班级：</td>
				<td><select data-value="" data-rule-required="true"
					data-msg-required="请填写所在班级" id="suozaibanji" name="suozaibanji"
					class="class_suozaibanji9">
					<ssm:sql var="select"
							type="select">SELECT * FROM banjixinxi ORDER BY id desc</ssm:sql>
						<c:forEach items="${select}" var="m">
							<option value="${m.banji}">${m.banji}</option>
						</c:forEach>
				</select> <span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">联系电话：</td>
				<td><input style="width: 150px;" data-rule-required="true"
					data-msg-required="请填写联系电话" data-rule-phone="true"
					data-msg-phone="请输入正确手机号码" id="lianxidianhua" name="lianxidianhua"
					value="" type="text" /> <span style="color: red;">*</span></td>
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
