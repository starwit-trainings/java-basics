package de.starwit.entities;

public class FootballClubEntity extends AbstractEntity {
    private String name;
    private FootballLeagueEntity league;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FootballLeagueEntity getLeague() {
        return league;
    }

    public void setLeague(FootballLeagueEntity league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "ClubEntity [id=" + id + ", name=" + name + ", league=" + league + "]";
    }

    @Override
    public void reportToString() {
        System.out.println(id + "|" + name + "|" + league.getLeagueName());
    }
}
