package main.day1;

public class Day1Solver {

    public static void main(String[] args){

        Day1Parser parser = new Day1Parser("src/main/resources/inputs/day1-real.txt");
        // i love oop!!!!! I LOVE OOOOOOOPPPP!!!1
        Day1Part1Solver part1 = new Day1Part1Solver(parser);
        int answer1 = part1.solve();
        System.out.println("Part 1 Answer: " + answer1);

        Day1Part2Solver part2 = new Day1Part2Solver(parser);
        int answer2 = part2.solve();
        System.out.println("Part 2 Answer: " + answer2);

    }
}
