package main.day6;

import main.day5.PrintingJob;
import main.day5.PrintingRule;

import java.util.ArrayList;

public class Day6Part1Solver {
    Day6Parser parser;
    int currentGuardX;
    int currentGuardY;
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Day6Part1Solver(Day6Parser parser){
        this.parser = parser;

    }
    boolean guardIsPresent(){
        return currentGuardX>=0 && currentGuardX < parser.map.getFirst().size() && currentGuardY>=0 &&  currentGuardY < parser.map.size();
    }
    public int solve() {
        int answer = 0;
        // loop until guard lea🅱s
        while(guardIsPresent()){
            //move the guard
        }
        return answer;
    }
}
