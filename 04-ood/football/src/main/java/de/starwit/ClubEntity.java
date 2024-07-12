package de.starwit;

public class ClubEntity extends AbstractEntity {
    private String name;
    private int league;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeague() {
        return league;
    }

    public void setLeague(int league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "ClubEntity [id=" + id + ", name=" + name + ", league=" + league + "]";
    }    
}
