package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.domain.Coordinates;
import com.mowItNow.cutControl.domain.Lawn;
import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.enums.Direction;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    private final Validator validationService = new Validator();

    @Test
    void validateMowerPosition_shouldThrowExceptionIfPositionOutOfBounds() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Coordinates(6, 2), Direction.N);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                validationService.validateMowerPosition(mower, lawn)
        );
        assertEquals("Mower position is out of bounds.", exception.getMessage());
    }

    @Test
    void validateMovements_shouldThrowExceptionIfMovementsListIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                validationService.validateMovements(Collections.emptyList())
        );
        assertEquals("Movements list cannot be null or empty.", exception.getMessage());
    }
}