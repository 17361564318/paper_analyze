package com.spring.controller;

import com.spring.dao.JieguoMapper;
import com.spring.entity.Jieguo;
import com.spring.service.JieguoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;

import java.util.*;


import com.spring.entity.Tiku;
import com.spring.service.TikuService;

/**
 * 结果
 */
@Controller
public class JieguoController extends BaseController {
    @Autowired
    private JieguoMapper dao;
    @Autowired
    private JieguoService service;

    @Autowired
    private TikuService serviceRead;

    /**
     * 后台列表页
     */
    @RequestMapping("/jieguo_list")
    public String list() {
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        Example example = new Example(Jieguo.class);
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
        List<Jieguo> list = service.selectPageExample(example, page, 12);
        request.setAttribute("list", list);
        assign("orderBy", order);
        assign("sort", sort);
        assign("where", where);
        return "jieguo_list";
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
        if (!Request.get("daan").equals("")) {
            where += " AND daan LIKE '%" + Request.get("daan") + "%' ";
        }
        if (session.getAttribute("cx").equals("教师")) {

            where += " AND banji='"+session.getAttribute("suodaibanji")+"' ";

        }
        return where;
    }

    @RequestMapping("/jieguo_list_kaoshiren")
    public String listkaoshiren() {
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }
        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        Example example = new Example(Jieguo.class);
        Example.Criteria criteria = example.createCriteria();
        String where = " kaoshiren='" + request.getSession().getAttribute("xueshengxuehao") + "' ";
        where += getWhere();

        criteria.andCondition(where);
        if (sort.equals("desc")) {
            example.orderBy(order).desc();
        } else {
            example.orderBy(order).asc();
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1, page);
        List<Jieguo> list = service.selectPageExample(example, page, 12);
        request.setAttribute("list", list);
        assign("orderBy", order);
        assign("sort", sort);
        assign("where", where);
        return "jieguo_list_kaoshiren";
    }


    @RequestMapping("/jieguo_add")
    public String add() {
        int id = Request.getInt("id");
        Tiku readMap = serviceRead.find(id);
        request.setAttribute("readMap", readMap);
        return "jieguo_add";
    }


    @RequestMapping("/jieguo_updt")
    public String updt() {
        int id = Request.getInt("id");
        Jieguo mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 0);
        return "jieguo_updt";
    }

    /**
     * 添加内容
     *
     * @return
     */
    @RequestMapping("/jieguoinsert")
    public String insert() {
        String tmp = "";
        Jieguo post = new Jieguo();
        post.setTikubianhao(Request.get("tikubianhao"));

        post.setTikumingcheng(Request.get("tikumingcheng"));

        post.setBanji(Request.get("banji"));

        post.setKaoshibianhao(Request.get("kaoshibianhao"));

        post.setBiaoti(Request.get("biaoti"));

        post.setLeixing(Request.get("leixing"));

        post.setDaan(Request.get("daan"));

        post.setDefen(Request.get("defen"));

        post.setKaoshiren(Request.get("kaoshiren"));

        post.setTikuid(Request.getInt("tikuid"));

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
    @RequestMapping("/jieguoupdate")
    public String update() {
        Jieguo post = new Jieguo();
        if (!Request.get("tikubianhao").equals(""))
            post.setTikubianhao(Request.get("tikubianhao"));
        if (!Request.get("tikumingcheng").equals(""))
            post.setTikumingcheng(Request.get("tikumingcheng"));
        if (!Request.get("banji").equals(""))
            post.setBanji(Request.get("banji"));
        if (!Request.get("kaoshibianhao").equals(""))
            post.setKaoshibianhao(Request.get("kaoshibianhao"));
        if (!Request.get("biaoti").equals(""))
            post.setBiaoti(Request.get("biaoti"));
        if (!Request.get("leixing").equals(""))
            post.setLeixing(Request.get("leixing"));
        if (!Request.get("daan").equals(""))
            post.setDaan(Request.get("daan"));
        if (!Request.get("defen").equals(""))
            post.setDefen(Request.get("defen"));
        if (!Request.get("kaoshiren").equals(""))
            post.setKaoshiren(Request.get("kaoshiren"));

        post.setId(Request.getInt("id"));
        service.update(post);
        int charuid = post.getId().intValue();
        Query.execute("UPDATE kaoshijieguo SET zongdefen=(SELECT SUM(defen) FROM jieguo WHERE kaoshibianhao='" + request.getParameter("kaoshibianhao") + "' AND defen>=0) WHERE kaoshibianhao='" + request.getParameter("kaoshibianhao") + "'");

        Query.execute("UPDATE kaoshijieguo SET tiankongtidefen=(SELECT SUM(defen) FROM jieguo WHERE kaoshibianhao='" + request.getParameter("kaoshibianhao") + "' AND leixing='填空题' AND defen>=0) WHERE kaoshibianhao='" + request.getParameter("kaoshibianhao") + "'");

        Query.execute("UPDATE kaoshijieguo SET jiandatidefen=(SELECT SUM(defen) FROM jieguo WHERE kaoshibianhao='" + request.getParameter("kaoshibianhao") + "' AND leixing='简答题' AND defen>=0) WHERE kaoshibianhao='" + request.getParameter("kaoshibianhao") + "'");

        Query.execute("");


        if (Request.getInt("updtself") == 1) {
            return showSuccess("保存成功", "jieguo_updtself.do");
        }
        return showSuccess("保存成功", Request.get("referer"));
    }

    /**
     * 后台详情
     */
    @RequestMapping("/jieguo_detail")
    public String detail() {
        int id = Request.getInt("id");
        Jieguo map = service.find(id);
        request.setAttribute("map", map);
        return "jieguo_detail";
    }

    /**
     * 删除
     */
    @RequestMapping("/jieguo_delete")
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
