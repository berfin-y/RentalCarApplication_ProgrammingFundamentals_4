package rental_car_app.customer.individual;

import rental_car_app.customer.CustomerId;
import rental_car_app.customer_id_exception.CustomerIdException;

public class NonMember extends Individual {
    private CustomerId<Long> id;
    
    //constructors
    public NonMember(){
        this(new CustomerId<Long>(00000000000L),0,"",0,0.0,0.0);
    }

    public NonMember(CustomerId<Long> id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice, double discount){
        super(numberOfDays, carModel, carModelYear, modelBasePrice,discount);
        this.id = id;
    }
    public NonMember(NonMember nonMember){
        this(nonMember.id,nonMember.getNumberOfDays(),nonMember.getCarModel(), nonMember.getCarModelYear(), nonMember.getModelBasePrice(),nonMember.getDiscount());
    }

    public NonMember(String[] info){
        this(new CustomerId<Long>(Long.parseLong(info[0])), Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]),0.0);
    }
    
    //getter method
    public Long getId(){
        return this.id.getId();
    }

    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
        	NonMember otherMember = (NonMember) other;
            return (this.getNumberOfDays() == otherMember.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherMember.getCarModel()))  &&
                    (this.getCarModelYear() == otherMember.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherMember.getModelBasePrice());
        }
    }

    public String toString() {
        return this.id.toString() + "     " + super.toString();
    }

    //checkId method is overridden for individual non-member customers
    public boolean checkId() {
        try{
            if (this.getId().toString().length() != 11){
                throw new CustomerIdException();
            }
            return true;
        }catch (CustomerIdException e){
            return false;
        }
    }
    
}