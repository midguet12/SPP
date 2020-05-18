package businesslogic;

import dataaccess.ReportDAO;
import domain.Report;
import utilities.DataValidator;

public class ReportLogic {
    private final ReportDAO dao;
    private Report report;
        
    public ReportLogic() {
        report = null;
        dao = new ReportDAO();
    }

    public int setReport(Report report) {
        int aux = 0;
        if(DataValidator.isValid(report)){
            this.report = report;
            aux = 1;
        }
        return aux;
    }
    
    public Report getReport() {
        return report;
    }
    
    public int saveNewReport(){
        return dao.insertReport(report);
    }
   
    public int readReport(int idReport){
        int aux = 0;
        Report reportAux;
        reportAux = dao.getReport(idReport);
        if(reportAux != null){
           this.report = reportAux;
           aux = 1;
        }
        return aux;
    }
    
    public int updateReport(){
        return dao.updateReport(report);
    }
    
    public int deleteReport(){
        return dao.deleteReport(report.getId());
    }
}
