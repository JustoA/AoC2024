package main.day7;


import java.util.concurrent.atomic.AtomicLong;

public class Day7Part1Solver {
    Day7Parser parser;

    public Day7Part1Solver(Day7Parser parser){
        this.parser = parser;
    }

    public long solve() {
       AtomicLong answer = new AtomicLong(0);
        parser.measurements.parallelStream().forEach(measurement -> {
            if(measurement.isPossible()) {answer.getAndAdd(measurement.getTestValue());}
        });
       return answer.get();
    }
}
