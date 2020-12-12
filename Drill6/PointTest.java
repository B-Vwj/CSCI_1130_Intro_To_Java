public class PointTest {

    public void testMoveToOrigin() {
         Point dot = new Point();
         dot.moveToOrigin();

         System.out.println("\n -- testMoveToOrigin --");
         System.out.println("X: " + dot.getX());
         System.out.println("Y: " + dot.getY());
         
    }

    public void testmove1() {
        Point dot = new Point();
        dot.move1();

        System.out.println("\n -- testmove1 --");
        System.out.println("X: " + dot.getX());
        System.out.println("Y: " + dot.getY());
        
    }

    public void testSetX() {
        Point dot = new Point();
        dot.setX(10);

        System.out.println("\n -- testSetX --");
        System.out.println("X is set to 10");
        System.out.println("X value: " + dot.getX());
    }

    public void testSetY() {
        Point dot = new Point();
        dot.setY(5);

        System.out.println("\n -- testSetY --");
        System.out.println("Y is set to 5");
        System.out.println("Y value: " + dot.getY());
    }

    public void testSetX_and_Y() {
        Point dot = new Point();
        dot.set(25);

        System.out.println("\n -- testSetX_and_Y --");
        System.out.println("X is set to 25");
        System.out.println("X value: " + dot.getX());
        System.out.println("Y is set to 25");
        System.out.println("Y value: " + dot.getY());

    }
    
    public void testSet() {
        Point dot = new Point();
        dot.set(1, 2);

        System.out.println("\n -- testSet --");
        System.out.println("X is set to 1");
        System.out.println("X value: " + dot.getX());
        System.out.println("Y is set to 2");
        System.out.println("Y value: " + dot.getY());

    }
    

    //=======================================
        
    public static void main(String[] args) {
        PointTest test = new PointTest();
        test.testMoveToOrigin();
        test.testmove1();
        test.testSetX();
        test.testSetY();
        test.testSetX_and_Y();
        test.testSet();
    }

}