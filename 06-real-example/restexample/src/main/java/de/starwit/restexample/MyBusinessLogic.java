package de.starwit.restexample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.starwit.restexample.entities.ClubEntity;
import jakarta.annotation.PostConstruct;

@Service
public class MyBusinessLogic {

    private Logger log = LoggerFactory.getLogger(MyBusinessLogic.class);

    String clubFileLocation = "data/bundesliga_clubs.csv";

    List<ClubEntity> clubs;

    @PostConstruct
    private void init() {
        log.info("read data");

        clubs = new ArrayList<>();

        try {
            Reader in = new FileReader(clubFileLocation, StandardCharsets.UTF_8);

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader("id","name","leauge")
                .setDelimiter(";")
                .setSkipHeaderRecord(true)
                .build();                
            
            Iterable<CSVRecord> records = csvFormat.parse(in);;
            for (CSVRecord record : records) {
                String clubName = record.get(1);
                int clubLeague = Integer.parseInt(record.get(2));
                ClubEntity ce = new ClubEntity();
                ce.setId(Integer.parseInt(record.get(0)));
                ce.setName(clubName);
                ce.setLeague(clubLeague);
                clubs.add(ce);
            }             
        } catch (FileNotFoundException e) {
            log.error("Can't find csv file " + e.getMessage());
        } catch (IOException e) {
            log.error("Can't access csv file " + e.getMessage());
        }
    }

    public List<ClubEntity> getClubs() {
        return clubs;
    }

}
