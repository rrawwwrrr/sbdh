package ru.sbdh.app.models;

/**
 * @author rrr on 29.03.2020
 * @project sbdh
 */
public class NorrisModel {
    public String id;
    public boolean used;
    public String isppodr;
    public String contractFull;
    public String objectFull;
    public String type;
    public String files;
    public String comment;
    public String created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getIsppodr() {
        return isppodr;
    }

    public void setIsppodr(String isppodr) {
        this.isppodr = isppodr;
    }

    public String getContractFull() {
        return contractFull;
    }

    public void setContractFull(String contractFull) {
        this.contractFull = contractFull;
    }

    public String getObjectFull() {
        return objectFull;
    }

    public void setObjectFull(String objectFull) {
        this.objectFull = objectFull;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
