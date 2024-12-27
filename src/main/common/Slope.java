package main.common;

public class Slope {
    int deltaX;
    int deltaY;

    public static int getXFromRepr(String repr){
        return Integer.parseInt(repr.split("/")[1]);
    }

    public static int getYFromRepr(String repr){
        return Integer.parseInt(repr.split("/")[0]);
    }

    public Slope(Point point1, Point point2){
        this.deltaY = point2.y-point1.y;
        this.deltaX = point2.x-point1.x;
    }

    public Slope(int deltaY, int deltaX){
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    /**
     * Parses a string representation of slope (y/x) to a Slope object.
     * @param repr String representation of the slope, in the form "y/x" where y and x are integers.
     */
    public Slope(String repr){
        this.deltaX = Integer.parseInt(repr.split("/")[1]);
        this.deltaY = Integer.parseInt(repr.split("/")[0]);
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Slope other){
            return (this.deltaX == other.deltaX && this.deltaY == other.deltaY);
        }
        else {
            return false;
        }
    }
}
