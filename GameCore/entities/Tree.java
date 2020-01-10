package GameCore.entities;

import GameCore.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import GameCore.gfx.Assets;

public class Tree extends StaticEntity{
	
	private BufferedImage tree = Assets.tree; 

	public Tree(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	    
		bounds.x = 32;
		bounds.y = 80;
		bounds.width = 48;
		bounds.height = 56;
		
		health = 200;
		maxHealth = 200;		
		
	}

	@Override
	public void tick(){

	}
	
	@Override
	public void die(){
		alive = false;
	}
	
	public void render(Graphics g){
//	    g.setColor(Color.green);
//	    g.fillRect((int) (x + bounds.x * 3/4), (int)(y + bounds.y / 2), bounds.width * 2, bounds.height * 2); 
//	    g.setColor (Color.red);
//	    g.fillRect ((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height); 
		g.drawImage(tree, (int)(x), (int)(y), width, height, null);
	}

}
