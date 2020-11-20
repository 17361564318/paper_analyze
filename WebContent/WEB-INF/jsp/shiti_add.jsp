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


	<form action="shitiinsert.do" method="post" name="form1" id="form1">
		添加试题: <br>
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
				<td width="200">标题：</td>
				<td><input style="width: 150px;" id="biaoti" name="biaoti"
					value="" type="text" /></td>
			</tr>
			<tr>
				<td width="200">类型：</td>
				<td><select data-value="" id="leixing" name="leixing"
					class="class_leixing18"><option value="单选题">单选题</option>
						<option value="填空题">填空题</option>
						<option value="简答题">简答题</option>
				</select></td>
			</tr>
			<tr>
				<td width="200">难度：</td>
				<td><select data-value="" id="nandu" name="nandu"
					class="class_nandu19"><option value="难">难</option>
						<option value="易">易</option>
				</select></td>
			</tr>
			<tr>
				<td width="200">答案：</td>
				<td>
					<div id="TypeFieldabc">
						<div
							style="border: 1px solid #ededed; border-radius: 5px; padding: 10px; background: #F2F2F2;">
							<table class="table table-hover">
								<thead>
									<tr>
										<th width="80">&nbsp;</th>
										<th>答案</th>
										<!--<th width="80">跳转序号</th>-->
										<th width="60">得分</th>
									</tr>
								</thead>
								<tbody id="field_box">

								</tbody>
							</table>
						</div>
						<button type="button" class="btn btn-default btn-sm" id="add_btn">增加答案</button>
					</div> <input type="hidden" id="daan" name="daan" /> <script>
						function selectType(obj) {
							var v = $(obj).val();
							if (v == '单选题' || v == '多选题') {
								$('#TypeFieldabc').show();
							} else {
								$('#TypeFieldabc').hide();
							}
						}

						function updateZimu() {
							var zimu = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
							var index = $("#field_box").find("tr").each(
									function(index) {
										$(this).find('td:eq(0)').find('input')
												.val(zimu.substr(index, 1));
									});
						}

						function addFieldItem(wx) {
							wx = wx || {};
							var str = [];
							str.push('<tr><td align="center" valign="middle">');
							str
									.push('<input type="text" readonly="readonly" style="width: 40px;" data-id="zimu" class="form-control" value="" />');
							str.push('</td><td>');
							str
									.push('<input type="text" style="width:100%" onblur="updateData()" data-id="title" class="form-control" value="'
											+ (wx.title || '') + '" />');
							str.push('</td><td>');

							str
									.push('<input type="number" step="1" style="width: 60px;" onblur="updateData()" data-id="point" class="form-control" value="'
											+ (wx.point || '0') + '" />');
							str.push('</td><td>');

							str
									.push('<button onclick="delItem(this);" type="button" class="btn btn-default">删除</button>');
							str.push('</td></tr>');
							var html = str.join('');
							$('#field_box').append(html);
							updateZimu();
						}

						function delItem(obj) {
							if (confirm('此操作将不可恢复，您确定删除？')) {
								$(obj).parent().parent().remove();
							}
							updateZimu();
						}
						$(function() {
							var __fields = [];
							if (__fields.length > 0) {
								$.each(__fields, function() {
									addFieldItem(this);
								});
							} else {
								addFieldItem();
							}
						});

						function updateData() {
							var result = [];
							$('#field_box')
									.find('tr')
									.each(
											function() {
												var obj = {};
												$(this)
														.find('[data-id]')
														.each(
																function() {
																	if ($(this)
																			.attr(
																					'type') == 'checkbox') {
																		obj[$(
																				this)
																				.attr(
																						'data-id')] = $(
																				this)
																				.attr(
																						'checked')
																	} else {
																		obj[$(
																				this)
																				.attr(
																						'data-id')] = $
																				.trim($(
																						this)
																						.val());
																	}
																});
												if (obj.title != ''
														&& obj.point != '') {
													result.push(obj);
												}
											});
							$('#daan').val(JSON.stringify(result));
						}

						$('#TypeFieldabc').on('input,checkbox', 'blur,change',
								function(e) {
									console.log(e);
								})

						$('#add_btn').click(addFieldItem);
						$('#form1').submit(function() {
							updateData();
							return true;
						})
					</script>
				</td>
			</tr>
			<tr>
				<td width="200">发布人：</td>
				<td><input style="width: 150px;" 
					id="faburen" name="faburen" value="${sessionScope.username}"
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
