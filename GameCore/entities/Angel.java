package GameCore.entities;

import java.awt.Color;
import java.awt.Graphics;

import GameCore.*;
import GameCore.gfx.*;
import GameCore.heroes.Player;

public class Angel extends LiveEntity{
 
 private Animation neutral, down, up, left, right;
 private int behaviour = 0;

 public Angel(Handler handler, float x, float y, int width, int height) {
  super(handler, x, y, width, height);
  flying = true;
  health = 100;
  maxHealth = 100;

  bounds.x = 32;
  bounds.y = 40;
  bounds.width = 48;
  bounds.height = 48;
  
  neutral = new Animation(50, Assets.angelDown);
  down = new Animation(100, Assets.angelDown);
  up = new Animation(100, Assets.angelUp);
  left = new Animation(100, Assets.angelLeft);
  right = new Animation(100, Assets.angelRight);
  
 }
 
 @Override
 public void tick(){
  neutral.tick();
  down.tick();
  up.tick();
  left.tick();
  right.tick();
  
     for (Entity e : handler.getWorld().getEntityManager().getEntities()){
       if (e.equals(this)){
        continue;
       }else if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xMove, 0)) || e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(0, yMove))){
        if(e instanceof Player){
        e.hurt(2.0f);
        }else if(e instanceof StaticEntity){
        continue;
        }
       }
      }

  attackMove(2);
  move();
  inBounds();
  
 }
 
 @Override
 public void render(Graphics g){

//     g.setColor(Color.green);
//     g.fillRect((int) (x + bounds.x * 3/4), (int)(y + bounds.y / 2), bounds.width * 2, bounds.height * 2); 
//     g.setColor (Color.red);
//     g.fillRect ((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height); 
  
     if(dir == 2){
  g.drawImage(right.getCurrentFrame(), (int)(x), (int)(y), width, height, null); 
     }else if(dir == 4){
  g.drawImage(left.getCurrentFrame(), (int)(x), (int)(y), width, height, null); 
     }else if(dir == 3){
  g.drawImage(up.getCurrentFrame(), (int)(x), (int)(y), width, height, null); 
     }else if(dir == 1){
  g.drawImage(down.getCurrentFrame(), (int)(x), (int)(y), width, height, null); 
     }else{
  g.drawImage(neutral.getCurrentFrame(), (int)(x), (int)(y), width, height, null);
     }
 }

}
