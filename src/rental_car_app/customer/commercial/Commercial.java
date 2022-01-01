package rental_car_app.customer.commercial;

import rental_car_app.customer.Customer;
import rental_car_app.customer.CustomerId;

public abstract class Commercial extends Customer implements ICommercial{

    private CustomerId<String> id;
    
    //default constructor, discount is set as 0%
    public Commercial(){
        this(new CustomerId<String>(),0,"",0,0.0,0.0);
    }

    public Commercial(CustomerId<String> id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice, double discount){
        super(numberOfDays,carModel,carModelYear,modelBasePrice,discount);
        this.id = id;
    }

    public Commercial(Commercial commercial){
        this(commercial.id,commercial.getNumberOfDays(),commercial.getCarModel(),
        		commercial.getCarModelYear(),commercial.getModelBasePrice(),commercial.getDiscount());
    }
    
    //getter method
    public String getId(){
        return this.id.getId();
    }

    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
            Commercial otherCommercial = (Commercial) other;
            return (this.id.equals(otherCommercial.id)) &&
                    (this.getNumberOfDays() == otherCommercial.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherCommercial.getCarModel()))  &&
                    (this.getCarModelYear() == otherCommercial.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherCommercial.getModelBasePrice());
        }
    }

    public String toString(){
        return this.id.toString() + "     " + super.toString();
    }
    
    //calculate price is overridden for commercial rentals
    public double calculatePrice() {
    	//daily price is evaluated
        double dailyPrice = getModelBasePrice()* getModelYearRatioMap().get(getCarModelYear());
        //rental price is evaluated
        double rentalPrice = (dailyPrice*getNumberOfDays()*30)*(1-getDiscount());
        //rental price is set
        setRentalPrice(rentalPrice);
        return rentalPrice;
    }
    
    public abstract boolean checkId();
}