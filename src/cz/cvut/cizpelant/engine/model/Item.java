package cz.cvut.cizpelant.engine.model;

public class Item {
	private String name;
	private String description;
	private boolean movable;
	private UseBehaviour useBehaviour;
	
	public Item(String name, String description, boolean movable) {
		this.name = name;
		this.description = description;
		this.movable = movable;
		this.useBehaviour = null;
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

	public void setUseBehaviour(UseBehaviour behaviour) {
		useBehaviour = behaviour;
	}
	
	public boolean isReusable() {
		if(useBehaviour != null) {
			return useBehaviour.isReusable();
		}
		return false;
	}
	
	public boolean use(Game game) {
		if(useBehaviour != null && useBehaviour.canBehave(game.getPlayer())) {
			useBehaviour.behave(game);
			return true;
		}
		return false;
	}
	

	
	
	
}
