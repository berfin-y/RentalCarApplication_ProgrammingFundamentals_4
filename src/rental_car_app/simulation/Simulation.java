package rental_car_app.simulation;

import rental_car_app.customer.ICustomer;
import rental_car_app.customer.commercial.Commercial;
import rental_car_app.customer.commercial.Gold;
import rental_car_app.customer.commercial.ICommercial;
import rental_car_app.customer.commercial.Platinum;
import rental_car_app.customer.commercial.Silver;
import rental_car_app.customer.individual.IIndividual;
import rental_car_app.fileIO.FileManagement;

import java.util.ArrayList;

public class Simulation {
    private FileManagement fileManagement;
    private ArrayList<ICommercial> commercials;
    private ArrayList<IIndividual> individuals;
    private ArrayList<Integer> rentalCodes;

    public Simulation(){
        fileManagement = new FileManagement();
        commercials = fileManagement.getCommercials();
        individuals = fileManagement.getIndividuals();
        rentalCodes = new ArrayList<Integer>();
    }
    
    public void simulateRentals() {
    	printStatistics();
    	generateRentalCodes();
    	calculateRentalPrices();
    	printIndividualRentals();
    	printCommercialRentals();
    }
    
    public void calculateRentalPrices() {
    	for (IIndividual individual:individuals) {
    		individual.calculatePrice();
    	}
    	for (ICommercial commercial:commercials) {
    		commercial.calculatePrice();
    	}
    }
    
    private void generateRentalCodes() {
    	rentalCodes.add(1000000);//0--nonmember
    	rentalCodes.add(2000000);//1--member
    	rentalCodes.add(3000000);//2-silver
    	rentalCodes.add(4000000);//3--gold
    	rentalCodes.add(5000000);//4--platinum
    	
    	for (IIndividual individual:individuals ) {
    		if (individual.isMember()) {
    			rentalCodes.set(1, rentalCodes.get(1)+1);
    			individual.setRentalCode(rentalCodes.get(1));
    		}
    		else {
    			rentalCodes.set(0, rentalCodes.get(0)+1);
    			individual.setRentalCode(rentalCodes.get(0));
    		}
    	}
    	
    	for (ICommercial commercial:commercials) {
    		if (commercial instanceof Silver) {
    			rentalCodes.set(2, rentalCodes.get(2)+1);
    			commercial.setRentalCode(rentalCodes.get(2));
    		}
    		else if (commercial instanceof Gold) {
    			rentalCodes.set(3, rentalCodes.get(3)+1);
    			commercial.setRentalCode(rentalCodes.get(3));
    		}
    		else if (commercial instanceof Platinum) {
    			rentalCodes.set(4, rentalCodes.get(4)+1);
    			commercial.setRentalCode(rentalCodes.get(4));
    		}
    	}
	}

	private void printStatistics() {
    	System.out.println("Welcome!");
    	int totalNumberOfCars = commercials.size()+individuals.size();
    	System.out.println("Total number of cars rented: "+totalNumberOfCars);
    	System.out.println("Total number of commercial rentals: "+commercials.size());
    	System.out.println("Total number of commercial rental-month: "+calculateCommercialRentalMonth());
    	System.out.println("Total number of individual rentals: "+individuals.size());
    	System.out.println("Total number of individual rental-day: "+calculateIndividualRentalDay());
    	int numOfNonmembers = individuals.size()-calculateIndividualMembers();
    	System.out.println("Total number of rentals of individual non-member customers: "+numOfNonmembers);
    	System.out.println("Total number of rentals of individual member customers: "+calculateIndividualMembers());
    	System.out.println("Total number of rentals of silver commercial customers: "+calculateCommercialMembers("S",commercials));
    	System.out.println("Total number of rentals of gold commercial customers: "+calculateCommercialMembers("G",commercials));
    	System.out.println("Total number of rentals of platinum commercial customers: "+calculateCommercialMembers("P",commercials));
    }
    
    private int calculateCommercialRentalMonth() {
    	int commercialRentalMonth = 0;
    	for(ICommercial i: commercials) {
    		commercialRentalMonth+=i.getNumberOfDays();
    	}
    	return commercialRentalMonth;
    }
    
    private int calculateIndividualRentalDay() {
    	int individualRentalDay = 0;
    	for(IIndividual i: individuals) {
    		individualRentalDay+=i.getNumberOfDays();
    	}
    	return individualRentalDay;
    }
    
    private int calculateIndividualMembers() {
    	int numOfMembers = 0;
    	for (IIndividual i:individuals) {
    		if (i.getId().toString().startsWith("M")) {
    			numOfMembers++;
    		}
    	}
    	return numOfMembers;
    }
    
    private int calculateCommercialMembers(String s, ArrayList<ICommercial> commercials) {
    	int numOfMembers = 0;
    	for(ICommercial i: commercials) {
    		if(i.getId().toString().startsWith(s)) {
    			numOfMembers++;
    		}
    	}
    	return numOfMembers;
    }
    
    private void printIndividualRentals() {
    	System.out.println("Individual Rentals:");
    	System.out.printf("%-5s%-15s%-15s%-18s%-18s%-22s%-15s%-18s\n","No","Rental Code",
							"Customer ID","isMember","Number of Days","Car Model","Model Year","Rental Price");    	
    	for(int i=0;i<individuals.size();i++) {
    		String memberStatus = "No";
    		if (individuals.get(i).isMember()) {
    			memberStatus="Yes";
    		}
    		System.out.printf("%-5s%-15s%-15s%-18s%-18s%-22s%-15s%-18s\n",(i+1),individuals.get(i).getRentalCode(),
    				individuals.get(i).getId(),memberStatus,individuals.get(i).getNumberOfDays(),individuals.get(i).getCarModel(),
    				individuals.get(i).getCarModelYear(),individuals.get(i).getRentalPrice());
    	}
    }
    
    private void printCommercialRentals() {
    	System.out.println("Commercial Rentals:");
    	System.out.printf("%-5s%-15s%-15s%-18s%-18s%-22s%-15s%-18s\n","No","Rental Code",
				"Customer ID","Customer Type","Number of Months","Car Model","Model Year","Rental Price");
    	int i = 0;
    	for(ICommercial commercial:commercials) {
    		String customerType = "";
    		if (commercial instanceof Silver) {
    			customerType = "Silver";
    		}
    		else if (commercial instanceof Gold) {
    			customerType = "Gold";
    		}
    		else if (commercial instanceof Platinum) {
    			customerType = "Platinum";
    		}
    		System.out.printf("%-5s%-15s%-15s%-18s%-18s%-22s%-15s%-18s\n",(i+1),commercials.get(i).getRentalCode(),
    				commercials.get(i).getId(),customerType,commercials.get(i).getNumberOfDays(),commercials.get(i).getCarModel(),
    				commercials.get(i).getCarModelYear(),commercials.get(i).getRentalPrice());
    		i++;
    	}
    }

}
