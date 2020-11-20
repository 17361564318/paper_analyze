package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.Banjixinxi;
import com.spring.service.BanjixinxiService;

import tk.mybatis.mapper.entity.Example;
import util.Info;
import util.Request;

/**
 * 班级信息
 */
@Controller
public class BanjixinxiController extends BaseController {
	@Autowired
	private BanjixinxiService service;

	/**
	 * 后台列表页
	 *
	 */
	@RequestMapping("/banjixinxi_list")
	public String list() {
		if (!checkLogin()) {
			return showError("尚未登录", "./login.do");
		}

		String order = Request.get("order", "id");
		String sort = Request.get("sort", "desc");

		Example example = new Example(Banjixinxi.class);
		Example.Criteria criteria = example.createCriteria();
		String where = " 1=1 ";
		where += getWhere();
		criteria.andCondition(where);
		if (sort.equals("desc")) {
			example.orderBy(order).desc();// 根据获取到的id进行默认的倒序排序
		} else {
			example.orderBy(order).asc();// 根据获取到的id进行升序排序
		}
		// 进行了拆箱操作，将integer类型数字转化为int类型数字
		int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
		page = Math.max(1, page);
		List<Banjixinxi> list = service.selectPageExample(example, page, 12);
		request.setAttribute("list", list);
		assign("orderBy", order);
		assign("sort", sort);
		assign("where", where);
		return "banjixinxi_list";
	}

	public String getWhere() {
		String where = " ";

		if (!Request.get("banji").equals("")) {
			where += " AND banji LIKE '%" + Request.get("banji") + "%' ";
		}
		return where;
	}

	@RequestMapping("/banjixinxi_add")
	public String add() {
		return "banjixinxi_add";
	}

	@RequestMapping("/banjixinxi_updt")
	public String updt() {
		int id = Request.getInt("id");
		Banjixinxi mmm = service.find(id);
		request.setAttribute("mmm", mmm);
		request.setAttribute("updtself", 0);
		return "banjixinxi_updt";
	}

	/**
	 * 添加班级
	 * 
	 * @return
	 */
	@RequestMapping("/banjixinxiinsert")
	public String insert() {
		String tmp = "";
		Banjixinxi post = new Banjixinxi();
		post.setBanji(Request.get("banji"));

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
	@RequestMapping("/banjixinxiupdate")
	public String update() {
		Banjixinxi post = new Banjixinxi();
		if (!Request.get("banji").equals(""))
			post.setBanji(Request.get("banji"));

		post.setId(Request.getInt("id"));
		service.update(post);
		int charuid = post.getId().intValue();

		if (Request.getInt("updtself") == 1) {
			return showSuccess("保存成功", "banjixinxi_updtself.do");
		}
		return showSuccess("保存成功", Request.get("referer"));
	}

	/**
	 * 删除
	 */
	@RequestMapping("/banjixinxi_delete")
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
