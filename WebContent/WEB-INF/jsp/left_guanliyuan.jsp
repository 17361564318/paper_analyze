<%@ page language="java" import="dao.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@page import="util.Info"%>
<%@ taglib prefix="ssm" uri="http://ssm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<li class="sidebar-list-item"><a href="javascript:;"
	data-toggle="collapse" data-target="#pages0" aria-expanded="false"
	aria-controls="pages" class="sidebar-link text-muted"> <span>帐号管理</span>
</a>
	<div id="pages0" class="collapse">
		<ul
			class="sidebar-menu list-unstyled border-left border-primary border-thick">
			<li class="sidebar-list-item"><a href="admin_list.do"
				target="main" class="sidebar-link text-muted pl-lg-5">管理员账号管理</a></li>
			<li class="sidebar-list-item"><a href="admin_add.do"
				target="main" class="sidebar-link text-muted pl-lg-5">管理员账号添加</a></li>
			<li class="sidebar-list-item"><a href="mod.do" target="main"
				class="sidebar-link text-muted pl-lg-5">密码修改</a></li>
		</ul>
	</div></li>
<li class="sidebar-list-item"><a href="javascript:;"
	data-toggle="collapse" data-target="#pages1" aria-expanded="false"
	aria-controls="pages" class="sidebar-link text-muted"> <span>班级信息管理</span>
</a>
	<div id="pages1" class="collapse">
		<ul
			class="sidebar-menu list-unstyled border-left border-primary border-thick">
			<li class="sidebar-list-item"><a href="banjixinxi_add.do"
				target="main" class="sidebar-link text-muted pl-lg-5">班级信息添加</a></li>
			<li class="sidebar-list-item"><a href="banjixinxi_list.do"
				target="main" class="sidebar-link text-muted pl-lg-5">班级信息查询</a></li>
		</ul>
	</div></li>
<li class="sidebar-list-item"><a href="javascript:;"
	data-toggle="collapse" data-target="#pages2" aria-expanded="false"
	aria-controls="pages" class="sidebar-link text-muted"> <span>教师管理</span>
</a>
	<div id="pages2" class="collapse">
		<ul
			class="sidebar-menu list-unstyled border-left border-primary border-thick">
			<li class="sidebar-list-item"><a href="jiaoshi_add.do"
				target="main" class="sidebar-link text-muted pl-lg-5">教师添加</a></li>
			<li class="sidebar-list-item"><a href="jiaoshi_list.do"
				target="main" class="sidebar-link text-muted pl-lg-5">教师查询</a></li>
		</ul>
	</div></li>
<li class="sidebar-list-item"><a href="javascript:;"
	data-toggle="collapse" data-target="#pages3" aria-expanded="false"
	aria-controls="pages" class="sidebar-link text-muted"> <span>学生管理</span>
</a>
	<div id="pages3" class="collapse">
		<ul
			class="sidebar-menu list-unstyled border-left border-primary border-thick">
			<li class="sidebar-list-item"><a href="xuesheng_add.do"
				target="main" class="sidebar-link text-muted pl-lg-5">学生添加</a></li>
			<li class="sidebar-list-item"><a href="xuesheng_list.do"
				target="main" class="sidebar-link text-muted pl-lg-5">学生查询</a></li>
		</ul>
	</div></li>
<li class="sidebar-list-item"><a href="javascript:;"
	data-toggle="collapse" data-target="#pages4" aria-expanded="false"
	aria-controls="pages" class="sidebar-link text-muted"> <span>试卷管理</span>
</a>
	<div id="pages4" class="collapse">
		<ul
			class="sidebar-menu list-unstyled border-left border-primary border-thick">
			<li class="sidebar-list-item"><a href="tiku_list.do"
				target="main" class="sidebar-link text-muted pl-lg-5">题库查询</a></li>
			<li class="sidebar-list-item"><a href="shiti_list.do"
				target="main" class="sidebar-link text-muted pl-lg-5">试题查询</a></li>
			<li class="sidebar-list-item"><a href="jieguo_list.do"
				target="main" class="sidebar-link text-muted pl-lg-5">结果查询</a></li>
			<li class="sidebar-list-item"><a href="kaoshijieguo_list.do"
				target="main" class="sidebar-link text-muted pl-lg-5">考试结果查询</a></li>
		</ul>
	</div></li>

<li class="sidebar-list-item"><a href="javascript:;"
	data-toggle="collapse" data-target="#pages41" aria-expanded="false"
	aria-controls="pages" class="sidebar-link text-muted"> <span>分析管理</span>
</a>
	<div id="pages41" class="collapse">
		<ul
			class="sidebar-menu list-unstyled border-left border-primary border-thick">
			<li class="sidebar-list-item"><a href="to_cj.do" target="main"
				class="sidebar-link text-muted pl-lg-5">班级成绩分析</a></li>
			<li class="sidebar-list-item"><a href="to_nyd.do" target="main"
				class="sidebar-link text-muted pl-lg-5">试题难度分析</a></li>
			<li class="sidebar-list-item"><a href="to_jg.do" target="main"
				class="sidebar-link text-muted pl-lg-5">考试结果信息分析</a></li>


		</ul>
	</div></li>