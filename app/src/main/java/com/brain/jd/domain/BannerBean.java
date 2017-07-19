package com.brain.jd.domain;

/**
 * banner 数据
 * @author : Brian
 * @date : 2017/6/23
 */

public class BannerBean {
    private long id;
    private int type;//跳转类型（1跳转到网页，2跳转到商品详情，3跳转到分类去）
    private String adUrl;//图片路径
    private String webUrl;//如果是跳转网页类型，则返回网页地址
    private int adKind;//1为导航banner，2为广告banner

    @Override
    public String toString() {
        return "BannerBean{" +
                "id=" + id +
                ", type=" + type +
                ", adUrl='" + adUrl + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", adKind=" + adKind +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public int getAdKind() {
        return adKind;
    }

    public void setAdKind(int adKind) {
        this.adKind = adKind;
    }
}
