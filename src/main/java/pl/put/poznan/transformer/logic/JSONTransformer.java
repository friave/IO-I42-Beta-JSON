package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.app.CompressedToFullJSON;
import pl.put.poznan.transformer.app.FullToCompressedJSON;

public class JSONTransformer {

    private final String[] transforms;

    public JSONTransformer(String[] transforms) {
        this.transforms = transforms;
    }

    public String compress(String text){
        FullToCompressedJSON uncompressed = new FullToCompressedJSON();
        return uncompressed.compression(text);
    }

    public String uncompress(String text){
        CompressedToFullJSON compressed = new CompressedToFullJSON();
        return compressed.uncompression(text);
    }
}

