package com.mowItNow.cutControl.business.parser.builder;

import com.mowItNow.cutControl.domain.Lawn;
import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.domain.MowerInstructions;
import com.mowItNow.cutControl.domain.ParsedInput;
import com.mowItNow.cutControl.enums.Movement;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Parsed input builder.
 */
public class ParsedInputBuilder {
    private Lawn lawn;
    private Mower mower;
    private List<Movement> movements;

    private final List<MowerInstructions> mowerInstructions = new ArrayList<>();

    /**
     * With lawn.
     *
     * @param lawn the lawn
     */
    public void withLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    /**
     * With mower.
     *
     * @param mower the mower
     */
    public void withMower(Mower mower) {
        finalizeCurrentInstruction();
        this.mower = mower;
    }

    /**
     * With movements.
     *
     * @param movements the movements
     */
    public void withMovements(List<Movement> movements) {
        if (mower == null) {
            throw new IllegalStateException("Mower must be set before adding movements.");
        }
        this.movements = movements;
        finalizeCurrentInstruction();
    }

    /**
     * Build parsed input.
     *
     * @return the parsed input
     */
    public ParsedInput build() {
        finalizeCurrentInstruction();
        if (lawn == null) {
            throw new IllegalStateException("Lawn must be set before building.");
        }
        return new ParsedInput(lawn, mowerInstructions);
    }

    private void finalizeCurrentInstruction() {
        if (mower != null && movements != null) {
            mowerInstructions.add(new MowerInstructions(mower, movements));
            mower = null;
            movements = null;
        }
    }
}
