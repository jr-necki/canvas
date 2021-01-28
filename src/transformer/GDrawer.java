package transformer;

import java.awt.Graphics2D;

public class GDrawer extends GTransformer {

	public GDrawer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initTransforming(Graphics2D g2d, int x, int y) {
		this.getShape().setOrigin(x, y);
	}

	@Override
	public void keepTransforming(Graphics2D g2d, int x, int y) {
		this.getShape().draw(g2d);
		this.getShape().setPoint(x, y);
		this.getShape().draw(g2d);

	}

	@Override
	public void finishTransforming(Graphics2D g2d, int x, int y) {

	}

	public void addPoint(Graphics2D g2d, int x, int y) {
		this.getShape().addPoint(x, y);
		this.getShape().draw(g2d);
	}
	public void setText(Graphics2D g2d, int x, int y,String input) {
		this.getShape().setText(g2d, x, y,input);
		this.getShape().draw(g2d);
		System.out.println("drawer");
	}
}
