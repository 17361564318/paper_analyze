package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.Shiti;
import com.spring.entity.Tiku;
import com.spring.service.ShitiService;
import com.spring.service.TikuService;

import tk.mybatis.mapper.entity.Example;
import util.Info;
import util.Request;

/**
 * 试题
 */
@Controller
public class ShitiController extends BaseController {

	@Autowired
	private ShitiService service;

	@Autowired
	private TikuService serviceRead;

	/**
	 * 后台列表页
	 *
	 */
	@RequestMapping("/shiti_list")
	public String list() {
		if (!checkLogin()) {
			return showError("尚未登录", "./login.do");
		}

		String order = Request.get("order", "id");
		String sort = Request.get("sort", "desc");

		Example example = new Example(Shiti.class);
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
		List<Shiti> list = service.selectPageExample(example, page, 12);
		request.setAttribute("list", list);
		assign("orderBy", order);
		assign("sort", sort);
		assign("where", where);
		return "shiti_list";
	}

	public String getWhere() {
		String where = " ";
		if (Request.getInt("tikuid") > 0) {
			where += " AND tikuid='" + Request.getInt("tikuid") + "' ";
		}

		if (!Request.get("tikubianhao").equals("")) {
			where += " AND tikubianhao LIKE '%" + Request.get("tikubianhao") + "%' ";
		}
		if (!Request.get("tikumingcheng").equals("")) {
			where += " AND tikumingcheng LIKE '%" + Request.get("tikumingcheng") + "%' ";
		}
		if (!Request.get("biaoti").equals("")) {
			where += " AND biaoti LIKE '%" + Request.get("biaoti") + "%' ";
		}
		if (!Request.get("leixing").equals("")) {
			where += " AND leixing ='" + Request.get("leixing") + "' ";
		}
		if (!Request.get("daan").equals("")) {
			where += " AND daan ='" + Request.get("daan") + "' ";
		}
		return where;
	}

	@RequestMapping("/shiti_list_faburen")
	public String listfaburen() {
		if (!checkLogin()) {
			return showError("尚未登录", "./login.do");
		}
		String order = Request.get("order", "id");
		String sort = Request.get("sort", "desc");

		Example example = new Example(Shiti.class);
		Example.Criteria criteria = example.createCriteria();
		String where = " faburen='" + request.getSession().getAttribute("jiaoshigonghao") + "' ";
		where += getWhere();

		criteria.andCondition(where);
		if (sort.equals("desc")) {
			example.orderBy(order).desc();
		} else {
			example.orderBy(order).asc();
		}

		int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
		page = Math.max(1, page);
		List<Shiti> list = service.selectPageExample(example, page, 12);
		request.setAttribute("list", list);
		assign("orderBy", order);
		assign("sort", sort);
		assign("where", where);
		return "shiti_list_faburen";
	}

	@RequestMapping("/shiti_add")
	public String add() {
		int id = Request.getInt("id");
		Tiku readMap = serviceRead.find(id);
		request.setAttribute("readMap", readMap);
		return "shiti_add";
	}

	@RequestMapping("/shiti_updt")
	public String updt() {
		int id = Request.getInt("id");
		Shiti mmm = service.find(id);
		request.setAttribute("mmm", mmm);
		request.setAttribute("updtself", 0);
		return "shiti_updt";
	}

	/**
	 * 添加内容
	 * 
	 * @return
	 */
	@RequestMapping("/shitiinsert")
	public String insert() {
		String tmp = "";
		Shiti post = new Shiti();
		post.setTikubianhao(Request.get("tikubianhao"));

		post.setTikumingcheng(Request.get("tikumingcheng"));

		post.setBiaoti(Request.get("biaoti"));

		post.setLeixing(Request.get("leixing"));

		post.setNandu(Request.get("nandu"));

		post.setDaan(Request.get("daan"));

		post.setFaburen(Request.get("faburen"));

		post.setTikuid(Request.getInt("tikuid"));

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
	@RequestMapping("/shitiupdate")
	public String update() {
		Shiti post = new Shiti();
		if (!Request.get("tikubianhao").equals(""))
			post.setTikubianhao(Request.get("tikubianhao"));
		if (!Request.get("tikumingcheng").equals(""))
			post.setTikumingcheng(Request.get("tikumingcheng"));
		if (!Request.get("biaoti").equals(""))
			post.setBiaoti(Request.get("biaoti"));
		if (!Request.get("leixing").equals(""))
			post.setLeixing(Request.get("leixing"));
		if (!Request.get("nandu").equals(""))
			post.setNandu(Request.get("nandu"));
		if (!Request.get("daan").equals(""))
			post.setDaan(Request.get("daan"));
		if (!Request.get("faburen").equals(""))
			post.setFaburen(Request.get("faburen"));

		post.setId(Request.getInt("id"));

		service.update(post);
		int charuid = post.getId().intValue();

		if (Request.getInt("updtself") == 1) {
			return showSuccess("保存成功", "shiti_updtself.do");
		}
		return showSuccess("保存成功", Request.get("referer"));
	}

	/**
	 * 后台详情
	 */
	@RequestMapping("/shiti_detail")
	public String detail() {
		int id = Request.getInt("id");
		Shiti map = service.find(id);
		request.setAttribute("map", map);
		return "shiti_detail";
	}

	/**
	 * 删除
	 */
	@RequestMapping("/shiti_delete")
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
