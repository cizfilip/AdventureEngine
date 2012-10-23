package cz.cvut.cizpelant.engine.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Room {
	private String name;
	private String description;
	
	private boolean locked;
	
	private Map<String, Room> nextRooms;
	private Inventory inventory;
	
	
	public Room(String name, String description, boolean locked) {
		this.name = name;
		this.description = description;
		this.nextRooms = new HashMap<String, Room>();
		this.inventory = new Inventory();
		this.locked = locked;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public void addNextRoom(Room room) {
		nextRooms.put(room.getName(), room);
	}
	
	public boolean hasNextRoom(String nextRoomName) {
		return nextRooms.containsKey(nextRoomName);
	}
	
	public Collection<Room> getNextRooms() {
		return nextRooms.values();
	}

	public Inventory getInventory() {
		return inventory;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
}
