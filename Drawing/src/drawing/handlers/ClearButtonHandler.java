package drawing.handlers;

import drawing.commands.ClearCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<ActionEvent> {

	private ICommand command;
	private DrawingPane dPane;
	
	public ClearButtonHandler(DrawingPane dPane) 
	{
		this.dPane = dPane;
	}
	
	@Override
	public void handle(ActionEvent arg0) 
	{
		this.command = new ClearCommand(dPane);
		this.dPane.getHistory().exec(command);
	}

}
