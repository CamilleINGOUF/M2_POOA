package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class ClearCommand implements ICommand {

	private DrawingPane dPane;
	private List<IShape> shapes;
	
	public ClearCommand(DrawingPane receiver) {
		dPane = receiver;
		shapes = new ArrayList<>();
	}
	
	@Override
	public void execute() {
		shapes = dPane.getShapes();
		dPane.clear();
	}

	@Override
	public void undo() {
		for(IShape shape : shapes)
			dPane.addShape(shape);
		shapes.clear();
	}

}
