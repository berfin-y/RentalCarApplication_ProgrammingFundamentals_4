package rental_car_app.customer.individual;

public class Membership  extends Individual {
    private String id;

    public Membership(){
        this("00000000000",0,"",0,0.0);
    }

    public Membership(String id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(numberOfDays, carModel, carModelYear, modelBasePrice);
        this.id = id;
    }
    public Membership(Membership membership){
        this(membership.id,membership.getNumberOfDays(),membership.getCarModel(), membership.getCarModelYear(), membership.getModelBasePrice());
    }

    public Membership(String[] info){
        this(info[0], Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4]));
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
