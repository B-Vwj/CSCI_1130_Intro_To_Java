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

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Setters
    public void setX(int aValue) {
        x = aValue;
    }

    public void setY(int aValue) {
        y = aValue;
    }

    public void set(int aValue) {
        x = aValue;
        y = aValue;
    }

    public void set(int aX, int aY) {
        x = aX;
        y = aY;
    }


    // Common
    public String toString()  {
		//Return a "nice" display string
		return "" + x + " x " + y;
	}

}