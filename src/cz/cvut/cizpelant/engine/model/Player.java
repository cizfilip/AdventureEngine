package cz.cvut.cizpelant.engine.model;

public class Player {
	private Inventory inventory;
	private Room currentRoom;
	
	public Player() {
		this.inventory = new Inventory();
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void moveTo(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	
	
}
