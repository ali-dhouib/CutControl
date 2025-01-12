package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.domain.Mower;

import java.util.List;

/**
 * The type Output parser.
 */
public class OutputParser {
    /**
     * Parse string.
     *
     * @param result the result
     * @return the string
     */
    public static String parse(List<Mower> result) {
        StringBuilder builder = new StringBuilder();

        for (Mower mower : result) {
            builder.append(mower.toString()).append(' ');
        }
        return builder.toString().trim();
    }
}
