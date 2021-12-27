package rental_car_app.customer.commercial;

import rental_car_app.customer.CustomerId;
import rental_car_app.customer_id_exception.CustomerIdException;

public class Platinum extends Commercial{

    public Platinum(){
        this(new CustomerId<String>("P0000000"), 0, "", 0,0);
        super.setDiscount(0.25);
    }

    public Platinum(CustomerId<String> id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(id, numberOfDays, carModel, carModelYear, modelBasePrice);
    }
    public Platinum(Platinum platinum){
        this(new CustomerId<String>(platinum.getId()), platinum.getNumberOfDays(), platinum.getCarModel(), platinum.getCarModelYear(), platinum.getModelBasePrice());
    }

    public Platinum(String[] info){
        this(new CustomerId<String>(info[0]), Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]));
    }
    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
            Platinum otherPlatinum = (Platinum) other;
            return (this.getId().equals(otherPlatinum.getId())) &&
                    (this.getNumberOfDays() == otherPlatinum.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherPlatinum.getCarModel())) &&
                    (this.getCarModelYear() == otherPlatinum.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherPlatinum.getModelBasePrice());
        }
    }
    public String toString(){
        return super.toString();
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public boolean checkId() {
        try{
            if (false){ //exception fırlatması gereken durum
                throw new CustomerIdException();
            }
            return true;
        }catch (CustomerIdException e){
            return false;
        }

    }
}
