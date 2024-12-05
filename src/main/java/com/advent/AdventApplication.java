package com.advent;

import com.advent.Day2.AnalyzeList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);

        AnalyzeList analyzeList = new AnalyzeList();
        analyzeList.countSafePart2("day2.txt");

    }
}