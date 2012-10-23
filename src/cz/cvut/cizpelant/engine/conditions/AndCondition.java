package cz.cvut.cizpelant.engine.conditions;

import cz.cvut.cizpelant.engine.abstraction.GameCondition;
import cz.cvut.cizpelant.engine.model.Player;

public class AndCondition implements GameCondition {
	private GameCondition left;
	private GameCondition right;
	
	public AndCondition(GameCondition left, GameCondition right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean Evaluate(Player player) {
		return left.Evaluate(player) && right.Evaluate(player);
	}
}
