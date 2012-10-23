package cz.cvut.cizpelant.engine;

import cz.cvut.cizpelant.engine.model.Game;
import cz.cvut.cizpelant.engine.samplegame.SampleGame;

public class Main {

	
	public static void main(String[] args) {
		View view = new View();
		Game game = new SampleGame().createSampleGame();
		
		Controller controller = new Controller(game, view);
		
		controller.start();
		
	}

}
