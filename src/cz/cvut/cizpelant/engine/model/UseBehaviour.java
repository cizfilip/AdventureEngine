package cz.cvut.cizpelant.engine.model;

import cz.cvut.cizpelant.engine.abstraction.GameAction;
import cz.cvut.cizpelant.engine.abstraction.GameActionException;
import cz.cvut.cizpelant.engine.abstraction.GameCondition;

public class UseBehaviour {
	private GameCondition whenCondition;
	private GameAction action;
	
	public UseBehaviour(GameCondition when, GameAction action) {
		this.whenCondition = when;
		this.action = action;
	}
	
	public boolean canBehave(Player player) {
		return whenCondition.Evaluate(player);
	}
	
	public void behave(Game game) throws GameActionException {
		action.run(game);
	}
}
