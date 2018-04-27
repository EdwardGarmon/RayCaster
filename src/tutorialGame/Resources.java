package tutorialGame;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

public class Resources {
	
	private static Map <String, Image> images;
	private static Map <String, SpriteSheet> sprites;
	private static Map <String, Sound> sounds;
	
	public Resources() {
		images = new HashMap<String, Image>();
		sprites = new HashMap<String, SpriteSheet>();
		sounds = new HashMap<String,Sound>();
		
		try {
			images.put("tiles", loadImage("res/tiles.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static public Image loadImage(String path) throws SlickException {
		return new Image(path, false, Image.FILTER_NEAREST);
	}
}
