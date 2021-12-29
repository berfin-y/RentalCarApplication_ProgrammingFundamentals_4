package rental_car_app;

import java.util.Arrays;

import rental_car_app.simulation.Simulation;

public class RentalCarApplication {
    public static void main(String[] args){
        Simulation simulation = new Simulation();
        simulation.simulateRentals();
    }
}
