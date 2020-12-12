public class Point {

    private int x;
    private int y;

    public void moveToOrigin() {
        x = 0;
        y = 0;
    }

    public void move1() {
        x = 100;
        y = 70;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int gridLocation) {
        this.x = gridLocation;
        this.y = gridLocation;
    }

    public Point(int xLocation, int yLocation) {
        this.x = xLocation;
        this.y = yLocation;
    }

}