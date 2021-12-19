package pl.put.poznan.transformer.app;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JsonOnlySpecificValues {
    private JSONBase base;

    public void Specify() {
        try {
            Set<String> specified = new HashSet<String>();
            base = new JSONBase("Json.json");
            JSONObject jsonDoc = (JSONObject) JSONValue.parse(base.getJSON());

            //Co chcesz zostawić:
            //specified.add("measures");
            specified.add("dimensions");

            Set<String> jsonKeys = new HashSet<String>(jsonDoc.keySet());

            for( String key : jsonKeys) {
                if (!specified.contains(key)) {
                    jsonDoc.remove(key);
                }
            }

            FileWriter file = new FileWriter("SpecificJson.json");
            file.write(jsonDoc.toJSONString());
            file.flush();
            System.out.println("Zmieniono strukturę");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
