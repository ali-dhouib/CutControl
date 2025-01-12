package com.mowItNow.cutControl.domain;

import java.util.Objects;

/**
 * The type Coordinates.
 */
public final class Coordinates {
    /**
     * The X.
     */
    int x;
    /**
     * The Y.
     */
    int y;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * To north.
     */
    public void toNorth() {
        this.y += 1;
    }

    /**
     * To east.
     */
    public void toEast() {
        this.x += 1;
    }

    /**
     * To south.
     */
    public void toSouth() {
        this.y -= 1;
    }

    /**
     * To west.
     */
    public void toWest() {
        this.x -= 1;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}