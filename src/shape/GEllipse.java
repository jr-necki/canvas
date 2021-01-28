package shape;

import java.awt.Graphics2D;

import java.awt.Point;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.io.Serializable;

public class GEllipse extends GShape implements Serializable {

	private Ellipse2D.Double ellipse;

	public GEllipse() {
		ellipse = new Ellipse2D.Double();
		this.shape = ellipse;
	}

	public void setOrigin(int x, int y) {
		ellipse.x = x;
		ellipse.y = y;
	}

	public void setPoint(int x, int y) {
		ellipse.width = x - ellipse.x;
		ellipse.height = y - ellipse.y;
	}

	public void addPoint(int x, int y) {

	}

	@Override
	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		// TODO Auto-generated method stub
		int dw = x - px;
		int dh = y - py;

		this.ellipse.setFrame(this.ellipse.x + dw, this.ellipse.y + dh, ellipse.width, ellipse.height);

		this.px = x;
		this.py = y;
	}

	@Override
	public void finishMoving(Graphics2D graphics2d, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public GShape newInstance() {
		return new GEllipse();
	}

	@Override
	public void setText(Graphics2D graphics2d, int x, int y, String input) {
		// TODO Auto-generated method stub
		
	}
}
