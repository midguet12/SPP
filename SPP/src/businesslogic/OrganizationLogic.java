package businesslogic;

import dataaccess.OrganizationDAO;
import domain.Organization;
import utilities.DataValidator;

public class OrganizationLogic {
    private final OrganizationDAO dao;
    private Organization organization;
    private boolean isValid;
        
    public OrganizationLogic() {
        organization = null;
        dao = new OrganizationDAO();
        isValid = false;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    
    public Organization getOrganization() {
        return organization;
    }

    public void writeNewOrganization(){
        dao.insertOrganization(organization);
    }
   
    public int readOrganization(int idOrganization){
        int notNullOrganization = 1;
        this.organization = dao.getOrganization(idOrganization);
        if(this.organization == null){
            notNullOrganization = 0;
        }

        return notNullOrganization;
    }
    
    public int updateOrganization(){
        return dao.updateOrganization(organization);
    }
    
    public int deleteOrganization(){
        return dao.deleteOrganization(organization.getId());
    }
    
    public boolean validate(){
        if(DataValidator.isValid(this.organization)){
            this.isValid = true;
        }
        return this.isValid;
    }
    public boolean isValid(){
        return this.isValid;
    }
}
