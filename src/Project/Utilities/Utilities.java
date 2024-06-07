package Project.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class Utilities {
    private static final DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");

    //txt file last ID +1
    public static String generateID(String objPath) {
        String ID;
        try {
            ArrayList<String> data = File.readFile(objPath);
            ArrayList<String[]> parsedData = File.parseData(data);
            ArrayList<Integer> IDList = new ArrayList<>();
            int IDIndex = 1;
            for (String[] dataArray : parsedData) {
                ID = dataArray[0];
                IDList.add(Integer.parseInt(ID.substring(2)));
            }

            IDList.sort(Integer::compareTo);

            for (Integer i : IDList) {
                if (i != IDIndex) {
                    break;
                }
                IDIndex++;
            }
            return "ID" + IDIndex;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCurrentDate() {
        LocalDate now = LocalDate.now();
        return now.format(formatterDate);
    }

    public static String getCurrentDate(int offset) {
        LocalDate now = LocalDate.now();
        return now.plusDays(offset).format(formatterDate);
    }

    public static String getCurrentTime() {
        LocalTime now = LocalTime.now();
        return now.format(formatterTime);
    }

    public static void main(String[] args) {
        System.out.println(generateID("\\users\\Patient.txt"));
        System.out.println(getCurrentDate());
        System.out.println(getCurrentDate(1));
        System.out.println(getCurrentTime());
    }
}
