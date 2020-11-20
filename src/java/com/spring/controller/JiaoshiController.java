package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.JiaoshiMapper;
import com.spring.entity.Jiaoshi;
import com.spring.service.JiaoshiService;

import tk.mybatis.mapper.entity.Example;
import util.Info;
import util.Request;

/**
 * 教师
 */
@Controller
public class JiaoshiController extends BaseController {

	@Autowired
	private JiaoshiService service;

	/**
	 * 后台列表页
	 *
	 */
	@RequestMapping("/jiaoshi_list")
	public String list() {
		if (!checkLogin()) {
			return showError("尚未登录", "./login.do");
		}

		String order = Request.get("order", "id");
		String sort = Request.get("sort", "desc");

		Example example = new Example(Jiaoshi.class);
		Example.Criteria criteria = example.createCriteria();
		String where = " 1=1 ";
		where += getWhere();
		criteria.andCondition(where);
		if (sort.equals("desc")) {
			example.orderBy(order).desc();
		} else {
			example.orderBy(order).asc();
		}
		int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
		page = Math.max(1, page);
		List<Jiaoshi> list = service.selectPageExample(example, page, 12);
		request.setAttribute("list", list);
		assign("orderBy", order);
		assign("sort", sort);
		assign("where", where);
		return "jiaoshi_list";
	}

	public String getWhere() {
		String where = " ";

		if (!Request.get("jiaoshigonghao").equals("")) {
			where += " AND jiaoshigonghao LIKE '%" + Request.get("jiaoshigonghao") + "%' ";
		}
		if (!Request.get("jiaoshixingming").equals("")) {
			where += " AND jiaoshixingming LIKE '%" + Request.get("jiaoshixingming") + "%' ";
		}
		return where;
	}

	@RequestMapping("/jiaoshi_add")
	public String add() {
		return "jiaoshi_add";
	}

	@RequestMapping("/jiaoshi_updt")
	public String updt() {
		int id = Request.getInt("id");
		Jiaoshi mmm = service.find(id);
		request.setAttribute("mmm", mmm);
		request.setAttribute("updtself", 0);
		return "jiaoshi_updt";
	}

	@RequestMapping("/jiaoshi_updtself")
	public String updtself() {
		int id = (int) request.getSession().getAttribute("id");
		Jiaoshi mmm = service.find(id);
		request.setAttribute("mmm", mmm);
		request.setAttribute("updtself", 1);

		return "jiaoshi_updtself";
	}

	/**
	 * 添加内容
	 * 
	 * @return
	 */
	@RequestMapping("/jiaoshiinsert")
	public String insert() {
		String tmp = "";
		Jiaoshi post = new Jiaoshi();
		post.setJiaoshigonghao(Request.get("jiaoshigonghao"));

		post.setMima(Request.get("mima"));

		post.setJiaoshixingming(Request.get("jiaoshixingming"));

		post.setXingbie(Request.get("xingbie"));

		post.setSuodaibanji(Request.get("suodaibanji"));

		post.setJiaoshizhaopian(Request.get("jiaoshizhaopian"));

		post.setLianxidianhua(Request.get("lianxidianhua"));

		post.setShenfenzheng(Request.get("shenfenzheng"));

		post.setAddtime(Info.getDateStr());
		service.insert(post);
		int charuid = post.getId().intValue();

		return showSuccess("保存成功",
				Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
	}

	/**
	 * 更新内容
	 * 
	 * @return
	 */
	@RequestMapping("/jiaoshiupdate")
	public String update() {
		Jiaoshi post = new Jiaoshi();
		if (!Request.get("jiaoshigonghao").equals(""))
			post.setJiaoshigonghao(Request.get("jiaoshigonghao"));
		if (!Request.get("mima").equals(""))
			post.setMima(Request.get("mima"));
		if (!Request.get("jiaoshixingming").equals(""))
			post.setJiaoshixingming(Request.get("jiaoshixingming"));
		if (!Request.get("xingbie").equals(""))
			post.setXingbie(Request.get("xingbie"));
		if (!Request.get("suodaibanji").equals(""))
			post.setSuodaibanji(Request.get("suodaibanji"));
		if (!Request.get("jiaoshizhaopian").equals(""))
			post.setJiaoshizhaopian(Request.get("jiaoshizhaopian"));
		if (!Request.get("lianxidianhua").equals(""))
			post.setLianxidianhua(Request.get("lianxidianhua"));
		if (!Request.get("shenfenzheng").equals(""))
			post.setShenfenzheng(Request.get("shenfenzheng"));

		post.setId(Request.getInt("id"));
		service.update(post);
		int charuid = post.getId().intValue();

		if (Request.getInt("updtself") == 1) {
			return showSuccess("保存成功", "jiaoshi_updtself.do");
		}
		return showSuccess("保存成功", Request.get("referer"));
	}

	/**
	 * 删除
	 */
	@RequestMapping("/jiaoshi_delete")
	public String delete() {
		if (!checkLogin()) {
			return showError("尚未登录");
		}
		int id = Request.getInt("id");
		// delete_before
		service.delete(id);
		return showSuccess("删除成功", request.getHeader("referer"));
	}
}
