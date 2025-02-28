package main.day5;

public class Day5Solver {

    public static final String FILEPATH = "src/main/resources/inputs/day5-real.txt";

    public static void main(String[] args) {
            Day5Parser parser = new Day5Parser(FILEPATH);
            Day5Part1Solver part1 = new Day5Part1Solver(parser);
            int answer1 = part1.solve();
            System.out.println("Part 1 Answer: " + answer1);

        Day5Part2Solver part2 = new Day5Part2Solver(parser);
        int answer2 = part2.solve();
        System.out.println("Part 2 Answer: " + answer2);

        }

}
