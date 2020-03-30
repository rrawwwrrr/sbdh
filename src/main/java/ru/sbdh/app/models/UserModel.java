package ru.sbdh.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    private Integer id;
    private String fio;
    private String fullname;
    private String dolj;
    private String email;
    private String ncbn;
    private String newphone;
    private String nphn2;
    private String otdel;

    public UserModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDolj() {
        return dolj;
    }

    public void setDolj(String dolj) {
        this.dolj = dolj;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNcbn() {
        return ncbn;
    }

    public void setNcbn(String ncbn) {
        this.ncbn = ncbn;
    }

    public String getNewphone() {
        return newphone;
    }

    public void setNewphone(String newphone) {
        this.newphone = newphone;
    }

    public String getNphn2() {
        return nphn2;
    }

    public void setNphn2(String nphn2) {
        this.nphn2 = nphn2;
    }

    public String getOtdel() {
        return otdel;
    }

    public void setOtdel(String otdel) {
        this.otdel = otdel;
    }
}