package pl.put.poznan.transformer.utils;

import java.util.ArrayList;

public class OnlySpecificValues {
    private String text;
    ArrayList<String> keys;

    public OnlySpecificValues(String text, ArrayList<String> keys){
        System.out.println(text);
        this.text = text;
        this.keys = keys;
    }

    public String getJson() {
        return text;
    }

    public ArrayList<String> getKeys() {
        return keys;
    }
}
