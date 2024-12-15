package main.day6;

import main.common.InputParser;
import main.day5.PrintingJob;
import main.day5.PrintingRule;

import java.sql.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Day6Parser extends InputParser {
    ArrayList<ArrayList<Character>> map = new ArrayList<>();
    int currentGuardPosX = 0;
    int currentGuardPosY = 0;

    public Day6Parser(String filepath) {
        super(filepath);
        for (String line : fileContentByLine){
            ArrayList<Character> nextLine = new ArrayList<>();
            for (Character c: line.toCharArray()){
                nextLine.add(c);
                if (c == '^') {
                    currentGuardPosX = nextLine.size() - 1;
                    currentGuardPosY = map.size() - 1;
                }
            }
            map.add(nextLine);
        }
        }
    }

