package de.starwit.restexample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.starwit.restexample.entities.ClubEntity;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/")
public class MyRestController {

    private Logger log = LoggerFactory.getLogger(MyRestController.class);

    @Autowired
    private MyBusinessLogic logic;

    @Operation(summary = "A fancy function")
    @GetMapping("/info")
    ResponseEntity<String> beanScopeDemo() {
        log.info("rest service called");
        return ResponseEntity.ok("Hallo Welt");
    }
    
    @Operation(summary = "Get a list of clubs")
    @GetMapping("/clubs")
    ResponseEntity<List<ClubEntity>> getClubs() {
        log.info("get all clubs");

        return ResponseEntity.ok(logic.getClubs());
    }    
}
