public class PointTest {

    public void testMoveToOrigin() {
         Point dot = new Point();
         dot.moveToOrigin();

         System.out.println("-- testMoveToOrigin --");
         System.out.println("X: " + dot.getX());
         System.out.println("Y: " + dot.getY());
         
    }

    public void testmove1() {
        Point dot = new Point();
        dot.move1();

        System.out.println("-- testmove1 --");
        System.out.println("X: " + dot.getX());
        System.out.println("Y: " + dot.getY());
        
    }

    //=======================================
        
    public static void main(String[] args) {
        PointTest test = new PointTest();
        test.testMoveToOrigin();
        test.testmove1();
    }

}