package cz.cvut.cizpelant.engine;

import java.util.Scanner;

import cz.cvut.cizpelant.engine.abstraction.GameCommand;
import cz.cvut.cizpelant.engine.abstraction.GameCommandResult;
import cz.cvut.cizpelant.engine.commands.CommandFactory;
import cz.cvut.cizpelant.engine.model.Game;

public class Controller {
	
	private Game model;
	private View view;
	
	public Controller(Game model, View view){
		this.model = model;
		this.view = view;
	}
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		
		view.writeGame(model);
		
		String commandText = "";
		
		while(true) {
			commandText = sc.nextLine();
			
			if(commandText.equalsIgnoreCase(CommandFactory.EXITGAME_COMMAND))
				break;
			
			executeCommand(commandText);
			
			if(model.isEnd()) {
				view.writeEnd();
				break;
			}
		}
		
		view.writeText("Press any key for exit.");
		sc.nextLine();
		sc.close();
	}

	private void executeCommand(String commandText) {
		GameCommand command = parseCommand(commandText);
		
		GameCommandResult result = command.Execute(model);
		
		if(result.wasSuccessful()) {
			view.writeGame(model);
			
		} else {
			view.writeText(result.getMessage());
		}
		
		
	}
	
	private GameCommand parseCommand(String commandText) {
		String[] tokens = commandText.split("\\s+");
		if(tokens.length < 1)
			return null;
		
		String commandName = tokens[0];
		
		String[] params = null;
		
		if(tokens.length > 1) {
			params = new String[tokens.length - 1];
			System.arraycopy(tokens, 1, params, 0, params.length);
		} 
				
		GameCommand command = CommandFactory.getCommand(commandName, params);
	
		return command;
	}
}
