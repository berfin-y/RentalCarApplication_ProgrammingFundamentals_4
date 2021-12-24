package rental_car_app.customer.individual;

import rental_car_app.customer.Customer;

public abstract class Individual extends Customer implements IIndividual {
    public Individual(){
        super();
    }
    public Individual(int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(numberOfDays, carModel, carModelYear, modelBasePrice);
    }
    @Override
    public abstract double calculatePrice();

    @Override
    public abstract boolean checkId();
}
