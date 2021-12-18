package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JSONTransformer;


@RestController
@RequestMapping("/minify")
public class FullToCompressedController {

    private static final Logger logger = LoggerFactory.getLogger(JSONTransformer.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> get(String text) {
        //pass
        return ResponseEntity.ok().build();

    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> post(@RequestBody String text, @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        //logger.debug(text);

        JSONTransformer converter = new JSONTransformer(transforms);
        String output = converter.compress(text);
        System.out.println(output);
        return ResponseEntity.ok(output);
    }



}


