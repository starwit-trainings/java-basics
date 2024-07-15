package de.starwit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.starwit.entities.ClubEntity;

public class FootballApp {
    static Logger log = LogManager.getLogger(FootballApp.class.getName());

    String clubFileLocation = "data/bundesliga_clubs.csv";

    public static void main(String[] args) throws Exception {
        log.info("Football app started");
        FootballApp fa = new FootballApp();
        List<ClubEntity> clubs = fa.parseClubs();
        log.info("Number of parsed clubs " + clubs.size());

        fa.parseLeagues();
        fa.parseGames();
        fa.parsePlayers();
    }

    public List<ClubEntity> parseClubs() {
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

    private void parseLeagues() {
        throw new UnsupportedOperationException("Unimplemented method 'parseLeagues'");
    }    

    private void parsePlayers() {
        throw new UnsupportedOperationException("Unimplemented method 'parsePlayers'");
    }

    private void parseGames() {
        throw new UnsupportedOperationException("Unimplemented method 'parseGames'");
    }

    private void getLeagueForClub(ClubEntity c) {

    }
}
