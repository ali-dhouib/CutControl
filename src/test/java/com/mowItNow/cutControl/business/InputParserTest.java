package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.domain.*;
import com.mowItNow.cutControl.enums.Direction;
import com.mowItNow.cutControl.enums.Movement;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {
    @Test
    void parse_shouldParseValidInputCorrectly() {
        List<String> inputs = List.of("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");

        ParsedInput parsedInput = InputParser.parse(inputs);

        Lawn expectedLawn = new Lawn(5, 5);
        assertEquals(expectedLawn, parsedInput.getLawn(), "Parsed lawn should match the expected lawn.");

        List<MowerInstructions> expectedInstructions = List.of(
                new MowerInstructions(new Mower(new Coordinates(1, 2), Direction.N), List.of(
                        Movement.TURN_LEFT, Movement.FORWARD, Movement.TURN_LEFT,
                        Movement.FORWARD, Movement.TURN_LEFT, Movement.FORWARD,
                        Movement.TURN_LEFT, Movement.FORWARD, Movement.FORWARD
                )),
                new MowerInstructions(new Mower(new Coordinates(3, 3), Direction.E), List.of(
                        Movement.FORWARD, Movement.FORWARD, Movement.TURN_RIGHT,
                        Movement.FORWARD, Movement.FORWARD, Movement.TURN_RIGHT,
                        Movement.FORWARD, Movement.TURN_RIGHT, Movement.TURN_RIGHT, Movement.FORWARD
                ))
        );
        assertEquals(expectedInstructions, parsedInput.getMowerInstructions(), "Parsed mower instructions should match expected instructions.");
    }

    @Test
    void parse_shouldThrowExceptionForInvalidLawnInput() {
        List<String> inputs = List.of("INVALID LAWN", "1 2 N", "GAGAGAGAA");

        assertThrows(IllegalArgumentException.class, () -> InputParser.parse(inputs),
                "Invalid lawn input should throw an exception.");
    }

    @Test
    void parse_shouldThrowExceptionForUnsupportedLineType() {
        List<String> inputs = List.of("5 5", "1 2 N", "GAGAGAGAA", "UNSUPPORTED LINE TYPE");

        assertThrows(IllegalArgumentException.class, () -> InputParser.parse(inputs),
                "Unsupported line type should throw an exception.");
    }
}