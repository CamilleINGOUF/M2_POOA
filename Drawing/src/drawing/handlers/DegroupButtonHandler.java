package drawing.handlers;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.shapes.ShapeGroup;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DegroupButtonHandler implements EventHandler<ActionEvent> {

	private DrawingPane dPane;
	
	public DegroupButtonHandler(DrawingPane drawingPane) {
		this.dPane = drawingPane;
	}

	@Override
	public void handle(ActionEvent event) {
		List<IShape> selectedShapes = dPane.getSelection();
		List<ShapeGroup> groups = new ArrayList<>();
		for(IShape shape : selectedShapes) {
			if(shape instanceof ShapeGroup) {
				groups.add((ShapeGroup)shape);
			}
		}
		
		for(ShapeGroup g : groups)
			degroup(g);
	}
	
	private void degroup(ShapeGroup group) {
		List<IShape> shapes = group.getShapes();
		dPane.removeShape(group);
		for(IShape s : shapes)
			dPane.addShape(s);
	}

}
