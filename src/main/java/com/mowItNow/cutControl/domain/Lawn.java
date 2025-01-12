package com.mowItNow.cutControl.domain;

import java.util.Objects;

/**
 * The type Lawn.
 */
public final class Lawn {
    /**
     * The Bounds.
     */
    Coordinates bounds;

    /**
     * Gets bounds.
     *
     * @return the bounds
     */
    public Coordinates getBounds() {
        return bounds;
    }

    /**
     * Instantiates a new Lawn.
     *
     * @param x the x
     * @param y the y
     */
    public Lawn(int x, int y) {
        bounds = new Coordinates(x, y);
    }

    @Override
    public String toString() {
        return bounds.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lawn lawn = (Lawn) o;
        return Objects.equals(bounds, lawn.bounds);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bounds);
    }
}
