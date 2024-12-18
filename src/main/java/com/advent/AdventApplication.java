package com.advent;

import com.advent.Day5.FileProcessor;
import com.advent.Day5.RulesChecker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);

        FileProcessor fileProcessor = new FileProcessor();
        RulesChecker rulesChecker = new RulesChecker();

        System.out.println(rulesChecker.checkPartTwo(fileProcessor.loadFile("day5.txt")));
    }
}