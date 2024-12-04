package test;

import main.common.InputParser;

public class TestInputParser {
    public static void main(String[] args){
        InputParser ip = new InputParser("C:\\Users\\Jutin\\IdeaProjects\\AOC2024\\src\\main\\resources\\inputs\\day1-test.txt");
        System.out.println(ip.fileContentByLine);
        assert (!ip.fileContentByLine.isEmpty());
        }
}
