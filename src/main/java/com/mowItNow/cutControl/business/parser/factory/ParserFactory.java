package com.mowItNow.cutControl.business.parser.factory;

import com.mowItNow.cutControl.business.parser.LineTypeResolver;
import com.mowItNow.cutControl.enums.Type;

/**
 * The type Parser factory.
 */
public class ParserFactory {

    /**
     * Gets line parser.
     *
     * @param lineIndex the line index
     * @return the line parser
     */
    public static LineParser<?> getLineParser(int lineIndex) {
        Type type = LineTypeResolver.resolve(lineIndex);
        return switch (type) {
            case LAWN -> new LawnParser();
            case MOWER -> new MowerParser();
            case MOVEMENTS -> new MovementsParser();
        };
    }
}