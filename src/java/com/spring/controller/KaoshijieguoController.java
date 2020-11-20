package com.spring.controller;

import com.spring.dao.KaoshijieguoMapper;
import com.spring.entity.Kaoshijieguo;
import com.spring.service.KaoshijieguoService;
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
 * 考试结果 */
@Controller
public class KaoshijieguoController extends BaseController
{
    @Autowired
    private KaoshijieguoMapper dao;
    @Autowired
    private KaoshijieguoService service;

    @Autowired
    private TikuService serviceRead;
    /**
     *  后台列表页
     *
     */
    @RequestMapping("/kaoshijieguo_list")
    public String list()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Kaoshijieguo.class);
        Example.Criteria criteria = example.createCriteria();
        String where = " 1=1 ";
        where += getWhere();
        criteria.andCondition(where);
        if(sort.equals("desc")){
            example.orderBy(order).desc();
        }else{
            example.orderBy(order).asc();
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1 , page);
        List<Kaoshijieguo> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        assign("orderBy" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "kaoshijieguo_list";
    }

    public String getWhere()
    {
        String where = " ";
        if(Request.getInt("tikuid")>0){
            where += " AND tikuid='"+Request.getInt("tikuid")+"' ";
        }

            if(!Request.get("tikubianhao").equals("")) {
            where += " AND tikubianhao LIKE '%"+Request.get("tikubianhao")+"%' ";
        }
                if(!Request.get("tikumingcheng").equals("")) {
            where += " AND tikumingcheng LIKE '%"+Request.get("tikumingcheng")+"%' ";
        }
                if(!Request.get("kaoshibianhao").equals("")) {
            where += " AND kaoshibianhao LIKE '%"+Request.get("kaoshibianhao")+"%' ";
        }
                if(!Request.get("danxuantidefen").equals("")) {
            where += " AND danxuantidefen LIKE '%"+Request.get("danxuantidefen")+"%' ";
        }
            return where;
    }

    @RequestMapping("/kaoshijieguo_list_faburen")
    public String listfaburen()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }
        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Kaoshijieguo.class);
        Example.Criteria criteria = example.createCriteria();
        String where = " faburen='"+request.getSession().getAttribute("jiaoshigonghao")+"' ";
        where += getWhere();

        criteria.andCondition(where);
        if(sort.equals("desc")){
            example.orderBy(order).desc();
        }else{
            example.orderBy(order).asc();
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1 , page);
        List<Kaoshijieguo> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        assign("orderBy" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "kaoshijieguo_list_faburen";
    }
    @RequestMapping("/kaoshijieguo_list_kaoshiren")
    public String listkaoshiren()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }
        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Kaoshijieguo.class);
        Example.Criteria criteria = example.createCriteria();
        String where = " kaoshiren='"+request.getSession().getAttribute("xueshengxuehao")+"' ";
        where += getWhere();

        criteria.andCondition(where);
        if(sort.equals("desc")){
            example.orderBy(order).desc();
        }else{
            example.orderBy(order).asc();
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1 , page);
        List<Kaoshijieguo> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        assign("orderBy" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "kaoshijieguo_list_kaoshiren";
    }




        @RequestMapping("/kaoshijieguo_add")
    public String add()
    {
        int id = Request.getInt("id");
        Tiku readMap = serviceRead.find(id);
        request.setAttribute("readMap" , readMap);
        return "kaoshijieguo_add";
    }



    @RequestMapping("/kaoshijieguo_updt")
    public String updt()
    {
        int id = Request.getInt("id");
        Kaoshijieguo mmm = service.find(id);
        request.setAttribute("mmm" , mmm);
        request.setAttribute("updtself" , 0);
        return "kaoshijieguo_updt";
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/kaoshijieguoinsert")
    public String insert()
    {
        String tmp="";
        Kaoshijieguo post = new Kaoshijieguo();
        post.setTikubianhao(Request.get("tikubianhao"));

        post.setTikumingcheng(Request.get("tikumingcheng"));

        post.setBanji(Request.get("banji"));

        post.setFaburen(Request.get("faburen"));

        post.setKaoshibianhao(Request.get("kaoshibianhao"));

        post.setDanxuantidefen(Request.get("danxuantidefen"));

        post.setJiandatidefen(Request.get("jiandatidefen"));

        post.setTiankongtidefen(Request.get("tiankongtidefen"));

        post.setZongdefen(Request.get("zongdefen"));

        post.setKaoshiren(Request.get("kaoshiren"));

        post.setTikuid(Request.getInt("tikuid"));

        post.setAddtime(Info.getDateStr());
                service.insert(post);
        int charuid = post.getId().intValue();
        
        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
    * 更新内容
    * @return
    */
    @RequestMapping("/kaoshijieguoupdate")
    public String update()
    {
        Kaoshijieguo post = new Kaoshijieguo();
        if(!Request.get("tikubianhao").equals(""))
        post.setTikubianhao(Request.get("tikubianhao"));
                if(!Request.get("tikumingcheng").equals(""))
        post.setTikumingcheng(Request.get("tikumingcheng"));
                if(!Request.get("banji").equals(""))
        post.setBanji(Request.get("banji"));
                if(!Request.get("faburen").equals(""))
        post.setFaburen(Request.get("faburen"));
                if(!Request.get("kaoshibianhao").equals(""))
        post.setKaoshibianhao(Request.get("kaoshibianhao"));
                if(!Request.get("danxuantidefen").equals(""))
        post.setDanxuantidefen(Request.get("danxuantidefen"));
                if(!Request.get("jiandatidefen").equals(""))
        post.setJiandatidefen(Request.get("jiandatidefen"));
                if(!Request.get("tiankongtidefen").equals(""))
        post.setTiankongtidefen(Request.get("tiankongtidefen"));
                if(!Request.get("zongdefen").equals(""))
        post.setZongdefen(Request.get("zongdefen"));
                if(!Request.get("kaoshiren").equals(""))
        post.setKaoshiren(Request.get("kaoshiren"));
        
        post.setId(Request.getInt("id"));
                service.update(post);
        int charuid = post.getId().intValue();
        
        if(Request.getInt("updtself") == 1){
            return showSuccess("保存成功" , "kaoshijieguo_updtself.do");
        }
        return showSuccess("保存成功" , Request.get("referer"));
    }
    /**
     *  后台详情
     */
    @RequestMapping("/kaoshijieguo_detail")
    public String detail()
    {
        int id = Request.getInt("id");
        Kaoshijieguo map = service.find(id);
        request.setAttribute("map" , map);
        return "kaoshijieguo_detail";
    }
    /**
     *  前台详情
     */
    @RequestMapping("/kaoshijieguodetail")
    public String detailweb()
    {
        int id = Request.getInt("id");
        Kaoshijieguo map = service.find(id);
        
        request.setAttribute("map" , map);
        return "kaoshijieguodetail";
    }
        /**
    *  删除
    */
    @RequestMapping("/kaoshijieguo_delete")
    public String delete()
    {
        if(!checkLogin()){
            return showError("尚未登录");
        }
        int id = Request.getInt("id");
        //delete_before
                service.delete(id);
                return showSuccess("删除成功",request.getHeader("referer"));
    }
}
