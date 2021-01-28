package shape;

import java.util.Vector;

public class GGroup extends GRectangle {
	private static final long serialVersionUID = 1L;
	
	private Vector<GShape> containedshapes;
	public GGroup() {
		this.containedshapes = new Vector<GShape>(); 
	}
	public GShape newInstance() {return new GGroup();}

	public void contains(Vector<GShape> shapeVector) {
		for(GShape shape : shapeVector) {
			if(this.getShape().contains(shape.getShape().getBounds())) {
				this.containedshapes.add(shape);
				shape.setSelected(true);
			}
		}
	}
}
