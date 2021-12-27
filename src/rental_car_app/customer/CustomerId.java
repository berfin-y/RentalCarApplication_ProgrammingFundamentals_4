package rental_car_app.customer;

public class CustomerId<T> {
    T id;

    public CustomerId(){
        this(null);
    }
    public CustomerId(T id){
        this.id = id;
    }

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

    @Override
    public String toString() {
        return " " + id;
    }
}
