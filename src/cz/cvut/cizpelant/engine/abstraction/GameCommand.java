package cz.cvut.cizpelant.engine.abstraction;

import cz.cvut.cizpelant.engine.model.Game;

public interface GameCommand {
	GameCommandResult Execute(Game game);
}
