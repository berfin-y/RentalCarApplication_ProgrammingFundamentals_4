package rental_car_app.customer.individual;

public class Member extends Individual {
    private int id;

    public Member(){
        this(00000000000,0,"",0,0.0);
    }

    public Member(int id, int numberOfDays, String carModel, int carModelYear, double modelBasePrice){
        super(numberOfDays, carModel, carModelYear, modelBasePrice);
        this.id = id;
    }
    public Member(Member member){
        this(member.id,member.getNumberOfDays(),member.getCarModel(), member.getCarModelYear(), member.getModelBasePrice());
    }

    public Member(String[] info){
        this(Integer.parseInt(info[0]), Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4]));
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
