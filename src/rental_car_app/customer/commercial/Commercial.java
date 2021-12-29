package rental_car_app.customer.commercial;

import rental_car_app.customer.Customer;
import rental_car_app.customer.CustomerId;

public abstract class Commercial extends Customer implements ICommercial{

    private CustomerId<String> id;

    public Commercial(){
        this(new CustomerId<String>(),0,"",0,0.0);
    }

    public Commercial(CustomerId<String> id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(numberOfDays,carModel,carModelYear,modelBasePrice);
        this.id = id;
    }

    public Commercial(Commercial commercial){
        this(commercial.id,commercial.getNumberOfDays(),commercial.getCarModel(),commercial.getCarModelYear(),commercial.getModelBasePrice());
    }

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

    @Override
    public abstract double calculatePrice();

    @Override
    public abstract boolean checkId();
}