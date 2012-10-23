package cz.cvut.cizpelant.engine.commands;

import cz.cvut.cizpelant.engine.abstraction.GameCommand;
import cz.cvut.cizpelant.engine.abstraction.GameCommandResult;
import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.model.Room;

public class MoveCommand implements GameCommand {
	private String roomName;
	
	public MoveCommand(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public GameCommandResult Execute(Game game) {
		if(CommandUtils.isNullOrEmptyString(roomName)) 
			return GameCommandResult.UnsuccessfulResult("You must specify room name.");
		
		Room toRoom = game.getRoomByName(roomName);

		if(toRoom == null)
			return GameCommandResult.UnsuccessfulResult("Unknown room");
			
		if(!game.getPlayer().getCurrentRoom().hasNextRoom(roomName))
			return GameCommandResult.UnsuccessfulResult("You can't go to this room from your current room.");
		
		if(toRoom.isLocked()) 
			return GameCommandResult.UnsuccessfulResult("You can't go to this room. Room is locked.");
		
		if(game.getPlayer().getInventory().hasImmovableItem())
			return GameCommandResult.UnsuccessfulResult("You can't go to this room. You are carrying immovable item.");
			
		
		game.getPlayer().moveTo(toRoom);
		
		return GameCommandResult.SuccessfulResult();
	}

}
