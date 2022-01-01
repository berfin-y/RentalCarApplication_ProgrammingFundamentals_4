package rental_car_app.customer;

import java.util.HashMap;

public abstract class Customer implements ICustomer {
	
	//the attributes of the rentals are listed below:
    private double modelBasePrice;
    private int carModelYear;
    private int numberOfDays;
    private String carModel;
    private int rentalCode;
    private double discount;
    private double rentalPrice;
    private HashMap<Integer, Double> modelYearRatioMap;
    
    //default constructor
    public Customer(){
        this(0,"",0,0.0,0.0);
    }
    //full arguments constructor
    public Customer(int numberOfDays, String carModel, int carModelYear, double modelBasePrice,double discount) {
        this.numberOfDays = numberOfDays;
        this.carModel = carModel;
        this.carModelYear = carModelYear;
        this.modelBasePrice = modelBasePrice;
        this.discount = discount;
        modelYearRatioMap = new HashMap<Integer, Double>();
        createModelYearRatio();
    }

    public Customer(Customer customer){
        this(customer.numberOfDays,customer.carModel,customer.carModelYear,customer.modelBasePrice,customer.discount);
    }
    
    //start of the getter methods
    public double getModelBasePrice() {
        return modelBasePrice;
    }

    public int getCarModelYear() {
        return carModelYear;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getDiscount() {
        return discount;
    }
    
    public double getRentalPrice() {
    	return rentalPrice;
    }
    
    public int getRentalCode() {
        return rentalCode;
    }
    
    //end of the getter methods and the start of the setter methods:
    public void setRentalCode(int rentalCode) {
        this.rentalCode = rentalCode;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public void setRentalPrice(double rentalPrice) {
    	this.rentalPrice=rentalPrice;
    }
    
    //end of the setter methods
    
    //creates a hashmap for model-year ratio
    public HashMap<Integer, Double> getModelYearRatioMap() {
        return new HashMap<>(modelYearRatioMap);
    }
    //fills the hashmap with given info
    //years are the keys and the ratios are paired with them
    private void createModelYearRatio(){
        modelYearRatioMap.put(2017, 0.9);
        modelYearRatioMap.put(2018, 0.9);
        modelYearRatioMap.put(2019, 0.9);
        modelYearRatioMap.put(2020, 0.95);
        modelYearRatioMap.put(2021, 0.95);
        modelYearRatioMap.put(2022, 1.0);
    }

    public String toString(){
        return getNumberOfDays() + "    " + getCarModel() + "    " + getCarModelYear();
    }
    
    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()) {
            return false;
        }else{
            Customer otherCustomer = (Customer) other;
            return (this.numberOfDays == otherCustomer.numberOfDays) &&
                    (this.carModel.equals(otherCustomer.carModel)) &&
                    (this.carModelYear == otherCustomer.carModelYear) &&
                    (this.modelBasePrice == otherCustomer.modelBasePrice);
        }

    }
    
    //the abstract methods that will be coded in subclasses:
    public abstract double calculatePrice();

    public abstract boolean checkId();
       
}