package cz.cvut.cizpelant.engine.actions;

import cz.cvut.cizpelant.engine.abstraction.GameAction;
import cz.cvut.cizpelant.engine.abstraction.GameActionException;
import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.model.Room;

public class UnlockRoomAction implements GameAction {

	private String roomName;
	
	public UnlockRoomAction(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public void run(Game game) throws GameActionException {
		Room room = game.getRoomByName(roomName);
		if(room == null)
			throw new GameActionException("Room to unlock does not exists.");
		room.unlock();
	}

}
