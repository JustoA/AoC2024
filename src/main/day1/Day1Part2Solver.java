package main.day1;

import java.util.ArrayList;

public class Day1Part2Solver {
    Day1Parser parser;
    public Day1Part2Solver(Day1Parser parser){
        this.parser = parser;
    }

    public int returnNumberOfInstancesInList(ArrayList<Integer> list, int number){
        int answer = 0;
        for (int i : list){
            if (number == i) answer++;
        }
        return answer;
    }

    public int solve() {
        int answer = 0;
        ArrayList<Integer> list1 = new ArrayList<>(parser.list1);
        ArrayList<Integer> list2 = new ArrayList<>(parser.list2);

        for (int i:  list1){
            answer += i*returnNumberOfInstancesInList(list2, i);
        }
        return answer;
    }
}
