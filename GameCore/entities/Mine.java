package GameCore.entities;

import GameCore.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import GameCore.gfx.Animation;
import GameCore.gfx.Assets;

public class Mine extends StaticEntity{
 
 private Animation neutral, detonate;
 private Rectangle trigger;
 private Boolean triggered = false;

 public Mine(Handler handler, float x, float y, int width, int height) {
  super(handler, x, y, width, height);
  
  neutral = new Animation(750, Assets.mineIdle); 
  detonate = new Animation(75, Assets.mineTrig);
  trigger = new Rectangle((int)(x + 18), (int)(y + 18), 32, 32);
     
  bounds.x = 24;
  bounds.y = 24;
  bounds.width = 16;
  bounds.height = 12;
  
  health = 30;
  maxHealth = 30;  
  
 }

 @Override
 public void tick(){
  neutral.tick();
  
  if(detonate.checkAnim()){
   die();
  }
  
  if(!triggered){
  for (Entity e : handler.getWorld().getEntityManager().getEntities()){
   if (e.equals(this))
    continue;
   if(e.playerNum == playerNum - 2)
    continue;
   if(e.getHitbox(0f, 0f).intersects(trigger)){
     bounds.width = 0;
     bounds.height = 0;
    e.hurt(30);  
    health = 5;
    triggered = true;
   }
  }
  }else{
  detonate.tick();
  }
 }
 
 @Override
 public void die(){
  alive = false;
 }
 
 public void render(Graphics g){
//     g.setColor(Color.green);
//     g.fillRect((int) (x + bounds.x * 3/4), (int)(y + bounds.y / 2), bounds.width * 2, bounds.height * 2); 
//     g.setColor (Color.red);
//     g.fillRect ((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height); 
//  g.fillRect(trigger.x, trigger.y, trigger.width, trigger.height);
     
  g.drawImage(getCurrentFrame(), (int)(x), (int)(y), width, height, null);
 }

 private BufferedImage getCurrentFrame(){
  if(triggered){  
  return detonate.getCurrentFrame();   
  }else{
  return neutral.getCurrentFrame();
  }
 }
}
