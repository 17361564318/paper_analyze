<%@ page language="java" import="dao.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="util.Info" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>题库</title>

    <link rel="stylesheet" href="css.css">
    <script src="js/jquery.js"></script>
    <script src="js/jquery.validate.js"></script>
    <link rel="stylesheet" href="js/layer/theme/default/layer.css">
    <script src="js/layer/layer.js"></script>

</head>
<body>
<% HashMap map = Query.make("tiku").where("id", request.getParameter("id")).find(); %>
<div class="admin-detail">
    <table class="table table-detail">
        <tr>

            <td width="180">
                题库编号
            </td>
            <td>${map.tikubianhao}</td>

            <td width="180">
                题库名称
            </td>
            <td>${map.tikumingcheng}</td>
        </tr>
        <tr>

            <td width="180">
                班级
            </td>
            <td>${map.banji}</td>

            <td width="180">
                发布人
            </td>
            <td>${map.faburen}</td>
        </tr>
        <tr>

        </tr>
    </table>
</div>


<style>
    #zhangjielianxi {
        padding: 20px;
        background: #f2f2f2;
    }

    #zhangjielianxi div {
        padding: 20px;
    }

    #zhangjielianxi div h3 {
        margin-bottom: 8px;
    }
</style>
<form action="javascript:;" onsubmit="submitZhangjie()" class="clearfix">
    <div class="clearfix" style="">
        <%
            List<HashMap> wenda = new dao.CommDAO().select("SELECT * FROM shiti WHERE tikuid='" + map.get("id") + "' ORDER BY id asc");
        %>
        <div id="zhangjielianxi">

        </div>
        <div style="margin-top: 10px; text-align: left; padding-left: 50px">

        </div>
    </div>
</form>
<div class="button-list">
    <div class="">
        <button onclick="window.print()" class="btn btn-default">打印本页</button>


        <button class="btn btn-primary" onclick="submitZhangjie().href='javascript:;'">提交试卷</button>
    </div>
</div>

</table>
</div>
<div id="div"
     style="position: fixed;bottom: 0px;padding: 10px;background: #f2f2f2; color: red; text-align: center;"></div>

<script>
    (function () {
        var fenshu = 10; // 分钟数
        var key = "stopTime<%=request.getParameter("id")%>";
        sessionStorage.removeItem(key);
        var stopTime = sessionStorage.getItem(key);
        if (stopTime && new Date().getTime() > stopTime) {
            stopTime = (new Date().getTime()) + 60 * fenshu * 1000;
        }
        stopTime = stopTime || (new Date().getTime()) + 60 * fenshu * 1000;
        sessionStorage.setItem(key, stopTime);
        stopTime = new Date(Math.floor(stopTime));

        function clock() {
            if (new Date().getTime() > stopTime) {
                submitZhangjie();

                return;
            }
            var today = new Date(),//当前时间
                h = today.getHours(),
                m = today.getMinutes(),
                s = today.getSeconds();
            var stopH = stopTime.getHours(),
                stopM = stopTime.getMinutes(),
                stopS = stopTime.getSeconds();
            var shenyu = stopTime.getTime() - today.getTime(),//倒计时毫秒数
                shengyuD = parseInt(shenyu / (60 * 60 * 24 * 1000)),//转换为天
                D = parseInt(shenyu) - parseInt(shengyuD * 60 * 60 * 24 * 1000),//除去天的毫秒数
                shengyuH = parseInt(D / (60 * 60 * 1000)),//除去天的毫秒数转换成小时
                H = D - shengyuH * 60 * 60 * 1000,//除去天、小时的毫秒数
                shengyuM = parseInt(H / (60 * 1000)),//除去天的毫秒数转换成分钟
                M = H - shengyuM * 60 * 1000;//除去天、小时、分的毫秒数
            var S = parseInt((shenyu - shengyuD * 60 * 60 * 24 * 1000 - shengyuH * 60 * 60 * 1000 - shengyuM * 60 * 1000) / 1000)//除去天、小时、分的毫秒数转化为秒
            document.getElementById("div").innerHTML = (shengyuH + "小时" + shengyuM + "分" + S + "秒" + "<br>");
            // setTimeout("clock()",500);
            setTimeout(clock, 500);
        }

        $(clock);
    })();
</script>


<% if (wenda.size() > 0) { %>
<script>
    (function () {
        var json = <%=JSONArray.toJSONString(wenda)%>;
        var result = "";
        var j = 1;
        //console.log(json);
        $.each(json, function () {
            console.log(this);
            result += '<div data-j="' + j + '" data-type="' + this.leixing + '" class="zhangjie-list" style="margin-bottom: 10px; padding: 10px; background: #fff">' +
                '<h5 data-timu="' + this.biaoti + '">第' + j + '题：' + this.biaoti + '</h5>' +
                '<div>';
            if (this.leixing == '单选题') {
                var daan = eval("(" + this.daan + ")");
                $.each(daan, function () {
                    result += '<label><input type="radio" name="daan' + j + '" data-point="' + this.point + '" data-title="' + this.zimu + '、' + this.title + '" value="' + this.zimu + '"  /> ' + this.zimu + ' ' + this.title + ' </label> ';
                });
            } else if (this.leixing == '多选题') {
                var daan = JSON.parse(this.daan);
                $.each(daan, function () {
                    result += '<label><input type="checkbox" name="daan' + j + '" data-point="' + this.point + '" data-title="' + this.zimu + '、' + this.title + '" value="' + this.zimu + '" /> ' + this.zimu + ' ' + this.title + ' </label> ';
                });
            } else if (this.leixing == '填空题') {
                result += '<textarea name="daan' + j + '" style="width: 100%;height: 85px;" placeholder="请填写"></textarea>';
            } else if (this.leixing == '简答题') {
                result += '<textarea name="daan' + j + '" style="width: 100%;height: 85px;" placeholder="请填写"></textarea>';
            }


            result += '</div>';
            result += '</div>';
            j++;
        });
        $('#zhangjielianxi').html(result);
    })();

    function submitZhangjie() {
        var result = [];
        var isOk = true;
        $('#zhangjielianxi>.zhangjie-list').each(function () {
            if (!isOk) return;
            var obj = {};
            var that = $(this);
            obj.timu = $(this).find('h5').attr("data-timu");
            var j = that.attr("data-j");
            var type = that.attr("data-type");
            obj.leixing = type;
            //var res = that.find('[name="daan'+j+'"]');
            if (type == "单选题") {
                var radio = that.find('[name="daan' + j + '"]:checked');
                if (radio.length == 0) {
                    alert('请选择【' + obj.timu + '】的题目答案');
                    isOk = false;
                    return;
                }
                obj.daan = radio.attr('data-title');
                obj.defen = radio.attr('data-point');
                obj.zimu = radio.val();
            } else if (type == "多选题") {
                var checkbox = that.find('[name="daan' + j + '"]:checked');
                if (checkbox.length == 0) {
                    alert('请选择【' + obj.timu + '】的题目答案');
                    isOk = false;
                    return;
                }
                var defen = 0;
                var daan = [];
                var zimu = [];
                checkbox.each(function () {
                    daan.push($(this).attr('data-title'));
                    defen += Math.floor($(this).attr('data-point'));
                    zimu.push(this.value);
                    //obj.defen = radio.attr('data-point');
                });
                obj.daan = daan.join(",");
                obj.defen = defen;
                obj.zimu = zimu.join(",");
            } else {
                daan = that.find('[name="daan' + j + '"]').val();
                obj.defen = -1;
                obj.daan = daan;
                obj.zimu = '';
            }
            result.push(obj);
        });
        if (!isOk) {
            return false;
        }
        var index = layer.load(0, {
            shade: [0.5, '#000'] //0.1透明度的白色背景
        });


        $.post("tiku_insert.do?f=f", {
            JSON: JSON.stringify(result),
            kechengxinxiid:<%=request.getParameter("id")%>
        }, function (res) {
            layer.close(index);
            if (res.code == 0) {
                layer.alert("提交成功", function () {
                    location.href = 'kaoshijieguo_list_kaoshiren.do?id=' + res.data;
                });
            } else {
                layer.alert(res.msg);
            }
        }, 'json');
        return false;
    }

</script>
<% } %>






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
