package main.day1;

import main.common.Toolbox;

import java.util.ArrayList;

public class Day1Part1Solver {
    Day1Parser parser;
    public Day1Part1Solver(Day1Parser parser) {
        this.parser = parser;
    }

    public int solve() {
        int answer = 0;
        // because we need the lists intact for part 2, we make some local copies so we can remove stuff
        ArrayList<Integer> list1 = new ArrayList<>(parser.list1);
        ArrayList<Integer> list2 = new ArrayList<>(parser.list2);
        while(!list1.isEmpty()){
            answer += Math.abs(Toolbox.getSmallestNumberAndRemoveIt(list1) - Toolbox.getSmallestNumberAndRemoveIt(list2));
        }
        return answer;
    }
}
