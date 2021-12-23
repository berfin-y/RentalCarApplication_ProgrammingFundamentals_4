package rental_car_app.customer.commercial;

public class Silver extends Commercial{

    public Silver(){
        this("S0000000", 0, "", 0,0);
        super.setDiscount(0.3);
    }

    public Silver(String id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(id, numberOfDays, carModel, carModelYear, modelBasePrice);
    }
    public Silver(Silver silver){
        this(silver.getId(), silver.getNumberOfDays(), silver.getCarModel(), silver.getCarModelYear(), silver.getModelBasePrice());
    }

    public Silver(String[] info){
        this(info[0], Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]));
    }
    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
            Silver otherSilver = (Silver) other;
            return (this.getId().equals(otherSilver.getId())) &&
                    (this.getNumberOfDays() == otherSilver.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherSilver.getCarModel())) &&
                    (this.getCarModelYear() == otherSilver.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherSilver.getModelBasePrice());
        }
    }


    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public boolean checkId() {
        return false;
    }
}
