/** This class has the main method of the Rent-a-car Application.
 * It calls Simulation class to start the app.
 *
 * @author Merve Malak     260201043
 * @author Berfin Yucak    280201096
 */

package rental_car_app;

import rental_car_app.simulation.Simulation;

public class RentalCarApplication {
    public static void main(String[] args){
        Simulation simulation = new Simulation();
        simulation.simulateRentals();
    }
}
