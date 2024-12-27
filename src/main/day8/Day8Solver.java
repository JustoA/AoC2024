package main.day8;

public class Day8Solver {

    public static final String FILEPATH = "src/main/resources/inputs/day8-real.txt";

    public static void main(String[] args) {
        Day8Parser parser = new Day8Parser(FILEPATH, false);

        Day8Part1Solver part1 = new Day8Part1Solver(parser);
        long answer1 = part1.solve();
        System.out.println("Part 1 Answer: " + answer1);

        Day8Parser parser2 = new Day8Parser(FILEPATH, true);

        Day8Part2Solver part2 = new Day8Part2Solver(parser2);
        long answer2 = part2.solve();
        System.out.println("Part 2 Answer: " + answer2);
    }

}
