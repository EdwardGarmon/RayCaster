package gameObjects;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.newdawn.slick.Graphics;

public class RayCaster {
	
	
	int renderDist;
	int viewingAngle;
	double res;
	
	
	WorldMap map;
	Player p;

	ArrayList<RenderedWall> frame;
	
	public RayCaster( WorldMap map, Player p){
		renderDist = 300;
		viewingAngle = 40;
		
		this.res  = .5;
		this.map = map;
		this.p = p;
		frame = new ArrayList<RenderedWall>(); 
	}
	
	public void calculateFrame() {
		
		
		ArrayList<RenderedWall>frame = new ArrayList<RenderedWall>(); 
		
		
		
		
		for(float i = p.getDegrees()-viewingAngle; i<p.getDegrees()+ viewingAngle;  i += res  ) {
			for(float x = 0; x< renderDist; x+=res) {
				
				float wallX =  (float) (p.x + x*Math.cos(radians(i)));
				float wallY =  (float) (p.y + x*Math.sin(radians(i)));
				
				Vector w = new Vector(wallX,wallY);
				//System.out.println("checked Vals "+ wallX+" "+wallY);
				if(map.contains(w)) {
				
					
					
					double totalWidth = 2 * Math.sin(radians(viewingAngle)) * x  ;
					
					double displacement =  Math.sin(radians( p.ang - i )) * x;
					
					double realDis =  displacement/totalWidth*1000;
					
					double totalHeight = 2*x*Math.tan(30);
					
					double wallHeight = 350;
					
					double height = wallHeight/totalHeight*700;
					
					RenderedWall newWall = new RenderedWall(realDis,1000/totalWidth*2,height,x);
					
					frame.add(newWall);
					
					break;
					
				}
				
			}
			
		}
		
		this.frame = frame;
		
		
		
		
	}
	
	public void draw( Graphics g ) {
		float x2 = (float) (p.x+renderDist*Math.cos(p.getRadians()-radians(viewingAngle)));
		
		float x1 = p.x;
		float y1 = p.y;
		float y2 = (float) (p.y+renderDist*Math.sin(p.getRadians()-radians(viewingAngle)));
		g.drawLine(x1, y1, x2, y2);
		 x2 = (float) (p.x+renderDist*Math.cos(p.getRadians()+radians(viewingAngle)));
		 x1 = p.x;
		 y1 = p.y;
		 y2 = (float) (p.y+renderDist*Math.sin(p.getRadians()+radians(viewingAngle)));
		g.drawLine(x1, y1, x2, y2);
	}
	
	public void renderFrame( Graphics g) {
		for(int i  = 0; i< frame.size(); i++) {
		
			frame.get(i).display(g);
			
		}
	}
	
	double radians(double degrees ) {
		return (double) (degrees*Math.PI/180);
	}
	
}
