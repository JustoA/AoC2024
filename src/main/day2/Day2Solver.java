package main.day2;

public class Day2Solver {

        public static void main(String[] args) {
            Day2Parser parser = new Day2Parser("src/main/resources/inputs/day2-real.txt");
            Day2Part1Solver part1 = new Day2Part1Solver(parser);
            int answer1 = part1.solve();
            System.out.println("Part 1 Answer: " + answer1);

            Day2Part2Solver part2 = new Day2Part2Solver(parser);
            int answer2 = part2.solve();
            System.out.println("Part 2 Answer: " + answer2);
        }

}
