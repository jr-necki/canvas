package shape;

import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.io.Serializable;

public class GLine extends GShape implements Serializable{
	
	private Line2D.Double line;
	private Point point;
	
	public GLine() {
		super();
		this.point = new Point(0, 0);
		line = new Line2D.Double(){
			@Override
			public boolean contains(double x, double y){
				return this.intersects(x, y, 1, 1);
			}
		};
		this.shape = line;
	}
	public void setOrigin(int x, int y) {
		this.point = new Point(x,y);
		line.setLine(x, y, x, y);
	}
	public void setPoint(int x, int y) {
		
		this.line.setLine(point.x, point.y, x, y);
		
	}
	public void addPoint(int x, int y) {
		
	}
	
	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		int dw = x-px;
		int dh = y-py;
		
		this.line.setLine(this.line.x1+dw, this.line.y1+dh,this.line.x2+dw, this.line.y2+dh);
		
		this.px=x;
		this.py=y;
	}
	public void finishMoving(Graphics2D graphics2d, int x, int y) {}
	@Override
	public GShape newInstance() {
		return new GLine();
	}
	@Override
	public void setText(Graphics2D graphics2d, int x, int y, String input) {
		// TODO Auto-generated method stub
		
	}
}
