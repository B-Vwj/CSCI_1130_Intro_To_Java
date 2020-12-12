/**
 * Class: ForwardIndicator
 * Class that indicates "direction" (movement)
 *
 * My most important job is "reversing" graphics objects.
 * If my xForward is false, I will "reverse" the
 * movement of a direction object (by negating it's x value).
 * Similar for yForward.
 *
 * Usage:
 * 	ForwardIndicator myDirection = new ForwardIndicator();
 *  int x = 20;
 *  x.negateX();
 *  x = myDirection.conformX(x);
 *  //We just reversed x -- so x is now -20
 *	x = myDirection.conformX(x);
 *  //We just reversed x again -- so x is now 20 or +20 (same thing)
 *
 */

class ForwardIndicator {

	//-------------------------------------------
	//Instance Variables

	private boolean xForward;
	private boolean yForward;

	public ForwardIndicator() {
		this.xForward = true;
		this.yForward = true;
	}

	public void negateX() {
		this.xForward = !this.xForward;
	}

	public void negateY() {
		this.yForward = !this.yForward;
	}

	public int conformX(int x) {
		//if forward just retun as-is, if backward negate
		return x * (this.xForward ? 1 : -1);
	}

	public int conformY(int y) {
		//if forward just retun as-is, if backward negate
		return y * (this.yForward ? 1 : -1);
	}

	public Point toVector() {
		int x, y;
		x = this.xForward ? 1 : -1;
		y = this.yForward ? 1 : -1;
		return new Point(x, y);
	}
	
	@Override
	public String toString() {
		return "ForwardIndicator: (" + xForward + ", " 
				+ yForward + ") " + "(xForward, yForward)";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Boolean.valueOf(xForward).hashCode();
		result = prime * result + Boolean.valueOf(yForward).hashCode();
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
		ForwardIndicator other = (ForwardIndicator) obj;
		if (xForward != other.xForward)
			return false;
		if (yForward != other.yForward)
			return false;
		return true;
	}	

}