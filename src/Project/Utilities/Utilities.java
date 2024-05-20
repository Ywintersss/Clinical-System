package Project.Utilities;

import java.io.IOException;
import java.util.ArrayList;

public class Utilities {
    //txt file last ID +1
    public static String generateID(String objPath) {
        String ID;
        try {
            ArrayList<String> data = File.readFile(objPath);
            ArrayList<String[]> parsedData = File.parseData(data);
            int IDIndex = 1;
            for (String[] dataArray : parsedData) {
                ID = dataArray[0];
                int IDnumber = Integer.parseInt(ID.substring(2));
                if (IDnumber != IDIndex) {
                    return "ID" + IDIndex;
                }
                IDIndex++;
            }
            return "ID" + IDIndex;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(generateID("src\\db\\Doctors.txt"));
    }
}
