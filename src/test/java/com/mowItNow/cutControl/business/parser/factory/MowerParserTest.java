package com.mowItNow.cutControl.business.parser.factory;

import com.mowItNow.cutControl.domain.Coordinates;
import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.enums.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerParserTest {

    private final MowerParser mowerParser = new MowerParser();

    @Test
    void parse_shouldReturnMowerWhenInputIsValid() {
        String input = "1 2 N";

        Mower mower = mowerParser.parse(input);

        assertNotNull(mower, "Mower should not be null.");
        assertEquals(new Coordinates(1, 2), mower.getPosition(), "Coordinates should match.");
        assertEquals(Direction.N, mower.getDirection(), "Direction should be North.");
    }

    @Test
    void parse_shouldThrowIllegalArgumentExceptionWhenCoordinatesAreInvalid() {
        String input = "1 X N";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mowerParser.parse(input),
                "Parsing invalid coordinates should throw an IllegalArgumentException.");
        assertTrue(exception.getMessage().contains("Les coordonnées doivent être des nombres entiers valides."),
                "The exception message should contain the expected error message.");
    }

    @Test
    void parse_shouldThrowIllegalArgumentExceptionWhenDirectionIsInvalid() {
        String input = "1 2 Z";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mowerParser.parse(input),
                "Parsing an invalid direction should throw an IllegalArgumentException.");
        assertTrue(exception.getMessage().contains("La direction doit correspondre à une valeur valide de l'énumération Direction."),
                "The exception message should contain the expected error message.");
    }

    @Test
    void parse_shouldReturnNullWhenInputIsEmpty() {
        String input = "";

        Mower mower = mowerParser.parse(input);

        assertNull(mower, "Parsing an empty string should return null.");
    }

    @Test
    void parse_shouldReturnNullWhenInputIsNull() {
        String input = null;

        Mower mower = mowerParser.parse(input);

        assertNull(mower, "Parsing a null string should return null.");
    }
}