package com.mowItNow.cutControl.business.parser.factory;

import com.mowItNow.cutControl.domain.Lawn;

/**
 * The type Lawn parser.
 */
public class LawnParser implements LineParser<Lawn> {

    @Override
    public Lawn parse(String line) {
        if (line != null && !line.isEmpty()) {
            String[] parts = line.split(" ");

            if (parts.length >= 2) {
                try {
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    return new Lawn(x, y);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Les parties doivent être des nombres entiers valides.", e);
                }
            }
        }
        return null;
    }
}
