package businesslogic;

import dataaccess.DocumentDAO;
import domain.Document;
import utilities.DataValidator;

public class DocumentLB {
    private final DocumentDAO dao;
    private Document document;
        
    public DocumentLB() {
        document = null;
        dao = new DocumentDAO();
    }

    public int setDocument(Document document) {
        int aux = 0;
        if(DataValidator.isValid(document)){
            this.document = document;
            aux = 1;
        }
        return aux;
    }
    
    public Document getDocument() {
        return document;
    }
    
    public int saveNewDocument(){
        return dao.insertDocument(document);
    }
   
    public int readDocument(int idDocument){
        int aux = 0;
        Document documentAux;
        documentAux = dao.getDocument(idDocument);
        if(documentAux != null){
           this.document = documentAux;
           aux = 1;
        }
        return aux;
    }
    
    public int updateDocument(){
        return dao.updateDocument(document);
    }
    
    public int deleteDocument(){
        return dao.deleteDocument(document.getIdDocument());
    }
}
