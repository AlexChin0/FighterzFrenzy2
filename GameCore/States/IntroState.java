//This is an extension of the State class. It displays the instructions to the screen if the option is chosen and allows the game to load 
//afterwords.

package GameCore.States;
import GameCore.Handler;
import GameCore.gfx.AudioPlayer;

import GameCore.gfx.Assets;

import java.awt.Rectangle;
import java.awt.Graphics;

public class IntroState extends State {

 private Rectangle bounds;

 public IntroState(Handler handler) {
  super(handler);
  bounds = new Rectangle(440, 630, 256, 128);//clickable object
 }

 @Override
 public void tick() {
   if(handler.getMouseManager().isLeftPressed() && bounds.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
	     selectSound3.playSound();
     State.setState(handler.getGame().selectionState);//loads the game
   }
 }

 @Override
 public void render(Graphics g) {
  g.drawImage(Assets.introscreen, 0, 0, null);//draws the objects
  g.drawImage(Assets.btn_start[0], 440, 630, 256, 128, null);
 }

}