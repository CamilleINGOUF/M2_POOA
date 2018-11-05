package drawing.handlers;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;

    private List<IShape> selectedShapes;

    public MouseMoveHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.setOnMousePressed(this);
        drawingPane.setOnMouseDragged(this);
        drawingPane.setOnMouseReleased(this);
        selectedShapes = new ArrayList<>();
    }

    @Override
    public void handle(MouseEvent event) {

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();

            selectedShapes = drawingPane.getSelection();

        }

        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
            if (selectedShapes.size() == 0)
                return;

            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;

            for(IShape shape : selectedShapes)
            	shape.offset(offsetX, offsetY);
            
            orgSceneX += offsetX;
            orgSceneY += offsetY;
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            selectedShapes = new ArrayList<>();
        }
    }
}
