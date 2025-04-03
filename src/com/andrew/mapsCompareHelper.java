package com.andrew;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class mapsCompareHelper {

    public static void compareMaps(Path resultPath, Path errorsPath,
                                   Map<String, String> priceMap,
                                   Map<String, String> nameMap) throws IOException {
        
        StringBuilder resultStrBuilder = new StringBuilder();
        StringBuilder errorsStrBuilder = new StringBuilder();
        resultStrBuilder.append("ID,NAME, Price").append(System.lineSeparator());
        errorsStrBuilder.append("ID").append(System.lineSeparator());
        for (String id : priceMap.keySet()) {
            String name = nameMap.get(id);
            String price = priceMap.get(id);
            if (name != null && price != null) {
                resultStrBuilder.append(id).append(",")
                        .append(name).append(",")
                        .append(price).append(System.lineSeparator());
            } else {
                errorsStrBuilder.append(id).append(System.lineSeparator());
            }
        }
        Files.writeString(resultPath, resultStrBuilder);
        Files.writeString(errorsPath, errorsStrBuilder);
    }
}
