package main.day3;

public class Day3Part1Solver {
    Day3Parser parser;
    public Day3Part1Solver(Day3Parser parser) {
        this.parser = parser;
    }

    public int doMult(String mult){
        // i wrote one regex today, thats more than enough. string split time
        int firstNum = Integer.parseInt(mult.split(",")[0].split("\\(")[1]);
        int secondNum = Integer.parseInt(mult.split(",")[1].split("\\)")[0]);
        return firstNum * secondNum;
    }
    public int solve() {
        int answer = 0;
        for (String parsedMult : this.parser.parsedMults){
            answer+=doMult(parsedMult);
        }
        return answer;
    }
}
