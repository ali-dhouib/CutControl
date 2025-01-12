package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.domain.Coordinates;
import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.domain.MowerInstructions;
import com.mowItNow.cutControl.enums.Direction;
import com.mowItNow.cutControl.enums.Movement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class ExecutorTest {
    private Executor executor;
    private Mower mower;

    @BeforeEach
    void setUp() {
        executor = new Executor();
        mower = new Mower(new Coordinates(1, 1), Direction.N);
        mower = Mockito.mock(Mower.class);
    }

    @Test
    void executeInstructions_shouldCallMovementMethodsCorrectly() {
        MowerInstructions instructions = new MowerInstructions(mower, List.of(Movement.FORWARD, Movement.FORWARD, Movement.TURN_LEFT, Movement.TURN_RIGHT));
        executor.execute(instructions);

        Mockito.verify(mower, Mockito.times(2)).goForward();
        Mockito.verify(mower, Mockito.times(1)).turnLeft();
        Mockito.verify(mower, Mockito.times(1)).turnRight();
    }
}