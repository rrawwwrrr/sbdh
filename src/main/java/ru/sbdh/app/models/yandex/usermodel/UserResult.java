package ru.sbdh.app.models.yandex.usermodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResult {
    private String gender;
    private BigInteger id;
    private UserResultName name;
    private String position = null;
    private List<UserResultContacts> contacts;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<UserResultContacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<UserResultContacts> contacts) {
        this.contacts = contacts;
    }

    public UserResultName getName() {
        return name;
    }

    public void setName(UserResultName name) {
        this.name = name;
    }
}