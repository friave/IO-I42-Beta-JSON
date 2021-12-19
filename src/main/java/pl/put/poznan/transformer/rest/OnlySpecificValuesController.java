package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.transformer.logic.JSONTransformer;
import pl.put.poznan.transformer.utils.OnlySpecificValues;

import java.util.ArrayList;

@RestController
@RequestMapping("/specific")
public class OnlySpecificValuesController {

    private static final Logger logger = LoggerFactory.getLogger(JSONTransformer.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> get(String text) {
        //pass
        logger.error("No GET method yet in onlySpecificValues");
        return ResponseEntity.ok().build();

    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> post(@RequestBody OnlySpecificValues temp) {
        System.out.println(temp.getJson());
        System.out.println(temp.getKeys());
        JSONTransformer converter = new JSONTransformer();
        String output = converter.getSpecificValues(temp);
        logger.info("Extraction successfull");
        logger.debug("Extracted JSON: {}", output);

        return ResponseEntity.ok(output);
    }


}
