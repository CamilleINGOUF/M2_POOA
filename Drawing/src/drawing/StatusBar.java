package drawing;

import java.util.stream.StreamSupport;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.shape.Shape;

public class StatusBar extends HBox implements Observer{

	private Text status;
	private DrawingPane dPane;
	
	public StatusBar(DrawingPane dp) 
	{
		status = new Text("Number of shapes : 0");
		this.getChildren().add(status);
		dPane = dp;
		dPane.addObserver(this);
	}
	
	@Override
	public void update() 
	{
		Iterable<IShape> newIterable = () -> dPane.iterator();
		long count = StreamSupport.stream(newIterable.spliterator(), false).count();
		status.setText("Number of Shape : "+count);
	}

}
