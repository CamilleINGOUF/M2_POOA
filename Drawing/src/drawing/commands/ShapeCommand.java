package drawing.commands;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class ShapeCommand implements ICommand {

	private DrawingPane dPane;
	private IShape shape;
	
	public ShapeCommand(DrawingPane dPane, IShape shape) {
		this.dPane = dPane;
		this.shape = shape;
	}

	@Override
	public void execute() {
		dPane.addShape(shape);
	}

	@Override
	public void undo() {
		dPane.removeShape(shape);
	}

}
