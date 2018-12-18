package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class CloneCommand implements ICommand {

	private DrawingPane dPane;
	private List<IShape> shapesCreated;
	private List<IShape> shapesSelected;
	
	public CloneCommand(DrawingPane dPane) {
		this.dPane = dPane;
		shapesCreated = new ArrayList<>();
		shapesSelected = this.dPane.getSelection();
		shapesSelected.forEach(shape -> this.shapesCreated.add(shape.clone()));
	}

	@Override
	public void execute() {
		shapesCreated.forEach(shape -> this.dPane.addShape(shape));
	}

	@Override
	public void undo() {
		shapesCreated.forEach(shape -> this.dPane.removeShape(shape));
	}

}
