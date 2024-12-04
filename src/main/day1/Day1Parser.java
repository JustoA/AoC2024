package main.day1;

import main.common.InputParser;

import java.util.ArrayList;

public class Day1Parser extends InputParser {
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    public Day1Parser(String filepath) {
        super(filepath);
        for(String listMember : this.fileContentByLine){
            // parse by any amount of white space > 1 because idk what the input's gonna look like between example
            // and the file they give
            String[] splitString = listMember.split("\\s+");
            if (splitString.length != 2){
                System.err.println("OH NO");
            }
            int item1 = Integer.parseInt(splitString[0]);
            int item2 = Integer.parseInt(splitString[1]);
            list1.add(item1);
            list2.add(item2);
        }
    }
}
