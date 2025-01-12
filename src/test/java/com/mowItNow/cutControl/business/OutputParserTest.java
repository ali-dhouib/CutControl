package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.domain.Coordinates;
import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.enums.Direction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputParserTest {
    @Test
    void parse_shouldReturnFormattedOutputForMultipleMowers() {
        Mower mower1 = new Mower(new Coordinates(1, 2), Direction.N);
        Mower mower2 = new Mower(new Coordinates(3, 3), Direction.E);
        List<Mower> mowers = List.of(mower1, mower2);

        String result = OutputParser.parse(mowers);

        assertEquals("1 2 N 3 3 E", result);
    }

    @Test
    void parse_shouldReturnEmptyStringForEmptyList() {
        List<Mower> mowers = List.of();

        String result = OutputParser.parse(mowers);

        assertEquals("", result);
    }

    @Test
    void parse_shouldReturnFormattedOutputForSingleMower() {
        Mower mower = new Mower(new Coordinates(0, 0), Direction.W);
        List<Mower> mowers = List.of(mower);

        String result = OutputParser.parse(mowers);

        assertEquals("0 0 W", result);
    }

    @Test
    void parse_shouldTrimTrailingSpaces() {
        Mower mower1 = new Mower(new Coordinates(1, 2), Direction.N);
        Mower mower2 = new Mower(new Coordinates(3, 3), Direction.E);
        List<Mower> mowers = List.of(mower1, mower2);

        String result = OutputParser.parse(mowers);

        assertEquals("1 2 N 3 3 E", result);
        assertEquals(result.trim(), result, "Output should not have trailing spaces.");
    }
}