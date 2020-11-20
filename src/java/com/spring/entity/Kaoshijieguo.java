package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "kaoshijieguo")
public class Kaoshijieguo implements Serializable {
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
    @Column(name = "faburen")
    private String faburen;
    @Column(name = "kaoshibianhao")
    private String kaoshibianhao;
    @Column(name = "danxuantidefen")
    private String danxuantidefen;
    @Column(name = "jiandatidefen")
    private String jiandatidefen;
    @Column(name = "tiankongtidefen")
    private String tiankongtidefen;
    @Column(name = "zongdefen")
    private String zongdefen;
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

    public String getFaburen() {
        return faburen;
    }
    public void setFaburen(String faburen) {
        this.faburen = faburen == null ? "" : faburen.trim();
    }

    public String getKaoshibianhao() {
        return kaoshibianhao;
    }
    public void setKaoshibianhao(String kaoshibianhao) {
        this.kaoshibianhao = kaoshibianhao == null ? "" : kaoshibianhao.trim();
    }

    public String getDanxuantidefen() {
        return danxuantidefen;
    }
    public void setDanxuantidefen(String danxuantidefen) {
        this.danxuantidefen = danxuantidefen == null ? "" : danxuantidefen.trim();
    }

    public String getJiandatidefen() {
        return jiandatidefen;
    }
    public void setJiandatidefen(String jiandatidefen) {
        this.jiandatidefen = jiandatidefen == null ? "" : jiandatidefen.trim();
    }

    public String getTiankongtidefen() {
        return tiankongtidefen;
    }
    public void setTiankongtidefen(String tiankongtidefen) {
        this.tiankongtidefen = tiankongtidefen == null ? "" : tiankongtidefen.trim();
    }

    public String getZongdefen() {
        return zongdefen;
    }
    public void setZongdefen(String zongdefen) {
        this.zongdefen = zongdefen == null ? "" : zongdefen.trim();
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
