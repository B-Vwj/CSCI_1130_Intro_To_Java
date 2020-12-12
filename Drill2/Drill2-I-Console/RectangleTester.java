/*
	RectangleTester.java
	Last Modified: 2/5/19

	I test/exercise the Rectangle class by constructing Rectangle
	objects and sending messages to them.

*/

public class RectangleTester
{

	//=================================================================
	//Test methods (instance methods)

	public void testSimpleConstruction() {
		Rectangle rec;
		rec = new Rectangle("My Crazy Rec", 3, 2);
		println("Test: " + "testSimpleConstruction");
		println("Constructed Rectangle with width=3, height=2");
		rec.print();
	}

	public void testTripleSize() {
		Rectangle rec;
		rec = new Rectangle("Outer Frame (Rectangle)", 3, 2);
		println("Test: " + "testTripleSize");
		println("Constructed Rectangle with width=3, height=2");
		rec.print();

		println("Now asking Rectangle object to tripleSize");
		rec.tripleSize();
		rec.print();
	}

	public void testFactorWidthBy() {
		Rectangle rec;
		rec = new Rectangle("Picture Frame (Rectangle)", 3, 2);
		println("Test: " + "testTripleSize");
		println("Constructed Rectangle with width=3, height=2");
		println("Here it is: " + rec.toString());

		println("Now asking Rectangle object to factorWidthBy(10)");
		rec.factorWidthBy(10);
		rec.print();
	}

	public void testFlipWidthAndHeight() {
		Rectangle rec;
		rec = new Rectangle("Kofi's Kitchen Window Frame (Rectangle)", 10, 1);
		println("Test: " + "testFlipWidthAndHeight");
		println("Constructed Rectangle with width=10, height=1");
		rec.print();

		println("Now asking Rectangle object to flipWidthAndHeight");
		rec.flipWidthAndHeight();
		rec.print();
	}

	//=================================================================
	//The main method (which will call the test methods)

	public static void main(String[] args)
	{
		RectangleTester tester;

		//Construct the tester
		tester = new RectangleTester();

		//Run some tests
		println("");
		tester.testSimpleConstruction();
		println("");
		tester.testTripleSize();
		println("");
		tester.testFactorWidthBy();
		println("");
		tester.testFlipWidthAndHeight();
		println("");
		//Note: println's are just blank lines to make the output look a bit nicer
	}

	//Helper
	public static void println(Object o)
	{
		System.out.println(o.toString());
	}

}


