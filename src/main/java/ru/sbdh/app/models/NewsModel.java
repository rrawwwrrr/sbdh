package ru.sbdh.app.models;

import java.util.Date;

public class NewsModel {
    private int id;
    private String full_value;
    private String short_value;
    private Date created;
    private boolean used;
    private int created_by;
    private int level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_value() {
        return full_value;
    }

    public void setFull_value(String full_value) {
        this.full_value = full_value;
    }

    public String getShort_value() {
        return short_value;
    }

    public void setShort_value(String short_value) {
        this.short_value = short_value;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
