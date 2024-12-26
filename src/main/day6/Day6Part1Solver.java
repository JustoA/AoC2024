package main.day6;

public class Day6Part1Solver {
    Day6Parser parser;

    public Day6Part1Solver(Day6Parser parser){
        this.parser = parser;
    }

    public int solve() {
        MetalGearSolid mgs = new MetalGearSolid(parser.map, parser.currentGuardPosX, parser.currentGuardPosY);
        // loop until guard lea🅱s
        while (mgs.guardIsPresent()) {
            //move the guard
            mgs.step();
        }
        return mgs.countX();
    }
}
