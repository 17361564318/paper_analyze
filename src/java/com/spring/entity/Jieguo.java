package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "jieguo")
public class Jieguo implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "tikubianhao")
    private String tikubianhao;
    @Column(name = "tikumingcheng")
    private String tikumingcheng;
    @Column(name = "banji")
    private String banji;
    @Column(name = "kaoshibianhao")
    private String kaoshibianhao;
    @Column(name = "biaoti")
    private String biaoti;
    @Column(name = "leixing")
    private String leixing;
    @Column(name = "daan")
    private String daan;
    @Column(name = "defen")
    private String defen;
    @Column(name = "kaoshiren")
    private String kaoshiren;
    private Integer tikuid;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTikubianhao() {
        return tikubianhao;
    }
    public void setTikubianhao(String tikubianhao) {
        this.tikubianhao = tikubianhao == null ? "" : tikubianhao.trim();
    }

    public String getTikumingcheng() {
        return tikumingcheng;
    }
    public void setTikumingcheng(String tikumingcheng) {
        this.tikumingcheng = tikumingcheng == null ? "" : tikumingcheng.trim();
    }

    public String getBanji() {
        return banji;
    }
    public void setBanji(String banji) {
        this.banji = banji == null ? "" : banji.trim();
    }

    public String getKaoshibianhao() {
        return kaoshibianhao;
    }
    public void setKaoshibianhao(String kaoshibianhao) {
        this.kaoshibianhao = kaoshibianhao == null ? "" : kaoshibianhao.trim();
    }

    public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? "" : biaoti.trim();
    }

    public String getLeixing() {
        return leixing;
    }
    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? "" : leixing.trim();
    }

    public String getDaan() {
        return daan;
    }
    public void setDaan(String daan) {
        this.daan = daan == null ? "" : daan.trim();
    }

    public String getDefen() {
        return defen;
    }
    public void setDefen(String defen) {
        this.defen = defen == null ? "" : defen.trim();
    }

    public String getKaoshiren() {
        return kaoshiren;
    }
    public void setKaoshiren(String kaoshiren) {
        this.kaoshiren = kaoshiren == null ? "" : kaoshiren.trim();
    }
    public Integer getTikuid() {
        return tikuid;
    }
    public void setTikuid(Integer tikuid) {
        this.tikuid = tikuid == null ? 0 : tikuid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
