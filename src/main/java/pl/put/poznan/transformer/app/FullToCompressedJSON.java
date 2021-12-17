package pl.put.poznan.transformer.app;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/*
 * Jako programista mogę uzyskać zminifikowaną strukturę w formacie JSON na podstawie pełnego zapisu w formacie JSON, aby zmniejszyć rozmiar danych.
 * <p>
 * Program pobiera plik Json (Json.json) z naszej klasy głównej
 *  i dzięki funkcji JSONValue.parse usuwa wszelkie
 * białe znaki z pliku. Dzięki temu jesteśmy w stanie otrzymać plik nawet o połowę
 * lżejszy niż oryginał. Następnie poprzez użycie klasy FileWriter zapisujemy nasz
 * otrzymany tekst do pliku.
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
     * @param base - Agregacja głównej klasy przechowującej plik do odczytu.
     */
    private JSONBase base;

    /*
     * Minimalizacja rozmiaru pliku JSON przy użyciu funkcji parse.
     * Zapis zminimalizowanego tekstu do oddzielnego pliku
     */
    public void Uncompression() {
        try {
            base = new JSONBase("Json.json");
            JSONObject jsonDoc = (JSONObject) JSONValue.parse(base.getJSON());
            // System.out.println(jsonDoc);

            FileWriter file = new FileWriter("MinJson.json");
            file.write(jsonDoc.toJSONString());
            file.flush();
            System.out.println("JSON compressed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
