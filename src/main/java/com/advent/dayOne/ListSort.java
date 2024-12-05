package com.advent.dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class ListSort {

    public void getNumber() {

        int result = 0;
        int similarity = 0;
        ClassLoader classLoader = ListSort.class.getClassLoader();
        URL resource = classLoader.getResource("day1.txt");
        boolean isItFirst = true;
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        if (resource != null) {
            try (Scanner scanner = new Scanner(new File(resource.getFile()))) {

                while (scanner.hasNextInt()) {
                    int number = scanner.nextInt();

                    if (isItFirst) {
                        firstList.add(number);
                        isItFirst = false;
                    } else {
                        secondList.add(number);
                        isItFirst = true;
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File not found in resources!");
        }

        Collections.sort(firstList);
        Collections.sort(secondList);

        for (int i = 0; i < firstList.size(); i++) {
            result = result + Math.abs(firstList.get(i) - secondList.get(i));
        }
        System.out.println(firstList.size());
        System.out.println(secondList.size());
        System.out.println(firstList);
        System.out.println(secondList);

        System.out.println(result);

        int number;
        int count;
        for (int i = 0; i < firstList.size(); i++) {
            number = firstList.get(i);
            count = 0;

            for (int j = 0; j < firstList.size(); j++) {
                if (secondList.get(j) == number) {
                    count++;
                }
            }
            similarity += number * count;
        }
        System.out.println(similarity);
    }
}