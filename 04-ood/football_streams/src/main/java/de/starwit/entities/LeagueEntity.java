package de.starwit.entities;

public class LeagueEntity extends AbstractEntity {
    private String leagueName;

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public LeagueEntity(int id, String leagueName) {
        this.id = id;
        this.leagueName = leagueName;
    }

    @Override
    public String toString() {
        return "LeagueEntity [id=" + id + ", leagueName=" + leagueName + "]";
    }
}
