<%@ page import="util.Request"%>
<%@ page import="dao.Query"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
<link rel="stylesheet" href="css.css">
<script src="js/datepicker/WdatePicker.js"></script>

<script src="js/highcharts/highcharts.js"></script>
<script src="js/highcharts/modules/exporting.js"></script>
<script src="js/highcharts/modules/series-label.js"></script>
<script src="js/highcharts/modules/oldie.js"></script>
</head>
<body>

	<form action="?" method="get">
		开始日期:<input sype="text" name="kaishiriqi"
			value="<%=Request.get("kaishiriqi")%>"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd',lang:'zh-cn'})">
		结束日期:<input sype="text" name="jieshuriqi"
			value="<%=Request.get("jieshuriqi")%>"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd',lang:'zh-cn'})">
		<button type="submit">提交</button>
	</form>


	

	<%
		String where = "1=1 ";
		if (!Request.get("kaishiriqi").equals("")) {
			where += " and addtime>='" + Request.get("kaishiriqi") + " 00:00:00' ";
		}
		if (!Request.get("jieshuriqi").equals("")) {
			where += " and addtime<='" + Request.get("jieshuriqi") + " 23:59:59' ";
		}
		List<HashMap> list = Query.make("kaoshijieguo").field("tikumingcheng,banji,sum(zongdefen) zongdefen")
				.where(where).group("tikumingcheng").group("banji")

				.order("sum(zongdefen) desc").select();
	%>

	<table class="table">
		<thead>
			<tr>
				<th>题库名称</th>
				<th>班级</th>

				<th>总得分</th>

			</tr>
		</thead>
		<tbody>
			<%
				for (HashMap map : list) {
			%>
			
			<tr>
				<td><%=map.get("tikumingcheng")%></td>
				<td><%=map.get("banji")%></td>

				<td><%=map.get("zongdefen")%></td>
			</tr>
			<%
				}
			%>


		</tbody>


	</table>
	<div id="container" style="max-width: 800px; height: 400px"></div>



	<script>
    var chart = Highcharts.chart('container', {

        chart: {
            type: 'column'
        },

        title: {
            text: '班级考试成绩数据'
        },
        subtitle: {
            text: ''
        },

        yAxis: {
            title: {
                text: '考试成绩',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' 分'
        },
        xAxis:{
            title:{
                text:'题库名称'
            },

            categories:[
                <%for (HashMap map : list) {%>
                '<%=map.get("tikumingcheng")%> <%=map.get("banji")%>',
                <%}%>

            ]

        },
        
        plotOptions: {
            series: {
                label: {
                    connectorAllowed: false
                },
            }
        },
        series: [{
            name: '总分数',
            data: [
                <%for (HashMap map : list) {%>
                <%=map.get("zongdefen")%>,
                <%}%>
            ]
        }],
        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }
    });
</script>

	<%
		//}
	%>
</body>
</html>
