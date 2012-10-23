package cz.cvut.cizpelant.engine.conditions;

import cz.cvut.cizpelant.engine.abstraction.GameCondition;
import cz.cvut.cizpelant.engine.model.Player;

public class PlayerInRoomCondition implements GameCondition {
	private String roomName;
	
	public PlayerInRoomCondition(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public boolean Evaluate(Player player) {
		return player.getCurrentRoom().getName().equalsIgnoreCase(roomName);
	}

}
