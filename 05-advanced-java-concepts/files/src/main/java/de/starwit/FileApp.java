package de.starwit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.starwit.entities.ClubEntity;

public class FileApp {
    static Logger log = LogManager.getLogger(FileApp.class.getName());

    String clubFileLocation = "data/bundesliga_clubs.csv";

    List<ClubEntity> clubs;

    public static void main(String[] args) throws Exception {
        log.info("Football app started");
        FileApp fa = new FileApp();
        fa.parseData();
        log.info("Number of parsed clubs " + fa.getClubs().size());

        Map<Integer,Integer> numberPerLeagues = fa.countClubsPerLeague();
        for (Integer i :numberPerLeagues.keySet()) {
            log.info(i + ": " + numberPerLeagues.get(i));
        }

        fa.writeClubsPerLeagueToFile(numberPerLeagues);
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

    public Map<Integer,Integer> countClubsPerLeague() {
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
    
    public void writeClubsPerLeagueToFile(Map<Integer,Integer> numberPerLeagues) {
        String nameOutputFile = "count-results.csv";
        try {
            Writer out = new FileWriter(nameOutputFile, StandardCharsets.UTF_8);
            for(var entry: numberPerLeagues.entrySet()) {
                out.write(entry.getKey() + ", " + entry.getValue() + "\n");
            }
            out.close();
        } catch (IOException e) {
            log.error("Can't write to output file " + e.getMessage());
        }

    }

    public List<ClubEntity> getClubs() {
        return clubs;
    }    
}
