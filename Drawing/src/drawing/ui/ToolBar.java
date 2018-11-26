package drawing.ui;

import drawing.handlers.ClearButtonHandler;
import drawing.handlers.DegroupButtonHandler;
import drawing.handlers.DeleteButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.GroupButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.RedoButtonHandler;
import drawing.handlers.TriangleButtonHandler;
import drawing.handlers.UndoButtonHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ToolBar extends HBox {

	private Button clearButton;
	private Button rectangleButton;
	private Button circleButton;
	private Button triangleButton;
	private Button deleteButton;
	private Button groupButton;
	private Button degroupButton;
	private Button undoButton;
	private Button redoButton;

	public ToolBar(DrawingPane drawingPane) {

		ButtonFactory factory = new ButtonFactory();

		clearButton = factory.createButton(ButtonFactory.CLEAR);
		clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(drawingPane));
		rectangleButton = factory.createButton(ButtonFactory.RECTANLGE);
		rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));
		circleButton = factory.createButton(ButtonFactory.CIRCLE);
		circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));
		triangleButton = factory.createButton(ButtonFactory.TRIANGLE);
		triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));
		deleteButton = factory.createButton(ButtonFactory.DELETE);
		deleteButton.addEventFilter(ActionEvent.ACTION, new DeleteButtonHandler(drawingPane));
		groupButton = factory.createButton(ButtonFactory.GROUP);
		groupButton.addEventFilter(ActionEvent.ACTION, new GroupButtonHandler(drawingPane));
		degroupButton = factory.createButton(ButtonFactory.DEGROUP);
		degroupButton.addEventFilter(ActionEvent.ACTION, new DegroupButtonHandler(drawingPane));
		undoButton = factory.createButton(ButtonFactory.UNDO);
		undoButton.addEventFilter(ActionEvent.ACTION, new UndoButtonHandler(drawingPane));
		redoButton = factory.createButton(ButtonFactory.REDO);
		redoButton.addEventFilter(ActionEvent.ACTION, new RedoButtonHandler(drawingPane));

		this.getChildren().addAll(clearButton, rectangleButton, circleButton, triangleButton, deleteButton, groupButton,
				degroupButton, undoButton, redoButton);
		this.setPadding(new Insets(5));
		this.setSpacing(5.0);
		this.getStyleClass().add("toolbar");
	}
}
