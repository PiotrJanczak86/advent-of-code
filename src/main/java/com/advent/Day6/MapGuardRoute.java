package com.advent.Day6;

import com.advent.Day2.AnalyzeList;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MapGuardRoute {

    public static List<List<String>> loadFile(String fileName) {
        ClassLoader classLoader = AnalyzeList.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        List<List<String>> result = new ArrayList<>();

        if (resource != null) {
            try (Scanner scanner = new Scanner(new File(resource.getFile()))) {
                while (scanner.hasNextLine()) {
                    List<String> row = new ArrayList<>();
                    String line = scanner.nextLine();

                    for (char ch : line.toCharArray()) {
                        row.add(String.valueOf(ch));
                    }

                    result.add(row);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File not found in resources!");
        }

        return result;
    }

    public void MapGuard(List<List<String>> map) {
        List<String> startingDirection = new ArrayList<>(Arrays.asList("<", "^", ">", "v"));
        List<Integer> moveX = new ArrayList<>(Arrays.asList(-1, 0, 1, 0));
        List<Integer> moveY = new ArrayList<>(Arrays.asList(0, -1, 0, 1));
        int x = 0;
        int y = 0;
        int direction = 0;

        search:
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < map.size(); i++) {
                if (map.get(i).contains(startingDirection.get(d))) {
                    x = map.get(i).indexOf(startingDirection.get(d));
                    y = i;
                    direction = d;
                    map.get(y).set(x, "X");
                    break search;
                }
            }
        }

        boolean keepGoing = true;
        for (int i = 0; keepGoing; i++) {
            if ((x == 0 && direction == 0) || (y == 0 && direction == 1) || (x == map.get(0).size() - 1 && direction == 2) || (y == map.size() - 1 && direction == 3)){
                keepGoing = false;
                break;
            }

            if (map.get(y + moveY.get(direction)).get(x + moveX.get(direction)).equals("#")) {
                if (direction < 3) direction++;
                else direction = 0;
            }

            map.get(y + moveY.get(direction)).set((x + moveX.get(direction)), "X");
            x = x + moveX.get(direction);
            y = y + moveY.get(direction);

        }

        int count = 0;
        for (List<String> row : map) {
            for (String element : row) {
                if (element.equals("X")) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}