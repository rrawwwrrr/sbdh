package ru.sbdh.app.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Otdel {
    private static final Logger LOGGER = LoggerFactory.getLogger(Otdel.class);
    private Integer id;
    private String nameotdel;
    private Integer nomenk;
    private String email;
    private User[] users;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameotdel() {
        return nameotdel;
    }

    public void setNameotdel(String nameotdel) {
        this.nameotdel = nameotdel;
    }

    public Integer getNomenk() {
        return nomenk;
    }

    public void setNomenk(Integer nomenk) {
        this.nomenk = nomenk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsers(String users) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.users = mapper.readValue(users, User[].class);
        } catch (IOException e) {
            LOGGER.warn(e.toString());
        }
    }
}
