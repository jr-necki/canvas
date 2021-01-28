package transformer;

import java.awt.Graphics2D;

import shape.GShape;

public abstract class GTransformer {

	private GShape Shape;
	public GTransformer() {
		this.setShape(null);
	}

	public GShape getShape() {return Shape;}
	public void setShape(GShape shape) {this.Shape = shape;}
	public void addPoint(Graphics2D g2d, int x, int y){}
	public void setText(Graphics2D g2d, int x, int y,String input){}
	
	public abstract void initTransforming(Graphics2D g2d, int x, int y);
	public abstract void keepTransforming(Graphics2D g2d, int x, int y);
	public abstract void finishTransforming(Graphics2D g2d, int x, int y);


}
