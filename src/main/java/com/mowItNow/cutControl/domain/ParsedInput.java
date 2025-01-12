package com.mowItNow.cutControl.domain;

import java.util.List;

/**
 * The type Parsed input.
 */
public final class ParsedInput {
    /**
     * The Lawn.
     */
    Lawn lawn;
    /**
     * The Mower instructions.
     */
    List<MowerInstructions> mowerInstructions;

    /**
     * Instantiates a new Parsed input.
     *
     * @param lawn              the lawn
     * @param mowerInstructions the mower instructions
     */
    public ParsedInput(Lawn lawn, List<MowerInstructions> mowerInstructions) {
        this.lawn = lawn;
        this.mowerInstructions = mowerInstructions;
    }

    /**
     * Gets lawn.
     *
     * @return the lawn
     */
    public Lawn getLawn() {
        return lawn;
    }

    /**
     * Gets mower instructions.
     *
     * @return the mower instructions
     */
    public List<MowerInstructions> getMowerInstructions() {
        return this.mowerInstructions;
    }

    @Override
    public String toString() {
        return lawn.toString() + mowerInstructions.toString();
    }
}
