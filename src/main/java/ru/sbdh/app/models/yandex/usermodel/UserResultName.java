package ru.sbdh.app.models.yandex.usermodel;

public class UserResultName {
    private String last;
    private String first;
    private String middle;


    // Getter Methods

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public String getFirst() {
        return first;
    }

    // Setter Methods

    public void setLast(String last) {
        this.last = last;
    }

    public void setFirst(String first) {
        this.first = first;
    }
}
