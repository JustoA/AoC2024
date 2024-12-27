package main.day8;
public class Day8Part1Solver {
    Day8Parser parser;
    BrainwashMap theSituation;
    public Day8Part1Solver(Day8Parser parser){
        this.parser = parser;
        theSituation = parser.theSituation;
    }

    public int solve() {
        return theSituation.calculateAntinodes();
    }
}
