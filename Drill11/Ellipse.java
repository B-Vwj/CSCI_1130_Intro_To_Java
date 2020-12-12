import java.awt.Color;
import java.awt.Graphics;

/*
NOTE WELL
	When you see "our" or "my" think "this" object
	e.g.
	The note:
		Return twice our "a" value
	Means:
	 	Return twice of the "a" value for "this" ellipse
*/

class Ellipse extends Shape {

	//-------------------------------------------
	//Instance Variables

	/*Just fyi:
		We use "a" for the ellipse semi-major axis
		We use "b" for the ellipse semi-minor axis*/

	private Point center;
	private int a;
	private int b;

	//-------------------------------------------
	//Constructors

	public Ellipse(Point cc, int aa, int bb) {
		/*Set our point center to "cc"
		Set our a to "aa" and our b to "bb"*/
		//CODE HERE
		this.center = cc;
		this.a = aa;
		this.b = bb;
	}

	public Ellipse() {
		/*No args constructor
		Set our (this) center to a point with x=0, y=0
		Set our (this) a to 0
		Set our (this) b to 0*/
		//CODE HERE
		this.center = new Point();
		this.a = 0;
		this.b = 0;
	}

	//-------------------------------------------
	//Instance Methods -- Special Behaviors

	public void drawOn(Graphics graphics, Color color) {
		/*
		Send the message "setColor" to "graphics" with param "color"
		Send the message "drawOval" to "graphics"
		Send the message "fillOval" to "graphics"
		"drawOval" and "fillOval" each have the same four method params:
		 	left
		 	top
		 	width
		 	height
		left is the left edge of the circle
		top is the top edge of the circel
		width is the width of the boundary that bounds this circle
		height is the height of the boundary that bounds this circle
		hint: The key word in above description starts with the letter "b"
		Side note (fyi only): The bounding width will equal
		  						the bounding height (for circle)
		*/
		//CODE HERE
		graphics.setColor(color);
		graphics.drawOval(center.getX(), center.getY(), 100, 100);
		graphics.fillOval(center.getX(), center.getY(), 100, 100);
	}

	public void moveBy(Point v) {
		//Delegate (pass the work) to our child (ivar)
		//CODE HERE
		this.center = v;
	}

	//-------------------------------------------
	//Instance Methods -- Special Getters And Setters

	public Frame getBoundary() {
		/*Return a Frame object that defines the boundary of this ellipse
		Algorithm:
			left = center x - a
			top = center y - b
			right = center x + a
			bottom = center y + b
		*/
		//CODE HERE
		int left = center.getX() - this.a;
		int top = center.getY() - this.b;
		int right = center.getX() + this.a;
		int bottom = center.getY() + this.b;
		
		Frame f = new Frame(left, top, right, bottom);
		return f;
	}

	public int getLongDimension() {
		//Return twice our "a" value
		//CODE HERE
		this.a = 2 * a;
		return a;
	}

	public void setAnchor(Point anchorPoint) {
		//Simply set our center	to the param
		//CODE HERE
		this.center = anchorPoint;
	}

	public Point getAnchor() {
		//Simply return our center
		//CODE HERE
		return center;
	}

	//============================================================
	//Code below this line is DONE

	public void setLongDimension(int longDimension) {
		//THIS CODE IS DONE
		//a is semi major (half), so divide by 2
		this.a = (int)Math.round(longDimension / 2.0);
		this.b = (int)Math.round(longDimension / 4.0);
		//this.b = Toolbox.getRandomNumber(this.a);
	}

	@Override
	public String toString() {
		//THIS CODE IS DONE
		return "Ellipse: " + "Center= " +
				this.center.basicToString() + " -- Semi-Major= " +
				this.a + " Semi-Minor= " + this.b
				+ " -- " + getBoundary().basicToString();
	}

	@Override
	public int hashCode() {
		//THIS CODE IS DONE
		//Return hash code that identifies object
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		//THIS CODE IS DONE
		//Return true if we equal param aOther
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ellipse other = (Ellipse) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		return true;
	}

}