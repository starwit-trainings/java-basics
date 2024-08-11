package de.starwit.entities;

public class ClubEntity extends AbstractEntity implements SizeInterface {
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

    @Override
    public int countBytes() {
        int size = 0;

        size += Integer.SIZE;
        if(name != null) {
            size += name.getBytes().length;
        }
        
        return size;
    }
    
}
