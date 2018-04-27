package states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import gameObjects.*;

public class GameState extends BasicGameState{
	
	RayCaster rc;
	Player p;
	WorldMap map;
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		
		p = new Player(0);
		map = MapEditor.map;
		rc = new RayCaster(map,p);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
		rc.renderFrame(g);
		rc.draw(g);
		p.display(g);
		map.display(g);
		g.drawString("GameState", 50, 50);
	
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		
		p.update(gc);
		changeState(gc, s);
		rc.calculateFrame();
	
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.GAME;
	}
	
	
	public void changeState(GameContainer gc, StateBasedGame s) {
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			s.enterState(States.MAPEDITOR);
		}
	}
	
	

}
