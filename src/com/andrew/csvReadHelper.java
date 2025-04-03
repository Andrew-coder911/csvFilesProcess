package com.andrew;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class csvReadHelper {

    public static Map<String, String> readIdPriceCsv(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        Map<String, String> idPriceMap = new HashMap<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            String id = parts[0].trim();
            String price = null;
            if (parts.length >= 2) {
                price = parts[1].trim();
            }
            idPriceMap.put(id, price);
        }
        return idPriceMap;
    }

    public static Map<String, String> readIdNameCsv(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        Map<String, String> idNameMap = new HashMap<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            String id = parts[0];
            String name = null;
            if (parts.length >= 2) {
                name = parts[1].trim();
            }
            idNameMap.put(id, name);
        }
        return idNameMap;
    }

}
