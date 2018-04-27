package tutorialGame;

import org.newdawn.slick.AppGameContainer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

import states.*;
import states.GameState;

public class Engine extends StateBasedGame{

	    public static boolean _APPLET = true;

	    public Engine() {
	        super("Snake");
	    }

	    public static void main(String[] args) {

	        _APPLET = false;

	      
	        

	        try {
	            AppGameContainer game = new AppGameContainer(new Engine());
	            game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
	            game.start();
	        } catch (SlickException e) {
	            e.printStackTrace();
	        }
	    }

	   

	 

		@Override
		public void initStatesList(GameContainer gc) throws SlickException {
			// TODO Auto-generated method stub
			gc.setMaximumLogicUpdateInterval(60);
	        gc.setTargetFrameRate(60);
	        gc.setAlwaysRender(true);
	        gc.setShowFPS(false);
	        gc.setVSync(true);
	        
	        this.addState(new MapEditor());
	        this.addState( new GameState());
	        this.addState(new MenuState());
		}
	}

