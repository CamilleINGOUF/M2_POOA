package drawing.ui;

import drawing.handlers.ClearButtonHandler;
import drawing.handlers.DeleteButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.TriangleButtonHandler;
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
        
        this.getChildren().addAll(clearButton, rectangleButton, circleButton,triangleButton, deleteButton);
		this.setPadding(new Insets(5));
        this.setSpacing(5.0);
        this.getStyleClass().add("toolbar");
	}
}
