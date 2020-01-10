//This is an extension of the State class. It is displays the world when the game has begun. 

package GameCore.States;
import GameCore.Handler;


import GameCore.entities.*;
import GameCore.worlds.World;
import GameCore.States.SelectionState;
import GameCore.gfx.AudioPlayer;
import GameCore.heroes.*;

import java.awt.Graphics;

public class GameState extends State{
  
  private World world; //world object
  private AudioPlayer battleMusic;
  
  public static boolean end = false;
  
  public GameState(Handler handler, String stage){
    super (handler);
    world = new World (handler, stage);//loads the txt file for the world
    handler.setWorld (world);
    
    if(stage.equals("res/worlds/world3.txt")){
       battleMusic = new AudioPlayer("/bgm/Darkness.wav");
    }
    
    //hero selection boxes
    if(SelectionState.heroes[0] == 1){
      handler.getWorld().getEntityManager().addEntity(new Sephira(handler, 100, 280), 1);
    }else if(SelectionState.heroes[0] == 2){
      handler.getWorld().getEntityManager().addEntity(new Grayson(handler, 100, 280), 1);
    }else if(SelectionState.heroes[0] == 3){
      handler.getWorld().getEntityManager().addEntity(new Luxaar(handler, 100, 280), 1);
    }else if(SelectionState.heroes[0] == 4){
      handler.getWorld().getEntityManager().addEntity(new Alta(handler, 100, 280), 1);
    }else if(SelectionState.heroes[0] == 5){
      handler.getWorld().getEntityManager().addEntity(new IronFiend(handler, 100, 280), 1);
    }else if(SelectionState.heroes[0] == 6){
      handler.getWorld().getEntityManager().addEntity(new TaFiRah(handler, 100, 280), 1);
    }else if(SelectionState.heroes[0] == 7){
     handler.getWorld().getEntityManager().addEntity(new Lauda(handler, 100, 280), 1);
    }else if(SelectionState.heroes[0] == 8){
     handler.getWorld().getEntityManager().addEntity(new Allistar(handler, 100, 280), 1);
    }
    
    if(SelectionState.heroes[1] == 1){
      handler.getWorld().getEntityManager().addEntity(new Sephira(handler, 1000, 280), 2);
    }else if(SelectionState.heroes[1] == 2){
      handler.getWorld().getEntityManager().addEntity(new Grayson(handler, 1000, 280), 2);
    }else if(SelectionState.heroes[1] == 3){
      handler.getWorld().getEntityManager().addEntity(new Luxaar(handler, 1000, 280), 2);
    }else if(SelectionState.heroes[1] == 4){
      handler.getWorld().getEntityManager().addEntity(new Alta(handler, 1000, 280), 2);
    }else if(SelectionState.heroes[1] == 5){
      handler.getWorld().getEntityManager().addEntity(new IronFiend(handler, 1000, 280), 2);
    }else if(SelectionState.heroes[1] == 6){
      handler.getWorld().getEntityManager().addEntity(new TaFiRah(handler, 1000, 280), 2);
    }else if(SelectionState.heroes[1] == 7){
     handler.getWorld().getEntityManager().addEntity(new Lauda(handler, 1000, 280), 2);
    }else if(SelectionState.heroes[1] == 8){
     handler.getWorld().getEntityManager().addEntity(new Allistar(handler, 1000, 280), 2);
    }
    
  }
  
  @Override
  public void tick() {
    world.tick();

    if(battleMusic != null){
    battleMusic.loopSound();
    }
    
    //failsafe key
    if (handler.getKeyManager().reset){
      for(int i = 0; i < handler.getWorld().getEntityManager().getEntities().size(); i++){
       handler.getWorld().getEntityManager().getEntities().get(i).freedom();
       
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
          if (e.playerNum == 1){
            e.setX(100f);
            e.setY(280f);
          }
          else if(e.playerNum == 2){
            e.setX(1000f);
            e.setY(280f);
          }
        }
      }
      
      
    }
          
    if(end){
     if(battleMusic != null){
     battleMusic.stopSound();
     }
      State.setState(handler.getGame().endState); //keeps track of if the game is still running
    }
  }
  
  @Override
  public void render (Graphics g){
  world.render(g);
  }
}