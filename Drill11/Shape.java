import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

	public abstract void drawOn(Graphics g, Color color);

	public abstract void moveBy(Point v);

	public abstract Frame getBoundary();

	public abstract void setLongDimension(int longDimension);

	public abstract int getLongDimension();

	public abstract void setAnchor(Point anchorPoint);

	public abstract Point getAnchor();

}