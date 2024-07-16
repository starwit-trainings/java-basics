package de.starwit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.starwit.entities.ClubEntity;

public class FootballApp {
    static Logger log = LogManager.getLogger(FootballApp.class.getName());

    Properties config = new Properties();

    String clubFileLocation = "data/bundesliga_clubs.csv";

    List<ClubEntity> clubs;

    public static void main(String[] args) throws Exception {
        log.info("Football app started");
        FootballApp fa = new FootballApp();
        fa.parseData();
        log.info("Number of parsed clubs " + fa.getClubs().size());

    }

    //Constructor
    FootballApp() {
        try (InputStream in = FootballApp.class.getClassLoader().getResourceAsStream("application.properties")) {
            if(in != null) {
                config.load(in);
            } else {
                log.error("Can't find property file");
                System.exit(1);
            }
            
        } catch (IOException e) {
            log.error("Can't load property file, exiting " + e.getMessage());
            System.exit(1); // exit with error status
        }
        config.forEach((k,v) -> log.debug(k + ": " + v));
        clubFileLocation = config.getProperty("import.location") + File.separator + config.getProperty("import.clubs");
    }

    public void parseData() {
        clubs = parseClubs();
    }

    private List<ClubEntity> parseClubs() {
        List<ClubEntity> result = new ArrayList<>();

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
                result.add(ce);
            }             
        } catch (FileNotFoundException e) {
            log.error("Can't find csv file " + e.getMessage());
        } catch (IOException e) {
            log.error("Can't access csv file " + e.getMessage());
        }        

        return result;
    }   

    public List<ClubEntity> getClubs() {
        return clubs;
    }    
}
