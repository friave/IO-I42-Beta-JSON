package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {

    public static void main(String[] args) {
        CompressedToFullJSON test1 = new CompressedToFullJSON();
        test1.test();

        FullToCompressedJSON test2 = new FullToCompressedJSON();
        test2.test();
        SpringApplication.run(TextTransformerApplication.class, args);
    }
}
