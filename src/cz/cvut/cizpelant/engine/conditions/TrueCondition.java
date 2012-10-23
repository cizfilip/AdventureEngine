package cz.cvut.cizpelant.engine.conditions;

import cz.cvut.cizpelant.engine.abstraction.GameCondition;
import cz.cvut.cizpelant.engine.model.Player;

public class TrueCondition implements GameCondition {

	@Override
	public boolean Evaluate(Player player) {
		return true;
	}

}
