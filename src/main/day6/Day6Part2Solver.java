package main.day6;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Day6Part2Solver {
    Day6Parser parser;

    public Day6Part2Solver(Day6Parser parser) {
        this.parser = parser;
    }
    /*
     * encoding states like this:
     * X,Y,D
     * ex:  6,5,U
     * D can be U,D,L,R
     */

    public int solve() {
        AtomicInteger answer = new AtomicInteger();
        // me breaking out the multithreading
        parser.map.parallelStream().forEach(characters -> {
            int y = parser.map.indexOf(characters);
            for (int x = 0; x < parser.map.getFirst().size(); x++) {
                ArrayList<String> pastStates = new ArrayList<>();
                boolean infiniteLooping = false;
                MetalGearSolid mgs = new MetalGearSolid(parser.map, parser.currentGuardPosX, parser.currentGuardPosY);
                if (mgs.map.get(y).get(x) == '^') {
                    // dont put the thing on the guard
                    continue;
                }
                mgs.map.get(y).set(x, '#');
                // loop until guard le🆎s OR we repeat a state
                while (mgs.guardIsPresent() && !infiniteLooping) {
                    if (pastStates.contains(mgs.getState())) {
                        infiniteLooping = true;
                        answer.addAndGet(1);
                        continue;
                    }
                    // add current state to list
                    pastStates.add(mgs.getState());
                    //move the guard
                    mgs.step();

                }
            }
        });

        return answer.get();
    }
}
