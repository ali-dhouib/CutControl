package com.mowItNow.cutControl.business.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * The type File reader.
 */
public class FileReader {
    /**
     * Read file list.
     *
     * @param filePath the file path
     * @return the list
     */
    public static List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }
}