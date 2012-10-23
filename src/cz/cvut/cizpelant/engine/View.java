package cz.cvut.cizpelant.engine;

import java.util.Collection;

import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.model.Inventory;
import cz.cvut.cizpelant.engine.model.Item;
import cz.cvut.cizpelant.engine.model.Player;
import cz.cvut.cizpelant.engine.model.Room;

public class View {
	public void writeText(String text) {
		System.out.println(text);
	}
	
	public void writeEnd() {
		writeSeparator();
		writeText("You win!!!");
		writeSeparator();
	}

	public void writeGame(Game game) {
		writePlayer(game.getPlayer());

		// writeEmptyLines(3);
	}

	private void writePlayer(Player player) {
		Room currentRoom = player.getCurrentRoom();
		writeText(String.format("Your current room is: %s - %s",
				currentRoom.getName(), currentRoom.getDescription()));

		writeInventory(player.getInventory(), "Your Inventory:", "You have no items in inventory.");
		writeInventory(currentRoom.getInventory(), "Items in this Room:", "There is no item to pick.");

		writeNextRooms(currentRoom);

		writeText("Your next step?");
	}

	private void writeNextRooms(Room currentRoom) {
		Collection<Room> nextRooms = currentRoom.getNextRooms();
		if (nextRooms.isEmpty()) {
			writeText("You can't move anywhere.");
		} else {
			writeText("Available rooms:");
			for (Room room : nextRooms) {
				String formatText = "\t%s";
				if (room.isLocked()) 
					formatText += " - Locked";
				writeText(String.format(formatText, room.getName()));
			}
		}
	}

	private void writeInventory(Inventory inventory, String inventoryName, String emptyMessage) {
		if (inventory.isEmpty()) {
			writeText(emptyMessage);
		} else {
			writeText(inventoryName);
			for (Item item : inventory) {
				writeText(String.format("\t%s - %s - %s", item.getName(), item
						.getDescription(), item.isMovable() ? "Can move"
						: "Can't move"));
			}
		}
	}

	private void writeSeparator() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 30; i++) {
			sb.append("-");
		}
		writeText(sb.toString());
	}

	private void writeEmptyLine() {
		System.out.println();
	}

	private void writeEmptyLines(int count) {
		for (int i = 0; i < count; i++)
			System.out.println();
	}

	

}
