package main.day7;

public class Day7Solver {

    public static final String FILEPATH = "src/main/resources/inputs/day7-real.txt";

    public static void main(String[] args) {
        Day7Parser parser = new Day7Parser(FILEPATH, false);

        Day7Part1Solver part1 = new Day7Part1Solver(parser);
        long answer1 = part1.solve();
        System.out.println("Part 1 Answer: " + answer1);

        Day7Parser parser2 = new Day7Parser(FILEPATH, true);

        Day7Part2Solver part2 = new Day7Part2Solver(parser2);
        long answer2 = part2.solve();
        System.out.println("Part 2 Answer: " + answer2);
    }

}
