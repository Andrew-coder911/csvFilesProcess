package com.andrew;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class csvReadHelper {

    public static Map<String, String> readIdAndSecondValueCSV(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        Map<String, String> idAndSecondValueMap = new HashMap<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            String id = parts[0];
            String secondValue = null;
            if (parts.length >= 2) {
                secondValue = parts[1].trim();
            }
            idAndSecondValueMap.put(id, secondValue);
        }
        return idAndSecondValueMap;
    }
}
