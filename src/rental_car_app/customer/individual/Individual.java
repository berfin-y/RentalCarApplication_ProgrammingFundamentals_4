package rental_car_app.customer.individual;

import rental_car_app.customer.Customer;


public abstract class Individual extends Customer implements IIndividual {
    public Individual(){
        super();
    }
    public Individual(int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(numberOfDays, carModel, carModelYear, modelBasePrice);
    }

    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
            Individual otherIndividual = (Individual) other;
            return (this.getNumberOfDays() == otherIndividual.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherIndividual.getCarModel()))  &&
                    (this.getCarModelYear() == otherIndividual.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherIndividual.getModelBasePrice());
        }
    }

    public String toString(){
        return super.toString();
    }

    @Override
    public abstract double calculatePrice();

    @Override
    public abstract boolean checkId();
}
