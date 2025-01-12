package com.mowItNow.cutControl.domain;

import com.mowItNow.cutControl.enums.Direction;

import java.util.Objects;

/**
 * The type Mower.
 */
public class Mower {
    /**
     * The Position.
     */
    Coordinates position;
    /**
     * The Direction.
     */
    Direction direction;

    /**
     * Gets position.
     *
     * @return the position
     */
    public Coordinates getPosition() {
        return position;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Instantiates a new Mower.
     *
     * @param coordinates the coordinates
     * @param direction   the direction
     */
    public Mower(Coordinates coordinates, Direction direction) {
        this.position = coordinates;
        this.direction = direction;
    }

    /**
     * Go forward.
     */
    public void goForward() {
        switch (this.direction) {
            case N -> this.position.toNorth();
            case E -> this.position.toEast();
            case S -> this.position.toSouth();
            case W -> this.position.toWest();
        }
    }

    /**
     * Turn left.
     */
    public void turnLeft() {
        switch (this.direction) {
            case N -> this.direction = Direction.W;
            case E -> this.direction = Direction.N;
            case S -> this.direction = Direction.E;
            case W -> this.direction = Direction.S;
        }
    }

    /**
     * Turn right.
     */
    public void turnRight() {
        switch (this.direction) {
            case N -> this.direction = Direction.E;
            case E -> this.direction = Direction.S;
            case S -> this.direction = Direction.W;
            case W -> this.direction = Direction.N;
        }
    }

    @Override
    public String toString() {
        return position +
                " " + direction;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(position, mower.position) && direction == mower.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
