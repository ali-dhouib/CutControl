package com.mowItNow.cutControl.business.parser.factory;

import com.mowItNow.cutControl.enums.Movement;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Movements parser.
 */
public class MovementsParser implements LineParser<List<Movement>> {

    @Override
    public List<Movement> parse(String line) {
        if (line != null && !line.isEmpty()) {
            List<Movement> movements = new ArrayList<>();
            char[] chars = line.toCharArray();

            for (char c : chars) {
                Movement movement = Movement.valueOf(c);
                if (movement != Movement.DEFAULT) {
                    movements.add(movement);
                }
            }
            return movements;
        }
        return null;
    }
}