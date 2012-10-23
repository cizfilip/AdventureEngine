package cz.cvut.cizpelant.engine.abstraction;

import cz.cvut.cizpelant.engine.model.Game;

public interface GameBuilder {
	void addRoom(String roomName, String roomDescription, boolean locked);
	
	void addPath(String fromRoomName, String toRoomName);
	
	void addItemToRoom(String roomName, String itemName, String itemDescription, boolean movable);
	
	void setStartRoom(String roomName);
	
	void setEndCondition(GameCondition endCondition);
	
	Game getResult();
}
