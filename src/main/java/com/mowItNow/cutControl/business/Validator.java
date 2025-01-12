package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.domain.Coordinates;
import com.mowItNow.cutControl.domain.Lawn;
import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.enums.Movement;

import java.util.List;

/**
 * The type Validator.
 */
public class Validator {
    /**
     * Validate mower position.
     *
     * @param mower the mower
     * @param lawn  the lawn
     */
    public void validateMowerPosition(Mower mower, Lawn lawn) {
        if (isOutOfBounds(mower.getPosition(), lawn.getBounds())) {
            throw new IllegalArgumentException("Mower position is out of bounds.");
        }
    }

    /**
     * Validate movements.
     *
     * @param movements the movements
     */
    public void validateMovements(List<Movement> movements) {
        if (movements == null || movements.isEmpty()) {
            throw new IllegalArgumentException("Movements list cannot be null or empty.");
        }
    }

    /**
     * Check If Is out of bounds boolean.
     *
     * @param a the coordinate to check
     * @param b the bounds coordinate
     * @return the boolean
     */
    public boolean isOutOfBounds(Coordinates a, Coordinates b) {
        return a.getX() < 0 || a.getX() > b.getX() || a.getY() < 0 || a.getY() > b.getY();
    }
}
