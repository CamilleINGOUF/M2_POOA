package drawing.handlers;

import drawing.commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DeleteButtonHandler implements EventHandler<ActionEvent> {
	
	private ICommand command;
	
	public DeleteButtonHandler(ICommand command) {
		this.command = command;
	}

	@Override
	public void handle(ActionEvent event) {
		command.execute();
	}

}
