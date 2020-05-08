package businesslogic;

import dataaccess.OrganizationDAO;
import domain.Organization;
import utilities.DataValidator;

public class OrganizationLB {
    private final OrganizationDAO dao;
    private Organization organization;
        
    public OrganizationLB() {
        organization = null;
        dao = new OrganizationDAO();
    }

    public int setOrganization(Organization organization) {
        int aux = 0;
        if(DataValidator.isValid(organization)){
            this.organization = organization;
            aux = 1;
        }
        return aux;
    }
    
    public Organization getOrganization() {
        return organization;
    }
    
    public int saveNewOrganization(){
        return dao.insertOrganization(organization);
    }
   
    public int readOrganization(int idOrganization){
        int aux = 0;
        Organization organizationAux;
        organizationAux = dao.getOrganization(idOrganization);
        if(organizationAux != null){
           this.organization = organizationAux;
           aux = 1;
        }
        return aux;
    }
    
    public int updateOrganization(){
        return dao.updateOrganization(organization);
    }
    
    public int deleteOrganization(){
        return dao.deleteOrganization(organization.getId());
    }
}
