package main.day2;

import java.util.ArrayList;

public class Day2Part1Solver {
    ArrayList<ArrayList<Integer>> measurements;
    public Day2Part1Solver(Day2Parser parser) {
        this.measurements = parser.measurements;
    }
    boolean checkDifferences(ArrayList<Integer> levels){
        ArrayList<Integer> levelsCopy = new ArrayList<>(levels);
        int recent = levelsCopy.getFirst();
        levelsCopy.removeFirst();
        for (int i : levelsCopy){
            int difference = Math.abs(recent - i);
            if( difference > 3 || difference < 1){
                return false;
            }
            recent = i;
        }
        return true;
    }

    boolean checkMonotonic(ArrayList<Integer> levels){
        ArrayList<Integer> levelsCopy = new ArrayList<>(levels);
        int first = levelsCopy.getFirst();
        levelsCopy.removeFirst();
        int second = levelsCopy.getFirst();
        levelsCopy.removeFirst();
        boolean ascending = first < second;
        for (int i : levelsCopy){
            if (ascending != (second < i)) return false;
            second = i;
            }
        return true;
    }
    public int solve(){
        int answer = 0;
        for(ArrayList<Integer> measurement : measurements){
            if (checkDifferences(new ArrayList<>(measurement)) && checkMonotonic(new ArrayList<>(measurement))){
                answer++;
                //System.out.println("Measurement " + measurement + " is safe");
            }
        }

        return answer;
    }
}
