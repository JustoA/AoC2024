package main.day4;

import main.common.InputParser;

import java.util.ArrayList;

public class Day4Parser extends InputParser {
    ArrayList<ArrayList<Character>> wordsearch = new ArrayList<>();
    public Day4Parser(String filepath) {
        super(filepath);
        for(String line : fileContentByLine){
            wordsearch.add(new ArrayList<>());
            for (Character c : line.toCharArray()){
                wordsearch.getLast().add(c);
            }
            }
        }
    }

