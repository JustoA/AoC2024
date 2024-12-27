package main.day8;

import main.common.Point;
import main.common.Slope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BrainwashMap {
    private final HashMap<String,Character> grid;
    private final HashMap<String,Character> antinodes = new HashMap<>();
    private final HashSet<Character> signalTypes = new HashSet<>();
    private final int maxX;
    private final int maxY;
    public BrainwashMap(HashMap<String,Character> grid, int maxX, int maxY){
        this.maxX = maxX;
        this.maxY = maxY;
        this.grid = grid;
        // will this work lol
        this.signalTypes.addAll(grid.values());
        // remove empty space character
        this.signalTypes.remove('.');
        System.out.println(signalTypes);
    }
    public int calculateAntinodes(){
        for (Character signalType: this.signalTypes){
            calculateAntinodesForSignalType(signalType);
        }
        return this.antinodes.size();
    }

    /**
     * mutates the antinodes hashmap
     */
    private void calculateAntinodesForSignalType(Character signalType){
        // grab all positions for antennas of type signalType
        ArrayList<Point> antennaPositions = new ArrayList<>();
        for (String position : grid.keySet()){
            if (grid.get(position) == signalType) antennaPositions.add(new Point(position));
        }
        for (Point tower : antennaPositions){
            calculateAntinodesForGivenTower(tower, signalType, antennaPositions);
        }
    }
    // draw a line to another tower, and then draw the same line past that tower. the end of this point is an antinode.
    // if any coordinate is greater than maxX / maxY, or less than 0, throw it out.
    // essentially,
    private void calculateAntinodesForGivenTower(Point tower, Character signalType, ArrayList<Point> sameFrequencyTowers){
        for (Point tower2: sameFrequencyTowers){
            if (tower.equals(tower2)) continue; //dont create an antinode with self
            Slope angleToTower = new Slope(tower, tower2);
            Point potentialAntiNode = tower2.addSlope(angleToTower);
            if (withinBounds(potentialAntiNode)){
                antinodes.put(potentialAntiNode.toString(),signalType);
            }
        }
    }

    private boolean withinBounds(Point potentialAntiNode) {
        return potentialAntiNode.x >= 0 && potentialAntiNode.x < maxX &&
                potentialAntiNode.y >= 0 && potentialAntiNode.y < maxY;
    }

    /*
     * Part 2 methods below here
     */
    public int calculateAntinodesWithResonance(){
        for (Character signalType: this.signalTypes){
            calculateAntinodesForSignalTypeWithResonance(signalType);
        }
        return this.antinodes.size();
    }

    private void calculateAntinodesForSignalTypeWithResonance(Character signalType){
        // grab all positions for antennas of type signalType
        ArrayList<Point> antennaPositions = new ArrayList<>();
        for (String position : grid.keySet()){
            if (grid.get(position) == signalType) antennaPositions.add(new Point(position));
        }
        for (Point tower : antennaPositions){
            calculateAntinodesForGivenTowerWithResonance(tower, signalType, antennaPositions);
        }
    }

    private void calculateAntinodesForGivenTowerWithResonance(Point tower, Character signalType, ArrayList<Point> sameFrequencyTowers){
        for (Point tower2: sameFrequencyTowers){
            if (tower.equals(tower2)) continue; //dont create an antinode with self
            Slope angleToTower = new Slope(tower, tower2);
            Point potentialAntiNode = tower2;
            // basically keep going until we run off the map
            while (withinBounds(potentialAntiNode)){
                antinodes.put(potentialAntiNode.toString(),signalType);
                potentialAntiNode = potentialAntiNode.addSlope(angleToTower);
            }
        }
    }

}
