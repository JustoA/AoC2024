package main.day4;

import java.util.ArrayList;

public class Day4Part1Solver {
    Day4Parser parser;
    ArrayList<ArrayList<Character>> wordsearch;
    int max_x;
    int max_y;
    static final char[] XMAS = {'X','M','A','S'};
    public Day4Part1Solver(Day4Parser parser) {
        this.parser = parser;
        this.wordsearch = parser.wordsearch;

        max_x = wordsearch.size() - 1;
        max_y = wordsearch.getFirst().size() - 1;
    }
    /*
       0 1 2 3 4 5
       y y y y y y y y y
  0  x X M A S
  1  x A M
  2  x     A
  3  x       S
  4  x
     */

    boolean searchForXmasInDirection(int x, int y, int deltax, int deltay){
//        System.out.println("Direction: " + deltax + " " + deltay);
        for(int xmas_index = 0;xmas_index<4;xmas_index++){
            int xToCheck = x+deltax*xmas_index;
            int yToCheck = y+deltay*xmas_index;
            if (xToCheck < 0 || xToCheck > max_x || yToCheck < 0 || yToCheck > max_y){
                return false;
            }
            Character current = wordsearch.get(xToCheck).get(yToCheck);
            if ( current != XMAS[xmas_index]){
                return false;
            }
            //System.out.println(current + " " + XMAS[xmas_index]);
        }
        //System.out.println("x: "+x+"\ny: "+y);

        return true;
    }

    int searchForXmasFromPoint(int x, int y){
        int foundXmas = 0;
        for(int xdir = -1; xdir<2; xdir++){
            for(int ydir = -1; ydir<2; ydir++){
                if(xdir==0 && ydir==0) continue;
                if(searchForXmasInDirection(x,y,xdir,ydir)) foundXmas++;
            }
        }

        return foundXmas;
    }
    public int solve() {
        int answer = 0;
        for(int x = 0;x<=max_x;x++){
            for(int y = 0; y<=max_y;y++){
                answer+=searchForXmasFromPoint(x,y);
            }
        }
        return answer;
    }
}
