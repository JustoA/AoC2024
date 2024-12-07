package main.day4;

import java.util.ArrayList;

public class Day4Part2Solver {
    Day4Parser parser;
    ArrayList<ArrayList<Character>> wordsearch;
    int max_x;
    int max_y;
    public Day4Part2Solver(Day4Parser parser) {
        this.parser = parser;
        this.wordsearch = parser.wordsearch;

        max_x = wordsearch.size() - 1;
        max_y = wordsearch.getFirst().size() - 1;
    }
    // 4 cases:
    // m m, m s, s m, s s

    int searchForMasAtA(int x, int y){
        int presentMASs = 0;
        // domain expansion: hardcoding
        if(x<=0 || y <= 0 || x>=max_x || y >= max_y) return 0;

        // top left -> bottom right - MAS
        if (wordsearch.get(x-1).get(y-1) == 'M' && wordsearch.get(x+1).get(y+1) == 'S' ) {
            presentMASs += 1;
        }
        // top left -> bottom right - SAM
        if (wordsearch.get(x-1).get(y-1) == 'S' && wordsearch.get(x+1).get(y+1) == 'M' ) {
            presentMASs += 1;
        }
        // top right -> bottom left - SAM
        if (wordsearch.get(x+1).get(y-1) == 'S' && wordsearch.get(x-1).get(y+1) == 'M' ) {
            presentMASs += 1;
        }
        // top right -> bottom left - MAS
        if (wordsearch.get(x+1).get(y-1) == 'M' && wordsearch.get(x-1).get(y+1) == 'S' ) {
            presentMASs += 1;
        }
        //System.out.println(presentMASs);
        if (presentMASs == 2)
            return 1;
        else
            return 0;
    }

    public int solve() {
        int answer = 0;
        for(int x = 0;x<=max_x;x++){
            for(int y = 0; y<=max_y;y++){
                if (wordsearch.get(x).get(y) == 'A') answer+=searchForMasAtA(x,y);
            }
        }
        return answer;
    }
}
