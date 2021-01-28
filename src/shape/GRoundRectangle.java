package shape;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;
import java.io.Serializable;

public class GRoundRectangle extends GShape implements Serializable{
	
	private RoundRectangle2D.Double rect;
	
	public GRoundRectangle() {
		super();
		this.shape = new RoundRectangle2D.Double();
		this.rect = (Double)shape;
	}
	public void setOrigin(int x, int y) {
		rect.x=x;
		rect.y=y;
	}
	public void setPoint(int x, int y) {
		rect.width = x - rect.x;
		rect.height = y - rect.y;
		this.rect.setRoundRect(this.rect.x, this.rect.y, rect.width, rect.height,40.0,40.0);
	}
	public void addPoint(int x, int y) {
		
	}
	
	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		int dw = x-px;
		int dh = y-py;
		
		this.rect.setRoundRect(this.rect.x+dw, this.rect.y+dh, rect.width, rect.height,40.0,40.0);
		
		this.px=x;
		this.py=y;
	}
	public void finishMoving(Graphics2D graphics2d, int x, int y) {}
	@Override
	public GShape newInstance() {
		return new GRoundRectangle();
	}
	@Override
	public void setText(Graphics2D graphics2d, int x, int y, String input) {
		// TODO Auto-generated method stub
		
	}
}