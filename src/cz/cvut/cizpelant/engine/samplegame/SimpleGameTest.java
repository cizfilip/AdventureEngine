
package cz.cvut.cizpelant.engine.samplegame;

import junit.framework.Assert;

import org.junit.Test;

import cz.cvut.cizpelant.engine.commands.MoveCommand;
import cz.cvut.cizpelant.engine.commands.PickItemCommand;
import cz.cvut.cizpelant.engine.commands.UseItemCommand;
import cz.cvut.cizpelant.engine.model.Game;

public class SimpleGameTest {

    @Test
    public void test() {
        Game game = new SampleGame().createSampleGame();
        new MoveCommand("coridor").Execute(game);
        new MoveCommand("large room").Execute(game);
        new MoveCommand("funky room").Execute(game);
        new PickItemCommand("a key").Execute(game);
        new MoveCommand("large room").Execute(game);
        new UseItemCommand("a key").Execute(game);
        new MoveCommand("The END").Execute(game);
        Assert.assertEquals(game.isEnd(), true);
    }
    
    @Test
    public void test2() {
        Game game = new SampleGame().createSampleGame();
        new MoveCommand("coridor").Execute(game);
        new MoveCommand("large room").Execute(game);
        new MoveCommand("The END").Execute(game);
        Assert.assertEquals(game.isEnd(), true);
    }
    
}
