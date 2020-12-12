/*
	Rectangle.java
	Last Modified: 2/5/19

	I model a Rectangle

	I have:

		width
		height

	I can do:

		calculate my area (cross sectional area)
		calculate my perimeter (distance around)

	The slash-slash starts a code comment (on the remainder of the given line)
	The slash-star to star-slash starts a block comment (can go on multiple lines -- see examples in this file)

	This class is heavily commented for learning.
	Also search in this file for this tag :
		A "local variable" story

	The word "object" is used interchangeably with "instance"

*/

public class Rectangle
{
	/*=================================================================
	/*=================================================================
	These are instance variables (ivars) -- A Rectangle object's data
	private means objects can [not] come along and directly access these ivars*/

	private String description;
	private int width;
	private int height;

	/*=================================================================
	/*=================================================================
	These are the construtor(s)
	We will use these methods to construct Rectangle objects
	Like this:
					Rectangle myRec = new Rectangle("Crazy Rec", 10, 5);*/

	public Rectangle(String initialDescription, int initialWidth, int initialHeight)
	{

		this.description = initialDescription;
		this.width = initialWidth;
		this.height = initialHeight;
	}

	/*=================================================================
	/*=================================================================
	These are instance methods (object behaviors)
	This is where most of the code will go. It will allow Rectangle objects (instances)
	to have behavior. Otherwise, a Rectangle object would do nothing (boring)*/

	public void setWidth(int newWidth)
	{
		//We can call this a "setter" method (it "sets" an instance variable)
		this.width = newWidth;
	}

	public void setHeight(int newHeight)
	{
		//Simply set our height with "newHeight" (another setter)
		this.height = newHeight;
	}

	public int computeArea()
	{
		/*
		A "local variable" story:

		1) See method body below and note that:
			Our first line is a "DECLARATION" line ("declares" variables e.g. variable named "area")
			Our second line is a "CALCULATION" line -- "uses" variables
		2) On the "DECLARATION" line:
			"area" is a local variable
			It is declared to be of type "int" (i.e. an integer)
		3) When Java comes along (and compiles) our CALCULATION line
			a) It first checks to make sure all the variables are declared.
			b) E.g., because "area" has been declared prior to
				the CALCULATION line (it was declared on the preceeding
				DECLARATION line), then Java is happy (it knows the "area" variable and it's type -- int).
			c) However, if we deleted the DECLARATION line, then on
				the CALCULATION line, Java would be temporarily unhappy because it does
				not know what "area" is, and it would tell us:
					"cannot find symbol" for "area"
				TRY IT: delete the DECLARATION line. Then fix it to make Java happy.
		*/
		int area;								//DECLARATION of "area"
		area = this.width * this.height;		//CALCULATION using "area"
		return area;
	}

	public int computePerimeter()
	{
		int perimeter;
		perimeter = (2 * this.width) + (2 * this.height);
		return perimeter;
	}

	public void tripleSize()
	{
		//Triple the dimensions (width and height of this Rectangle)
		this.width = 3 * this.width;
		this.height = 3 * this.height;
	}

	public void factorWidthBy(int factor)
	{
		/*Factor the width by "factor", e.g. if factor=3, then our width is tripled (width = 3*width)
		Example use:
			this.factorWidthBy(2);			//Tell "this" to double it's width (i.e. *2)
			myRectangle.factorWidthBy(3);	//Tell object "myRectangle" to triple it's width (i.e. *3)*/
		this.width = factor * this.width;
	}

	public void flipWidthAndHeight()
	{
		int oldHeight = this.height;
		this.height = this.width;
		this.width = oldHeight;
	}

	public void print()
	{
		//Print myself (this rectangle) to the console
		//Note: "System.out" is a Java object we are free to use. It is the console (good for output).
		System.out.println(this.toString());
	}

	public String toString()
	{
		//Note: You may code Java statements on multiple lines like this (when statement is long)
		//Remember the semicolon terminates/ends the statement -- so we have only one semicolon below
		return this.description + " -- " + "width=" + this.width
			+ " height=" + this.height
			+ " -- area=" + this.computeArea()
			+ " Perimeter=" + this.computePerimeter();
	}

}


