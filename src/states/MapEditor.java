package states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import gameObjects.*;

public class MapEditor extends BasicGameState {

	Player p;
	WallAdder wallAdder;
	public static WorldMap map;
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		p = new Player(0);
		map = new WorldMap();
		wallAdder = new WallAdder(map);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		g.drawString("Map Editor", 50, 50);
		p.display(g);
		map.display(g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		// TODO Auto-generated method stub

		p.update(gc);
	
		System.out.println();
		changeState(gc,s);
		wallAdder.addWall(gc);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.MAPEDITOR;
	}


	
	public void changeState(GameContainer gc, StateBasedGame s) {
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			s.enterState(States.GAME);
		}
	}
	
	

}
