package com.mowItNow.cutControl.business.parser.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserFactoryTest {

    @Test
    void getLineParser_shouldReturnLawnParserForLine0() {
        LineParser<?> parser = ParserFactory.getLineParser(0);

        assertNotNull(parser);
        assertTrue(parser instanceof LawnParser, "Expected LawnParser for line 0");
    }

    @Test
    void getLineParser_shouldReturnMowerParserForOddLines() {
        LineParser<?> parser = ParserFactory.getLineParser(1);

        assertNotNull(parser);
        assertTrue(parser instanceof MowerParser, "Expected MowerParser for odd lines");
    }

    @Test
    void getLineParser_shouldReturnMovementsParserForEvenLinesAfterFirst() {
        LineParser<?> parser = ParserFactory.getLineParser(2);

        assertNotNull(parser);
        assertTrue(parser instanceof MovementsParser, "Expected MovementsParser for even lines after the first");
    }
}