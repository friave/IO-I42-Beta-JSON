package pl.put.poznan.transformer.app;

/*
 * Jako programista mogę uzyskać pełną strukturę w formacie JSON ze zminifikowanego zapisu w formacie JSON, aby polepszyć czytelność danych.
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CompressedToFullJSON {

    public void test() {
        try {
            JSONObject jsonDoc = (JSONObject) JSONValue.parse(new FileReader("MinJson.json"));
            // System.out.println(jsonDoc);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(String.valueOf(jsonDoc));
            String prettyJsonString = gson.toJson(je);

            FileWriter file = new FileWriter("MaxJson.json");
            file.write(prettyJsonString);
            file.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
