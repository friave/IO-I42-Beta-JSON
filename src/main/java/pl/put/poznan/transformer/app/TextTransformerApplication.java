package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {

    public static void main(String[] args) {
        CompressedToFullJSON comp = new CompressedToFullJSON();
        comp.Compression();

        FullToCompressedJSON full = new FullToCompressedJSON();
        full.Uncompression();

        JsonOnlySpecificValues specified = new JsonOnlySpecificValues();
        specified.Specify();

        SpringApplication.run(TextTransformerApplication.class, args);
    }
}
