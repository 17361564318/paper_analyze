package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "xuesheng")
public class Xuesheng implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "xueshengxuehao")
    private String xueshengxuehao;
    @Column(name = "mima")
    private String mima;
    @Column(name = "xueshengxingming")
    private String xueshengxingming;
    @Column(name = "xingbie")
    private String xingbie;
    @Column(name = "xueshengzhaopian")
    private String xueshengzhaopian;
    @Column(name = "suozaibanji")
    private String suozaibanji;
    @Column(name = "lianxidianhua")
    private String lianxidianhua;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXueshengxuehao() {
        return xueshengxuehao;
    }
    public void setXueshengxuehao(String xueshengxuehao) {
        this.xueshengxuehao = xueshengxuehao == null ? "" : xueshengxuehao.trim();
    }

    public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? "" : mima.trim();
    }

    public String getXueshengxingming() {
        return xueshengxingming;
    }
    public void setXueshengxingming(String xueshengxingming) {
        this.xueshengxingming = xueshengxingming == null ? "" : xueshengxingming.trim();
    }

    public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? "" : xingbie.trim();
    }

    public String getXueshengzhaopian() {
        return xueshengzhaopian;
    }
    public void setXueshengzhaopian(String xueshengzhaopian) {
        this.xueshengzhaopian = xueshengzhaopian == null ? "" : xueshengzhaopian.trim();
    }

    public String getSuozaibanji() {
        return suozaibanji;
    }
    public void setSuozaibanji(String suozaibanji) {
        this.suozaibanji = suozaibanji == null ? "" : suozaibanji.trim();
    }

    public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? "" : lianxidianhua.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
