package cz.cvut.cizpelant.engine.abstraction;

import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.model.Item;

public interface GameBuilder {
	void addRoom(String roomName, String roomDescription, boolean locked);
	
	void addOneWayPath(String fromRoomName, String toRoomName);
	void addTwoWayPath(String fromRoomName, String toRoomName);
	
	void addItemToRoom(String roomName, Item item);
	
	void setStartRoom(String roomName);
	
	void setEndCondition(GameCondition endCondition);
	
	Game getResult();
}
