package de.starwit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.starwit.entities.ClubEntity;

public class FootballApp {
    static Logger log = LogManager.getLogger(FootballApp.class.getName());

    String clubFileLocation = "data/bundesliga_clubs.csv";

    List<ClubEntity> clubs;

    public static void main(String[] args) throws Exception {
        log.info("Football app started");
        FootballApp fa = new FootballApp();
        fa.parseData();
        log.info("Number of parsed clubs " + fa.getClubs().size());

        fa.runningThroughLists();
        fa.sortingLists();

        Map<Integer,Integer> numberPerLeagues = fa.countClubsPerLeague(fa.getClubs());
        for (Integer i :numberPerLeagues.keySet()) {
            log.info(i + ": " + numberPerLeagues.get(i));
        }
    }

    public void parseData() {
        clubs = parseClubs();
        // add parsing other data here
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

    private void runningThroughLists() {
        log.debug("******************* forach loop quick");
        for (ClubEntity clubEntity : clubs) {
            log.debug(clubEntity.getName());
        }

        log.debug("******************* for loop like an arry");
        for(int i = 0; i < clubs.size(); i++) {
            ClubEntity c = clubs.get(i);
            log.debug(c.getName());
        }
        
        log.debug("******************* using Iterator pattern");
        Iterator<ClubEntity> iter = clubs.iterator();
        while(iter.hasNext()) {
            ClubEntity c = iter.next();
            log.debug(c.getName());
        }
        log.debug("******************* using lambda function");
        clubs.forEach(c -> log.debug(c.getName()));

        
    }
    
    public void sortingLists() {
        log.info("List order prior sorting ***********************************");
        clubs.forEach(c -> log.debug(c.getId()));

        clubs.sort((ClubEntity c1, ClubEntity c2) -> c1.getName().compareTo(c2.getName()));
        log.info("List order after sorting ***********************************");
        clubs.forEach(c -> log.debug(c.getId()));
    }

    public Map<Integer,Integer> countClubsPerLeague(List<ClubEntity> clubs) {
        Map<Integer,Integer> numberPerLeagues =  new HashMap<>();
        numberPerLeagues.put(Integer.valueOf(1), Integer.valueOf(0));
        numberPerLeagues.put(Integer.valueOf(2), Integer.valueOf(0));
        numberPerLeagues.put(Integer.valueOf(3), Integer.valueOf(0));

        clubs.forEach(c -> {    
            int l = c.getLeague();
            Integer tmpNo = numberPerLeagues.get(l);
            tmpNo += 1;
            numberPerLeagues.put(l, tmpNo);
        });

        return numberPerLeagues;
    }    

    public List<ClubEntity> getClubs() {
        return clubs;
    }

    public void setClubs(List<ClubEntity> clubs) {
        this.clubs = clubs;
    }  
}
