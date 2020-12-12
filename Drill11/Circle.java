import java.awt.Color;
import java.awt.Graphics;

/*
 NOTE WELL
 	When you see "our" or "my" think "this" object
 	e.g.
 	The note:
 		Set "our" center to parameter
 	Means:
 		Set the center of "this" object to the parameter
 */

class Circle extends Shape {

	//-------------------------------------------
	//Instance Variables

	//CODE HERE (ivars)
	private Point center;
	private int radius;

	//-------------------------------------------
	//Constructors

	public Circle(Point cc, int rr) {
		//Set our center to parameter
		//Set our ivar to parameter
		//CODE HERE
		this.center = cc;
		this.radius = rr;
	}

	public Circle() {
		//No args constructor
		//Set our center to a point with x=0, y=0
		//Set our radius to 0
		//CODE HERE
		this.center = new Point(); // Defaults x and y values to 0
		this.radius = 0;
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
		 top is the top edge of the circlc
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
		/*Return a Frame object that defines the boundary of this circle
		Sketch out a circle and you'll see that using the "center" and "radius"
		you can find left, top, right, bottom.
		Remember y axis is downward (so bottom is larger than top)
		Remember you can not only get you ivars, but also send messages to them
		*/
		//CODE HERE
		Frame f = new Frame(center.getX(), center.getY(), center.getX(), center.getY());
		f.contains(center);
		Point point = f.lt();
		f.contains(f);
		return f;
	}

	public int getLongDimension() {
		//Simply return the diameter of this circle.
		//In other words 2 * our radius
		//CODE HERE
		return 2 * this.radius;
	}

	public void setAnchor(Point anchorPoint) {
		//Simply set our center	to the param
		//CODE HERE
		this.center = anchorPoint;
	}

	public Point getAnchor() {
		//Simply return our center
		//CODE HERE
		return this.center;
	}

	//============================================================
	//Code below this line is DONE

	public void setLongDimension(int longDimension) {
		//THIS CODE IS DONE
		this.radius = (int)Math.round(longDimension / 2.0);
	}

	@Override
	public String toString() {
		//THIS CODE IS DONE
		Frame f = getBoundary();
		return "Circle: " + this.center.basicToString() + " r=" + this.radius
			+ " " + f.basicToString() + f.toStringLegend();
	}

	@Override
	public int hashCode() {
		//THIS CODE IS DONE
		//Return hash code that identifies object
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + radius;
		return result;
	}

	@Override
	public boolean equals(Object aOther) {
		//THIS CODE IS DONE
		//Return true if we equal param aOther
		if (this == aOther)
			return true;
		if (aOther == null)
			return false;
		if (getClass() != aOther.getClass())
			return false;
		Circle other = (Circle) aOther;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (radius != other.radius)
			return false;
		return true;
	}

}