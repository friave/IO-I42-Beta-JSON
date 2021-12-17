package pl.put.poznan.transformer.app;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * <p>
 * Głowna klasa przechowująca wybrany przez nas plik. Służy do zaimplementowania
 * wzorca projektowego 'dekorator'.
 *
 * <p>
 * @author 144493 (Scrum Master)
 * @author 145299 (Proxy Product Owner)
 * @author 144629
 * @author 145357
 * @version 1.0.2
 * @since 1.0
 *
 *
 */

public class JSONBase {

    /*
     * @param json - przechowuje plik do odczytu
     */
    private FileReader json;

    /*
     * Podstawowe wczytanie pliku do zmiennej
     */
    public JSONBase(String file) {
        try {
            json = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public FileReader getJSON() {
        return json;
    }

}
