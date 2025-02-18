package com.advent;

import com.advent.Day5.FileProcessor;
import com.advent.Day5.RulesChecker;
import com.advent.Day6.MapGuardRoute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);

        MapGuardRoute mapGuardRoute = new MapGuardRoute();
        mapGuardRoute.MapGuard(mapGuardRoute.loadFile("day6.txt"));

    }
}