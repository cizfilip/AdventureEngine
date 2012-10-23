package cz.cvut.cizpelant.engine.commands;

import cz.cvut.cizpelant.engine.abstraction.GameCommand;
import cz.cvut.cizpelant.engine.abstraction.GameCommandResult;
import cz.cvut.cizpelant.engine.model.Game;

public class UnknownCommand implements GameCommand {
	private String commandName;
	
	public UnknownCommand(String commandName) {
		this.commandName = commandName;
	}
	
	
	@Override
	public GameCommandResult Execute(Game game) {
		return GameCommandResult.UnsuccessfulResult(String.format("Command \"%s\" does not exists", commandName));
	}

}
