package de.starwit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.starwit.entities.ClubEntity;
import de.starwit.entities.LeagueEntity;

public class FootballApp {
    static Logger log = LogManager.getLogger(FootballApp.class.getName());

    String clubFileLocation = "data/bundesliga_clubs.csv";

    public static void main(String[] args) throws Exception {
        log.info("Football app started");
        FootballApp fa = new FootballApp();
        List<ClubEntity> clubs = fa.parseClubs();
        log.info("Number of parsed clubs " + clubs.size());

        fa.streamExamples(clubs);

        fa.parseLeagues();
        fa.parseGames();
        fa.parsePlayers();
    }

    public void streamExamples(List<ClubEntity> clubs) {
        // Example do something for every element
        Stream<ClubEntity> s = clubs.stream();
        s.forEach(c -> {
            ClubEntity ce = (ClubEntity) c;
            log.info(ce.getName());
        });

        System.out.println("Filtered List");
        List<ClubEntity> filteredClubs = clubs.stream().filter(c -> c.getName().contains("FC")).collect(Collectors.toList());
        // alternative use forEach from List interface
        filteredClubs.forEach(c -> log.info(c.getName()));

        System.out.println("Mapped List");
        // do something for every element and return result
        clubs.stream().map(c -> {
            c.setName(c.getName().toUpperCase());
            return c;
        }).collect(Collectors.toList());
        clubs.forEach(c -> log.info(c.getName()));

        List<String> clubSummaries = clubs.stream()
            .map(club -> club.getName() + " is playing in league " + club.getLeague()) // Create a custom summary
            .collect(Collectors.toList());
        clubSummaries.forEach(System.out::println);


        List<LeagueEntity> leagues = new ArrayList<>();
        leagues.add(new LeagueEntity(1, "Erste Liga"));
        leagues.add(new LeagueEntity(2, "Zweite Liga"));
        leagues.add(new LeagueEntity(3, "Dritte Liga"));

        clubs.stream().map(c -> {
            int leagueId = c.getLeague();
            for(LeagueEntity l : leagues) {
                if (l.getId() == leagueId) {
                    c.setLeagueEntity(l);
                    break;
                }
            }
            //alternative
            //LeagueEntity league = leagues.stream().filter(l -> l.getId() == leagueId).findFirst().orElse(null);
            return c;
        }).collect(Collectors.toList()).forEach(System.out::println);
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
