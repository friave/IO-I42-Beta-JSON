package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.app.CompressedToFullJSON;
import pl.put.poznan.transformer.app.FullToCompressedJSON;
import pl.put.poznan.transformer.app.JSONOnlySpecificValues;
import pl.put.poznan.transformer.utils.OnlySpecificValues;

import java.util.ArrayList;

public class JSONTransformer {

    public String compress(String text){
        FullToCompressedJSON uncompressed = new FullToCompressedJSON();
        return uncompressed.compression(text);
    }

    public String uncompress(String text){
        CompressedToFullJSON compressed = new CompressedToFullJSON();
        return compressed.uncompression(text);
    }

    public String getSpecificValues(OnlySpecificValues wrapped){
        JSONOnlySpecificValues jsonOnlySpecificValues = new JSONOnlySpecificValues();
        return jsonOnlySpecificValues.specify(wrapped.getJson(), wrapped.getKeys());

    }
}

