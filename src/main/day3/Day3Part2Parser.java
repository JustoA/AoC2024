package main.day3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part2Parser extends Day3Parser {
    String mulString = "mul\\(\\d+,\\d+\\)";
    Pattern mulPattern = Pattern.compile(mulString);

    // so.... find all the do() ... dont() and add it to a list to parse like in part 1.
    // we can add a do() to the beginning because they start enabled.
    String doDontString = "do\\(\\).*?don't\\(\\)";
    Pattern doDontPattern = Pattern.compile(doDontString);

    public Day3Part2Parser(String filepath) {
        super(filepath);
        // i extended the base class causing parsedMults to already be populated.
        parsedMults.clear();
        String everything = "do()" + String.join("", fileContentByLine) + "don't()";
        System.out.println(everything);
        Matcher dontDoMatch = doDontPattern.matcher(everything);
        ArrayList<String> realAndTrueMults = new ArrayList<>();
        while (dontDoMatch.find()) {
            realAndTrueMults.add(everything.substring(dontDoMatch.start(), dontDoMatch.end()));
        }
        // use a for loop here to go through all the lines of the input
        for (String line : realAndTrueMults) {
            Matcher matcher = mulPattern.matcher(line);
            // find() returns true if there's a match
            while (matcher.find()) {
                int startIndex = matcher.start();
                int endIndex = matcher.end();
                parsedMults.add(line.substring(startIndex, endIndex));
            }
        }
    }
}