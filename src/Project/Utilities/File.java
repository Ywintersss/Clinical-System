package Project.Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {
    private static BufferedReader reader;
    private static BufferedWriter writer;
    public static String currentWorkingDirectory() {
        return System.getProperty("user.dir");
    }

    //read txt file
    public static ArrayList<String> readFile(String path) throws IOException {
        if (!path.endsWith(".txt")){
            throw new IllegalArgumentException("Invalid file type");
        }
        path = currentWorkingDirectory() + "\\src\\db\\" + path;
        //initialize an array that stores the data
        ArrayList<String> data = new ArrayList<>();

        //try to open and read the file
        try {
            //create file reader
            reader = new BufferedReader(new FileReader(path));

            String line;
            while ((line = reader.readLine()) != null) {
                //add each line to the array
                data.add(line);
            }

            return data;

        } finally {
            //close the reader
            if (reader != null) {
                reader.close();
            }
        }
    }

    //parse txt file data <T> only accepts String or ArrayList<String>
    public static<T> ArrayList<String[]> parseData(T data) {
        //initialize an array that stores the data
        ArrayList<String[]> parsedData = new ArrayList<>();

        //parsing a list of data
        if (data instanceof ArrayList<?>) {
            for (Object obj : (ArrayList<?>) data) {
                if (obj instanceof String) {
                    String[] array = ((String) obj).split(",");
                    parsedData.add(array);
                }
            }
            //parsing single line data
        } else if (data instanceof String str) {
            String[] array = str.split(",");
            parsedData.add(array);
        } else {
            throw new IllegalArgumentException("Invalid data type");
        }


        return parsedData;
    }

    //write to txt file
    public static void writeToFile(String path, String data) throws IOException {
        path = currentWorkingDirectory() + "\\src\\db\\" + path;
        try {
            writer = new BufferedWriter(new FileWriter(path, true));

            writer.newLine();
            writer.write(data);

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    public static String formatData(String ...dataArray) {
        StringBuilder formattedString = new StringBuilder();

        // Loop through the data array
        for (int i = 0; i < dataArray.length; i++) {
            formattedString.append(dataArray[i]);

            // Add comma if it's not the last element
            if (i < dataArray.length - 1) {
                formattedString.append(",");
            }
        }

        return formattedString.toString();
    }


    //update txt file
    public static void updateFile(String path, String data) throws IOException {

    }

    //testing
    public static void main(String[] args) {
        try {
            ArrayList<String> data = readFile("Doctors.txt");
            ArrayList<String[]> parsedData = parseData(data);
            System.out.println(parsedData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
