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
		
		builder.addRoom("a room", "a nice looking room", false);
		builder.addRoom("coridor", "a coridor", false);
		builder.addRoom("large room", "large room", false);
		builder.addRoom("funky room", "funky room", false);
		builder.addRoom("The END", "the end", true);
		
		builder.addTwoWayPath("a room", "coridor");
		builder.addTwoWayPath("coridor", "large room");
		builder.addTwoWayPath("large room", "funky room");
		builder.addTwoWayPath("large room", "The END");

		Item klic = new Item("a key", "a key", true);
		klic.setUseBehaviour(new UseBehaviour(new PlayerInRoomCondition("large room"), new UnlockRoomAction("The END"), true));
		builder.addItemToRoom("funky room", klic);
		
		
		builder.setStartRoom("a room");
		
		builder.setEndCondition(new PlayerInRoomCondition("The END"));
		
		return builder.getResult();
	}
}
