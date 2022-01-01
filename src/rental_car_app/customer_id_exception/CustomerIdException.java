package rental_car_app.customer_id_exception;

//this subclass of Exception handles the Customer ID exceptions
public class CustomerIdException extends Exception{

    public CustomerIdException(){
        super("Customer Id does not match the type");
    }
    public CustomerIdException(String message) {
        super(message);
    }
}