package GameCore.States;
import GameCore.Handler;
import GameCore.entities.*;
import GameCore.gfx.Assets;

import java.awt.Graphics;
import java.awt.Rectangle;
  
public class StageState extends State {
  
    private Rectangle h1, h2, h3, h4;

 public StageState(Handler handler) {
  super(handler);
  
  h1 = new Rectangle(75, 115, 415, 280); //clickable objects
  h2 = new Rectangle(735, 115, 415, 280);
  h3 = new Rectangle(75, 465, 415, 280);
  h4 = new Rectangle(735, 465, 415, 280);
 }

 @Override
 public void tick() {
   if(handler.getMouseManager().isLeftPressed() && h1.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
      selectSound.playSound();
      musicPlayer.stopSound();
     handler.getGame().gameInit("res/worlds/world1.txt");
     //handler.getWorld().getEntityManager().addEntity(new Tree(handler, 650, 300, 128, 144), 0);    
     /*handler.getWorld().getEntityManager().addEntity(new Tree(handler, 830, 500, 128, 144), 0);    
     handler.getWorld().getEntityManager().addEntity(new Tree(handler, 380, 430, 128, 144), 0);   */
     System.out.println("Classic selected");
   }else if(handler.getMouseManager().isLeftPressed() && h2.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
      selectSound.playSound();
   musicPlayer.stopSound();
     handler.getGame().gameInit("res/worlds/world2.txt");
     //handler.getWorld().getEntityManager().addEntity(new Angel(handler, 580, 400, 128, 128), 0); 
     System.out.println("Sula Cielands selected");
   }else if(handler.getMouseManager().isLeftPressed() && h3.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
      selectSound.playSound();
   musicPlayer.stopSound();
     handler.getGame().gameInit("res/worlds/world3.txt");
     System.out.println("Goelnovia Bridge selected");
   }else if(handler.getMouseManager().isLeftPressed() && h4.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
      selectSound.playSound();
   musicPlayer.stopSound();
     handler.getGame().gameInit("res/worlds/world4.txt");
     handler.getWorld().getEntityManager().addEntity(new HealingCrystal(handler, 580, 260, 90, 180), 0);   
     System.out.println("Ancient Battlegrounds Selected");
   }
 }

 @Override
 public void render(Graphics g) {
  g.drawImage(Assets.stagescreen, 0, 0, null);
 
//  g.drawRect(h1.x, h1.y, h1.width, h1.height);
//  g.drawRect(h2.x, h2.y, h2.width, h2.height);
//  g.drawRect(h3.x, h3.y, h3.width, h3.height);
//  g.drawRect(h4.x, h4.y, h4.width, h4.height);
 }

}
