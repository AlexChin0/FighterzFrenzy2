
package GameCore.worlds.Tiles;

import GameCore.gfx.Assets;

public class Sky extends Tile {
  
  public Sky (int id) {
   super (Assets.sky1, id); 
  }
  
    @Override 
  public boolean willFall(){
   return true; 
  }
  
  
}


