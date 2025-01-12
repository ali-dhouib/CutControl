package com.mowItNow.cutControl.business.parser.builder;

import com.mowItNow.cutControl.domain.*;
import com.mowItNow.cutControl.enums.Direction;
import com.mowItNow.cutControl.enums.Movement;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParsedInputBuilderTest {

    @Test
    void build_shouldReturnParsedInputWithCorrectData() {
        ParsedInputBuilder builder = new ParsedInputBuilder();
        Lawn lawn = new Lawn(5, 5);
        Mower mower1 = new Mower(new Coordinates(1, 2), Direction.N);
        List<Movement> movements1 = List.of(Movement.FORWARD, Movement.TURN_LEFT, Movement.TURN_RIGHT);
        Mower mower2 = new Mower(new Coordinates(3, 3), Direction.E);
        List<Movement> movements2 = List.of(Movement.FORWARD, Movement.FORWARD, Movement.TURN_LEFT);

        builder.withLawn(lawn);
        builder.withMower(mower1);
        builder.withMovements(movements1);
        builder.withMower(mower2);
        builder.withMovements(movements2);
        ParsedInput parsedInput = builder.build();

        assertNotNull(parsedInput);
        assertEquals(lawn, parsedInput.getLawn());
        assertEquals(2, parsedInput.getMowerInstructions().size());

        MowerInstructions instructions1 = parsedInput.getMowerInstructions().getFirst();
        assertEquals(mower1, instructions1.getMower());
        assertEquals(movements1, instructions1.getMovements());

        MowerInstructions instructions2 = parsedInput.getMowerInstructions().get(1);
        assertEquals(mower2, instructions2.getMower());
        assertEquals(movements2, instructions2.getMovements());
    }

    @Test
    void build_shouldThrowExceptionIfLawnIsNotSet() {
        ParsedInputBuilder builder = new ParsedInputBuilder();

        IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
        assertEquals("Lawn must be set before building.", exception.getMessage());
    }

    @Test
    void withMovements_shouldThrowExceptionIfMowerIsNotSet() {
        ParsedInputBuilder builder = new ParsedInputBuilder();
        List<Movement> movements = List.of(Movement.FORWARD);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> builder.withMovements(movements));
        assertEquals("Mower must be set before adding movements.", exception.getMessage());
    }

    @Test
    void build_shouldHandleSingleMowerAndMovementsCorrectly() {
        ParsedInputBuilder builder = new ParsedInputBuilder();
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Coordinates(0, 0), Direction.W);
        List<Movement> movements = List.of(Movement.FORWARD);

        builder.withLawn(lawn);
        builder.withMower(mower);
        builder.withMovements(movements);
        ParsedInput parsedInput = builder.build();

        assertNotNull(parsedInput);
        assertEquals(1, parsedInput.getMowerInstructions().size());
        assertEquals(mower, parsedInput.getMowerInstructions().getFirst().getMower());
        assertEquals(movements, parsedInput.getMowerInstructions().getFirst().getMovements());
    }

    @Test
    void build_shouldHandleMultipleMowersAndMovements() {
        ParsedInputBuilder builder = new ParsedInputBuilder();
        Lawn lawn = new Lawn(5, 5);
        builder.withLawn(lawn);

        Mower mower1 = new Mower(new Coordinates(1, 1), Direction.N);
        List<Movement> movements1 = List.of(Movement.FORWARD, Movement.TURN_RIGHT);
        builder.withMower(mower1);
        builder.withMovements(movements1);

        Mower mower2 = new Mower(new Coordinates(2, 2), Direction.E);
        List<Movement> movements2 = List.of(Movement.TURN_LEFT, Movement.FORWARD);
        builder.withMower(mower2);
        builder.withMovements(movements2);

        ParsedInput parsedInput = builder.build();

        assertNotNull(parsedInput);
        assertEquals(2, parsedInput.getMowerInstructions().size());

        MowerInstructions instructions1 = parsedInput.getMowerInstructions().getFirst();
        assertEquals(mower1, instructions1.getMower());
        assertEquals(movements1, instructions1.getMovements());

        MowerInstructions instructions2 = parsedInput.getMowerInstructions().get(1);
        assertEquals(mower2, instructions2.getMower());
        assertEquals(movements2, instructions2.getMovements());
    }
}