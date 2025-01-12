package com.mowItNow.cutControl.business.reader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {
    @TempDir
    Path tempDir;

    @Test
    void readFile_shouldReturnFileContentsWhenFileExists() throws IOException {
        Path tempFile = tempDir.resolve("testFile.txt");
        List<String> expectedContent = List.of("Line 1", "Line 2", "Line 3");
        Files.write(tempFile, expectedContent);

        List<String> actualContent = readFile(tempFile.toString());

        assertEquals(expectedContent, actualContent, "File content should match the expected content.");
    }

    @Test
    void readFile_shouldThrowRuntimeExceptionWhenFileDoesNotExist() {
        String invalidFilePath = tempDir.resolve("nonExistentFile.txt").toString();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> readFile(invalidFilePath), "Reading a non-existent file should throw a RuntimeException.");
        assertEquals("Failed to read file: " + invalidFilePath, exception.getMessage().split("\n")[0]);
    }

    private List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }
}