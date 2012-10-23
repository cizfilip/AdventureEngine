package cz.cvut.cizpelant.engine.samplegame;

import cz.cvut.cizpelant.engine.abstraction.GameBuilder;
import cz.cvut.cizpelant.engine.actions.UnlockRoomAction;
import cz.cvut.cizpelant.engine.builders.DefaultGameBuilder;
import cz.cvut.cizpelant.engine.conditions.PlayerInRoomCondition;
import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.model.Item;
import cz.cvut.cizpelant.engine.model.UseBehaviour;

public class SampleGame {
	
	public Game createSampleGame() {
		GameBuilder builder = new DefaultGameBuilder();
		
		builder.addRoom("Pokusna", "Super mistnost", false);
		builder.addRoom("Nova", "jeste lepsi", false);
		builder.addRoom("Locked", "nejde", true);
		
		builder.addTwoWayPath("Pokusna", "Nova");

		builder.addOneWayPath("Pokusna", "Locked");
		
		Item klic = new Item("Klic", "eeee", true);
		//klic.addUseBehaviour(new UseBehaviour(new PlayerInRoomCondition("Pokusna"), new UnlockRoomAction("Locked")));
		builder.addItemToRoom("Pokusna", klic);
		
		
		builder.setStartRoom("Pokusna");
		
		builder.setEndCondition(new PlayerInRoomCondition("Locked"));
		
		return builder.getResult();
	}
}
