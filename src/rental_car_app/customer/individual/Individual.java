package rental_car_app.customer.individual;

import rental_car_app.customer.Customer;


public abstract class Individual extends Customer implements IIndividual {
	
	//constructors
    public Individual(){
        super();
    }
    public Individual(int numberOfDays, String carModel, int carModelYear, double modelBasePrice, double discount){
        super(numberOfDays, carModel, carModelYear, modelBasePrice,discount);
    }
    
    //checks whether the individual customer is a member or not
    public boolean isMember() {
    	if (this instanceof Member) {
    		return true;
    	}
    	return false;
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

    //calculatePrice method is overridden for the individdual customers
    public double calculatePrice() {
        double dailyPrice = getModelBasePrice()*getModelYearRatioMap().get(getCarModelYear());
        double rentalPrice = (dailyPrice*getNumberOfDays())*(1-getDiscount());
        setRentalPrice(rentalPrice);
        return rentalPrice;
    }
    
    public abstract boolean checkId();
}