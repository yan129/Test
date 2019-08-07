package com.xiong.model;

public class Comment {
    private int id;
    private int newlist_id;
    private String user;
    private String add_time;
    private String body;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", newlist_id=" + newlist_id +
                ", user='" + user + '\'' +
                ", add_time='" + add_time + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewlist_id() {
        return newlist_id;
    }

    public void setNewlist_id(int newlist_id) {
        this.newlist_id = newlist_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
