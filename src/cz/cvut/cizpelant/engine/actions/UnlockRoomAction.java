package cz.cvut.cizpelant.engine.actions;

import cz.cvut.cizpelant.engine.abstraction.GameAction;
import cz.cvut.cizpelant.engine.model.Game;

public class UnlockRoomAction implements GameAction {

	private String roomName;
	
	public UnlockRoomAction(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public void run(Game game) {
		game.getRoomByName(roomName).unlock();
	}

}
