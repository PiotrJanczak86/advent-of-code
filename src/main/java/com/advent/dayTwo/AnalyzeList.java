package com.advent.dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AnalyzeList {
    public List<List<Integer>> loadFile(String fileName) {

        ClassLoader classLoader = AnalyzeList.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        List<List<Integer>> result = new ArrayList<>();

        if (resource != null) {
            try (Scanner scanner = new Scanner(new File(resource.getFile()))) {
                while (scanner.hasNextLine()) {
                    List<Integer> row = new ArrayList<>();
                    String line = scanner.nextLine();
                    Scanner lineScanner = new Scanner(line);

                    while (lineScanner.hasNextInt()) {
                        row.add(lineScanner.nextInt());
                    }
                    lineScanner.close();
                    result.add(row);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else System.out.println("File not found in resources!");
        return result;
    }

    public boolean safeCheck(List<Integer> list) {
        if (Objects.equals(list.get(0), list.get(1))) {
            return false;
        }

        if (list.get(0) < list.get(1)) {
            for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) >= list.get(i + 1) || Math.abs(list.get(i) - list.get(i + 1)) > 3) {
                        return false;
                    }
            }
        }

        if (list.get(0) > list.get(1)) {
            for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) <= list.get(i + 1) || Math.abs(list.get(i) - list.get(i + 1)) > 3) {
                        return false;
                    }
            }
        }
        return true;
    }

    public void countSafePart1(String fileName){
        int safeCounter = 0;
        List<List<Integer>> input = loadFile(fileName);
        for (List<Integer> row : input){
            if(safeCheck(row)) safeCounter++;
        }
        System.out.println("Part 1 safe entries: " + safeCounter);
    }
}