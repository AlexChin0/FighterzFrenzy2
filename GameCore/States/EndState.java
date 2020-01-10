//This is an extension of the State class. It is displayed when the game end and gives the option to either quit or replay the game.

package GameCore.States;
import GameCore.Handler;
import GameCore.gfx.Assets;
import GameCore.entities.*;

import java.awt.Rectangle;
import java.awt.Graphics;

public class EndState extends State {
  
  private Rectangle b1, b2;

 public EndState(Handler handler) {
  super(handler);
 }

 @Override
 public void tick(){
   b1 = new Rectangle(475, 480, 256, 52); //clickable boxes
   b2 = new Rectangle(475, 480 + 52, 256, 52);
   
   if(handler.getMouseManager().isLeftPressed() && b1.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
    selectSound3.playSound();
     State.setState(handler.getGame().menuState);
     handler.getWorld().getEntityManager().getEntities().clear(); //restarts the game
     GameState.end = false;
   }
   if(handler.getMouseManager().isLeftPressed() && b2.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
     System.exit(0); //quits the game
   }
 }

 @Override
 public void render(Graphics g) {
   
   for (Entity e : handler.getWorld().getEntityManager().getEntities()){
     if(e.playerNum == 1){
       g.drawImage(Assets.endscreen, 0, 0, null);
     }else if(e.playerNum == 2){
        g.drawImage(Assets.endscreen2, 0, 0, null);    
     } 
   }
 }

}