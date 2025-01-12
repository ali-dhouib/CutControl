package com.mowItNow.cutControl.enums;

/**
 * The enum Movement.
 */
public enum Movement {
    /**
     * Forward movement.
     */
    FORWARD,
    /**
     * Turn left movement.
     */
    TURN_LEFT,
    /**
     * Turn right movement.
     */
    TURN_RIGHT,
    /**
     * Default movement.
     */
    DEFAULT,
    ;

    /**
     * Value of movement.
     *
     * @param c the c
     * @return the movement
     */
    public static Movement valueOf(char c) {
        return switch (c) {
            case 'A' -> FORWARD;
            case 'G' -> TURN_LEFT;
            case 'D' -> TURN_RIGHT;
            default -> DEFAULT;
        };
    }


}