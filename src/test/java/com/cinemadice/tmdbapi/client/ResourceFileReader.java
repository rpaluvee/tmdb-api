package com.cinemadice.tmdbapi.client;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

final class ResourceFileReader {

    private static final ClassLoader CLASS_LOADER = ResourceFileReader.class.getClassLoader();

    private ResourceFileReader() {
    }

    static String readJson(String fileName) {
        if (CLASS_LOADER.getResource(fileName) == null) {
            throw new RuntimeException("Resource does not exist: " + fileName);
        }
        String filePath = new File(CLASS_LOADER.getResource(fileName).getFile()).getAbsolutePath();
        StringBuilder json = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(line -> json.append(line.trim()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json.toString();
    }

}
