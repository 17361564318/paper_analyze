package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "jiaoshi")
public class Jiaoshi implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "jiaoshigonghao")
    private String jiaoshigonghao;
    @Column(name = "mima")
    private String mima;
    @Column(name = "jiaoshixingming")
    private String jiaoshixingming;
    @Column(name = "xingbie")
    private String xingbie;
    @Column(name = "suodaibanji")
    private String suodaibanji;
    @Column(name = "jiaoshizhaopian")
    private String jiaoshizhaopian;
    @Column(name = "lianxidianhua")
    private String lianxidianhua;
    @Column(name = "shenfenzheng")
    private String shenfenzheng;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJiaoshigonghao() {
        return jiaoshigonghao;
    }
    public void setJiaoshigonghao(String jiaoshigonghao) {
        this.jiaoshigonghao = jiaoshigonghao == null ? "" : jiaoshigonghao.trim();
    }

    public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? "" : mima.trim();
    }

    public String getJiaoshixingming() {
        return jiaoshixingming;
    }
    public void setJiaoshixingming(String jiaoshixingming) {
        this.jiaoshixingming = jiaoshixingming == null ? "" : jiaoshixingming.trim();
    }

    public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? "" : xingbie.trim();
    }

    public String getSuodaibanji() {
        return suodaibanji;
    }
    public void setSuodaibanji(String suodaibanji) {
        this.suodaibanji = suodaibanji == null ? "" : suodaibanji.trim();
    }

    public String getJiaoshizhaopian() {
        return jiaoshizhaopian;
    }
    public void setJiaoshizhaopian(String jiaoshizhaopian) {
        this.jiaoshizhaopian = jiaoshizhaopian == null ? "" : jiaoshizhaopian.trim();
    }

    public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? "" : lianxidianhua.trim();
    }

    public String getShenfenzheng() {
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng == null ? "" : shenfenzheng.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
