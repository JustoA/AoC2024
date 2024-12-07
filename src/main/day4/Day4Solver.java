package main.day4;

public class Day4Solver {

    public static final String FILEPATH = "src/main/resources/inputs/day4-real.txt";

    public static void main(String[] args) {
            Day4Parser parser = new Day4Parser(FILEPATH);
            Day4Part1Solver part1 = new Day4Part1Solver(parser);
            int answer1 = part1.solve();
            System.out.println("Part 1 Answer: " + answer1);

            Day4Part2Solver part2 = new Day4Part2Solver(parser);
            int answer2 = part2.solve();
            System.out.println("Part 2 Answer: " + answer2);
        }

}
