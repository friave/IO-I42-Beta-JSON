package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JSONTransformer;


@RestController
@RequestMapping("/unminify")
public class CompressedToFullController {

    private static final Logger logger = LoggerFactory.getLogger(JSONTransformer.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> get(String text, String[] transforms) {
        //pass
        logger.error("No GET method yet in unminify");
        return ResponseEntity.ok().build();

    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> post(@RequestBody String text) {

        JSONTransformer converter = new JSONTransformer();
        String output = converter.uncompress(text);
        logger.info("UnMinification succesfull");
        logger.debug("Unminified JSON: {}", output);
        return ResponseEntity.ok(output);
    }



}


