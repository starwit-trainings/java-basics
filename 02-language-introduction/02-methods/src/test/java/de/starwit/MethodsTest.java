package de.starwit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MethodsTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testGetFive() {
        int result = Control.getFive();
        assertTrue(result == 5);
    }
}
