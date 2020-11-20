package com.spring.controller;

import com.spring.dao.XueshengMapper;
import com.spring.entity.Xuesheng;
import com.spring.service.XueshengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;

import java.util.*;


/**
 * 学生
 */
@Controller
public class XueshengController extends BaseController {
    @Autowired
    private XueshengMapper dao;
    @Autowired
    private XueshengService service;

    /**
     * 后台列表页
     */
    @RequestMapping("/xuesheng_list")
    public String list() {
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        Example example = new Example(Xuesheng.class);
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
        List<Xuesheng> list = service.selectPageExample(example, page, 12);
        request.setAttribute("list", list);
        assign("orderBy", order);
        assign("sort", sort);
        assign("where", where);
        return "xuesheng_list";
    }

    public String getWhere() {
        String where = " ";

        if (!Request.get("xueshengxuehao").equals("")) {
            where += " AND xueshengxuehao LIKE '%" + Request.get("xueshengxuehao") + "%' ";
        }
        if (!Request.get("xueshengxingming").equals("")) {
            where += " AND xueshengxingming LIKE '%" + Request.get("xueshengxingming") + "%' ";
        }
        if (!Request.get("suozaibanji").equals("")) {
            where += " AND suozaibanji ='" + Request.get("suozaibanji") + "' ";
        }
        if (session.getAttribute("cx").equals("教师")) {

            where += " AND suozaibanji='"+session.getAttribute("suodaibanji")+"' ";

        }

        return where;
    }


    @RequestMapping("/xuesheng_add")
    public String add() {
        return "xuesheng_add";
    }


    @RequestMapping("/xuesheng_updt")
    public String updt() {
        int id = Request.getInt("id");
        Xuesheng mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 0);
        return "xuesheng_updt";
    }

    @RequestMapping("/xuesheng_updtself")
    public String updtself() {
        int id = (int) request.getSession().getAttribute("id");
        Xuesheng mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 1);

        return "xuesheng_updtself";
    }

    /**
     * 添加内容
     *
     * @return
     */
    @RequestMapping("/xueshenginsert")
    public String insert() {
        String tmp = "";
        Xuesheng post = new Xuesheng();
        post.setXueshengxuehao(Request.get("xueshengxuehao"));

        post.setMima(Request.get("mima"));

        post.setXueshengxingming(Request.get("xueshengxingming"));

        post.setXingbie(Request.get("xingbie"));

        post.setXueshengzhaopian(Request.get("xueshengzhaopian"));

        post.setSuozaibanji(Request.get("suozaibanji"));

        post.setLianxidianhua(Request.get("lianxidianhua"));


        post.setAddtime(Info.getDateStr());
        service.insert(post);
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 更新内容
     *
     * @return
     */
    @RequestMapping("/xueshengupdate")
    public String update() {
        Xuesheng post = new Xuesheng();
        if (!Request.get("xueshengxuehao").equals(""))
            post.setXueshengxuehao(Request.get("xueshengxuehao"));
        if (!Request.get("mima").equals(""))
            post.setMima(Request.get("mima"));
        if (!Request.get("xueshengxingming").equals(""))
            post.setXueshengxingming(Request.get("xueshengxingming"));
        if (!Request.get("xingbie").equals(""))
            post.setXingbie(Request.get("xingbie"));
        if (!Request.get("xueshengzhaopian").equals(""))
            post.setXueshengzhaopian(Request.get("xueshengzhaopian"));
        if (!Request.get("suozaibanji").equals(""))
            post.setSuozaibanji(Request.get("suozaibanji"));
        if (!Request.get("lianxidianhua").equals(""))
            post.setLianxidianhua(Request.get("lianxidianhua"));

        post.setId(Request.getInt("id"));
        service.update(post);
        int charuid = post.getId().intValue();

        if (Request.getInt("updtself") == 1) {
            return showSuccess("保存成功", "xuesheng_updtself.do");
        }
        return showSuccess("保存成功", Request.get("referer"));
    }

    /**
     * 删除
     */
    @RequestMapping("/xuesheng_delete")
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
