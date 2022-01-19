package pl.put.poznan.transformer.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullToCompressedJSONTest {

    FullToCompressedJSON fullJSON;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compression1() {
        fullJSON = new FullToCompressedJSON("{\n\t\"test1\" : {\n\t\t\"test1\" : 111\n\t}\n}");
        String json = fullJSON.compression();
        assertEquals("{\"test1\":{\"test1\":111}}", json);
    }

    @Test
    void compression2() {
        fullJSON = new FullToCompressedJSON("{\"test2\":{\"test2\":222}}");
        assertEquals("{\"test2\":{\"test2\":222}}", fullJSON.getJSON());
    }

    @Test
    void NoValidJSON() {
        fullJSON = new FullToCompressedJSON("dasdasdas");
        String json = fullJSON.compression();
        assertEquals("Invalid JSON!", json);
    }

    @Test
    void ValidJSON() {
        fullJSON = new FullToCompressedJSON("{\"test4\":{\"test4\":444}}");
        String json = fullJSON.compression();
        assertEquals(true, fullJSON.isJSONValid(json));
    }
}