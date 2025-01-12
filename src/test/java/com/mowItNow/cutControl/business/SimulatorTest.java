package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.domain.*;
import com.mowItNow.cutControl.enums.Direction;
import com.mowItNow.cutControl.enums.Movement;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimulatorTest {
    private final Simulator simulationService = new Simulator();

    @Test
    void simulate_shouldReturnFinalPositionAndOrientation() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Coordinates(1, 2), Direction.N);

        var movements = Arrays.asList(Movement.TURN_LEFT, Movement.FORWARD, Movement.TURN_LEFT, Movement.FORWARD, Movement.TURN_LEFT, Movement.FORWARD, Movement.TURN_LEFT, Movement.FORWARD, Movement.FORWARD);

        ParsedInput parsedInput = new ParsedInput(lawn,
                List.of(new MowerInstructions(mower, movements)));

        List<Mower> result = simulationService.simulate(parsedInput);

        assertEquals(1, result.getFirst().getPosition().getX());
        assertEquals(3, result.getFirst().getPosition().getY());
        assertEquals(Direction.N, result.getFirst().getDirection());
    }

    @Test
    void simulate_shouldThrowExceptionForInvalidMowerPosition() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Coordinates(6, 2), Direction.N);

        ParsedInput parsedInput = new ParsedInput(lawn,
                List.of(new MowerInstructions(mower, List.of(Movement.FORWARD))));

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                simulationService.simulate(parsedInput)
        );
        assertEquals("Mower position is out of bounds.", exception.getMessage());
    }
}