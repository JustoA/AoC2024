package main.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MetalGearSolid {
    ArrayList<ArrayList<Character>> map;
    int currentGuardPosX;

    public int getCurrentGuardPosX() {
        return currentGuardPosX;
    }

    public int getCurrentGuardPosY() {
        return currentGuardPosY;
    }

    public String getCurrentGuardDir() {
        switch (currentGuardDir) {
            case UP -> {
                return "U";
            }
            case DOWN -> {
                return "D";
            }
            case LEFT -> {
                return "L";
            }
            case RIGHT -> {
                return "R";
            }
        }
        return "AAAAAAAAAAAAAAAAAAAAAAAA";
        // this should never happen.
    }

    public String getState() {
        return getCurrentGuardPosX() + "," + getCurrentGuardPosY() + "," + getCurrentGuardDir();
    }

    int currentGuardPosY;
    Direction currentGuardDir = Direction.UP;

    public MetalGearSolid(ArrayList<ArrayList<Character>> map, int currentGuardPosX, int currentGuardPosY) {
        // make a deep copy of the map for part 2. This shouldn't affect part 1.
        this.map = new ArrayList<>();
        for (ArrayList<Character> row : map) {
            this.map.add(new ArrayList<>(row)); // thank you java collections
        }

        this.currentGuardPosX = currentGuardPosX;
        this.currentGuardPosY = currentGuardPosY;
    }

    void rotateGuard() {
        switch (currentGuardDir) {
            case UP -> currentGuardDir = Direction.RIGHT;

            case RIGHT -> currentGuardDir = Direction.DOWN;

            case DOWN -> currentGuardDir = Direction.LEFT;

            case LEFT -> currentGuardDir = Direction.UP;

        }
    }

    void moveGuard() {
        int deltax = 0;
        int deltay = 0;
        switch (currentGuardDir) {
            case UP -> deltay = -1;

            case DOWN -> deltay = 1;

            case LEFT -> deltax = -1;

            case RIGHT -> deltax = 1;

        }
        map.get(currentGuardPosY).set(currentGuardPosX, 'X');
        this.currentGuardPosX += deltax;
        this.currentGuardPosY += deltay;
        if (!isOutOfBounds(0, 0)) map.get(currentGuardPosY).set(currentGuardPosX, '^');


    }

    boolean isOutOfBounds(int deltax, int deltay) {
        return !(currentGuardPosY + deltay < map.size() && // must not call map.get(map.size)
                currentGuardPosX + deltax < map.getFirst().size() && // same here
                currentGuardPosX + deltax >= 0 && // must not call map.get(-1)
                currentGuardPosY + deltay >= 0); // same
    }

    boolean guardIsPresent() {
        return currentGuardPosX >= 0 && currentGuardPosX < map.getFirst().size() && currentGuardPosY >= 0 && currentGuardPosY < map.size();
    }

    boolean guardIsObstructed() {
        int deltax = 0;
        int deltay = 0;
        switch (currentGuardDir) {
            case UP -> deltay = -1;

            case DOWN -> deltay = 1;

            case LEFT -> deltax = -1;

            case RIGHT -> deltax = 1;

        }
        if (isOutOfBounds(deltax, deltay)) return false;
        return map.get(currentGuardPosY + deltay).get(currentGuardPosX + deltax) == '#';
    }

    int countX() {
        int answer = 0;
        for (ArrayList<Character> row : map) {
            answer += Collections.frequency(row, 'X');

            // i dont feel like figuring out why the ^ doesn't get overwritten.
            answer += Collections.frequency(row, '^');

        }
        return answer;
    }

    void step() {
        // check if guard is obstructed
        while (guardIsObstructed()) {
            rotateGuard();
        }
        moveGuard();
        //printMap();
    }

    public void printMap() {
        for (ArrayList<Character> line : map) {
            // im lucky this works
            System.out.println(Arrays.stream(line.toArray()).reduce("", ((o, o2) -> o + o2.toString())));
        }
        System.out.println("\n\n");
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
