package cz.cvut.cizpelant.engine.commands;

import cz.cvut.cizpelant.engine.abstraction.GameCommand;

public class CommandFactory {
	private CommandFactory() {}
	
	
	public static final String EXITGAME_COMMAND = "exit";
	
	public static final String HELP_COMMAND = "help";
	public static final String MOVE_COMMAND = "move";
	public static final String PICK_COMMAND = "pick";
	public static final String DROP_COMMAND = "drop";
	public static final String USE_COMMAND = "use";
	
	
	public static GameCommand getCommand(String commandName, String param) {
		
		if(commandName.equalsIgnoreCase(MOVE_COMMAND)) {
			return new MoveCommand(param);
		}
		if(commandName.equalsIgnoreCase(PICK_COMMAND)) {
			return new PickItemCommand(param);
		}
		if(commandName.equalsIgnoreCase(DROP_COMMAND)) {
			return new DropItemCommand(param);
		}
		if(commandName.equalsIgnoreCase(USE_COMMAND)) {
			return new UseItemCommand(param);
		}
		
		if(commandName.equalsIgnoreCase(HELP_COMMAND)) {
			return new HelpCommand();
		}
			
		return new UnknownCommand(commandName);
	}
	
	
	
	
	
}
