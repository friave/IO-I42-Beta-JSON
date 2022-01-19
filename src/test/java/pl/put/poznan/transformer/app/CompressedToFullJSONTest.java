package pl.put.poznan.transformer.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressedToFullJSONTest {

    CompressedToFullJSON compressJSON;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void uncompression1() {
        compressJSON = new CompressedToFullJSON("{\"test1\":{\"test1\":111}}");
        String json = compressJSON.uncompression();
        assertEquals("{\n" +
                "  \"test1\": {\n" +
                "    \"test1\": 111\n" +
                "  }\n" +
                "}", json);
    }

    @Test
    void uncompression2() {
        compressJSON = new CompressedToFullJSON("{\"test2\" : {\n\"test2\" : 222\n}\n}");
        String json = compressJSON.uncompression();
        assertEquals("{\n" +
                "  \"test2\": {\n" +
                "    \"test2\": 222\n" +
                "  }\n" +
                "}", json);
    }

    @Test
    void NoValidJSON() {
        compressJSON = new CompressedToFullJSON("dasdasdas");
        String json = compressJSON.uncompression();
        assertEquals(String.valueOf("null"), json);
    }

    @Test
    void ValidJSON() {
        compressJSON = new CompressedToFullJSON("{\"test4\":{\"test4\":444}}");
        String json = compressJSON.uncompression();
        assertEquals(true, compressJSON.isJSONValid(json));
    }
}