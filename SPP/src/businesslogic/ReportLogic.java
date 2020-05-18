package businesslogic;

import dataaccess.ReportDAO;
import domain.Report;
import utilities.DataValidator;

public class ReportLogic {
    private final ReportDAO dao;
    private Report report;
    private boolean isValid;
        
    public ReportLogic() {
        report = null;
        dao = new ReportDAO();
        isValid = false;
    }

    public void setReport(Report report) {
        this.report = report;
    }
    
    public Report getReport() {
        return report;
    }

    public void writeNewReport(){
        dao.insertReport(report);
    }
   
    public int readReport(int idReport){
        int notNullReport = 1;
        this.report = dao.getReport(idReport);
        if(this.report == null){
            notNullReport = 0;
        }

        return notNullReport;
    }
    
    public int updateReport(){
        return dao.updateReport(report);
    }
    
    public int deleteReport(){
        return dao.deleteReport(report.getId());
    }
        
    public void addIntern(String idIntern){
        this.report.setIdIntern(idIntern);
    }
    
    public boolean validate(){
        if(DataValidator.isValid(this.report)){
            this.isValid = true;
        }
        return this.isValid;
    }
    public boolean isValid(){
        return this.isValid;
    }
}
