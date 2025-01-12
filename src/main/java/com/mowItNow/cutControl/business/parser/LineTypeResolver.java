package com.mowItNow.cutControl.business.parser;

import com.mowItNow.cutControl.enums.Type;

/**
 * The type Line type resolver.
 */
public class LineTypeResolver {
    /**
     * Resolve type.
     *
     * @param lineIndex the line index
     * @return the type
     */
    public static Type resolve(final int lineIndex) {
        if (lineIndex == 0) {
            return Type.LAWN;
        } else if (lineIndex % 2 == 1) {
            return Type.MOWER;
        } else {
            return Type.MOVEMENTS;
        }
    }
}