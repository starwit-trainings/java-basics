package de.starwit.entities;

import java.util.List;

public class GenericLeague<T extends AbstractEntity, U extends AbstractEntity> {
    private T league;
    private List<U> clubs;

    public T getLeague() {
        return league;
    }

    public void setLeague(T league) {
        this.league = league;
    }

    public List<U> getClubs() {
        return clubs;
    }

    public void setClubs(List<U> clubs) {
        this.clubs = clubs;
    }

    public void printLeague() {
        System.out.println("-----------------------------------------");
        System.out.println("League: " + league);
        System.out.println("-----------------------------------------");
        for (U club : clubs) {
            System.out.println("Club: " + club);
        }
        System.out.println("-----------------------------------------");
    }
}
