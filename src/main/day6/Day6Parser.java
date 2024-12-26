package main.day6;

import main.common.InputParser;

import java.util.ArrayList;

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
                    currentGuardPosY = map.size(); // not -1 because we havent added this row to the list yet
                }
            }
            map.add(nextLine);
        }
        }
    }

