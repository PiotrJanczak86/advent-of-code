package com.advent.dayTwo;

class Result {

    boolean safe;
    int number;

    public boolean isSafe() {
        return safe;
    }

    public int getNumber() {
        return number;
    }

    public Result(boolean status, int number) {
        this.safe = status;
        this.number = number;
    }

    public Result(boolean status){
        this.safe = status;
    }
}
