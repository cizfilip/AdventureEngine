package cz.cvut.cizpelant.engine.conditions;

import cz.cvut.cizpelant.engine.abstraction.GameCondition;
import cz.cvut.cizpelant.engine.model.Player;

public class PlayerHasItem implements GameCondition {
	private String itemName;
	
	public PlayerHasItem(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public boolean Evaluate(Player player) {
		return player.getInventory().hasItem(itemName);
	}

}