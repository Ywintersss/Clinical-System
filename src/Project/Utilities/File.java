package Project.Utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    //update txt file
    // Takes in String array of the user's updated data.
    public static void updateFile(String path, String[] newData) throws IOException{
        path = currentWorkingDirectory() + "\\src\\db\\" + path;

        try {
            reader = new BufferedReader(new FileReader(path));

            String oldData;
            ArrayList<String[]> DataArray = new ArrayList<>();

            while ((oldData = reader.readLine()) != null) {
                String[] oldDataArray = oldData.split(",");
                DataArray.add(oldDataArray);
                String ID = oldData.split(",")[0];

                //Updating the specific row with the updated data
                if (newData[0].equals(ID)) {
                    int index = Integer.parseInt(ID.substring(2))-1;
                    DataArray.set(index, newData);
                }
            }

            // Writing the updated data back to the file
            writer = new BufferedWriter(new FileWriter(path, false));

            for (String[] i : DataArray) {
                String line = String.join(",", i);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    //testing
    public static void main(String[] args) {
        try {
            ArrayList<String> data = readFile("Doctors.txt");
            ArrayList<String[]> parsedData = parseData(data);
            parsedData.get(0)[1] = "This text is really cringe for some reason";
            updateFile("Doctors.txt", parsedData.get(0));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
