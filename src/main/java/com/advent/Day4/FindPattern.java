package com.advent.Day4;

import com.advent.Day2.AnalyzeList;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPattern {
    public List<List<String>> loadFile(String fileName) {

        ClassLoader classLoader = AnalyzeList.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        List<List<String>> result = new ArrayList<>();

        if (resource != null) {
            try (Scanner scanner = new Scanner(new File(resource.getFile()))) {
                while (scanner.hasNextLine()) {
                    List<String> row = new ArrayList<>();
                    String line = scanner.nextLine();
                    Scanner lineScanner = new Scanner(line);

                    while (lineScanner.hasNext()) {
                        row.add(lineScanner.next());
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

    public void FindPattern(List<List<String>> list){
        int count = 0;
        for(int i =0; i< list.get(0).size(); i++){

        }
    }

}
