package GameCore.entities;

import GameCore.*;
import java.awt.*;

import GameCore.gfx.Animation;
import GameCore.gfx.Assets;
import GameCore.gfx.AudioPlayer;
import GameCore.heroes.*;

public class HealingCrystal extends StaticEntity{
 
 public Animation neutral, healEffect;
 
 private AudioPlayer shatter;
 
 public Rectangle area;

 public HealingCrystal(Handler handler, float x, float y, int width, int height) {
  super(handler, x, y, width, height);
  
  shatter = new AudioPlayer("/se/Magic3.wav");
  
     healEffect = new Animation (80, Assets.heals);    
  neutral = new Animation (200, Assets.hCrystal); 
  
  area = new Rectangle((int)(x - 150), (int)(y - 100), 400, 400);
     
  bounds.x = 16;
  bounds.y = 80;
  bounds.width = 48;
  bounds.height = 56;
  
  health = 1000;
  maxHealth = 1000;  
  
 }
 
 @Override
 public void die(){
  shatter.playSound();
  rangedCheck(area.x, area.y, area.width, area.height, 200, 1, 4);
  alive = false;
 }
 

 @Override
 public void tick(){
  neutral.tick();
     healEffect.tick();
 }
 
 public void render(Graphics g){
//     g.setColor(Color.green);
//     g.fillRect((int) (x + bounds.x * 3/4), (int)(y + bounds.y / 2), bounds.width * 2, bounds.height * 2); 
//     g.setColor (Color.red);
//     g.fillRect ((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height); 
  //g.fillRect(area.x, area.y, area.width, area.height);
  g.drawImage(neutral.getCurrentFrame(), (int)(x), (int)(y), width, height, null);
  
  for (Entity e : handler.getWorld().getEntityManager().getEntities()){
   if (e.equals(this))
    continue;
   if(e.getHitbox(0, 0).intersects(area) && e instanceof Player){
     e.heal(0.1f); 
     g.drawImage(healEffect.getCurrentFrame(), (int)(e.getX()), (int)(e.getY()), null); 
     healing.playSound();
   }
  }
 }

}