package transformer;

import java.awt.Graphics2D;

public class GMover extends GTransformer{
	
	
	public GMover() {
		
	}
	@Override
	public void initTransforming(Graphics2D g2d, int x, int y) {
		this.getShape().initMoving(g2d, x, y);

	}

	@Override
	public void keepTransforming(Graphics2D g2d, int x, int y) {
		this.getShape().draw(g2d);
		this.getShape().keepMoving(g2d, x, y);
		this.getShape().draw(g2d);
		
	}

	@Override
	public void finishTransforming(Graphics2D g2d, int x, int y) {
		this.getShape().finishMoving(g2d, x, y);
		
	}

	
}
