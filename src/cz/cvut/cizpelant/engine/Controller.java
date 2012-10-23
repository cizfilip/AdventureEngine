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
		String[] tokens = commandText.split("\\s+", 2);
		
		String commandName = "";		
		String param = "";
		
		if(tokens.length == 2) {
			commandName = tokens[0];
			param = tokens[1];
		}
				
		GameCommand command = CommandFactory.getCommand(commandName, param);
	
		return command;
	}
}
