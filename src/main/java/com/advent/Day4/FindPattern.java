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
                    for (int i = 0; i < line.length(); i++) {
                        row.add(line.substring(i, i + 1));
                    }
                    result.add(row);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else System.out.println("File not found in resources!");
        return result;
    }

    public static List<List<String>> rotate90DegreesRight(List<List<String>> original) {
        int rows = original.size();
        int cols = original.get(0).size();

        List<List<String>> rotated = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            rotated.add(new ArrayList<>());
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated.get(j).add(0, original.get(i).get(j));
            }
        }
        return rotated;
    }

    public void countXMAS(List<List<String>> list) {
        int count = 0;
        for (int rotate = 0; rotate < 4; rotate++) {
            if (rotate > 0) list = rotate90DegreesRight(list);
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(0).size() - 3; j++) {
                    if (list.get(i).get(j).equals("X") && list.get(i).get(j + 1).equals("M") && list.get(i).get(j + 2).equals("A") && list.get(i).get(j + 3).equals("S"))
                        count++;
                    if (i < list.size() - 3) {
                        if (list.get(i).get(j).equals("X") && list.get(i + 1).get(j + 1).equals("M") && list.get(i + 2).get(j + 2).equals("A") && list.get(i + 3).get(j + 3).equals("S"))
                            count++;
                    }
                }
            }
            System.out.println(list);
        }
        System.out.println(count);
    }

    public void countCrossedMAS(List<List<String>> list){
        int count = 0;
        for (int i=0;i<list.size()-2;i++){
            for(int j=0;j<list.get(i).size()-2;j++){
                if(list.get(i).get(j).equals("M") && list.get(i+1).get(j+1).equals("A") && list.get(i+2).get(j+2).equals("S") &&
                        list.get(i+2).get(j).equals("M") && list.get(i).get(j+2).equals("S")) count++;
                else if(list.get(i).get(j).equals("M") && list.get(i+1).get(j+1).equals("A") && list.get(i+2).get(j+2).equals("S") &&
                        list.get(i+2).get(j).equals("S") && list.get(i).get(j+2).equals("M")) count++;
                 else if(list.get(i).get(j).equals("S") && list.get(i+1).get(j+1).equals("A") && list.get(i+2).get(j+2).equals("M") &&
                        list.get(i+2).get(j).equals("M") && list.get(i).get(j+2).equals("S")) count++;
                 else if(list.get(i).get(j).equals("S") && list.get(i+1).get(j+1).equals("A") && list.get(i+2).get(j+2).equals("M") &&
                        list.get(i+2).get(j).equals("S") && list.get(i).get(j+2).equals("M")) count++;
            }
        }
        System.out.println(count);
    }
}