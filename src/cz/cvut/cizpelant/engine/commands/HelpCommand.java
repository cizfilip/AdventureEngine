package cz.cvut.cizpelant.engine.commands;

import cz.cvut.cizpelant.engine.abstraction.GameCommand;
import cz.cvut.cizpelant.engine.abstraction.GameCommandResult;
import cz.cvut.cizpelant.engine.model.Game;

public class HelpCommand implements GameCommand {

	private String helpMessage;
	
	public HelpCommand() {
		StringBuilder sb = new StringBuilder();
		sb.append("Available commands:\n");
		sb.append("move [room name] - Move to another specified room.\n");
		sb.append("pick [item name] - Pick item with specified name in current room.\n");
		
		sb.append("help - Show this help.\n");
		sb.append("exit - Exits the game.\n");
		
		this.helpMessage = sb.toString();
	}
	
	@Override
	public GameCommandResult Execute(Game game) {
		return GameCommandResult.UnsuccessfulResult(helpMessage);
	}

}
