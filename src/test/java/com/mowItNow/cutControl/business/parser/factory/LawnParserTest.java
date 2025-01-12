package com.mowItNow.cutControl.business.parser.factory;

import com.mowItNow.cutControl.domain.Lawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnParserTest {

    private final LawnParser lawnParser = new LawnParser();

    @Test
    void parse_shouldReturnLawnObjectWhenInputIsValid() {
        String input = "5 5";

        Lawn lawn = lawnParser.parse(input);

        assertNotNull(lawn, "Lawn object should not be null.");
        assertEquals(5, lawn.getBounds().getX(), "Lawn X-coordinate should be 5.");
        assertEquals(5, lawn.getBounds().getY(), "Lawn Y-coordinate should be 5.");
    }

    @Test
    void parse_shouldReturnNullWhenInputIsEmpty() {
        String input = "";

        Lawn lawn = lawnParser.parse(input);

        assertNull(lawn, "Parsing an empty string should return null.");
    }

    @Test
    void parse_shouldReturnNullWhenInputIsNull() {
        String input = null;

        Lawn lawn = lawnParser.parse(input);

        assertNull(lawn, "Parsing a null string should return null.");
    }

    @Test
    void parse_shouldThrowIllegalArgumentExceptionWhenInvalidCoordinates() {
        String input = "x y";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> lawnParser.parse(input),
                "Parsing invalid coordinates should throw an IllegalArgumentException.");
        assertTrue(exception.getMessage().contains("Les parties doivent être des nombres entiers valides"),
                "The exception message should contain the expected error message.");
    }
}