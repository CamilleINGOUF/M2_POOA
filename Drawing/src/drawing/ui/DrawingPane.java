package drawing.ui;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import drawing.commands.CommandHistory;
import drawing.handlers.MouseMoveHandler;
import drawing.handlers.SelectionHandler;
import drawing.shapes.IShape;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class DrawingPane extends Pane implements Iterable<IShape>, Observable {

    @SuppressWarnings("unused")
	private MouseMoveHandler mouseMoveHandler;
    private SelectionHandler selectionHandler;

    private ArrayList<IShape> shapes;
    
    private List<Observer> observers;
    
    private CommandHistory history;

    public DrawingPane() {
        clipChildren();
        shapes = new ArrayList<>();
        mouseMoveHandler = new MouseMoveHandler(this);
        selectionHandler = new SelectionHandler(this);
        observers = new ArrayList<>();
        history = new CommandHistory();
    }
    
    public List<IShape> getSelection()
    {
    	return selectionHandler.getShapes();
    }

    public List<IShape> getShapes()
    {
    	return shapes;
    }
    
    public CommandHistory getHistory() {
    	return history;
    }

    /**
     * Clips the children of this {@link Region} to its current size.
     * This requires attaching a change listener to the region’s layout bounds,
     * as JavaFX does not currently provide any built-in way to clip children.
     */
    void clipChildren() {
        final Rectangle outputClip = new Rectangle();
        this.setClip(outputClip);

        this.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
        shape.addShapeToPane(this);
        notifyObservers();
    }
    
    public void removeShape(IShape shape) {
    	shapes.remove(shape);
    	shape.remove(this);
    	this.selectionHandler.removeShape(shape);
    	notifyObservers();
    }
    
    public void clear() {
    	for(IShape shape : shapes)
    	{
    		this.selectionHandler.removeShape(shape);
    		shape.remove(this);
    	}
        shapes.clear();
        notifyObservers();
    }


	@Override
	public Iterator<IShape> iterator() {
		return shapes.iterator();
	}


	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public SelectionHandler getSelectionHandler() 
	{
		return selectionHandler;
	}
	
	@Override
	public void notifyObservers() 
	{
		for(Observer o : observers)
			o.update();
	}
}
