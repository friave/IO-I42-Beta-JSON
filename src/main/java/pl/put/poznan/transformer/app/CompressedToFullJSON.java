package pl.put.poznan.transformer.app;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.google.gson.*;



/*
 * Jako programista mogę uzyskać pełną strukturę w formacie JSON ze zminifikowanego zapisu w formacie JSON, aby polepszyć czytelność danych
 * <p>
 * Program pobiera łańcuch znaków w formacie zgodnym z JSON z naszej klasy głównej
 *  i dzięki bibliotece gson i klasy GsonBuilder
 * jesteśmy w stanie odtworzyć zminifikowaną strukturę JSON do przyjrzystej
 * i czytelnej dla człowieka struktury.
 *
 * @author 144493 (Scrum Master)
 * @author 145299 (Proxy Product Owner)
 * @author 144629
 * @author 145357
 * @version 1.0.2
 * @since 1.0
 * @param File - "MinJson.json"
 */

public class CompressedToFullJSON {

    /*
     * @param base - Agregacja głównej klasy przechowującej strukturę JSON.
     */
    private JSONBase base;

    /*
     * Transformacha struktury JSON na czytelną
     */
    public String uncompression(String compressed) {
        try {
            base = new JSONBase(compressed);
            JSONObject jsonDoc = (JSONObject) JSONValue.parse(base.getJSON());
            // System.out.println(jsonDoc);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(String.valueOf(jsonDoc));

            return gson.toJson(je);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invalid JSON!";
    }
}
