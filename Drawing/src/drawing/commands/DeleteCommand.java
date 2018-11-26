package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class DeleteCommand implements ICommand {
	
	private DrawingPane dPane;
	private List<IShape> shapes;
	
	public DeleteCommand(DrawingPane dPane) {
		this.dPane = dPane;
		this.shapes = new ArrayList<>();
		List<IShape> selectedShapes = this.dPane.getSelection();
		selectedShapes.iterator().forEachRemaining(shapes::add);
	}

	@Override
	public void execute() {
		for(IShape shape : shapes)
		{
			dPane.removeShape(shape);
		}
	}

	@Override
	public void undo() {
		for(IShape shape : this.dPane)
			shape.setSelected(false);
		for(IShape shape : this.shapes) {
			this.dPane.addShape(shape);
			shape.setSelected(true);
		}
	}

}
