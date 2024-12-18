package com.advent.Day5;

import java.io.*;
import java.util.*;

public class FileProcessor {

    public ResultFile loadFile(String fileName) {

        // Lists to store results
        List<List<Integer>> rules = new ArrayList<>();
        List<List<Integer>> cases = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(FileProcessor.class.getClassLoader().getResourceAsStream(fileName))
                ))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Check if the line contains a pair (with "|")
                if (line.contains("|")) {
                    // Split the line into two integers
                    String[] parts = line.split("\\|");
                    List<Integer> pair = Arrays.asList(
                            Integer.parseInt(parts[0].trim()),
                            Integer.parseInt(parts[1].trim())
                    );
                    rules.add(pair);
                } else if (line.contains(",")) {
                    // Split the line into a collection of integers (with ",")
                    String[] parts = line.split(",");
                    List<Integer> collection = new ArrayList<>();
                    for (String part : parts) {
                        collection.add(Integer.parseInt(part.trim()));
                    }
                    cases.add(collection);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResultFile(rules, cases);
    }
}
