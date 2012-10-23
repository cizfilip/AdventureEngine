package cz.cvut.cizpelant.engine.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Inventory implements Iterable<Item> {
	private Map<String, Item> items;
	
	public Inventory(){
		this.items = new HashMap<String, Item>();
	}
	
	public void addItem(Item item) {
		this.items.put(item.getName(), item);
	}
	
	public void removeItem(String itemName) {
		this.items.remove(itemName);
	}
	
	public void removeItem(Item item) {
		this.items.remove(item.getName());
	}
	
	public boolean hasItem(String itemName) {
		return this.items.containsKey(itemName);
	}
	
	public boolean hasItem(Item item) {
		return this.items.containsKey(item.getName());
	}
	
	public Item getItemByName(String itemName) {
		Item item = items.get(itemName);
		
		if(item == null)
			throw new NoSuchElementException("Item does not exist");
		
		return item;
	}
	
	public boolean hasImmovableItem() {
		for (Item item : items.values()) {
			if(!item.isMovable()) 
				return true;
		}	
		return false;
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public Iterator<Item> iterator() {
		return items.values().iterator();
	}
}
