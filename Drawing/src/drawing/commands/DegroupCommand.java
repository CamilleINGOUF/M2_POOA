package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.shapes.ShapeGroup;
import drawing.ui.DrawingPane;

public class DegroupCommand implements ICommand {

	private DrawingPane dPane;
	private List<ShapeGroup> groups;
	private List<IShape> shapes;
	
	public DegroupCommand(DrawingPane drawingPane) {
		this.dPane = drawingPane;
		List<IShape> selectedShapes = dPane.getSelection();
		this.groups = new ArrayList<>();
		for(IShape shape : selectedShapes) {
			if(shape instanceof ShapeGroup) {
				groups.add((ShapeGroup)shape);
			}
		}
	}
	@Override
	public void execute() {
		
		for(ShapeGroup g : groups)
			degroup(g);
	}
	
	private void degroup(ShapeGroup group) {
		shapes = group.getShapes();
		dPane.removeShape(group);
		for(IShape s : shapes)
			dPane.addShape(s);
	}

	@Override
	public void undo() {
		this.shapes.forEach(shape -> this.dPane.removeShape(shape));
		this.groups.forEach(group -> this.dPane.addShape(group));
	}

}
