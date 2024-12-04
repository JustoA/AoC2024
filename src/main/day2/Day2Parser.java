package main.day2;

import main.common.InputParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Day2Parser extends InputParser {
    ArrayList<ArrayList<Integer>> measurements = new ArrayList<>();
    public Day2Parser(String filepath) {
        super(filepath);
        for(String s : this.fileContentByLine){
            String[] parsedNumbers = s.split(" ");
            // lol
            measurements.add(
                    new ArrayList<>(
                            Arrays.stream(parsedNumbers).map((Integer::parseInt)).collect(Collectors.toList())));
        }
        System.out.println(measurements);
    }
}
