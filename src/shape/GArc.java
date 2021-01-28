package shape;

import java.awt.Graphics2D;

import java.awt.Point;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.io.Serializable;

public class GArc extends GShape implements Serializable {

	private Arc2D.Double arc;

	public GArc() {
		arc = new Arc2D.Double();
		this.shape = arc;
	}

	public void setOrigin(int x, int y) {
		arc.x = x;
		arc.y = y;
	}

	public void setPoint(int x, int y) {
		arc.width = x - arc.x;
		arc.height = y - arc.y;
		this.arc.setAngles(x,y,60,90);
	}

	public void addPoint(int x, int y) {
		

	}

	@Override
	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		// TODO Auto-generated method stub
		int dw = x - px;
		int dh = y - py;

		this.arc.setFrame(this.arc.x + dw, this.arc.y + dh, arc.width, arc.height);

		this.px = x;
		this.py = y;
	}

	@Override
	public void finishMoving(Graphics2D graphics2d, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public GShape newInstance() {
		return new GArc();
	}

	@Override
	public void setText(Graphics2D graphics2d, int x, int y, String input) {
		// TODO Auto-generated method stub
		
	}
}
