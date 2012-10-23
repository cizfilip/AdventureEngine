package cz.cvut.cizpelant.engine.model;

import java.util.HashMap;
import java.util.Map;

import cz.cvut.cizpelant.engine.abstraction.GameCondition;


public class Game {
	private Player player;
	private Map<String, Room> rooms;
	private GameCondition endCondition;
	
	public Game() {
		this.player = new Player();
		this.rooms = new HashMap<String, Room>();
	}

	public Player getPlayer() {
		return player;
	}
	
	public void addRoom(Room room) {
		rooms.put(room.getName(), room);
	}
	
	public Room getRoomByName(String roomName) {
		return rooms.get(roomName);
	}

	public void setEndCondition(GameCondition endCondition) {
		this.endCondition = endCondition;
	}
	
	public boolean isEnd() {
		return endCondition.Evaluate(player);
	}

	public GameCondition getEndCondition() {
		return endCondition;
	}

	
	
}
