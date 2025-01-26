package de.starwit.entities;

public class ChessClubEntity extends AbstractEntity{
    private String name;
    private String eloRank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEloRank() {
        return eloRank;
    }

    public void setEloRank(String eloRank) {
        this.eloRank = eloRank;
    }

    @Override
    public String toString() {
        return "ChessClubEntity [eloRank=" + eloRank + "]";
    }

    @Override
    public void reportToString() {
        System.out.println(id + "|" + name );
    }
}
