
package utils;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataDriven {

    // Method to read JSON file from project root
    public static JSONObject jsonReader(String filePath) {
        JSONParser parser = new JSONParser();
        JSONObject data = null;

        try {
            // Correct path: starts from project root, not src
            FileReader reader = new FileReader(filePath);
            data = (JSONObject) parser.parse(reader);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}