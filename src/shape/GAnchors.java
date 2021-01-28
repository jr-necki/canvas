package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.Vector;
import java.util.prefs.BackingStoreException;

import global.GConstants.EPointerState;

public class GAnchors implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private final int w = 8;
	private final int h = 8;
	private final int dw = w / 2;
	private final int dh = h / 2;

	public enum EAnchors {
		NW, NN, NE, EE, SE, SS, SW, WW, RR
	}

	private Vector<Ellipse2D> anchors;

	@SuppressWarnings("unused")
	public GAnchors() {
		this.anchors = new Vector<Ellipse2D>();
		for (EAnchors eAnchors : EAnchors.values()) {
			this.anchors.add(new Ellipse2D.Double(0, 0, w, h));
		}
	}

	public void draw(Graphics2D g2d) {
		Color c = g2d.getColor();
		g2d.setColor(Color.darkGray);

		for (Shape shape : this.anchors) {
			g2d.draw(shape);
			g2d.fill(shape);

		}
		g2d.setColor(c);
	}

	public EAnchors onShape(int x, int y) {
		for (int i = 0; i < EAnchors.values().length; i++) {
			if (this.anchors.get(i).contains(x, y)) {
				return EAnchors.values()[i];
			}
		}
		return null;
	}

	// 좌표를 설정하는 함수 - 둘러 싸야할 네모를 주면 좌표를 딱 구한다
	public void setBoundingRect(Rectangle r) {
		for (EAnchors eAnchors : EAnchors.values()) {
			int x = 0, y = 0;
			switch (eAnchors) {
			case NW:
				x = r.x;
				y = r.y;
				break;
			case NN:
				x = r.x + r.width / 2;
				y = r.y;
				break;
			case NE:
				x = r.x + r.width;
				y = r.y;
				break;
			case EE:
				x = r.x + r.width;
				y = r.y + r.height / 2;
				break;
			case SE:
				x = r.x + r.width;
				y = r.y + r.height;
				break;
			case SS:
				x = r.x + r.width / 2;
				y = r.y + r.height;
				break;
			case SW:
				x = r.x;
				y = r.y + r.height;
				break;
			case WW:
				x = r.x;
				y = r.y + r.height / 2;
				break;
			case RR:
				x = r.x + r.width / 2;
				y = r.y - 50;
				break;
			}
			// 동그라미가 좌표 중간에 생성되는 것이 아니므로 따로또 수정을 해줘야한다.좌표가 엥커원의 중간에 오도록 하는 작업
			x = x - dw;
			y = y - dh;
			this.anchors.get(eAnchors.ordinal()).setFrame(x, y, w, h);
		}
	}

	public EPointerState includes(int x, int y) {
		for (int i = 0; i < anchors.size(); i++) {
			if (anchors.get(i).contains(x, y)) {return EPointerState.values()[i];}
		}
		return null;
	}

}
