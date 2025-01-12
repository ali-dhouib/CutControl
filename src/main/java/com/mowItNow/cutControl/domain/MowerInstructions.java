package com.mowItNow.cutControl.domain;

import com.mowItNow.cutControl.enums.Movement;

import java.util.List;
import java.util.Objects;

/**
 * The type Mower instructions.
 */
public final class MowerInstructions {
    /**
     * The Mower.
     */
    Mower mower;
    /**
     * The Movements.
     */
    List<Movement> movements;

    /**
     * Instantiates a new Mower instructions.
     *
     * @param mower     the mower
     * @param movements the movements
     */
    public MowerInstructions(Mower mower, List<Movement> movements) {
        this.mower = mower;
        this.movements = movements;
    }

    /**
     * Gets mower.
     *
     * @return the mower
     */
    public Mower getMower() {
        return mower;
    }

    /**
     * Gets movements.
     *
     * @return the movements
     */
    public List<Movement> getMovements() {
        return movements;
    }

    @Override
    public String toString() {
        return mower + " " + movements;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MowerInstructions that = (MowerInstructions) o;
        return Objects.equals(mower, that.mower) && Objects.equals(movements, that.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mower, movements);
    }
}