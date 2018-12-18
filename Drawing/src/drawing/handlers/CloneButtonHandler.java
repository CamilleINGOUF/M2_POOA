package drawing.handlers;

import drawing.commands.CloneCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CloneButtonHandler implements EventHandler<ActionEvent> {

	private DrawingPane dPane;
	private ICommand command;
	
	public CloneButtonHandler(DrawingPane drawingPane) {
		this.dPane = drawingPane;
	}

	@Override
	public void handle(ActionEvent event) {
		command = new CloneCommand(this.dPane);
		this.dPane.getHistory().exec(command);
	}

}
