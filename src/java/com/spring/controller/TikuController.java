package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.TikuMapper;
import com.spring.entity.Tiku;
import com.spring.service.TikuService;

import tk.mybatis.mapper.entity.Example;
import util.Info;
import util.Request;


/**
 * 题库
 */
@Controller
public class TikuController extends BaseController {
    @Autowired
    private TikuMapper dao;
    @Autowired
    private TikuService service;

    /**
     * 后台列表页
     */
    @RequestMapping("/tiku_list")
    public String list() {
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        Example example = new Example(Tiku.class);
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
        List<Tiku> list = service.selectPageExample(example, page, 12);
        request.setAttribute("list", list);
        assign("orderBy", order);
        assign("sort", sort);
        assign("where", where);
        return "tiku_list";
    }

    public String getWhere() {
        String where = " ";

        if (!Request.get("tikubianhao").equals("")) {
            where += " AND tikubianhao LIKE '%" + Request.get("tikubianhao") + "%' ";
        }
        if (!Request.get("tikumingcheng").equals("")) {
            where += " AND tikumingcheng LIKE '%" + Request.get("tikumingcheng") + "%' ";
        }
        if (session.getAttribute("cx").equals("学生")) {

            where += " AND banji='"+session.getAttribute("suozaibanji")+"' ";

        }
        return where;
    }

    @RequestMapping("/tiku_list_faburen")
    public String listfaburen() {
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }
        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        Example example = new Example(Tiku.class);
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
        List<Tiku> list = service.selectPageExample(example, page, 12);
        request.setAttribute("list", list);
        assign("orderBy", order);
        assign("sort", sort);
        assign("where", where);
        return "tiku_list_faburen";
    }


    /**
     * 前台列表页
     */
    @RequestMapping("/tikulist")
    public String index() {
        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        Example example = new Example(Tiku.class);
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
        List<Tiku> list = service.selectPageExample(example, page, 12);
        request.setAttribute("list", list);
        request.setAttribute("where", where);
        assign("orderBy", order);
        assign("sort", sort);
        return "tikulist";
    }


    @RequestMapping("/tiku_add")
    public String add() {
        return "tiku_add";
    }


    @RequestMapping("/tiku_updt")
    public String updt() {
        int id = Request.getInt("id");
        Tiku mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 0);
        return "tiku_updt";
    }

    /**
     * 添加内容
     *
     * @return
     */
    @RequestMapping("/tikuinsert")
    public String insert() {
        String tmp = "";
        Tiku post = new Tiku();
        post.setTikubianhao(Request.get("tikubianhao"));

        post.setTikumingcheng(Request.get("tikumingcheng"));

        post.setBanji(Request.get("banji"));

        post.setFaburen(Request.get("faburen"));


        post.setAddtime(Info.getDateStr());
        service.insert(post);
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    @RequestMapping("tiku_insert")
    public String tiku_list() {
    	return "tiku_insert";
    }
    
    /**
     * 更新内容
     *
     * @return
     */
    @RequestMapping("/tikuupdate")
    public String update() {
        Tiku post = new Tiku();
        if (!Request.get("tikubianhao").equals(""))
            post.setTikubianhao(Request.get("tikubianhao"));
        if (!Request.get("tikumingcheng").equals(""))
            post.setTikumingcheng(Request.get("tikumingcheng"));
        if (!Request.get("banji").equals(""))
            post.setBanji(Request.get("banji"));
        if (!Request.get("faburen").equals(""))
            post.setFaburen(Request.get("faburen"));

        post.setId(Request.getInt("id"));
        service.update(post);
        int charuid = post.getId().intValue();

        if (Request.getInt("updtself") == 1) {
            return showSuccess("保存成功", "tiku_updtself.do");
        }
        return showSuccess("保存成功", Request.get("referer"));
    }

    /**
     * 后台详情
     */
    @RequestMapping("/tiku_detail")
    public String detail() {
        int id = Request.getInt("id");
        Tiku map = service.find(id);
        request.setAttribute("map", map);
        return "tiku_detail";
    }

    /**
     * 前台详情
     */
    @RequestMapping("/tikudetail")
    public String detailweb() {
        int id = Request.getInt("id");
        Tiku map = service.find(id);

        request.setAttribute("map", map);
        return "tikudetail";
    }

    /**
     * 删除
     */
    @RequestMapping("/tiku_delete")
    public String delete() {
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id");
        //delete_before
        service.delete(id);
        return showSuccess("删除成功", request.getHeader("referer"));
    }
}
