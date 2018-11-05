package drawing;

import java.util.stream.StreamSupport;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class StatusBar extends HBox implements Observer{

	private Text status;
	private Text selected;
	private DrawingPane dPane;
	private SelectionHandler selectionHandler;
	
	public StatusBar(DrawingPane dp) 
	{
		status = new Text("Number of shapes : 0; ");
		selected = new Text("Selected shapes : 0");
		this.getChildren().addAll(status, selected);
		dPane = dp;
		dPane.addObserver(this);
		this.selectionHandler = dPane.getSelectionHandler();
		this.selectionHandler.addObserver(this);
	}
	
	@Override
	public void update() 
	{
		Iterable<IShape> newIterable = () -> dPane.iterator();
		long count = StreamSupport.stream(newIterable.spliterator(), false).count();
		status.setText("Number of Shape : "+count+"; ");
		selected.setText("Selected shapes: "+this.selectionHandler.getShapes().size());
	}

}
