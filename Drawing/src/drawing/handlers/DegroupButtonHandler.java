package drawing.handlers;

import drawing.commands.DegroupCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DegroupButtonHandler implements EventHandler<ActionEvent> {

	private DrawingPane dPane;
	private ICommand command;
	
	public DegroupButtonHandler(DrawingPane drawingPane) {
		this.dPane = drawingPane;
	}

	@Override
	public void handle(ActionEvent event) {
		this.command = new DegroupCommand(dPane);
		this.dPane.getHistory().exec(command);
	}

}
