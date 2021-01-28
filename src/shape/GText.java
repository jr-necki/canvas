package shape;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.JOptionPane;

import drawingPanel.GDrawingPanel;

public class GText extends GShape implements Cloneable, Serializable{
	private static final long serialVersionUID = 1L;
	
	public GText() {
	}

	public void setOrigin(int x, int y) {
	}
	public void setPoint(int x, int y) {
		
	}

	public void setText(Graphics2D g2d, int x, int y,String input) {
		g2d.setFont(new Font("Arial",Font.ITALIC,50));
		g2d.drawString(input, x, y);
		System.out.println(1);
	}
	
	
	public void keepMoving(Graphics2D graphics2d, int x, int y) {
	}
	public void finishMoving(Graphics2D graphics2d, int x, int y) {}
	public void addPoint(int x, int y) {}
	public GShape newInstance() {return new GText();}

	
}
