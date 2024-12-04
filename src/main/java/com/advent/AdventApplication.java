package com.advent;

import com.advent.dayOne.ListSort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);

        ListSort listSort = new ListSort();
        listSort.getNumber();
    }
}