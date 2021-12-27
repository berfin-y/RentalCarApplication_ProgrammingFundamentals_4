package rental_car_app.fileIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIo implements Serializable {

    private final String FILE_NAME = "HW4_Rentals.csv";

    public FileIo() { }

    public ArrayList<String> readFile() {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.equals("")) {
                    lines.add(line);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(lines);
    }

}
