package domain;

import java.sql.Date;

public class Document {
    private int id;
    private String documentType;
    private String filePath;
    private String idIntern;
    private Date uploadDate;

    public Document(int id, String filePath, String documentType, String idIntern, Date uploadDate) {
        this.id = id;
        this.documentType = documentType;
        this.filePath = filePath;
        this.idIntern = idIntern;
        this.uploadDate = uploadDate;
    }

    public int getIdDocument() {
        return id;
    }

    public void setIdDocument(int id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
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
        return "Document{" + "id=" + id + ", documentType=" + documentType + ", filePath=" + filePath + ", idIntern=" + idIntern + ", uploadDate=" + uploadDate + '}';
    }
    
    
}
