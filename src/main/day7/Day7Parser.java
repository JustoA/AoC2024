package main.day7;

import main.common.InputParser;

import java.util.ArrayList;

public class Day7Parser extends InputParser {
    ArrayList<Measurement> measurements
            = new ArrayList<>();

    public Day7Parser(String filepath, boolean part2) {
        super(filepath);
        for (String line : fileContentByLine){
            measurements.add(new Measurement(line, part2));
            }
        }
    }

