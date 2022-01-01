package rental_car_app.customer;

//this class is parameterized in order to create objects representing id's both integer and String
public class CustomerId<T> {
	
    T id;
    
    //default constructor
    public CustomerId(){
        this(null);
    }
    //full argument constructor
    public CustomerId(T id){
        this.id = id;
    }
    //getter method
    public T getId(){
        return id;
    }
    
    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (this.getClass() != other.getClass()){
            return false;
        }else{
            CustomerId<T> otherCustomerId = (CustomerId<T>) other;
            return id.equals(otherCustomerId.id);
        }
    }

    public String toString() {
        return " " + id;
    }
}