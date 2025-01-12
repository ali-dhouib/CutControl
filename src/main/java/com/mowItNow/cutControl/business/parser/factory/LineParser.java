package com.mowItNow.cutControl.business.parser.factory;

/**
 * The interface Line parser.
 *
 * @param <T> the type parameter
 */
public interface LineParser<T> {
    /**
     * Parse t.
     *
     * @param line the line
     * @return the t
     */
    T parse(String line);
}