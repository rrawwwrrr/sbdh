package ru.sbdh.models;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Long id;
    private String fio;
    private String dolj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
