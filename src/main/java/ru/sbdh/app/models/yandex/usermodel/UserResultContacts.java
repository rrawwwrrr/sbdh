package ru.sbdh.app.models.yandex.usermodel;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class UserResultContacts {
    private String type;
    private String value;
    private Boolean main;
    private Boolean alias;
    private Boolean synthetic;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public Boolean getAlias() {
        return alias;
    }

    public void setAlias(Boolean alias) {
        this.alias = alias;
    }

    public Boolean getSynthetic() {
        return synthetic;
    }

    public void setSynthetic(Boolean synthetic) {
        this.synthetic = synthetic;
    }
}
