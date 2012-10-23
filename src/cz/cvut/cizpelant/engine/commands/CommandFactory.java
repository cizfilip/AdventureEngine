package cz.cvut.cizpelant.engine.commands;

import cz.cvut.cizpelant.engine.abstraction.GameCommand;

public class CommandFactory {
	private CommandFactory() {}
	
	
	public static final String EXITGAME_COMMAND = "exit";
	
	public static final String HELP_COMMAND = "help";
	public static final String MOVE_COMMAND = "move";
	public static final String PICK_COMMAND = "pick";
	public static final String DROP_COMMAND = "drop";
	
	
	public static GameCommand getCommand(String commandName, String[] params) {
		
		if(commandName.equalsIgnoreCase(MOVE_COMMAND)) {
			return new MoveCommand(getParam(params, 0));
		}
		if(commandName.equalsIgnoreCase(PICK_COMMAND)) {
			return new PickItemCommand(getParam(params, 0));
		}
		if(commandName.equalsIgnoreCase(DROP_COMMAND)) {
			return new DropItemCommand(getParam(params, 0));
		}
		
		
		
		if(commandName.equalsIgnoreCase(HELP_COMMAND)) {
			return new HelpCommand();
		}
			
		return new UnknownCommand(commandName);
	}
	
	private static String getParam(String[] params, int index) {
		if(params == null || params.length < 1)
			return null;
		else
			return params[index];
	}
	
	
	
}
