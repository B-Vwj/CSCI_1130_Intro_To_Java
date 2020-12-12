import java.awt.Color;
import java.awt.Graphics;

public class OuterSpace {

	private SpaceObject spaceObject;
	private Frame limits;

	public OuterSpace(Frame frameLimits) {
		this.limits = frameLimits;
		Shape shape;
		shape = new Circle(new Point(0, 0), 0);
		//shape = new Ellipse(new Point(0, 0), 0, 0);
		SpaceObject so = new SpaceObject(shape);
		this.spaceObject = so;
		this.randomize();
	}

	public static OuterSpace newOuterSpace(Frame frameLimits, SpaceObject aSo) {
		OuterSpace space = new OuterSpace(frameLimits);
		space.spaceObject = aSo;
		return space;
	}



	//=======================================================
	//Accessor Methods

	public SpaceObject getSpaceObject() {
		return this.spaceObject;
	}

	public Frame getLimits() {
		return limits;
	}

	//=======================================================
	//Instance Methods

	public void drawOn(Graphics g) {
		this.spaceObject.drawOn(g);
	}

	public void drawOn(Graphics g, Color c) {
		this.spaceObject.drawOn(g, c);
	}

	public void move() {
		this.spaceObject.move();
		//bring back home if we've escaped our bounds
		constrain(this.spaceObject);
	}

	private void constrain(SpaceObject spaceObject) {
		//If the spaceObject is leaving our limits, bring her home
		//If the boundary of the so is outside our limits, bring her home
		Frame spaceObjectFrame, spaceLimits;
		spaceLimits = this.limits;
		spaceObjectFrame = spaceObject.getBoundary();
		if (spaceLimits.contains(spaceObjectFrame))
			return;
		//We know she is outside
		if (!spaceLimits.containsHoriz(spaceObjectFrame))
			spaceObject.reverseDirectionX();
		if (!spaceLimits.containsVert(spaceObjectFrame))
			spaceObject.reverseDirectionY();
	}

	public void randomize() {
		this.spaceObject.randomize(this.limits);
		this.assureObjectsInside();
	}

	public void setRate(int xRate, int yRate) {
		this.getSpaceObject().setRate(xRate, yRate);
	}

	public void assureObjectsInside() {
		this.spaceObject.assureIn(this.limits);
	}

	@Override
	public String toString() {
		return "Outer Space: "
					+ this.spaceObject.toString()
					+ " "
					+ this.limits.basicToString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((spaceObject == null) ? 0 : spaceObject.hashCode());
		result = prime * result + ((limits == null) ? 0 : limits.hashCode());
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
		OuterSpace other = (OuterSpace) obj;
		if (!spaceObject.equals(other.getSpaceObject()))
			return false;
		if (!limits.equals(other.limits))
			return false;
		return true;
	}

}
