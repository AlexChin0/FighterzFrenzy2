//The world class is a class which draws the map, loads the array list of players, and ticks the games that are running. 
//it is the primary drawing class for the game.

package GameCore.worlds;

import GameCore.worlds.Tiles.*;
import GameCore.gfx.Utils;
import GameCore.Handler;
import GameCore.managers.EntityManager;
import java.awt.Graphics;

public class World {
  
private Handler handler;  
private int width, height;
private int[][] tiles;

//players
private EntityManager entityManager;

public World(Handler handler, String path){
  this.handler = handler;
  entityManager = new EntityManager(handler);//initiates the entity manager class
  
  loadWorld(path); 
}

public void tick(){
  entityManager.tick();
}

public void render(Graphics g){
  for(int y = 0;y < height;y++){ //loads the tile to x and y coordinates
   for(int x = 0;x < width;x++){
    getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
   }
  }
  entityManager.render(g);
 }

 public Tile getTile(int x, int y){
   if(x < 0 || y < 0 || x >= width || y >= height){
   return Tile.PlainTile; //draws map tiles
   }
   
  Tile t = Tile.tiles[tiles[x][y]];
  if(t == null)
   return Tile.PlainTile;
  return t;
 }
 
 private void loadWorld(String path){
  String file = Utils.loadFileAsString(path); //reads the file from the utility class to draw tiles
  String[] tokens = file.split("\\s+");
  width = Utils.parseInt(tokens[0]);
  height = Utils.parseInt(tokens[1]);
  
  tiles = new int[width][height];
  for(int y = 0;y < height;y++){
    for(int x = 0;x < width;x++){
      tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 2]);
    }
  }
 }
 
 public EntityManager getEntityManager(){
  return entityManager; 
 }
  
}
