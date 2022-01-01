package rental_car_app.customer;

//the interface that realized by Customer class
public interface ICustomer {
	
    double calculatePrice();

    boolean checkId();
    
    int getNumberOfDays();
        
    int getRentalCode();
    
    String getCarModel();
    
    int getCarModelYear();
    
    double getRentalPrice();
    
    void setRentalCode(int rentalCode);
    
}