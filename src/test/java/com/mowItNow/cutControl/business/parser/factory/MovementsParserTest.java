package com.mowItNow.cutControl.business.parser.factory;

import com.mowItNow.cutControl.enums.Movement;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovementsParserTest {
    private final MovementsParser movementsParser = new MovementsParser();

    @Test
    void parse_shouldReturnMovementsListWhenInputIsValid() {
        String input = "AGAGAGAG";

        List<Movement> movements = movementsParser.parse(input);

        assertNotNull(movements, "Movements list should not be null.");
        assertEquals(8, movements.size(), "The number of movements should be 8.");
        assertEquals(Movement.FORWARD, movements.get(0), "First movement should be FORWARD.");
        assertEquals(Movement.TURN_LEFT, movements.get(1), "Second movement should be TURN_LEFT.");
        assertEquals(Movement.FORWARD, movements.get(2), "Third movement should be FORWARD.");
        assertEquals(Movement.TURN_LEFT, movements.get(3), "Fourth movement should be TURN_LEFT.");
        assertEquals(Movement.FORWARD, movements.get(4), "Fifth movement should be FORWARD.");
        assertEquals(Movement.TURN_LEFT, movements.get(5), "Sixth movement should be TURN_LEFT.");
        assertEquals(Movement.FORWARD, movements.get(6), "Seventh movement should be FORWARD.");
        assertEquals(Movement.TURN_LEFT, movements.get(7), "Eighth movement should be TURN_LEFT.");
    }

    @Test
    void parse_shouldReturnNullWhenInputIsEmpty() {
        String input = "";

        List<Movement> movements = movementsParser.parse(input);

        assertNull(movements, "Parsing an empty string should return null.");
    }

    @Test
    void parse_shouldReturnNullWhenInputIsNull() {
        String input = null;

        List<Movement> movements = movementsParser.parse(input);

        assertNull(movements, "Parsing a null string should return null.");
    }

    @Test
    void parse_shouldReturnListWithNoDefaultMovement() {
        String input = "GGAAG";

        List<Movement> movements = movementsParser.parse(input);

        assertNotNull(movements, "Movements list should not be null.");
        assertEquals(5, movements.size(), "The number of movements should be 5.");
        assertFalse(movements.contains(Movement.DEFAULT), "List should not contain default movements.");
    }
}