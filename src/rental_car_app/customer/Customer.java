package rental_car_app.customer;

public abstract class Customer implements ICustomer {

    private double modelBasePrice;
    private int carModelYear;
    private int numberOfDays;
    private String carModel;
    private int rentalCode;
    private double discount;
    private double rentalPrice;

    public Customer(){
        this(0,"",0,0.0);
    }

    public Customer(int numberOfDays, String carModel, int carModelYear, double modelBasePrice) {
        this.numberOfDays = numberOfDays;
        this.carModel = carModel;
        this.carModelYear = carModelYear;
        this.modelBasePrice = modelBasePrice;
    }

    public Customer(Customer customer){
        this(customer.numberOfDays,customer.carModel,customer.carModelYear,customer.modelBasePrice);
    }

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


    @Override
    public abstract double calculatePrice();

    @Override
    public abstract boolean checkId();


    public int getRentalCode() {
        return rentalCode;
    }

    public void setRentalCode(int rentalCode) {
        this.rentalCode = rentalCode;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public void setRentalPrice(double rentalPrice) {
    	this.rentalPrice=rentalPrice;
    }
    
    
}