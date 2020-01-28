package ru.sbdh.app.models;

public class UserModel {
    private Integer id;
    private String fio;
    private String dolj;


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
}