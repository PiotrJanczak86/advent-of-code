package com.advent.Day5;

import java.util.List;

public class ResultFile {
    private final List<List<Integer>> rules;
    private final List<List<Integer>> cases;

    public List<List<Integer>> getRules() {
        return rules;
    }

    public List<List<Integer>> getCases() {
        return cases;
    }

    public ResultFile(List<List<Integer>> rules, List<List<Integer>> cases) {
        this.rules = rules;
        this.cases = cases;
    }
}