package com.advent;

import com.advent.Day2.AnalyzeList;
import com.advent.Day3.FindRegex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);

        FindRegex findRegex = new FindRegex();
        findRegex.find("day3.txt");

    }
}