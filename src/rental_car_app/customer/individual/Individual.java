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
    
    public boolean isMember() {
    	if (this instanceof Member) {
    		return true;
    	}
    	return false;
    }

    @Override
    public double calculatePrice() {
        double modelYearRatio = 0;
        if (getCarModelYear()>2021) {
        	modelYearRatio = 1;
        }
        else if (getCarModelYear()>=2020 && getCarModelYear()<=2021) {
        	modelYearRatio = 0.95;
        }
        else {
        	modelYearRatio = 0.9;
        }
        double dailyPrice = getModelBasePrice()*modelYearRatio;
        double rentalPrice = (dailyPrice*getNumberOfDays())*(1-getDiscount());
        setRentalPrice(rentalPrice);
        return rentalPrice;
    }
    @Override
    public abstract boolean checkId();
}