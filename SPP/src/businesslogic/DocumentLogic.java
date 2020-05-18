package businesslogic;

import dataaccess.DocumentDAO;
import domain.Document;
import utilities.DataValidator;

public class DocumentLogic {
    private final DocumentDAO dao;
    private Document document;
    private boolean isValid;
        
    public DocumentLogic() {
        document = null;
        dao = new DocumentDAO();
        isValid = false;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
    
    public Document getDocument() {
        return document;
    }

    public void writeNewDocument(){
        dao.insertDocument(document);
    }
   
    public int readDocument(int idDocument){
        int notNullDocument = 1;
        this.document = dao.getDocument(idDocument);
        if(this.document == null){
            notNullDocument = 0;
        }

        return notNullDocument;
    }
    
    public int updateDocument(){
        return dao.updateDocument(document);
    }
    
    public int deleteDocument(){
        return dao.deleteDocument(document.getIdDocument());
    }
    
    public boolean validate(){
        if(DataValidator.isValid(this.document)){
            this.isValid = true;
        }
        return this.isValid;
    }
    public boolean isValid(){
        return this.isValid;
    }
}
