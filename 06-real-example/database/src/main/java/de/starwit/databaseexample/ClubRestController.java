package de.starwit.databaseexample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.starwit.databaseexample.entities.ClubEntity;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "${rest.base-path}/clubs")
public class ClubRestController {

    private Logger log = LoggerFactory.getLogger(ClubRestController.class);

    @Autowired
    private ClubRepository clubRepository;

    @Operation(summary = "A fancy function")
    @GetMapping("/info")
    ResponseEntity<String> beanScopeDemo() {
        log.info("rest service called");
        return ResponseEntity.ok("Hallo Welt");
    }
    
    @Operation(summary = "Get a list of all clubs")
    @GetMapping("/")
    ResponseEntity<List<ClubEntity>> getClubs() {
        log.info("get all clubs");
        return ResponseEntity.ok(clubRepository.findAll());
    }    
}
