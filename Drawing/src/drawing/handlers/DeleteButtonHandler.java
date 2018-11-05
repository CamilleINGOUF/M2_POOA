package drawing.handlers;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DeleteButtonHandler implements EventHandler<ActionEvent> {

	private DrawingPane dPane;
	
	public DeleteButtonHandler(DrawingPane drawingPane) {
		this.dPane = drawingPane;
	}

	@Override
	public void handle(ActionEvent event) {
		List<IShape> selectedShapes = this.dPane.getSelection();
		List<IShape> shapes = new ArrayList<IShape>();
		dPane.iterator().forEachRemaining(shapes::add);
		for(IShape shape : shapes)
		{
			if(selectedShapes.contains(shape))
				dPane.removeShape(shape);
		}
	}

}
