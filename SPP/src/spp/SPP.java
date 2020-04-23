package spp;

import dataaccess.DataBaseConnection;
import domain.Coordinator;


public class SPP {
    public static void main(String[] args) {
        DataBaseConnection dbc = new DataBaseConnection();
        Coordinator coord = dbc.getCoordinator(18012147);
        
        if(coord != null){
            System.out.println(coord.getName());
        }
    }
}
