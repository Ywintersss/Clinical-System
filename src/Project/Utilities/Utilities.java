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
            ArrayList<Integer> IDList = new ArrayList<>();
            int IDIndex = 1;
            for (String[] dataArray : parsedData) {
                if (dataArray.length == 1) {
                    break;
                }
                ID = dataArray[0];
                IDList.add(Integer.parseInt(ID.substring(2)));
            }
            for (Integer i : IDList) {
                IDIndex++;
            }
            return "ID" + IDIndex;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(generateID("\\users\\Patient.txt"));
    }
}
