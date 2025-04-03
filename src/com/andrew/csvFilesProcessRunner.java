package com.andrew;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class csvFilesProcessRunner {
    public static void main(String[] args) {
        Path firstFilePath = Path.of("resources", "items-price.csv");
        Path secondFilePath = Path.of("resources", "items-name.csv");
        Path resultPath = Path.of("resources", "result.csv");
        Path errorsPath = Path.of("resources", "errors.csv");

        try {
            Map<String, String> priceMap = csvReadHelper.readIdAndSecondValueCSV(firstFilePath);
            Map<String, String> nameMap = csvReadHelper.readIdAndSecondValueCSV(secondFilePath);
            mapsCompareHelper.compareMaps(resultPath, errorsPath, priceMap, nameMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
