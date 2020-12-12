import java.awt.Color;
import java.awt.Graphics;

class SpaceObject {

	//-------------------------------------------
	//Instance Variables

	private Shape shape;
	private ForwardIndicator forwardIndicator;
	private Color color; // foreground color
	private Point rate;	//rate of movement (or step size) in x and y

	//=======================================================
	//Constructors

	public SpaceObject(Shape newSS) {
		this.shape = newSS;
		this.forwardIndicator = new ForwardIndicator();
		this.rate = new Point();
		this.color = Color.blue;
	}

	//=======================================================
	//Accessors	(Getters and Setters)

	public Point getRate() {
		return rate;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color c) {
		this.color = c;
	}

	public void setRate(int movementX, int movementY) {
		this.rate = new Point(movementX, movementY);
	}

	//=======================================================

	//Special Accessors (Getters and Setters)

	public void setLongDimension(int longDimension) {
		this.shape.setLongDimension(longDimension);
	}

	public void setAnchor(Point aPoint) {
		this.shape.setAnchor(aPoint);
	}

	public Point getAnchor() {
		return this.shape.getAnchor();
	}

	public int getLongDimension() {
		return this.shape.getLongDimension();
	}

	public Frame getBoundary() {
		return this.shape.getBoundary();
	}

	//=======================================================
	//Instance Methods - Drawing

	public void drawOn(Graphics g) {
		drawOn(g, this.color);
	}

	public void drawOn(Graphics g, Color c) {
		this.shape.drawOn(g, c);
	}

	//=======================================================
	//Instance Methods - Changing

	public void move() {
		Point v = this.forwardIndicator.toVector();
		v = v.multiply(this.rate);
		this.shape.moveBy(v);
	}

	public void reverseDirectionX() {
		this.forwardIndicator.negateX();
	}

	public void reverseDirectionY() {
		this.forwardIndicator.negateY();
	}

	public void randomize(Frame spaceLimits) {

		//this.setRate(Toolbox.getRandomNumber(20)-10, Toolbox.getRandomNumber(20)-10);

		//Setting new random speed
		int maxRate = 45;
		int halfMaxRate = (int)Math.round((double)maxRate/2.0);
		int dx = Toolbox.getRandomNumber(maxRate) - halfMaxRate;
		int halfDx = (int)Math.round((double)dx/2.0);
		int dy = Toolbox.getRandomNumber(dx) - halfDx;
		this.setRate(dx, dy);
		System.out.println("Rate: " + this.getRate());

		//Setting new random size
		int max = Math.round(spaceLimits.getWidth() / 2);
		int span = Toolbox.getRandomNumber(max);
		this.setLongDimension(span);

		//Setting new random position
		int x, y;
		x = Toolbox.getRandomNumber(spaceLimits.getRight());
		y = Toolbox.getRandomNumber(spaceLimits.getBottom());
		this.setAnchor(new Point(x, y));

		//doesn't seem to work -- Color color = new Color((int)Math.round(0xFFFFFF));
		//this.setColor(color);


		float r = Toolbox.getRandomFloat(1);
		float g = Toolbox.getRandomFloat(1);
		float b = Toolbox.getRandomFloat(1);
		this.color = new Color(r, g, b);
	}

	public void assureIn(Frame frame) {
		if (!frame.contains(this.getBoundary()))
				this.shape.setAnchor(frame.middle());
	}

	@Override
	public String toString() {
		return "Space Object: "
					+ this.shape.toString()
					+ " "
					+ this.forwardIndicator.toString()
					+ " "
					+ "Rate: " + this.rate.toString()
					+ " "
					+ "Color: " + this.color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.color.hashCode();
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		result = prime * result + ((forwardIndicator == null) ? 0 : forwardIndicator.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpaceObject other = (SpaceObject) obj;
		if (!color.equals(other.color))
			return false;
		if (!shape.equals(other.shape))
			return false;
		if (!forwardIndicator.equals(other.forwardIndicator))
			return false;
		if (!rate.equals(other.rate))
			return false;
		return true;
	}

}
