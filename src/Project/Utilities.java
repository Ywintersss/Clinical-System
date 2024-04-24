package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {
    private static BufferedReader reader;

    public static String generateID() {
        //txt file last ID +1
        return null;
    }

    public static String currentWorkingDirectory() {
        return System.getProperty("user.dir");
    }

    //read txt file
    public static String readFile(String path) throws IOException {
        reader = new BufferedReader(new FileReader(path));
        return null;
    }

}
