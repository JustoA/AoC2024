package main.day2;
import java.util.ArrayList;

public class Day2Part2Solver extends Day2Part1Solver{
    public Day2Part2Solver(Day2Parser parser) {
        super(parser);
    }
    @Override
    public int solve(){
        int answer = 0;
        for(ArrayList<Integer> measurement : measurements){
            if (checkDifferences(measurement) && checkMonotonic(measurement)){
                answer++;
                //System.out.println("Measurement " + measurement + " is safe");
            }
            else{
                // its stupid but.....
                for(int i = 0; i<measurement.size();i++){
                    ArrayList<Integer> newMeasurement = new ArrayList<>(measurement);
                    newMeasurement.remove(i);
                    if (checkDifferences(newMeasurement) && checkMonotonic(newMeasurement)){
                        answer++;
                        //System.out.println("Measurement " + measurement + " is safe with modification");
                        break;
                    }
                }

            }
        }

        return answer;
    }
}
