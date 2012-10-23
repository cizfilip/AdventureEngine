package cz.cvut.cizpelant.engine.builders;

import cz.cvut.cizpelant.engine.abstraction.GameBuilder;
import cz.cvut.cizpelant.engine.abstraction.GameCondition;
import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.model.Item;
import cz.cvut.cizpelant.engine.model.Room;

public class DefaultGameBuilder implements GameBuilder {
	private Game game;
	
	
	public DefaultGameBuilder(){
		this.game = new Game();
	}
	
	@Override
	public void addRoom(String roomName, String roomDescription, boolean locked) {
		game.addRoom(new Room(roomName, roomDescription, locked));
	}

	@Override
	public void addOneWayPath(String fromRoomName, String toRoomName) {
		Room fromRoom = getRoomOrThrow(fromRoomName);
		Room toRoom = getRoomOrThrow(toRoomName);
		fromRoom.addNextRoom(toRoom);
	}
	
	@Override
	public void addTwoWayPath(String fromRoomName, String toRoomName) {
		Room fromRoom = getRoomOrThrow(fromRoomName);
		Room toRoom = getRoomOrThrow(toRoomName);
		fromRoom.addNextRoom(toRoom);
		toRoom.addNextRoom(fromRoom);
	}

	@Override
	public void addItemToRoom(String roomName, Item item) {
		Room room = getRoomOrThrow(roomName);
		room.getInventory().addItem(item);
	}

	@Override
	public Game getResult() {
		if(game.getPlayer().getCurrentRoom() == null)
			throw new UnsupportedOperationException("You must set Start room before getting result.");
		if(game.getEndCondition() == null)
			throw new UnsupportedOperationException("You must set End condition before getting result.");
		
		return game;
		
	}

	@Override
	public void setStartRoom(String roomName) {
		Room room = getRoomOrThrow(roomName);
		game.getPlayer().moveTo(room);
	}

	@Override
	public void setEndCondition(GameCondition endCondition) {
		game.setEndCondition(endCondition);
	}


	private Room getRoomOrThrow(String roomName) {
		Room room = game.getRoomByName(roomName);
		if(room == null)
			throw new NullPointerException("Room was not added yet");
		return room;
	}

}	
