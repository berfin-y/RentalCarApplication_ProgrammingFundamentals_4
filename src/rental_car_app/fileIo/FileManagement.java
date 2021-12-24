package rental_car_app.fileIo;

import rental_car_app.customer.CustomerId;
import rental_car_app.customer.commercial.ICommercial;
import rental_car_app.customer.individual.IIndividual;
import rental_car_app.customer.individual.Membership;
import rental_car_app.customer_id_exception.CustomerIdException;

import java.util.ArrayList;

public class FileManagement {

    private FileIo fileIo;
    private ArrayList<String> objectsList;
    private ArrayList<IIndividual> individuals;
    private ArrayList<ICommercial> commercials;

    public FileManagement(){
        fileIo = new FileIo();
        objectsList = new ArrayList<>();
        individuals = new ArrayList<>();
        commercials = new ArrayList<>();
    }

    public void createArrayList(){
        fileIo.readFile();
    }

    public void createObject(){
        for (String object: objectsList){
            String[] info = object.split(",");
            decideType(info);
        }
    }

    public void decideType(String[] info) {
        switch (info[0]) {
            case "Individual":
                if (info[1].startsWith("M")) {
                    IIndividual membership = new Membership(info);
                    CustomerId<IIndividual> customerId = new CustomerId<IIndividual>(membership);
                    try {
                        if (customerId.checkCustomerId()) {
                            throw new CustomerIdException();
                        }
                        individuals.add(membership);
                    } catch (CustomerIdException e) {
                        e.printStackTrace();
                    }
                }
            case "Commercial":
                if (info[1].startsWith("P")) {
                    //platinum
                } else if (info[1].startsWith("S")) {
                    //Silver
                } else if (info[1].startsWith("G")) {
                    //Gold
                } else {
                }
        }
    }
}
