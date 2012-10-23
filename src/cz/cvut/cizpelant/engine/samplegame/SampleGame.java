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
		
		builder.addRoom("room", "a nice looking room", false);
		builder.addRoom("coridor", "a coridor", false);
		builder.addRoom("largeRoom", "large room", false);
		builder.addRoom("funkyRoom", "funky room", false);
		builder.addRoom("TheEND", "the end", true);
		
		builder.addTwoWayPath("room", "coridor");
		builder.addTwoWayPath("coridor", "largeRoom");
		builder.addTwoWayPath("largeRoom", "funkyRoom");
		builder.addTwoWayPath("largeRoom", "TheEND");

		Item klic = new Item("key", "a key", true);
		klic.setUseBehaviour(new UseBehaviour(new PlayerInRoomCondition("largeRoom"), new UnlockRoomAction("TheEND"), false));
		builder.addItemToRoom("funkyRoom", klic);
		
		
		builder.setStartRoom("room");
		
		builder.setEndCondition(new PlayerInRoomCondition("TheEND"));
		
		return builder.getResult();
	}
}
