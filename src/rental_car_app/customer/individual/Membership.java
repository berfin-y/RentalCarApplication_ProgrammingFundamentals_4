package rental_car_app.customer.individual;

import rental_car_app.customer.CustomerId;
import rental_car_app.customer_id_exception.CustomerIdException;

public class Membership  extends Individual {

    private CustomerId<String> id;

    public Membership(){
        this(new CustomerId<String>("M0000000000"),0,"",0,0.0);
    }

    public Membership(CustomerId<String> id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(numberOfDays, carModel, carModelYear, modelBasePrice);
        this.id = id;
    }
    public Membership(Membership membership){
        this(membership.id,membership.getNumberOfDays(),membership.getCarModel(), membership.getCarModelYear(), membership.getModelBasePrice());
    }

    public Membership(String[] info){
        this(new CustomerId<String>(info[0]), Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]));
    }

    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
            Membership otherMembership = (Membership) other;
            return (this.getNumberOfDays() == otherMembership.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherMembership.getCarModel()))  &&
                    (this.getCarModelYear() == otherMembership.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherMembership.getModelBasePrice());
        }
    }
    @Override
    public String toString() {
        return this.id.toString() + "     " + super.toString();
    }

    public String getId(){
        return this.id.getId();
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
