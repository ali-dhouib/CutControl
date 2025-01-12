package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.domain.MowerInstructions;
import com.mowItNow.cutControl.domain.ParsedInput;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Simulator.
 */
public class Simulator {
    /**
     * The Executor.
     */
    Executor executor;
    /**
     * The Validator.
     */
    Validator validator;

    /**
     * Instantiates a new Simulator.
     */
    public Simulator() {
        this.executor = new Executor();
        this.validator = new Validator();
    }

    /**
     * Simulate list.
     *
     * @param input the input
     * @return the list
     */
    public List<Mower> simulate(ParsedInput input) {
        List<Mower> result = new ArrayList<>();

        input.getMowerInstructions()
                .forEach(instr -> {
                    this.validator.validateMowerPosition(instr.getMower(), input.getLawn());
                    this.validator.validateMovements(instr.getMovements());
                    this.executor.execute(instr);
                });

        input.getMowerInstructions().stream().map(MowerInstructions::getMower).forEach(result::add);
        return result;
    }
}