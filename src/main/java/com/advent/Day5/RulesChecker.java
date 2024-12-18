package com.advent.Day5;

import java.util.List;

public class RulesChecker {

    public int checkPartOne(ResultFile resultFile) {
        List<List<Integer>> rules = resultFile.getRules();
        List<List<Integer>> cases = resultFile.getCases();
        int counter = 0;

        for (List<Integer> aCase : cases) {
            boolean allGood = true;
            for (List<Integer> rule : rules) {
                if (aCase.contains(rule.get(0)) && aCase.contains(rule.get(1))) {
                    if (aCase.indexOf(rule.get(0)) > aCase.indexOf(rule.get(1))) {
                        allGood = false;
                        break;
                    }
                }
            }
            if (allGood) counter += aCase.get(aCase.size() / 2);
        }
        return counter;
    }

    public int checkPartTwo(ResultFile resultFile) {

        List<List<Integer>> rules = resultFile.getRules();
        List<List<Integer>> cases = resultFile.getCases();
        int counter = 0;

        for (List<Integer> aCase : cases) {
            boolean sortWasNeeded = false;
            boolean sortingNotDone = true;
            boolean doAnotherLoop = true;

            while (sortingNotDone) {
                boolean changesMadeInThisIteration = false; // Track if any changes were made

                // Iterate over the rules
                for (List<Integer> rule : rules) {
                    if (aCase.contains(rule.get(0)) && aCase.contains(rule.get(1))) {
                        if (aCase.indexOf(rule.get(0)) > aCase.indexOf(rule.get(1))) {
                            // A change is made, set the flag to true
                            sortWasNeeded = true;
                            changesMadeInThisIteration = true;

                            aCase.remove(rule.get(1));
                            aCase.add(aCase.indexOf(rule.get(0)) + 1, rule.get(1));
                            break; // Exit the rule loop to start over
                        }
                    }
                }

                // If no changes were made during this pass, set sortingNotDone to false
                if (!changesMadeInThisIteration) {
                    sortingNotDone = false;
                }
            }

            // If sorting was needed, add the middle element to the counter
            if (sortWasNeeded) {
                counter += aCase.get(aCase.size() / 2);
            }
        }

        return counter;
    }
}