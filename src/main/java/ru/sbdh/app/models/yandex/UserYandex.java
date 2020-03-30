package ru.sbdh.app.models.yandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.sbdh.app.models.yandex.usermodel.UserResult;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserYandex {
    private Integer page;
    private Integer per_page;
    private Integer pages;
    private Integer total;
    private Boolean multishard;
    private List<UserResult> result;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean isMultishard() {
        return multishard;
    }

    public void setMultishard(Boolean multishard) {
        this.multishard = multishard;
    }

    public List<UserResult> getResult() {
        return result;
    }

    public void setResult(List<UserResult> result) {
        this.result = result;
    }
}
