package com.advent;

import com.advent.Day2.AnalyzeList;
import com.advent.Day3.FindRegex;
import com.advent.Day4.FindPattern;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);

        FindPattern findPattern = new FindPattern();
        System.out.println(findPattern.loadFile("day4.txt"));

    }
}