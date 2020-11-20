<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<li class="sidebar-list-item"><a href="javascript:;"
	data-toggle="collapse" data-target="#pages0" aria-expanded="false"
	aria-controls="pages" class="sidebar-link text-muted"> <span>班级试卷</span>
</a>
	<div id="pages0" class="collapse">
		<ul
			class="sidebar-menu list-unstyled border-left border-primary border-thick">
			<li class="sidebar-list-item"><a href="tiku_list.do"
				target="main" class="sidebar-link text-muted pl-lg-5">试卷查询</a></li>
		</ul>
	</div></li>
<li class="sidebar-list-item"><a href="javascript:;"
	data-toggle="collapse" data-target="#pages1" aria-expanded="false"
	aria-controls="pages" class="sidebar-link text-muted"> <span>考试成绩</span>
</a>
	<div id="pages1" class="collapse">
		<ul
			class="sidebar-menu list-unstyled border-left border-primary border-thick">
			<li class="sidebar-list-item"><a href="jieguo_list_kaoshiren.do"
				target="main" class="sidebar-link text-muted pl-lg-5">考试答题结果查询</a></li>
			<li class="sidebar-list-item"><a
				href="kaoshijieguo_list_kaoshiren.do" target="main"
				class="sidebar-link text-muted pl-lg-5">考试成绩查询</a></li>
		</ul>
	</div></li>
<li class="sidebar-list-item"><a href="javascript:;"
	data-toggle="collapse" data-target="#pages2" aria-expanded="false"
	aria-controls="pages" class="sidebar-link text-muted"> <span>个人中心</span>
</a>
	<div id="pages2" class="collapse">
		<ul
			class="sidebar-menu list-unstyled border-left border-primary border-thick">
			<li class="sidebar-list-item"><a href="xuesheng_updtself.do"
				target="main" class="sidebar-link text-muted pl-lg-5">修改个人资料</a></li>
			<li class="sidebar-list-item"><a href="mod.do" target="main"
				class="sidebar-link text-muted pl-lg-5">修改密码</a></li>
		</ul>
	</div></li>
