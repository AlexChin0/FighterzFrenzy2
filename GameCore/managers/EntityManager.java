//This class creates an array list of every player in the game. It controls the number of entities that are rendered to the screen and
// is repsonsible for proper handling of player objects.

package GameCore.managers;
import GameCore.Handler;

import GameCore.gfx.Assets;
import GameCore.entities.Entity;
import GameCore.entities.*;

import java.awt.Graphics;
import java.awt.Color;
import java.util.*;

public class EntityManager {

  private Handler handler;
  private ArrayList<Entity> entities; //render priority check
  private Entity p1, p2;
  
  private Comparator<Entity> renderSorter = new Comparator<Entity>(){
   @Override
   public int compare(Entity a, Entity b) {
    if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
     return -1;
    return 1;
   }
  };

  public EntityManager(Handler handler){ //class constructor
    this.handler = handler;
    entities = new ArrayList<Entity>();
  }
  
  public void tick(){
    for(int i = 0; i < entities.size(); i++){ //ticks every player in the game
     Entity e = entities.get(i);
     e.tick();
     if(!e.isAlive()) //removes entities who are dead
       entities.remove(e);
    }
    Collections.sort(entities, renderSorter);
  }
  
  public void render(Graphics g){ //renders all entities
    for(Entity e : entities){

      if(e.playerNum == 1){
        p1 = e;
      }
      if(e.playerNum == 2){
        p2 = e; 
      }
  
      e.render(g);
      //g.drawRect((int)(e.getX()), (int)(e.getY()), e.getWidth(), e.getHeight());
    }
        g.setColor(Color.red);
        g.fillRect(44, 784, (int)(p1.getHealth() / p1.getMod()), 12); //renders player health bars
        g.fillRect(652, 784,(int)(p2.getHealth() / p2.getMod()), 12);       
    g.drawImage(Assets.hud1, 0, 768, 608, 64, null); //draws the heads up display
    g.drawImage(Assets.hud1, 608, 768, 608, 64, null);
  }
  
  public void addEntity (Entity e, int pick){ //adds entities to the array list
    entities.add(e);
    e.playerNum = pick; 
  }
  
  public int mineCount(){
	  int count = 0;
	 for(Entity e : entities){
		 if(e instanceof Mine){
			count ++; 
		 }else{
			 continue;
		 }
	 }
	 return count;
  }
  
//  public int getCount(Class<?> c){
//	int count = 0;
//	 for(Entity e : entities){
//		 if(e instanceof c){
//			count ++; 
//		 }else{
//			 continue;
//		 }
//	 }
//	 return count;
//  }
 
 
  //getters and setters
  
  public Handler getHandler() {
    return handler;
  }
  
  public void setHandler(Handler handler) {
    this.handler = handler;
  }
  
  public ArrayList<Entity> getEntities() {
    return entities;
  }
  
  public void setEntities(ArrayList<Entity> entities) {
    this.entities = entities;
  }
  
}
