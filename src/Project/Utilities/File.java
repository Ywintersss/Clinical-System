package Project.Utilities;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.util.ArrayList;

public class File {
    private static BufferedReader reader;
    private static BufferedWriter writer;
    public static String currentDbDirectory() {
        return System.getProperty("user.dir") + "\\src\\db";
    }


    /**
     * Returns a list of all text files in the specified directory.
     *
     * @param path The path to the directory. The path should end with "/" and
     *             specify a specific directory in the db directory.
     * @return A list of all text files in the specified directory.
     * @throws IOException If an I/O error occurs while reading the directory.
     */
    //get all txt files
    public static ArrayList<String> getAllDbFilesFromDirectory(String path) throws IOException {
        ArrayList<String> files = new ArrayList<>();

        //initialize path
        Path paths = Paths.get(currentDbDirectory() + path);

        //try to open and read the directory
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(paths)) {
            //iterate through each file
            for (Path entry : stream) {
                String file = entry.toString();
                if (file.endsWith(".txt")){
                    files.add(file.substring(currentDbDirectory().length()));
                }
            }
        }
        return files;
    }


    /**
     * Reads a text file and returns all its contents as a list of strings.
     *
     * @param path The path to the text file. The path should end with ".txt" and
     *             specify a specific directory in the db directory.
     * @return A list of strings containing the contents of the text file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    //read txt file
    public static ArrayList<String> readFile(String path) throws IOException {
        if (!path.endsWith(".txt")){
            throw new IllegalArgumentException("Invalid file type");
        }
        String filePath = currentDbDirectory() + path;
        //initialize an array that stores the data
        ArrayList<String> data = new ArrayList<>();

        //try to open and read the file
        try {
            //create file reader
            reader = new BufferedReader(new FileReader(filePath));

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

    /**
     * A generic method that modifies data read into the appropriate data format.
     *
     * Parses a read text file and returns all its contents as an ArrayList of list of strings.
     *
     * @param data Accepts a list of strings or a single string only.
     *
     * @return ArrayList of list of strings containing the contents of the text file.
     *          (Format: [["data,data,data"], ["data,data,data"], [...]])
     *
     *
     * @throws IllegalArgumentException If an invalid data type is provided.
     */
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

    /**
     * Writes into a text file and appends the given data to the end of the file.
     *
     * @param path The path to the text file. The path should end with ".txt" and
     *             specify a specific directory in the db directory.
     * @param data The data to be written into the text file.
     *             (Format: "data,data,data")
     * @throws IOException If an I/O error occurs while reading the file.
     */
    //write to txt file
    public static void appendToFile(String path, String data) throws IOException {
        if (!path.endsWith(".txt")){
            throw new IllegalArgumentException("Invalid file type");
        }

        String filePath = currentDbDirectory() + path;

        try {
            writer = new BufferedWriter(new FileWriter(filePath,true));
            writer.write(data);
            writer.newLine();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void updateFile(String path, ArrayList<String[]> data) throws IOException {
        if (!path.endsWith(".txt")){
            throw new IllegalArgumentException("Invalid file type");
        }
        String filePath = currentDbDirectory() + path;

        String[] newData = new String[data.size()];

        for (int i = 0; i < data.size(); i++) {
            newData[i] = formatData(data.get(i));
        }


        try {
            writer = new BufferedWriter(new FileWriter(filePath, false));
            for (String i : newData) {
                writer.write(i);
                writer.newLine();
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Reads a text file and returns all its contents as a list of strings.
     *
     * @param dataArray an array of strings containing the data to be written into the text file.
     * @return A concatenated string of the data array.
     *      (Format: "data,data,data")
     * @throws IOException If an I/O error occurs while reading the file.
     */
    //formats a data array into a string with commas between each element
    public static String formatData(String ...dataArray) {
        return String.join(",", dataArray);
    }


    //testing
    public static void main(String[] args) {
        try {
            ArrayList<String> data = readFile("\\users\\Patient.txt");
            ArrayList<String[]> dataArray = parseData(data);
            for (String[] i : dataArray) {
                for (String j : i) {
                    System.out.println(j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
