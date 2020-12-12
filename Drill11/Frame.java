
/*
lt left top
rt right top
rb right bottom
lb left bottom

NOTE WELL -- In computer graphics y axis is oriented downward (top to bottom).
X is left to right.
*/

public class Frame {

	private int leftX, topY, rightX, bottomY;

	public Frame(int newLeftX, int newTopY, int newRightX, int newBottomY) {
		this.leftX = newLeftX;
		this.topY = newTopY;
		this.rightX = newRightX;
		this.bottomY = newBottomY;
	}

	@Override	
	public String toString() {
		return "Frame: " + basicToString();
	}
	
	public String basicToString() {
		String delim = ", ";
		return "(" + getLeft() + delim + getTop() + delim
			+ getRight() + delim + getBottom() + ")";
	}
	
	public String toStringLegend() {
		return "(leftX, topY, rightX, bottomY)";
	}	

	public Point lt() {
		return new Point(getLeft(), getTop());
	}

	public Point rt() {
		return new Point(getRight(), getTop());
	}

	public Point rb() {
		return new Point(getRight(), getBottom());
	}

	public Point lb() {
		return new Point(getLeft(), getBottom());
	}

	public int getLeft() {
		return this.leftX;
	}

	public int getTop() {
		return this.topY;
	}

	public int getRight() {
		return this.rightX;
	}

	public int getBottom() {
		return this.bottomY;
	}

	public boolean intersects(Frame other) {
		return contains(other.lt()) || contains(other.rt()) || contains(other.rb()) || contains(other.lb());
	}

	public boolean contains(Frame other) {
		return this.containsHoriz(other) && this.containsVert(other);
	}

	public boolean containsHoriz(Frame other) {
		return this.containsX(other.getLeft()) && this.containsX(other.getRight());
	}

	public boolean containsVert(Frame other) {
		return this.containsY(other.getTop()) && this.containsY(other.getBottom());
	}

	public boolean contains(Point p) {
		return containsX(p.getX()) && containsY(p.getY());
	}

	public boolean containsX(int x) {
		return x >= getLeft() && x <= getRight();
	}

	public boolean containsY(int y) {
		return y >= getTop() && y <= getBottom();
	}

	public void shrinkByAmount(int shrink) {
		this.leftX += shrink;
		this.topY += shrink;
		this.rightX -= shrink;
		this.bottomY -= shrink;
	}

	public int getWidth() {
		return this.rightX - this.leftX;
	}

	public int getHeight() {
		return this.bottomY - this.topY;
	}

	public Point middle() {
		int x, y;
		x = this.leftX + (int)Math.round(this.getWidth() / 2.0);
		y = this.topY + (int)Math.round(this.getHeight() / 2.0);
		return new Point(x, y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bottomY;
		result = prime * result + leftX;
		result = prime * result + rightX;
		result = prime * result + topY;
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
		Frame other = (Frame) obj;
		if (bottomY != other.bottomY)
			return false;
		if (leftX != other.leftX)
			return false;
		if (rightX != other.rightX)
			return false;
		if (topY != other.topY)
			return false;
		return true;
	}
	
	

}