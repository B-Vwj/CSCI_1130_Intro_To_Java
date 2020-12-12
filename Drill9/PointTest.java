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

    public void testNoArgConstructor() {
        Point circle = new Point();
        System.out.println("-- testNoArgConstructor --");
        System.out.println(circle);
    }

    public void testConstructorWithOneParam() {
        Point square = new Point(10);
        System.out.println("-- testConstructorWithOneParam --");
        System.out.println(square);
    }

    public void testConstructorWithTwoParams() {
        Point rec = new Point(5, 10);
        System.out.println("-- testConstructorWithTwoParams --");
        System.out.println(rec);
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