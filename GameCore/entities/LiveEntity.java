package GameCore.entities;

import GameCore.*;
import GameCore.gfx.*;
import GameCore.worlds.Tiles.Tile;
import GameCore.heroes.*;

import java.awt.*;

public class LiveEntity extends Entity {
 
 protected boolean flying, falling;
 protected float xMove, yMove;
 protected int moveCounter = 0, dirWheel = 1;
 protected Entity p1, p2;
  
  public LiveEntity(Handler handler, float x, float y, int width, int height) { 
    super(handler, x , y, width, height);
    
    this.handler = handler;
    this.x = x;
    this.y = y;
    this.width = width; 
    this.height = height;
    health = defaultHP;
    
    p1 = getTarget(1);
    p2 = getTarget(2);
    
    
    bounds = new Rectangle (0, 0, width, height);
  }
  
  public void tick(){
    
  }
  
  public void render(Graphics g){
    
  }
  
  public void stunned(){
  
  }
  
  public void slowed(float percent){
   
  }
  
  public void silenced(){
   
  }
  
  public void bleed()
  {
    
  }
  
  protected void moveBehaviour(int type){ //0 == random 1 == attack
    if(type == 0){  
      randMove();
    }else if(type == 1){
      attackMove(0);
    }
  }
  
  protected void randMove(){
    moveCounter += 2;
    
    if(moveCounter >= 50){
      dirWheel = 1 + (int)(Math.random() * ((4 - 1) + 1));
      moveCounter = 0;
    }
    
    if(dirWheel == 1){
      dir = 1;
      yMove = 3;
      xMove = 0;
    }else if(dirWheel == 2){
      dir = 2;
      xMove = 3;
      yMove = 0;
    }else if(dirWheel == 3){
      dir = 3;
      yMove = -3;
      xMove = 0;
    }else if(dirWheel == 4){
      dir = 4;
      xMove = -3;
      yMove = 0;
    }
  }
  
  protected void attackMove(int playerNum){
    float dx = 0, dy = 0, dx2 = 0, dy2 = 0;
    
    if(playerNum == 1){
    dx = x - p1.getX();
    dy = y - p1.getY();
    }else if(playerNum == 2){
    dx2 = x - p2.getX();
    dy2 = y - p2.getY();
    }
    if(dx > 0 && playerNum == 1|| dx2 > 0 && playerNum == 2){
      xMove = -3;
      dir = 4;
    }else if(dx < 0 && playerNum == 1|| dx2 < 0 && playerNum == 2){
      xMove = 3;
      dir = 2;
    }
    
    if(dy > 0 && playerNum == 1 || dy2 > 0 && playerNum == 2){
      yMove = -3;
      //dir = 3;
    }else if(dy < 0 && playerNum == 1 || dy2 < 0 && playerNum == 2){
      yMove = 3;
      //dir = 1;
    }
    
  }
  
  public Entity getTarget(int playerNum){
    for(Entity e : handler.getWorld().getEntityManager().getEntities()){
      if(e.equals(this)){
        continue; 
      }else if(e instanceof Player && e.playerNum == playerNum){
        return e;
      }
    }
    return null;   
  }

  protected boolean collisionWithTile(int x, int y){
   return handler.getWorld().getTile(x, y).isSolid(); 
  }

  protected boolean collisionWithFall(int x, int y){
   return handler.getWorld().getTile(x, y).willFall(); 
  }

  private void fallInit(){
   width -= 10;
   height -= 10; //falling animation
   x+=10;
   y+=10;
   if(width <= 96 && height <= 96){
    hurt(maxHealth * 0.15f);
    if(playerNum == 1){
     x = 100;
     y = 280;
    }else if(playerNum == 2){
     x = 1000;
     y = 280; 
    }
    height = 192;
    width = 192;
    falling = false;
    return;
   }
  }

public void effectTiles(){ 
    if(collisionWithFall((int) (x + bounds.x + bounds.width * 1.5) / Tile.TILEWIDTH, (int) (y + bounds.y + bounds.height * 1.5) / Tile.TILEHEIGHT) && 
       collisionWithFall((int) (x + bounds.x) / Tile.TILEWIDTH, (int) (y + bounds.y * 1.5) / Tile.TILEHEIGHT)){//tile collision
      falling = true;
    }
    if(falling){
      fallInit();
    }
}
  
public void move(){
  if(!checkEntityCollisions(xMove, 0))
  moveX();
  if(!checkEntityCollisions(0, yMove))
  moveY();
  if(!flying){
  effectTiles();
  }
}

public void inBounds(){
   if ((int)(x + xMove + bounds.x) < Tile.TILEWIDTH * 0.6){ // left
    x += Tile.TILEWIDTH; 
   }else if ((int) (x + xMove + bounds.x + bounds.width) > (Launcher.runWidth - Tile.TILEWIDTH * 0.6)){ // right
    x -= Tile.TILEWIDTH; 
   }else if ((int)(y + yMove + bounds.y) > Launcher.runHeight - Tile.TILEHEIGHT){ // up
    y -= Tile.TILEHEIGHT;
   }else if ((int) (y + yMove + bounds.y + bounds.height) < Tile.TILEHEIGHT){ // down
    y += Tile.TILEHEIGHT;
   }
   
   if(!flying){
   if (collisionWithTile((int) (x + bounds.x + bounds.width/2)/ Tile.TILEWIDTH,(int) (y + bounds.y) / Tile.TILEHEIGHT) &&
   collisionWithTile((int) (x + bounds.x + bounds.width/2)/ Tile.TILEWIDTH, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
     x -= Tile.TILEWIDTH; // right collision
   }
   
   if (collisionWithTile((int)(x + bounds.x + bounds.width/2)/ Tile.TILEWIDTH,(int) (y + bounds.y) / Tile.TILEHEIGHT) &&
       collisionWithTile((int)(x + bounds.x + bounds.width/2)/ Tile.TILEWIDTH, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
     x += Tile.TILEWIDTH; // left collision
   }
   
   if(collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, (int)(y + bounds.y) / Tile.TILEHEIGHT) &&
      collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, (int)(y + bounds.y) / Tile.TILEHEIGHT)){
     y -= Tile.TILEHEIGHT;//up collision
   }  
   
   if(collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, (int)(y + bounds.y + bounds.height/2) / Tile.TILEHEIGHT) &&
      collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, (int)(y + bounds.y + bounds.height/2) / Tile.TILEHEIGHT)){
     y += Tile.TILEHEIGHT; //down collision
   }
 }
 }

public void moveX(){
 if(!flying){
  if(xMove > 0){//Checks collisions moving right
    int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
    
    if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
       !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
      x += xMove;
    }
  }else if(xMove < 0){// Checks collisions moving left
    int tx = (int)(x + xMove + bounds.x) / Tile.TILEWIDTH;
    
    if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
       !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
      x += xMove;
    }
  }
 }else if(flying){
  if(xMove != 0){
  x += xMove;
  }
 }
}

public void moveY(){
 if(!flying){
  if(yMove < 0){//Checks collisions moving up
    int ty = (int)(y + yMove + bounds.y) / Tile.TILEHEIGHT;
    
    if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
       !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
      y += yMove;
    }
  }else if(yMove > 0){//Checks collisions moving down
    int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
    
    if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
       !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
      y += yMove;
    }
  }
  }else if(flying){
  if(yMove != 0){
  y += yMove;
  }
 }
}
  
  public void hurt(float amt){
    health -= amt;
    if(health <= 0){
      die();
    }
  }
  
  public void heal(float amt){
    health+= amt;
    if(health >= maxHealth){
      health = maxHealth;
    }
  }
}
