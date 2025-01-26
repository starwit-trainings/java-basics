package de.starwit;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.starwit.entities.FootballClubEntity;
import de.starwit.entities.FootballLeagueEntity;
import de.starwit.entities.GenericLeague;

public class GenericsApp {
    static Logger log = LogManager.getLogger(GenericsApp.class.getName());

    FootballLeagueEntity league;
    List<FootballClubEntity> clubs = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        GenericsApp app = new GenericsApp();
        app.createSampleLeague();
        app.genericExample();
    }

    private void createSampleLeague() {

        league = new FootballLeagueEntity();
        league.setId(1);
        league.setLeagueName("Erste Bundesliga");

        FootballClubEntity club = new FootballClubEntity();
        club.setName("FC Bayern München");
        club.setLeague(league);
        clubs.add(club);

        FootballClubEntity club2 = new FootballClubEntity();
        club2.setName("Borussia Dortmund");
        club2.setLeague(league);
        clubs.add(club2);
    }

    private void genericExample() {

        GenericLeague<FootballLeagueEntity, FootballClubEntity> genericLeague = new GenericLeague<>();
        genericLeague.setLeague(league);
        genericLeague.setClubs(clubs);

        genericLeague.printLeague();
    }
}
