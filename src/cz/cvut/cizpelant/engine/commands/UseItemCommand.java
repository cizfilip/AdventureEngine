package cz.cvut.cizpelant.engine.commands;

import cz.cvut.cizpelant.engine.abstraction.GameCommand;
import cz.cvut.cizpelant.engine.abstraction.GameCommandResult;
import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.model.Inventory;
import cz.cvut.cizpelant.engine.model.Item;

public class UseItemCommand implements GameCommand {
	private String itemName;
	
	public UseItemCommand(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public GameCommandResult Execute(Game game) {
		if(CommandUtils.isNullOrEmptyString(itemName)) 
			return GameCommandResult.UnsuccessfulResult("You must specify item name.");
		
		Inventory playerInventory = game.getPlayer().getInventory();
		
		if(!playerInventory.hasItem(itemName)) 
			return GameCommandResult.UnsuccessfulResult("You doesn't have this item in your inventory");
		
		Item item = playerInventory.getItemByName(itemName);
		
		boolean actionTaken = item.use(game);
		if(actionTaken) {
			if(!item.isReusable()){
				playerInventory.removeItem(item);
			}
			return GameCommandResult.SuccessfulResult();
		} else {
			return GameCommandResult.UnsuccessfulResult("This item can't be used now.");
		}
	}

}
