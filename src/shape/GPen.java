package shape;

import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.io.Serializable;

public class GPen extends GShape implements Serializable{
	
	private Polygon pen;

	public GPen() {
		super();
		this.pen = new Polygon();
		this.shape = this.pen;
	}

	public void setOrigin(int x, int y) {
		this.pen.addPoint(x, y);

	}
	public void addPoint(int x, int y) {
		this.pen.addPoint(x, y);
	}

	public void setPoint(int x, int y) {
		this.pen.xpoints[this.pen.npoints - 1] = x;
		this.pen.ypoints[this.pen.npoints - 1] = y;
	}

	

	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		int dw = x - px;
		int dh = y - py;
		
		this.pen.translate(dw, dh);

		this.px = x;
		this.py = y;
	}

	public void finishMoving(Graphics2D graphics2d, int x, int y) {
		Polygon newPoly = new Polygon();
		for (int i = 0; i < this.pen.npoints; i++) {
			newPoly.addPoint(this.pen.xpoints[i], this.pen.ypoints[i]);
		}
		this.pen = newPoly;
		this.shape = this.pen;
	}

	@Override
	public GShape newInstance() {
		return new GPolygon();
	}
	@Override
	public void setText(Graphics2D graphics2d, int x, int y, String input) {
		// TODO Auto-generated method stub
		
	}
}
