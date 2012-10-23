package cz.cvut.cizpelant.engine.commands;

import cz.cvut.cizpelant.engine.abstraction.GameCommand;
import cz.cvut.cizpelant.engine.abstraction.GameCommandResult;
import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.model.Inventory;
import cz.cvut.cizpelant.engine.model.Item;

public class PickItemCommand implements GameCommand {
	
	private String itemName;
	
	public PickItemCommand(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public GameCommandResult Execute(Game game) {
		if(CommandUtils.isNullOrEmptyString(itemName)) 
			return GameCommandResult.UnsuccessfulResult("You must specify item name.");
		
		Inventory roomInventory = game.getPlayer().getCurrentRoom().getInventory();
		
		if(!roomInventory.hasItem(itemName)) 
			return GameCommandResult.UnsuccessfulResult("This item doesn't exist in your current room");
		
		Item item = roomInventory.getItemByName(itemName);
		
		game.getPlayer().getInventory().addItem(item);
		roomInventory.removeItem(item);
		
		return GameCommandResult.SuccessfulResult();
	}

}
