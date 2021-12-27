package rental_car_app.customer.individual;

import rental_car_app.customer.ICustomer;

public interface IIndividual<T> extends ICustomer {

    public T getId();

}
