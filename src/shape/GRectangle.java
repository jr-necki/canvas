package shape;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

public class GRectangle extends GShape implements Cloneable, Serializable{
	private static final long serialVersionUID = 1L;
	
	private Rectangle rect;
	
	public GRectangle() {
		super();
		this.shape = new Rectangle();
		this.rect = (Rectangle)shape;
	}
	public void setOrigin(int x, int y) {
		this.rect.setBounds(x, y, 0, 0);
	}
	public void setPoint(int x, int y) {
		this.rect.setSize(x-this.rect.x, y-this.rect.y);
	}
	public void addPoint(int x, int y) {
		
	}
	
	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		int dw = x-px;
		int dh = y-py;
		
		this.rect.setLocation(this.rect.x+dw, this.rect.y+dh);
		
		this.px=x;
		this.py=y;
	}
	public void finishMoving(Graphics2D graphics2d, int x, int y) {}
	@Override
	public GShape newInstance() {
		return new GRectangle();
	}
	@Override
	public void setText(Graphics2D graphics2d, int x, int y, String input) {
		// TODO Auto-generated method stub
		
	}
}
