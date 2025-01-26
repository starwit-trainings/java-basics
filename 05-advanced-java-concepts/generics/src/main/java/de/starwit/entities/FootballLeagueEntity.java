package de.starwit.entities;

public class FootballLeagueEntity extends AbstractEntity {
    private String leagueName;

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    @Override
    public String toString() {
        return "FootballLeagueEntity [LeagueName=" + leagueName + "]";
    }

    @Override
    public void reportToString() {
        System.out.println("League Info");
        System.out.println(toString());
    }    
}
