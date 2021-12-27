package rental_car_app.customer.individual;

import rental_car_app.customer.CustomerId;
import rental_car_app.customer_id_exception.CustomerIdException;

public class Member extends Individual {
    private CustomerId<Long> id;

    public Member(){
        this(new CustomerId<Long>(00000000000L),0,"",0,0.0);
    }

    public Member(CustomerId<Long> id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(numberOfDays, carModel, carModelYear, modelBasePrice);
        this.id = id;
    }
    public Member(Member member){
        this(member.id,member.getNumberOfDays(),member.getCarModel(), member.getCarModelYear(), member.getModelBasePrice());
    }

    public Member(String[] info){
        this(new CustomerId<Long>(Long.parseLong(info[0])), Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]));
    }

    public Long getId(){
        return this.id.getId();
    }

    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
            Member otherMember = (Member) other;
            return (this.getNumberOfDays() == otherMember.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherMember.getCarModel()))  &&
                    (this.getCarModelYear() == otherMember.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherMember.getModelBasePrice());
        }
    }

    @Override
    public String toString() {
        return this.id.toString() + "     " + super.toString();
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
