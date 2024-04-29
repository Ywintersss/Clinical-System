package Project.Utilities;

import java.io.IOException;
import java.util.ArrayList;

public class Utilities {
    private static File fileHandler = new File();
    //txt file last ID +1
    public String generateID(String objPath) {
        String ID;
        try {
            ArrayList<String> data = fileHandler.readFile(objPath);
            ArrayList<String[]> parsedData = fileHandler.parseData(data);
            for (String[] dataArray : parsedData) {
                ID = dataArray[0];
                int IDnumber = Integer.parseInt(ID.substring(2));
                System.out.println(IDnumber);
            }
            return parsedData.get(0)[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Utilities utilities = new Utilities();
        System.out.println(utilities.generateID("src\\db\\Doctors.txt"));
    }
}
