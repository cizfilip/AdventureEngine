package cz.cvut.cizpelant.engine.model;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.cizpelant.engine.abstraction.GameActionException;

public class Item {
	private String name;
	private String description;
	private boolean movable;
	private List<UseBehaviour> useBehaviour;
	
	public Item(String name, String description, boolean movable) {
		this.name = name;
		this.description = description;
		this.movable = movable;
		this.useBehaviour = new ArrayList<UseBehaviour>();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isMovable() {
		return movable;
	}

	public void addUseBehaviour(UseBehaviour behaviour) {
		useBehaviour.add(behaviour);
	}
	
	public boolean use(Game game) {
		boolean result = false;
		for(UseBehaviour behaviour : useBehaviour) {
			if(behaviour.canBehave(game.getPlayer())) {
				try {
					behaviour.behave(game);
					result = true;
				} catch (GameActionException e) {
					result = false;
				}
			}
		}
		return result;
	}

	
	
	
}
