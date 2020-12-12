public class EnhancePoint extends Point {

    private int x;
    private int y;

    public boolean isBalanced() {
        return x == y;
    }

    public boolean isAtOrigin() {
        return x == 0 && y == 0;
    }

    public boolean reset(boolean resetX, boolean resetY) {
        if (resetX) {
            x = 0;
        } else if (resetY) {
            y = 0;
        }

        if (x != 0 || y != 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isRightOf(Point otherPoint) {
        // Using graph paper as an analogy,
        // The higher the positive value of X is compared to otherPoint's X,
        // The further RIGHT it is from otherPoint
        if (otherPoint.getX() < this.x) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRightAndAbove(Point otherPoint) {
        // Using graph paper as an analogy,
        // The higher the positive value of X is compared to otherPoint's X,
        // The further RIGHT it is from otherPoint.
        // The higher the positive value of Y is compared to otherPoint's Y,
        // The further ABOVE it is from otherPoint.
        if (isRightOf(otherPoint) && (otherPoint.getY() < this.y)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isInside(int left, int top, int width, int height) {
        if ((this.x <= left && this.x < width) && (this.y <= top && this.y < height)) {
            return true;
        } else {
            return false;
        }
    }

    public void print(boolean option) {
        // if TRUE, print basic along with details,
        // else if FALSE, just print basic
        if (option) {
            printDetails();
        } else {
            printValues();
        }
    }

    public void printValues() {
        prn("\nX: " + x);
        prn("\nY: " + y);
    }

    public void printDetails() {
        // First print the basic information
        printValues();

        // Now print a rich mix of information about this Point
        if (isAtOrigin() && isBalanced()) {
            prn("\nBoth the X and Y are at the origin point.");
            prn("\nBoth the X and Y are perfectly balance (as all things should be).");
        } else if (isBalanced()) {
            prn("\nBoth the X and Y are perfectly balance (as all things should be).");
        } else {
            prn("\nError in getting information about your Point.");
        }
    }

    //================//
    // Helper Methods //
    //================//

    public void prn(Object o) {
        System.out.println(o);
    }

}
