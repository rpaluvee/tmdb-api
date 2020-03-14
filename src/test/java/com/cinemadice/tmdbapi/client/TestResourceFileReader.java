package com.cinemadice.tmdbapi.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

final class TestResourceFileReader {

    private static final ClassLoader CLASS_LOADER = TestResourceFileReader.class.getClassLoader();

    private TestResourceFileReader() {
    }

    static String readFileContents(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(
                    new File(Objects.requireNonNull(CLASS_LOADER.getResource(fileName)).getFile()).getAbsolutePath()
            )));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
