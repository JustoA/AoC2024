package main.common;

public class Point {
    public int x;
    public int y;

    public static int getXFromRepr(String repr){
        return Integer.parseInt(repr.split(",")[0]);
    }
    public static int getYFromRepr(String repr){
        return Integer.parseInt(repr.split(",")[1]);
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(String repr){
        this.x = Integer.parseInt(repr.split(",")[0]);
        this.y = Integer.parseInt(repr.split(",")[1]);
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Point other){
            return (this.x == other.x && this.y == other.y);
        }
        else {
            return false;
        }
    }

    public int manhattanDistanceTo(Point other){
        return Math.abs(x-other.x) + Math.abs(y-other.y);
    }

    /*      A
     *    / |
     *  /   |
     * B----x
     *
     * soh cah toa y2-y1/x2-x1
     *
     * help.
     */
    public double angleTo(Point other){
        return Math.atan2(y-other.y, x-other.x);
    }

    public Point addSlope(Slope slope){
        return new Point(this.x+ slope.deltaX,this.y+slope.deltaY);
    }

    @Override
    public String toString(){
        return x+","+y;
    }
}
