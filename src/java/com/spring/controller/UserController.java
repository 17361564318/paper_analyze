package com.spring.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.Admin;
import com.spring.entity.Jiaoshi;
import com.spring.entity.Xuesheng;
import com.spring.service.AdminService;
import com.spring.service.JiaoshiService;
import com.spring.service.XueshengService;

import util.Request;

@Controller
public class UserController extends BaseController {

	@Resource
	private AdminService adminService;
	@Resource
	private JiaoshiService jiaoshiService;
	@Resource
	private XueshengService xueshengService;

	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String Index() {
		return "login";
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	public String Logout() {
		request.getSession().invalidate();
		return showSuccess("退出成功", "./");
	}

	protected String authLoginUser(boolean isAdmin, String username, String pwd, String cx) {
		if (username == null || "".equals(username)) {
			return showError("账号不允许为空");
		}
		if (pwd == null || "".equals(pwd)) {
			return showError("密码不允许为空");
		}
		if (cx == null) {
			return showError("请选中登录类型");
		}

		String random = (String) request.getSession().getAttribute("random");
		String pagerandom = request.getParameter("pagerandom") == null ? "" : request.getParameter("pagerandom");

		if (request.getParameter("a") != null && !pagerandom.equals(random)) {
			return showError("验证码不正确");
		}

		if (cx.equals("管理员")) {
			Admin user = adminService.login(username, pwd);
			if (user == null) {
				return showError("用户名或密码错误");
			}
			session.setAttribute("id", user.getId());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("cx", cx);
			session.setAttribute("login", cx);
			session.setAttribute("pwd", user.getPwd());

		}
		if (cx.equals("教师")) {
			Jiaoshi user = jiaoshiService.login(username, pwd);
			if (user == null) {
				return showError("用户名或密码错误");
			}
			session.setAttribute("id", user.getId());
			session.setAttribute("username", user.getJiaoshixingming());
			session.setAttribute("cx", cx);
			session.setAttribute("login", cx);
			session.setAttribute("jiaoshigonghao", user.getJiaoshigonghao());
			session.setAttribute("mima", user.getMima());
			session.setAttribute("jiaoshixingming", user.getJiaoshixingming());
			session.setAttribute("xingbie", user.getXingbie());
			session.setAttribute("suodaibanji", user.getSuodaibanji());
			session.setAttribute("jiaoshizhaopian", user.getJiaoshizhaopian());
			session.setAttribute("lianxidianhua", user.getLianxidianhua());
			session.setAttribute("shenfenzheng", user.getShenfenzheng());

		}
		if (cx.equals("学生")) {
			Xuesheng user = xueshengService.login(username, pwd);
			if (user == null) {
				return showError("用户名或密码错误");
			}
			session.setAttribute("id", user.getId());
			session.setAttribute("username", user.getXueshengxingming());
			session.setAttribute("cx", cx);
			session.setAttribute("login", cx);
			session.setAttribute("xueshengxuehao", user.getXueshengxuehao());
			session.setAttribute("mima", user.getMima());
			session.setAttribute("xueshengxingming", user.getXueshengxingming());
			session.setAttribute("xingbie", user.getXingbie());
			session.setAttribute("xueshengzhaopian", user.getXueshengzhaopian());
			session.setAttribute("suozaibanji", user.getSuozaibanji());
			session.setAttribute("lianxidianhua", user.getLianxidianhua());

		}

		String referer = request.getParameter("referer");
		if (referer == null) {
			if (isAdmin) {
				referer = "./main.do";
			} else {
				referer = "./";
			}
		}
		return showSuccess("登录成功", referer);
	}

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/sy")
	public String sy() {
		return "sy";
	}

	@RequestMapping("/mygo")
	public String mygo() {
		return "mygo";
	}

	@RequestMapping("/top")
	public String top() {
		return "top";
	}

	@RequestMapping("/authLogin")
	public String authLogin() {
		String username = Request.get("username");
		String pwd = Request.get("pwd");
		String cx = Request.get("cx");
		return authLoginUser(false, username, pwd, cx);
	}

	@RequestMapping("/authAdminLogin")
	public String authAdminLogin() {
		String username = Request.get("username");
		String pwd = Request.get("pwd");
		String cx = Request.get("cx");
		return authLoginUser(true, username, pwd, cx);
	}

	@RequestMapping("/mod")
	public String mod() {
		return "mod";
	}

	@RequestMapping("/editPassword")
	public String editPassword() {
		String username = request.getSession().getAttribute("username").toString();
		String cx = request.getSession().getAttribute("login").toString();
		String oldPassword = Request.get("oldPassword");
		String newPwd = Request.get("newPwd");
		String newPwd2 = Request.get("newPwd2");

		if (!newPwd.equals(newPwd2)) {
			return showError("两次密码不一致");
		}

		if (cx.equals("管理员")) {
			Admin user = adminService.login(username, oldPassword);
			if (user == null) {
				return showError("原密码不正确");
			}
			adminService.updatePassword(user.getId(), newPwd);
		}
		if (cx.equals("教师")) {
			Jiaoshi user = jiaoshiService.login(username, oldPassword);
			if (user == null) {
				return showError("原密码不正确");
			}
			jiaoshiService.updatePassword(user.getId(), newPwd);
		}
		if (cx.equals("学生")) {
			Xuesheng user = xueshengService.login(username, oldPassword);
			if (user == null) {
				return showError("原密码不正确");
			}
			xueshengService.updatePassword(user.getId(), newPwd);
		}
		return showSuccess("修改密码成功", "./mod.do");
	}
}
