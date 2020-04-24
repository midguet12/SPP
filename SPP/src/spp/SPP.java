package spp;

import dataaccess.CoordinatorDAO;
import domain.Coordinator;

public class SPP {
    public static void main(String[] args) {
        CoordinatorDAO coorDAO = new CoordinatorDAO();
        
        Coordinator coord = new Coordinator(18012148, "Esteban", "Quito", "");
        System.out.println(coord);
        coorDAO.insertCoordinator(coord);
        
//        coord = coorDAO.getCoordinator(18012147);
//        if(coord != null){
//            System.out.println(coord);
//        }
    }
}
