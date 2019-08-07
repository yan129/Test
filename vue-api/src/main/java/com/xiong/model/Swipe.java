package com.xiong.model;

public class Swipe {
    private String img;
    private String url;

    @Override
    public String toString() {
        return "Swipe{" +
                "img='" + img + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
