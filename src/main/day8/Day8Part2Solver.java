package main.day8;

public class Day8Part2Solver {
    Day8Parser parser;
    BrainwashMap theSituation;
    public Day8Part2Solver(Day8Parser parser){
        this.parser = parser;
        theSituation = parser.theSituation;
    }

    public long solve() {
       return theSituation.calculateAntinodesWithResonance();
    }
}
