<%@ page language="java" import="dao.CommDAO" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ page import="dao.Query"%>
<%@ page import="com.alibaba.fastjson.*"%>

<%
	if (request.getSession().getAttribute("username") == null
			|| "".equals(request.getSession().getAttribute("username"))) {
		out.println("{\"code\":1,\"msg\":\"您尚未登陆\"}");
		out.close();
	}

	if (request.getParameter("f") != null) {

		String str = request.getParameter("JSON");
		//JSONParser parser= new JSONParser();
		JSONArray json = JSON.parseArray(str);

		//[{"timu":"第1题：Ai 画直线使用直线工具","daan":"A、正确","defen":"0"},{"timu":"第2题：老师使用缩放工具是什么","daan":"A、旋转工具","defen":"0"}]
		//JSONArray json = JSONArray.fromObject(JSON);
		String id = request.getParameter("kechengxinxiid");
		HashMap data = new HashMap();
		HashMap readMap = new CommDAO().find(
				"SELECT id tikuid,tikubianhao,tikumingcheng,banji,faburen FROM tiku WHERE  id = " + id + "");
		readMap.put("kaoshibianhao", Info.getID());
		data.putAll(readMap);
		data.put("kaoshiren", request.getSession().getAttribute("username"));
		data.put("addtime", Info.getDateStr());
		int total = 0;
		int danxuanti = 0;
		int duoxuanti = 0;
		int panduanti = 0;
		//int total = 0;

		for (int i = 0; i < json.size(); i++) {
			JSONObject obj = json.getJSONObject(i);
			data.putAll(obj);
			int defen = Integer.valueOf(String.valueOf(obj.get("defen"))).intValue();
			if (obj.get("leixing").equals("单选题")) {
				danxuanti += defen;
			} else if (obj.get("leixing").equals("多选题")) {
				duoxuanti += defen;
			} else if (obj.get("leixing").equals("判断题")) {
				panduanti += defen;
			}
			if (defen >= 0) {
				total += defen;
			}

			Query.make("jieguo").add(data);
		}

		HashMap post = new HashMap();
		post.putAll(readMap);
		post.put("danxuantidefen", danxuanti);
		post.put("duoxuantidefen", duoxuanti);
		post.put("panduantidefen", panduanti);

		post.put("zongdefen", total);
		post.put("kaoshiren", request.getSession().getAttribute("username"));
		post.put("addtime", Info.getDateStr());

		long insertId = Query.make("kaoshijieguo").insert(post);

		out.println("{\"code\":0,\"data\":" + insertId + "}");
		out.close();
	}
	out.println("信息提交失败");
%>