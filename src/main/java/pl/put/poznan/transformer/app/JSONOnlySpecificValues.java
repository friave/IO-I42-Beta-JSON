package pl.put.poznan.transformer.app;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JSONOnlySpecificValues {

    private JSONBase base;

    public String specify(String json, ArrayList<String> keys) {
        try {

            base = new JSONBase(json);
            JSONObject jsonDoc = (JSONObject) JSONValue.parse(base.getJSON());

            Set<String> specified = new HashSet<String>(keys);
            Set<String> jsonKeys = new HashSet<String>(jsonDoc.keySet());

            for( String key : jsonKeys) {
                if (!specified.contains(key)) {
                    jsonDoc.remove(key);
                }
            }
            //System.out.println("Zmieniono strukturę");
            return jsonDoc.toJSONString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invalid Json!";
    }
}