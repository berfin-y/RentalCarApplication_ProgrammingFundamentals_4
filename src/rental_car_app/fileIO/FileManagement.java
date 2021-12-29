package rental_car_app.fileIO;

import rental_car_app.customer.commercial.Gold;
import rental_car_app.customer.commercial.ICommercial;
import rental_car_app.customer.commercial.Platinum;
import rental_car_app.customer.commercial.Silver;
import rental_car_app.customer.individual.IIndividual;
import rental_car_app.customer.individual.Individual;
import rental_car_app.customer.individual.Member;
import rental_car_app.customer.individual.NonMember;

import java.util.ArrayList;

public class FileManagement {

    private FileIO fileIo;
    private ArrayList<String> objectsList;
    private ArrayList<IIndividual> individuals;
    private ArrayList<ICommercial> commercials;

    public FileManagement(){
        fileIo = new FileIO();
        individuals = new ArrayList<>();
        commercials = new ArrayList<>();
        createCommercialAndIndividualLists();
    }

    private void getLinesListFromFileIo(){
        ArrayList<String> lineList = fileIo.readFile();
        objectsList = new ArrayList<>(lineList);
    }

    private void createObject(){
        for (String object: objectsList){
            String[] info = object.split(",");
            decideType(info);
        }
    }

    private void decideType(String[] info) {
        switch (info[0]) {
            case "Individual":
                if (info[1].startsWith("M")) {
                    IIndividual membership = new Member(new String[] {info[1], info[2], info[3], info[4], info[5]});
                    if (membership.checkId()){
                        individuals.add(membership);
                    }
                }
                else{
                    Individual member = new NonMember(new String[] {info[1], info[2], info[3], info[4], info[5]});
                    if (member.checkId()){
                        individuals.add(member);
                    }
                }
            case "Commercial":
                if (info[1].startsWith("P")) { //platinum
                    ICommercial platinum = new Platinum(new String[] {info[1], info[2], info[3], info[4], info[5]});
                    if (platinum.checkId()){
                        commercials.add(platinum);
                    }
                } else if (info[1].startsWith("S")) { //silver
                    ICommercial silver = new Silver(new String[] {info[1], info[2], info[3], info[4], info[5]});
                    if (silver.checkId()){
                        commercials.add(silver);
                    }
                } else if (info[1].startsWith("G")) { //gold
                    ICommercial gold = new Gold(new String[] {info[1], info[2], info[3], info[4], info[5]});
                    if (gold.checkId()){
                        commercials.add(gold);
                    }
                }
        }
    }

    private void createCommercialAndIndividualLists(){
        getLinesListFromFileIo();
        createObject();
    }

    public ArrayList<ICommercial> getCommercials() {
        return new ArrayList<ICommercial>(commercials);
    }

    public ArrayList<IIndividual> getIndividuals() {
        return new ArrayList<IIndividual>(individuals);
    }

}