package rental_car_app.customer.commercial;

public class Gold extends Commercial{

    public Gold(){
        this("G0000000",0,"",0,0);
    }

    public Gold(String id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(id, numberOfDays, carModel, carModelYear, modelBasePrice);
        super.setDiscount(0.2);
    }
    public Gold(Gold gold){
        this(gold.getId(), gold.getNumberOfDays(), gold.getCarModel(), gold.getCarModelYear(), gold.getModelBasePrice());
    }

    public Gold(String[] info){
        this(info[0], Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]));
    }
    public boolean equals(Object other){
        if (other == null){
            return false;
        }else if (other.getClass() != this.getClass()){
            return false;
        }else{
            Gold otherGold = (Gold) other;
            return (this.getId().equals(otherGold.getId())) &&
                    (this.getNumberOfDays() == otherGold.getNumberOfDays()) &&
                    (this.getCarModel().equals(otherGold.getCarModel())) &&
                    (this.getCarModelYear() == otherGold.getCarModelYear()) &&
                    (this.getModelBasePrice() == otherGold.getModelBasePrice());
        }
    }

    public String toString(){
        return super.toString();
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
