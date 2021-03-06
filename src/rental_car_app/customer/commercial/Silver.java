package rental_car_app.customer.commercial;

import rental_car_app.customer.CustomerId;
import rental_car_app.customer_id_exception.CustomerIdException;

public class Silver extends Commercial{
	
	//constructors
    public Silver(){
        this(new CustomerId<String>("S0000000"), 0, "", 0,0,0.2);
    }

    public Silver(CustomerId<String> id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice, double discount){
        super(id, numberOfDays, carModel, carModelYear, modelBasePrice,discount);
    }
    public Silver(Silver silver){
        this(new CustomerId<String>(silver.getId()), silver.getNumberOfDays(), silver.getCarModel(), 
        		silver.getCarModelYear(), silver.getModelBasePrice(),silver.getDiscount());
    }

    public Silver(String[] info){
        this(new CustomerId<String>(info[0]), Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]),0.2);
    }
    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
            Silver otherSilver = (Silver) other;
            return (this.getId().equals(otherSilver.getId())) &&
                    (this.getNumberOfDays() == otherSilver.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherSilver.getCarModel())) &&
                    (this.getCarModelYear() == otherSilver.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherSilver.getModelBasePrice());
        }
    }

    public String toString(){
        return super.toString();
    }

    //checkId method is overridden for Silver type of commercial customers
    public boolean checkId() {

        try{
            if (this.getId().length() != 8){
                throw new CustomerIdException();
            }
            return true;
        }catch (CustomerIdException e){
            return false;
        }
    }
    
}