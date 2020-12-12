public class Point {

	private int x;
	private int y;

	//-----------------------------------------------
	//Methods for graphics

	public void moveBy(Point other) {
		/*Move this point by "other"
		Increase our x by other's x
		Increase our y by other's y
		e.g. (10,5) + (2,1) = (12,6)
		Algorithm:
			Set our x equal to our x + other's x
			Set our y equal to our y + other's y
		NOTE WELL:
			We do YES change "this" point (we do NOT return a new Point)
			our means this
		*/
		//CODE HERE
		this.x += other.getX();
		this.y += other.getY();
	}

	public Point multiply(Point other) {
		/*
		Algorithm:
			Construct new point, let's call it "p"
			Set p's x with our (this) x times other's x
			Set p's y with our (this) y times other's y
			return p
		 NOTE WELL: We do NOT change "this" point
		  			(instead we return a new Point)
		*/
		//CODE HERE
		Point p = new Point();
		int pX = p.getX() * other.getX();
		int pY = p.getY() * other.getY();
		p.set(pX, pY);
		return p;
	}

	//-----------------------------------------------
	//Constructors

	/** no-args constructor */
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	/** full constructor (initializing all our base ivars) */
	public Point(int aX, int aY) {
		this.x = aX;
		this.y = aY;
	}

	/** one-param, set both ivars with param */
	public Point(int value) {
		this.x = value;
		this.y = value;
		//Could also do this (would need to be first line of constructor):
		//this(value, value);
	}

	//-----------------------------------------------

	public void moveToOrigin() {
		x = 0;
		y = 0;
	}

	public void move1() {
		x = 100;
		y = 70;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	//-----------------------------------------------------
	//Setting

	public void setX(int aX) {
		this.x = aX;
	}

	public void setY(int aY) {
		this.y = aY;
	}

	public void set(int value) {
		//Simplify by calling sister method (method in this class)
		this.set(value, value);
		/*Also could do:
		this.setX(value);
		this.setY(value);*/
		/*Also could do:
		this.x = value;
		this.y = value;*/
	}

	public void set(int aX, int aY) {
		this.setX(aX);
		this.setY(aY);
		/*Also could do:
		this.x = value;
		this.y = value;*/
	}

	//-----------------------------------------------------

	@Override
	public String toString() {
		return "Point: " + basicToString();
	}

	public String basicToString() {
		return "(" + this.x + ", " + this.y + ")";
	}

}