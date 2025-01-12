package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.domain.MowerInstructions;

/**
 * The type Executor.
 */
public class Executor {

    /**
     * Execute.
     *
     * @param instructions the instructions
     */
    public void execute(MowerInstructions instructions) {
        instructions.getMovements().forEach(movement -> {
            switch (movement) {
                case FORWARD -> instructions.getMower().goForward();
                case TURN_LEFT -> instructions.getMower().turnLeft();
                case TURN_RIGHT -> instructions.getMower().turnRight();
            }
        });
    }
}