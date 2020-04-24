package domain;

import java.sql.Date;

public class Activity {
    private int id;
    private String name;
    private String description;
    private String value;
    private String filePath;
    private String idIntern;
    private Date uploadDate;

    public Activity(int id, String name, String value, String description,  Date uploadDate, String filePath, String idIntern) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.filePath = filePath;
        this.idIntern = idIntern;
        this.uploadDate = uploadDate;
    }

    public Activity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getIdIntern() {
        return idIntern;
    }

    public void setIdIntern(String idIntern) {
        this.idIntern = idIntern;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Activity{" + "id=" + id + ", name=" + name + ", description=" + description + ", value=" + value + ", filePath=" + filePath + ", idIntern=" + idIntern + ", uploadDate=" + uploadDate + '}';
    }
    
}
