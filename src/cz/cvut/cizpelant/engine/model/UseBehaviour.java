package cz.cvut.cizpelant.engine.model;

import cz.cvut.cizpelant.engine.abstraction.GameAction;
import cz.cvut.cizpelant.engine.abstraction.GameCondition;
import cz.cvut.cizpelant.engine.conditions.TrueCondition;

public class UseBehaviour {
	private GameCondition whenCondition;
	private GameAction action;
	private boolean reusable;
	
	public UseBehaviour(GameAction action, boolean reusable) {
		this(new TrueCondition(), action, reusable);
	}
	
	public UseBehaviour(GameCondition when, GameAction action, boolean reusable) {
		this.whenCondition = when;
		this.action = action;
		this.reusable = reusable;
	}
	
	public boolean canBehave(Player player) {
		return whenCondition.Evaluate(player);
	}
	
	public void behave(Game game) {
		action.run(game);
	}
	
	public boolean isReusable(){
		return reusable;
	}
	
}
