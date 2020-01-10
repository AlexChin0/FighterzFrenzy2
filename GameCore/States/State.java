//This is an abstract class which is the base for all states, which are different menus/screens that are displayed at different stages of the game.

package GameCore.States; 
import GameCore.Handler;
import GameCore.gfx.AudioPlayer;

import java.awt.Graphics;
  
public abstract class State {
  
  private static State currentState = null;
  protected static AudioPlayer selectSound, selectSound2, selectSound3, musicPlayer;
  
  public static void setState(State state){
   currentState = state; 

  }
  
  public static State getState(){
   return currentState; 
  }
  
  protected Handler handler;
  
  public State (Handler handler){
   this.handler = handler; 
   
   selectSound = new AudioPlayer("/se/select.wav");
   selectSound2 = new AudioPlayer("/se/select5.wav");
   selectSound3 = new AudioPlayer("/se/select3.wav");
   
   musicPlayer = new AudioPlayer("/bgm/title.wav");
  }
  
  public abstract void tick();
  
  public abstract void render (Graphics g);
}
