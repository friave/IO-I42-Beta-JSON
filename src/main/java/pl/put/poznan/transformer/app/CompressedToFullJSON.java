package pl.put.poznan.transformer.app;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Jako programista mogę uzyskać pełną strukturę w formacie JSON ze zminifikowanego zapisu w formacie JSON, aby polepszyć czytelność danych
 * <p>
 * Program pobiera plik Json (MinJson.json) z naszej klasy głównej
 *  i dzięki biblioteki gson i klasy GsonBuilder
 * jesteśmy w stanie odtworzyć zminifikowany plik JSON do przyjrzystej
 * i czytelnej dla człowieka struktury.
 *
 * @author 144493 (Scrum Master)
 * @author 145299 (Proxy Product Owner)
 * @author 144629
 * @author 145357
 * @version 1.0.2
 * @since 1.0
 * @param File - "MinJson.json"
 *
 * <p>
 * Dla poprawy wygody można dodać możliwość wpisania przez użytkownika jakiego pliku
 * chcemy dokonać transformacji do pełnej struktury pliku JSON.
 */

public class CompressedToFullJSON {

    /*
     * @param base - Agregacja głównej klasy przechowującej plik do odczytu.
     */
    private JSONBase base;

    /*
     * Transformacha pliku JSON na czytelny
     */
    public void Compression() {
        try {
            base = new JSONBase("MinJson.json");
            JSONObject jsonDoc = (JSONObject) JSONValue.parse(base.getJSON());
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
