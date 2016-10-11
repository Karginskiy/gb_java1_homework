package tictactoe.model;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int[] getBothCoordinates() {
        return new int[] {x, y};
    }

    public boolean equals(Point point) {
        return (this.x == point.getX()) && (this.y == point.getY());
    }
}
