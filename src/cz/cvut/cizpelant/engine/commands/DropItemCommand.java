package cz.cvut.cizpelant.engine.commands;

import cz.cvut.cizpelant.engine.abstraction.GameCommand;
import cz.cvut.cizpelant.engine.abstraction.GameCommandResult;
import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.model.Inventory;
import cz.cvut.cizpelant.engine.model.Item;

public class DropItemCommand implements GameCommand {

	private String itemName;
	
	public DropItemCommand(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public GameCommandResult Execute(Game game) {
		if(CommandUtils.isNullOrEmptyString(itemName)) 
			return GameCommandResult.UnsuccessfulResult("You must specify item name.");
		
		Inventory playerInventory = game.getPlayer().getInventory();
		
		if(!playerInventory.hasItem(itemName)) 
			return GameCommandResult.UnsuccessfulResult("This item doesn't exist in your inventory");
		
		Item item = playerInventory.getItemByName(itemName);
		
		game.getPlayer().getCurrentRoom().getInventory().addItem(item);
		playerInventory.removeItem(item);
		
		return GameCommandResult.SuccessfulResult();
	}

}
