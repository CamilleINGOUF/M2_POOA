package drawing;
import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectionHandler implements EventHandler<MouseEvent>, Observable {

	private DrawingPane drawingPane;
	
	private List<IShape> selectedShapes;
	
	private List<Observer> observers;

	public SelectionHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        this.drawingPane.setOnMouseClicked(this);
        selectedShapes = new ArrayList<>();
        this.observers = new ArrayList<>();
	}

	@Override
	public void handle(MouseEvent event) {
		if(event.isShiftDown())
		{
			for(IShape shape : drawingPane)
			{
				if(shape.isOn(event.getX(), event.getSceneY()))
				{
					addOrRemoveSelectedShape(shape);
					break;
				}
			}
		} 
		else 
		{
			for(IShape shape : drawingPane)
			{
				removeShape(shape);
				if(shape.isOn(event.getX(), event.getY()))
					addOrRemoveSelectedShape(shape);
			}
		}
		notifyObservers();
	}
	
	private void addOrRemoveSelectedShape(IShape shape)
	{
		if(selectedShapes.contains(shape))
		{
			removeShape(shape);
		}
		else
		{
			addShape(shape);
		}
	}
	
	private void addShape(IShape shape)
	{
		selectedShapes.add(shape);
		shape.setSelected(true);
	}
	
	private void removeShape(IShape shape)
	{
		selectedShapes.remove(shape);
		shape.setSelected(false);
	}
	
	public List<IShape> getShapes()
	{
		return selectedShapes;
	}

	@Override
	public void addObserver(Observer o) 
	{
		this.observers.add(o);
	}

	@Override
	public void notifyObservers() 
	{
		for(Observer o : observers)
			o.update();
	}
}
