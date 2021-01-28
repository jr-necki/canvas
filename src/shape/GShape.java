package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import global.GConstants.EPointerState;
import shape.GAnchors.EAnchors;

public abstract class GShape implements Serializable{
	private static final long serialVersionUID = 1L;
	public enum EOnState {eOnShape, eOnResize, eOnRotate};
	// shape의 Actionstate를 drawingpanel의 actionstate로 바꾼다

	protected int px;
	protected int py;
	protected Shape shape;
	public Shape getShape() {return this.shape;}
	protected GAnchors anchors;
	protected Color lineColor, fillColor;
	protected float dashs[] = {4};
	public Color getLineColor() {return lineColor;}
	public void setLineColor(Color lineColor) {this.lineColor = lineColor;}
	public Color getFillColor() {return fillColor;}
	public void setFillColor(Color fillColor) {this.fillColor = fillColor;}
	
	
	public boolean selected;
	protected int s;
	public boolean isSelected() {return selected;} // boolean인 경우에만 get이 아니라 is로 생성된다.
	public void setSelected(boolean selected) {
		this.selected = selected;
		if (this.selected) {this.anchors.setBoundingRect(this.shape.getBounds());
			// 셀렉트가 도면 쉐입에 자기를 둘러싸고 있는 네모를 부른다음 그것을 엥커로 보내면 엥커가 좌표값을 계산한다.
		}
	}

	public GShape() {
		this.selected = false;
		this.anchors = new GAnchors();
	}
	
	public abstract GShape newInstance(); 

	public abstract void setOrigin(int x, int y);
	public abstract void setPoint(int x, int y);
	public abstract void setText(Graphics2D graphics2d,int x, int y, String input);
	public abstract void addPoint(int x, int y);
	public abstract void keepMoving(Graphics2D graphics2d, int x, int y);
	public abstract void finishMoving(Graphics2D graphics2d, int x, int y);

	public GShape clone() {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(this);
		
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			return (GShape)objectInputStream.readObject();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void draw(Graphics2D g2d) {
		System.out.println(this.shape);
		Color color = g2d.getColor();
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashs, 0));
		g2d.setColor(this.fillColor);
		if(this.shape!=null){
		g2d.fill(shape);
		g2d.setColor(this.lineColor);
		g2d.draw(this.shape);
		g2d.setColor(color);}
		else
			g2d.draw(this.shape);
		
		g2d.setStroke(new BasicStroke(s,BasicStroke.CAP_ROUND, 0));
		g2d.setColor(this.fillColor);
		if(this.shape!=null){
		g2d.fill(shape);
		g2d.setColor(this.lineColor);
		g2d.draw(this.shape);
		g2d.setColor(color);}
		else
			g2d.draw(this.shape);

		if(this.selected) {
			this.anchors.setBoundingRect(this.shape.getBounds());
			this.anchors.draw(g2d);
		}else {
			
		}
	}

	public EOnState onShape(int x, int y) {
		if (this.selected) {
			EAnchors eAnchor = this.anchors.onShape(x, y);
			if (eAnchor == EAnchors.RR) {// rotate
				return EOnState.eOnRotate;
			} else if (eAnchor == null) {//
				if (this.shape.contains(x, y)) {
					return EOnState.eOnShape;
				}
			} else {// resize
				return EOnState.eOnResize;
			}
		} else {
			if (this.shape.contains(x, y)) {
				return EOnState.eOnShape;
			}
		}
		return null;
	}

	public void initMoving(Graphics2D graphics2d, int x, int y) {
		this.px = x;
		this.py = y;
		if(!this.selected) {
			this.anchors.setBoundingRect(this.shape.getBounds());
			this.anchors.draw(graphics2d);
		}
	}
	
	
	public EPointerState includes(int x, int y) {
		if(selected) {
			EPointerState state = anchors.includes(x, y);
			if(state != null) {	return state;}
		}
		if(shape.contains(x, y)) {return EPointerState.MM;}
		return null;
	}
	public void setPenSize(int s) {
		this.s=s;
		
	}


}
