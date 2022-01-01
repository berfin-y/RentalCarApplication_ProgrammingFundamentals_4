package rental_car_app.customer.individual;

import rental_car_app.customer.ICustomer;

//the interface that is realized by the Individual class
public interface IIndividual<T> extends ICustomer {

    public T getId();
    
    boolean isMember();
    
    int getRentalCode();

}