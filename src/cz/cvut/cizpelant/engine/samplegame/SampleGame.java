package cz.cvut.cizpelant.engine.samplegame;

import cz.cvut.cizpelant.engine.abstraction.GameBuilder;
import cz.cvut.cizpelant.engine.builders.DefaultGameBuilder;
import cz.cvut.cizpelant.engine.conditions.PlayerInRoomCondition;
import cz.cvut.cizpelant.engine.model.Game;

public class SampleGame {
	
	public Game createSampleGame() {
		GameBuilder builder = new DefaultGameBuilder();
		
		builder.addRoom("Pokusna", "Super mistnost", false);
		builder.addRoom("Nova", "jeste lepsi", false);
		
		builder.addPath("Pokusna", "Nova");
		
		builder.addItemToRoom("Pokusna", "Klic", "eeee", false);
		
		builder.setStartRoom("Pokusna");
		
		builder.setEndCondition(new PlayerInRoomCondition("Nova"));
		
		return builder.getResult();
	}
}
