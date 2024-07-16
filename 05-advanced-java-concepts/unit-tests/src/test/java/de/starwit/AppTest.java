package de.starwit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.starwit.entities.ClubEntity;

public class AppTest {

    private List<ClubEntity> prepList() {
        List<ClubEntity> clubs = new ArrayList<>();
        
        ClubEntity c1 = new ClubEntity();
        c1.setId(1);
        c1.setName("ClubA");
        c1.setLeague(1);
        
        ClubEntity c2 = new ClubEntity();
        c2.setId(1);
        c2.setName("ClubB");
        c2.setLeague(1);
        
        ClubEntity c3 = new ClubEntity();
        c3.setId(1);
        c3.setName("ClubCd");
        c3.setLeague(1);        

        clubs.add(c2);
        clubs.add(c3);
        clubs.add(c1);

        return clubs;
    }

    @Test
    public void testSorting() {
        FootballApp fa = new FootballApp();
        fa.setClubs(prepList());

        // test if data is unordered
        assertTrue(fa.getClubs().get(0).getName().equals("ClubB"));
        assertTrue(fa.getClubs().get(1).getName().equals("ClubCd"));
        assertTrue(fa.getClubs().get(2).getName().equals("ClubA"));

        // this is the function, we want to test
        fa.sortingLists();

        // test if ordering worked properly
        assertTrue(fa.getClubs().get(0).getName().equals("ClubA"));
        assertTrue(fa.getClubs().get(1).getName().equals("ClubB"));
        assertTrue(fa.getClubs().get(2).getName().equals("ClubCd"));
    }

    @Test
    public void testSizeCalculation() {
        FootballApp fa = new FootballApp();
        fa.setClubs(prepList());

        long size = fa.getClubs().get(0).countBytes();
        assertEquals(37l, size);
        size = fa.getClubs().get(1).countBytes();
        assertEquals(38l, size); // no sorting here
        size = fa.getClubs().get(2).countBytes();
        assertEquals(37l, size);                
    }
}
