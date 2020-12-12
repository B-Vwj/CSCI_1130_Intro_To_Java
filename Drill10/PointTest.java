public class PointTest {

    // Helper 1
    public void prnt(Object o) {
        System.out.println(o);
    }

    // Helper 2
    public void summary(Object testee, String testTitle, String additionalNotes) {
        // Testee is what is being manipulated
        prnt("\nTest conducted: " + testTitle);
        prnt("\nObject manipulated: " + testee);
        prnt("\nAdditional Notes: " + additionalNotes);
    }

    public void testMoveToOrigin() {
         Point dot = new Point();
         dot.moveToOrigin();

        //  System.out.println("-- testMoveToOrigin --");
        //  System.out.println("X: " + dot.getX());
        //  System.out.println("Y: " + dot.getY());
         summary(dot, "\n-- testMoveToOrigin --", "Moved dot to origin point! \nX: " + dot.getX() + "\nand" + "\nY: " + dot.getY());
    }

    public void testmove1() {
        Point dot = new Point();
        dot.move1();

        // System.out.println("-- testmove1 --");
        // System.out.println("X: " + dot.getX());
        // System.out.println("Y: " + dot.getY());
        summary(dot, "\n-- testmove1 --", "Used method 'move1'! \nX: " + dot.getX() + "\nand" + "\nY: " + dot.getY());
    }

    public void testNoArgConstructor() {
        Point circle = new Point();
        // System.out.println("-- testNoArgConstructor --");
        // System.out.println(circle);
        summary(circle, "\n-- testNoArgConstructor --", "Passed in no args!");
    }

    public void testConstructorWithOneParam() {
        Point square = new Point(10);
        // System.out.println("-- testConstructorWithOneParam --");
        // System.out.println(square);
        summary(square, "\n-- testConstructorWithOneParam --", "Passed in one arg!");
    }

    public void testConstructorWithTwoParams() {
        Point rec = new Point(5, 10);
        // System.out.println("-- testConstructorWithTwoParams --");
        // System.out.println(rec);
        summary(rec, "\n-- testConstructorWithTwoParam --", "Passed in two args!");
    }

    //=======================================
        
    public static void main(String[] args) {
        PointTest test = new PointTest();
        test.testMoveToOrigin();
        test.testmove1();
        test.testNoArgConstructor();
        test.testConstructorWithOneParam();
        test.testConstructorWithTwoParams();
    }

}