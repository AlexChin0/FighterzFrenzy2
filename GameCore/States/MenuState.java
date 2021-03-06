//This is an extension of the State class. It is displayed when the game is launched, and gives the option to start a match, or go
// to the instruction screen

package GameCore.States;
import GameCore.Handler;
import GameCore.Launcher;
import GameCore.gfx.Assets;

import java.awt.Rectangle;
import java.awt.Graphics;

public class MenuState extends State {
  
 private Rectangle bounds_start, bounds_intro;

 public MenuState(Handler handler) {
  super(handler);
  bounds_start = new Rectangle(240, 630, 256, 128);
  bounds_intro = new Rectangle(700, 630, 256, 128);//clickable objects
 }

 @Override
 public void tick() {

  //musicPlayer.loopSound();
  
   if(handler.getMouseManager().isLeftPressed() && bounds_start.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
    selectSound.playSound();
     State.setState(handler.getGame().selectionState);//switches to the map selection
   }
   if(handler.getMouseManager().isLeftPressed() && bounds_intro.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
    selectSound.playSound();
     State.setState(handler.getGame().introState);//shows the intro screen
   }
 }

 @Override
 public void render(Graphics g) {
  g.drawImage(Assets.titlescreen, 0, 0, Launcher.runWidth, Launcher.runHeight, null);
  g.drawImage(Assets.btn_start[0], 240, 630, 256, 128, null);
  g.drawImage(Assets.btn_intro[0], 700, 620, 256, 128, null);
 }

}