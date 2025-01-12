package com.mowItNow.cutControl.business.parser.factory;

import com.mowItNow.cutControl.domain.Coordinates;
import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.enums.Direction;

/**
 * The type Mower parser.
 */
public class MowerParser implements LineParser<Mower> {

    @Override
    public Mower parse(String line) {
        if (line != null && !line.isEmpty()) {
            String[] parts = line.split(" ");

            if (parts.length >= 3) {
                try {
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    Direction direction = Direction.valueOf(parts[2].toUpperCase());
                    return new Mower(new Coordinates(x, y), direction);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Les coordonnées doivent être des nombres entiers valides.", e);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("La direction doit correspondre à une valeur valide de l'énumération Direction.", e);
                }
            }
        }
        return null;
    }
}