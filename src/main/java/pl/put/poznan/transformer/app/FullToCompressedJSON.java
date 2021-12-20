package pl.put.poznan.transformer.app;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


/*
 * Jako programista mogę uzyskać zminifikowaną strukturę w formacie JSON na podstawie pełnego zapisu w formacie JSON, aby zmniejszyć rozmiar danych.
 * <p>
 * Program pobiera łańcuch znaków w formacie zgodnym z JSON z naszej klasy głównej
 *  i dzięki funkcji JSONValue.parse usuwa wszelkie
 * białe znaki z pliku. Dzięki temu jesteśmy w stanie otrzymać strukturę nawet o połowę
 * lżejszą niż oryginał.
 *
 * <p>
 * @author 144493 (Scrum Master)
 * @author 145299 (Proxy Product Owner)
 * @author 144629
 * @author 145357
 * @version 1.0.2
 * @since 1.0
 *

 */

public class FullToCompressedJSON{

    /*
     * @param base - Agregacja głównej klasy przechowującej strukturę JSON.
     */
    private JSONBase base;

    /*
     * Minimalizacja rozmiaru struktury JSON przy użyciu funkcji parse.
     */

    public String compression(String uncompressed) {
        try {
            base = new JSONBase(uncompressed);
            JSONObject jsonDoc = (JSONObject) JSONValue.parse(base.getJSON());
            // System.out.println(jsonDoc);
            System.out.println("JSON compressed");
            return jsonDoc.toJSONString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invalid JSON!";
    }



}
