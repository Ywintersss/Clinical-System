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
    public static String generateID(String prefix, String objPath) {
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
            return prefix + IDIndex;
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

    public static boolean hasPassedDate(String date) {
        return LocalDate.now().isAfter(LocalDate.parse(date, formatterDate));
    }

    public static boolean hasPassedTime(String time) {
        StringBuilder timeBuilder = new StringBuilder(time);
        for (int i = 2; i < time.length(); i+=3) {
            char c = time.charAt(i);
            if (c != ':') {
                timeBuilder.insert(i, ":");
            }
        }
        int length;
        while ((length = timeBuilder.length()) < 8) {
            if (length % 3 == 2){
                timeBuilder.append(':');
            }
            timeBuilder.append('0');
        }
        String newTime = timeBuilder.toString();
        //returns true if the current time is after the given time
        return LocalTime.now().isAfter(LocalTime.parse(newTime, formatterTime));
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
    public static void main(String[] args) {
        System.out.println(generateID("PA","\\users\\Patient.txt"));
        System.out.println(getCurrentDate());
        System.out.println(getCurrentDate(1));
        System.out.println(getCurrentTime());
        System.out.println(hasPassedTime("2200"));
    }
}
