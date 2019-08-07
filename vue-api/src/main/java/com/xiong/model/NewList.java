package com.xiong.model;


public class NewList {
    private int id;
    private String title;
    private String add_time;
    private String zhaiyao;
    private int click;
    private String img_url;
    public String content;

    @Override
    public String toString() {
        return "NewList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", add_time='" + add_time + '\'' +
                ", zhaiyao='" + zhaiyao + '\'' +
                ", click=" + click +
                ", img_url='" + img_url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getZhaiyao() {
        return zhaiyao;
    }

    public void setZhaiyao(String zhaiyao) {
        this.zhaiyao = zhaiyao;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
