package shape;

import java.awt.Graphics2D;
import java.awt.Polygon;

public class GPolygon extends GShape {

	private Polygon poly;

	public GPolygon() {
		super();
		this.poly = new Polygon();
		this.shape = this.poly;
	}

	public void setOrigin(int x, int y) {
		this.poly.addPoint(x, y);

	}
	public void addPoint(int x, int y) {
		this.poly.addPoint(x, y);
	}

	public void setPoint(int x, int y) {
		this.poly.xpoints[this.poly.npoints - 1] = x;
		this.poly.ypoints[this.poly.npoints - 1] = y;
	}

	

	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		int dw = x - px;
		int dh = y - py;
		
		this.poly.translate(dw, dh);

		this.px = x;
		this.py = y;
	}

	public void finishMoving(Graphics2D graphics2d, int x, int y) {
		Polygon newPoly = new Polygon();
		for (int i = 0; i < this.poly.npoints; i++) {
			newPoly.addPoint(this.poly.xpoints[i], this.poly.ypoints[i]);
		}
		this.poly = newPoly;
		this.shape = this.poly;
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
