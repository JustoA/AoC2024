package main.day8;

import main.common.InputParser;
import java.util.HashMap;

public class Day8Parser extends InputParser {
    // position-  "x,y"
    public BrainwashMap theSituation;
    HashMap<String, Character> grid = new HashMap<>();


    public Day8Parser(String filepath, boolean part2) {
        super(filepath);
        int maxY = fileContentByLine.size();
        int maxX = fileContentByLine.getFirst().length();
        for(int y = 0; y< maxY;y++){
            for(int x = 0; x < maxX; x++){
                grid.put(x+","+y, fileContentByLine.get(y).charAt(x));
            }
        }
        theSituation = new BrainwashMap(grid, maxX, maxY);
    }
}

