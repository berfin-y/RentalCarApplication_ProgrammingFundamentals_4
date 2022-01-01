package rental_car_app.customer.individual;

import rental_car_app.customer.CustomerId;
import rental_car_app.customer_id_exception.CustomerIdException;

public class Member  extends Individual {

    private CustomerId<String> id;
    
    //constructors
    public Member(){
        this(new CustomerId<String>("M0000000000"),0,"",0,0.0,0.1);
    }

    public Member(CustomerId<String> id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice,double discount){
        super(numberOfDays, carModel, carModelYear, modelBasePrice,discount);
        this.id = id;
    }
    public Member(Member member){
        this(member.id,member.getNumberOfDays(),member.getCarModel(), member.getCarModelYear(), member.getModelBasePrice(),member.getDiscount());
    }

    public Member(String[] info){
        this(new CustomerId<String>(info[0]), Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]),0.1);
    }

    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
        	Member otherMembership = (Member) other;
            return (this.getNumberOfDays() == otherMembership.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherMembership.getCarModel()))  &&
                    (this.getCarModelYear() == otherMembership.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherMembership.getModelBasePrice());
        }
    }
    
    public String toString() {
        return this.id.toString() + "     " + super.toString();
    }

    public String getId(){
        return this.id.getId();
    }

    //checkId method is overridden for individual members
    public boolean checkId() {

        try{
            if (this.getId().length() != 12){
                throw new CustomerIdException();
            }
            return true;
        }catch (CustomerIdException e){
            return false;
        }
    }
    

}