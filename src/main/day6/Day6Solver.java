package main.day6;

public class Day6Solver {

    public static final String FILEPATH = "src/main/resources/inputs/day6-real.txt";

    public static void main(String[] args) {
        Day6Parser parser = new Day6Parser(FILEPATH);
        System.out.println("The guard is at " + parser.currentGuardPosX + " , " + parser.currentGuardPosY);
        Day6Part1Solver part1 = new Day6Part1Solver(parser);
        int answer1 = part1.solve();
        System.out.println("Part 1 Answer: " + answer1);

        Day6Parser parser2 = new Day6Parser(FILEPATH);
        Day6Part2Solver part2 = new Day6Part2Solver(parser2);
        int answer2 = part2.solve();
        System.out.println("Part 2 Answer: " + answer2);

    }

}
