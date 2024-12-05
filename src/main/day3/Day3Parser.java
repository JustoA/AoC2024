package main.day3;

import main.common.InputParser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Parser extends InputParser {
    public ArrayList<String> parsedMults = new ArrayList<>();
    String mulString = "mul\\(\\d+,\\d+\\)";
    Pattern mulPattern = Pattern.compile(mulString);

    public Day3Parser(String filepath) {
        super(filepath);
        // use a for loop here to go through all the lines of the input
        for (String line : fileContentByLine) {
            Matcher matcher = mulPattern.matcher(line);
            // find() returns true if there's a match
            while(matcher.find()){
                int startIndex = matcher.start();
                int endIndex = matcher.end();
                parsedMults.add(line.substring(startIndex,endIndex));
            }
        }
    }
}
