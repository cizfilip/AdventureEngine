package cz.cvut.cizpelant.engine.abstraction;

import cz.cvut.cizpelant.engine.model.Player;

public interface GameCondition {
	boolean Evaluate(Player player);
}
