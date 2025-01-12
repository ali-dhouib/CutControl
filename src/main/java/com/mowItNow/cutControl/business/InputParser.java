package com.mowItNow.cutControl.business;

import com.mowItNow.cutControl.business.parser.builder.ParsedInputBuilder;
import com.mowItNow.cutControl.business.parser.factory.LineParser;
import com.mowItNow.cutControl.business.parser.factory.ParserFactory;
import com.mowItNow.cutControl.domain.Lawn;
import com.mowItNow.cutControl.domain.Mower;
import com.mowItNow.cutControl.domain.ParsedInput;
import com.mowItNow.cutControl.enums.Movement;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * The type Input parser.
 */
public class InputParser {
    /**
     * Parse parsed input.
     *
     * @param inputs the inputs
     * @return the parsed input
     */
    public static ParsedInput parse(List<String> inputs) {
        ParsedInputBuilder builder = new ParsedInputBuilder();

        IntStream.range(0, inputs.size())
                .forEachOrdered(i -> processLine(inputs.get(i), i, builder));

        return builder.build();
    }

    private static void processLine(String line, int lineIndex, ParsedInputBuilder builder) {
        LineParser<?> parser = ParserFactory.getLineParser(lineIndex);
        Object parsedObject = parser.parse(line);

        addParsedObjectToBuilder(parsedObject, builder);
    }

    private static void addParsedObjectToBuilder(Object parsedObject, ParsedInputBuilder builder) {
        switch (parsedObject) {
            case Lawn lawn -> builder.withLawn(lawn);
            case Mower mower -> builder.withMower(mower);
            case List<?> rawList -> {
                List<Movement> movements = cast(rawList);
                builder.withMovements(movements);
            }
            case null, default -> {
                assert parsedObject != null;
                throw new IllegalArgumentException("Unsupported parsed object type: " + parsedObject.getClass().getName());
            }
        }
    }

    private static List<Movement> cast(List<?> list) {
        @SuppressWarnings("unchecked")
        List<Movement> movements = (List<Movement>) list;
        return movements.stream()
                .filter(Objects::nonNull)
                .toList();
    }

}