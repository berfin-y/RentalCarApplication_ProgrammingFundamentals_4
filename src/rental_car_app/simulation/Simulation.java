package rental_car_app.simulation;

import rental_car_app.customer.commercial.ICommercial;
import rental_car_app.customer.individual.IIndividual;
import rental_car_app.fileIo.FileManagement;

import java.util.ArrayList;

public class Simulation {
    private FileManagement fileManagement;
    private ArrayList<ICommercial> commercials;
    private ArrayList<IIndividual> individuals;

    public Simulation(){
        fileManagement = new FileManagement();
        commercials = fileManagement.getCommercials();
        individuals = fileManagement.getIndividuals();
    }

}
