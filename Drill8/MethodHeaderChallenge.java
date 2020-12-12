
public class MethodHeaderChallenge  {

	public Point problem1(Point p1, Point p2, int k) {
		Point p3;
		Point p4;

		p3 = p1.multiply(p2);
		p4 = p3.multiply(k);

		return p4;
	}

	public void problem2_NOT_USED() {
		//NOTE: We are not using this problem for this problem set
	}

	public void problem3_NOT_USED() {
		//NOTE: We are not using this problem for this problem set
	}

	public void problem4_NOT_USED() {
		//NOTE: We are not using this problem for this problem set
	}

	public void problem5_NOT_USED() {
		//NOTE: We are not using this problem for this problem set
	}

	public boolean problem6(Ellipse ellipse, Frame frame) {

		boolean result = frame.contains(ellipse.getBoundary());

		return result;
	}

	public void problem7(Circle circ, Ellipse ellipse) {
		//YOUR CODE HERE
	}

	public Ellipse problem8(ForwardIndicator fw, int x, int y) {
		// int x2, y2;

		int x2 = fw.conformX(x);
		int y2 = fw.conformY(y);

		Point p = new Point();

		p.setX(x2);
		p.setY(y2);

		Ellipse elli = new Ellipse();

		elli.setAnchor(p);
		elli.setLongDimension(100);

		return elli;
	}

	public Point problem9(Frame frame) {

		Point leftTop = new Point();

		leftTop.setX(frame.getLeft());
		leftTop.setY(frame.getTop());

		return leftTop;
	}

	public String problem10() {
		Point p = new Point();

		p.setX(123);
		p.setY(405);

		String niceString = new String();

		niceString = p.toString();

		return niceString;
	}

	public Circle problem11(Frame frame) {
		Circle circ = new Circle();

		circ.setAnchor(frame.middle());
		circ.setLongDimension(frame.getLeft());

		return circ;
	}

	public void problem12_NOT_USED() {
		//NOTE: We are not using this problem for this problem set
	}

	public void problem13(Frame frame, int value) {
		//YOUR CODE HERE
	}

	public Ellipse problem14(Frame frame) {
		Ellipse ellipse = new Ellipse();

		ellipse.setAnchor(frame.middle());
		ellipse.setLongDimension(frame.getLeft());

		return ellipse;
	}

	public void problem15(OuterSpace space, Point p) {
		//YOUR CODE HERE
	}

	public void problem16(Frame frame, Point p) {
		//YOUR CODE HERE
	}

}