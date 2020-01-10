//Extension of the tile class. It is a lake tile.

package GameCore.worlds.Tiles;

import GameCore.gfx.Assets;

public class LakeTile extends Tile {
  
  public LakeTile (int id) {
   super (Assets.lake, id); 
  }
  
  @Override
  public boolean isSolid (){
   return true;
  }
  
}
