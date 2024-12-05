package main.day3;

public class Day3Solver {

    public static final String FILEPATH = "src/main/resources/inputs/day3-real.txt";

    public static void main(String[] args) {
            Day3Parser parser = new Day3Parser(FILEPATH);
            Day3Part1Solver part1 = new Day3Part1Solver(parser);
            int answer1 = part1.solve();
            System.out.println("Part 1 Answer: " + answer1);
            // going to be quirky and just reuse the part1 solver entirely
            // and just give it a different input,
            Day3Parser parser2 = new Day3Part2Parser(FILEPATH);
            Day3Part1Solver part2 = new Day3Part1Solver(parser2);
            int answer2 = part2.solve();
            System.out.println("Part 2 Answer: " + answer2);
        }

}
