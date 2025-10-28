package de.starwit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DataTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testCalculateMinimum() {
        double minimum = Data.calculateMinimum(new int[] {3, -1, 2, 100, -20});
        assertTrue(minimum == -20);
    }

    @Test
    public void testCalculateMaximum() {
        double minimum = Data.calculateMaximum(new int[] {3, -1, 2, 100, -20});
        assertTrue(minimum == 100);
    }

    @Test
    public void testCalculateSum() {
        double minimum = Data.calculateSum(new int[] {3, -1, 2, 100, -20});
        assertTrue(minimum == 84);
    }

    @Test
    public void testCalculateAverage() {
        double minimum = Data.calculateAverage(new int[] {10, 5, 50, 100, 20});
        assertTrue(minimum == 185. / 5);
    }
    
}
