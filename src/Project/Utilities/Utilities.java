package Project.Utilities;

import Project.Users.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class Utilities {
    private static final DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");

    //generate a specific with a prefix ID based on users in the specified file
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
        if (time.equals("null")) {
            return false;
        }

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

    public static boolean isActive(String date, String time) {
        if (date.equals("null") || time.equals("null")) {
            return false;
        }
        if (date.equals(getCurrentDate())) {
            return !hasPassedTime(time);
        } else {
            return !hasPassedDate(date);
        }
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public static boolean isSameObjectInstance(Object obj1, Object obj2) {
        return obj1.getClass().equals(obj2.getClass());
    }
}
