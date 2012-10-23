package cz.cvut.cizpelant.engine.model;

public class Item {
	private String name;
	private String description;
	private boolean movable;
	
	public Item(String name, String description, boolean movable) {
		this.name = name;
		this.description = description;
		this.movable = movable;
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

	
	
	
}
