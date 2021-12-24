package rental_car_app.customer;

public class CustomerId<T extends ICustomer> {

    private T customerType;

    public CustomerId(T customerType){
        this.customerType = customerType;
    }

    public boolean checkCustomerId(){
        return customerType.checkId();
    }

}
