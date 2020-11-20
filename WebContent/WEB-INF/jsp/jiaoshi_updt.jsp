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
<link rel="stylesheet" href="js/layer/theme/default/layer.css" />
<script src="js/layer/layer.js"></script>


</head>
<body>


	<form action="jiaoshiupdate.do" method="post" name="form1" id="form1">
		编辑教师: <br> <br>
		<table width="100%" class="table table-insert" border="1"
			align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF"
			style="border-collapse: collapse">
			<tr>
				<td width="200">教师工号：</td>
				<td><input style="width: 150px;" data-rule-required="true"
					data-msg-required="请填写教师工号"
					remote="checkno.do?checktype=update&id=${mmm.id}&table=jiaoshi&col=jiaoshigonghao"
					data-msg-remote="内容重复了" id="jiaoshigonghao" name="jiaoshigonghao"
					value="${ssm:Info_html(mmm.jiaoshigonghao)}" type="text" /> <span
					style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">教师姓名：</td>
				<td><input style="width: 150px;" data-rule-required="true"
					data-msg-required="请填写教师姓名" id="jiaoshixingming"
					name="jiaoshixingming"
					value="${ssm:Info_html(mmm.jiaoshixingming)}" type="text" /> <span
					style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">性别：</td>
				<td><select data-value="${ssm:Info_html(mmm.xingbie)}"
					data-rule-required="true" data-msg-required="请填写性别" id="xingbie"
					name="xingbie" class="class_xingbie5"><option value="男">男</option>
						<option value="女">女</option>
				</select> 
				<script>
					$(".class_xingbie5").val(
							$(".class_xingbie5").attr("data-value"))
				</script> 
				<span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">所带班级：</td>
				<td><select data-value="${ssm:Info_html(mmm.suodaibanji)}"
					data-rule-required="true" data-msg-required="请填写所带班级"
					id="suodaibanji" name="suodaibanji" class="class_suodaibanji6">
					<ssm:sql
							var="select" type="select">SELECT * FROM banjixinxi ORDER BY id desc</ssm:sql>
						<c:forEach items="${select}" var="m">
							<option value="${m.banji}">${m.banji}</option>
						</c:forEach>
				</select> <script>
					$(".class_suodaibanji6").val(
							$(".class_suodaibanji6").attr("data-value"))
				</script> <span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">教师照片：</td>
				<td><input type="text" data-rule-required="true"
					data-msg-required="请填写教师照片" id="jiaoshizhaopian"
					name="jiaoshizhaopian"
					value="${ssm:Info_html(mmm.jiaoshizhaopian)}" /> <input
					type="button"
					onclick="layer.open({type:2,title:'上传图片',fixed:true,shadeClose:true,shade:0.5,area:['320px','150px'],content:'upload.html?result=jiaoshizhaopian'})"
					value="上传" /> <span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">联系电话：</td>
				<td><input style="width: 150px;" data-rule-required="true"
					data-msg-required="请填写联系电话" data-rule-phone="true"
					data-msg-phone="请输入正确手机号码" id="lianxidianhua" name="lianxidianhua"
					value="${ssm:Info_html(mmm.lianxidianhua)}" type="text" /> <span
					style="color: red;">*</span></td>
			</tr>
			<tr>
				<td width="200">身份证：</td>
				<td><input style="width: 150px;" data-rule-required="true"
					data-msg-required="请填写身份证" id="shenfenzheng" name="shenfenzheng"
					value="${ssm:Info_html(mmm.shenfenzheng)}" type="text" /> <span
					style="color: red;">*</span></td>
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
