package GameCore.heroes;

import GameCore.*;
import GameCore.States.GameState;
import GameCore.entities.*;
import GameCore.gfx.*;
import GameCore.worlds.Tiles.Tile;

import java.awt.*;
import java.awt.image.*;

public class IronFiend extends Player{
  
  public Boolean shield = false, stampede = false, unholy = false, ring = false,rending = false;
  public int vengeCounter = 0;
  
  public Animation neutral, neutral2, left, right, down, up, attackLight, attackLight2, attackHeavy, attackHeavy2, flinch, flinch2, stunned, stunned2, rend, rend2, SG1, SG2, ironI , ringCast, ringCast2, sprintUp, sprintDown, sprintLeft, sprintRight, beat;
  public Animation sAttackLight, sAttackLight2, sAttackHeavy, sAttackHeavy2;
  
  public IronFiend(Handler handler, float x, float y) { 
    super (handler, x , y, Player.defaultWidth, Player.defaultHeight); 
    
    bounds.x = 64;
    bounds.y = 108;
    bounds.width = 59;
    bounds.height = 59;
    
    neutral = new Animation (1000, Assets.ironN);
    neutral2 = new Animation (1000,Assets.ironN2);
    left = new Animation (150, Assets.ironML);
    right = new Animation (150, Assets.ironMR);
    down = new Animation (150, Assets.ironMD);
    up = new Animation (150, Assets.ironMU);
    
    sAttackLight = new Animation (60, Assets.ironLA);
    sAttackLight2 = new Animation (60, Assets.ironLA2);
    sAttackHeavy = new Animation (60, Assets.ironHA);
    sAttackHeavy2 = new Animation (60, Assets.ironHA2);    
    
    attackLight = new Animation (85, Assets.ironLA);
    attackLight2 = new Animation (85, Assets.ironLA2);
    attackHeavy = new Animation (85, Assets.ironHA);
    attackHeavy2 = new Animation (85, Assets.ironHA2);      
    
    flinch = new Animation (100, Assets.ironF);
    flinch2 = new Animation (100, Assets.ironF2);
    stunned = new Animation (200, Assets.ironS);
    stunned2 = new Animation (200, Assets.ironS2);
    
    sprintDown = new Animation(100, Assets.sprintDown);
    sprintUp = new Animation(100, Assets.sprintUp);
    sprintLeft = new Animation(100, Assets.sprintLeft);
    sprintRight = new Animation(100, Assets.sprintRight);
    
    SG1 = new Animation(25, Assets.ironSG1);
    SG2 = new Animation(25, Assets.ironSG2);
    ringCast = new Animation(80, Assets.ironRC);
    ringCast2 = new Animation(80, Assets.ironRC2);
    rend = new Animation(100, Assets.ironWR);
    rend2 = new Animation(100, Assets.ironWR2);
    
    ironI = new Animation(70, Assets.ironI);
    beat = new Animation(100, Assets.beat);
    
    width = 192;
    height = 192;
    
    health = 550;
    maxHealth = 550;//495
    healthMod = health / 300;
    speed = 3.7f;
    maxSpeed = 3.7f;
    
    cooldowns[0] = 6; //6
    cooldowns[1] = 8; //8
    cooldowns[2] = 21; //21
    cooldowns[3] = 1;//1
    cooldowns[4] = 1;//1
  }
  
  @Override
  public void hurt(float amt){
      hit = true;
      health -= amt;
      if(proc(20) && amt > 10){
     health -= amt + (amt/10);  
     vengeCounter ++;
     shield = true; 
      }
    System.out.println("Player " + playerNum + " Iron Fiend." + health + " hp.");
    if (health <= 0){
      alive = false;
      die();
    }
  }
  
      @Override 
  public void heal(float amt){
    if (health > maxHealth){
     health = maxHealth;
    }else{
     health += amt; 
    }
  }
      
  @Override
  public void die(){
    alive = false;
    GameState.end = true;
  }
  
  public void getInput(){
  xMove = 0;
  yMove = 0;
  
  if(playerNum == 1){
    if (handler.getKeyManager().up)
      yMove = -speed;
    if (handler.getKeyManager().down)
      yMove = speed;
    if (handler.getKeyManager().left)
      xMove = -speed;
    if (handler.getKeyManager().right)
      xMove = speed;   
  } 
  if(playerNum == 2){
    if (handler.getKeyManager().up2)
      yMove = -speed;
    if (handler.getKeyManager().down2)
      yMove = speed;
    if (handler.getKeyManager().left2)
      xMove = -speed;
    if (handler.getKeyManager().right2)
      xMove = speed; 
  }
}
  
  @Override 
  public void tick(){
    inBounds(); 
    tickCooldowns(); 
        
    //Animation
    neutral.tick();
    neutral2.tick();
    left.tick();
    right.tick();
    up.tick();
    down.tick();
    flinch.tick();
    flinch2.tick();
    stunned.tick();
    stunned2.tick();
    
    if(shield){
        SG1.tick();
        SG2.tick();
        
        if(SG1.checkAnim()){
          shield = false;
        }
      }

    effectCheck(timeStack, affectedBy); 
    
    if (free && !stun){
    //Moving
      getInput();
      move();
      if (handler.getKeyManager().attackLight && playerNum == 1 && checkArmed(3) || handler.getKeyManager().attackLight2 && checkArmed(3) && playerNum == 2){
        LA = true;
        free = false;
        abilities[3] = 0;
      }
      if (handler.getKeyManager().attackHeavy && playerNum == 1 && checkArmed(4) || handler.getKeyManager().attackHeavy2 && checkArmed(4) && playerNum == 2){
        HA = true;
        free = false;
        abilities[4] = 0;
      }
      if (handler.getKeyManager().a1 && checkCooldowns(0) && playerNum == 1 || handler.getKeyManager().a4 && checkCooldowns(0) && playerNum == 2){
        abilities[0] = 0;
        stampede = true;
        free = false;
      }
      if (handler.getKeyManager().a2 && checkCooldowns(1) && playerNum == 1 || handler.getKeyManager().a5 && checkCooldowns(1) && playerNum == 2){
       abilities[1] = 0;
       rending = true;
      }
      if (handler.getKeyManager().a3 && checkCooldowns(2) && playerNum == 1 || handler.getKeyManager().a6 && checkCooldowns(2) && playerNum == 2){
       abilities[2] = 0;
       ring = true;
      }

    }else if (!free){
      
    }
    
    if (LA){
      LightAttack(); 
    }
    if (HA){
      HeavyAttack();
    }
    if(stampede){    
     A1(); 
    }
    if (rending){
      A2(); 
    }
    if (ring){
     A3(); 
    }
    
    if(hit && flinch.checkAnim()){
      hit = false; 
    }
  }
  
  @Override
  public void LightAttack(){
	  if(unholy)
	  {
		  sAttackLight.tick();  
		  sAttackLight2.tick(); 	
		  free = false;

		  if (sAttackLight.checkAnim()){
			  LA = false;
			  free = true;
			  hitSteal(75, 65, 50 + (int)(vengeCounter * (50*0.10)), 0.15f); 
		  }
	  }
	  else{
		  attackLight.tick();  
		  attackLight2.tick(); 
		  free = false;

		  if (attackLight.checkAnim()){
			  LA = false;
			  free = true;
			  hitCheck(50, 60, 50 + (int)(vengeCounter * (50*0.10))); 
		  }
	  }

	  if(stun){
		  LA = false;
		  attackLight.index = 0;
		  attackLight2.index = 0;
		  sAttackLight.index = 0;
		  sAttackLight2.index = 0;
		  return;
	  }     
  }
  
  @Override
  public void HeavyAttack(){
	  if(unholy)
	  {
		  sAttackHeavy.tick();
		  sAttackHeavy2.tick();
		  adjust(216, 216);
		  free = false;

		  if (sAttackHeavy.checkAnim()){
			  HA = false;
			  free = true;
			  reShape(216, 216, 192, 192);
			  hitSteal(125, 65, 85 + (int)(vengeCounter * (50*0.10)), 0.15f);      

		  }

	  }
	  else
	  {
		  attackHeavy.tick();  
		  attackHeavy2.tick();
		  adjust(216, 216);
		  free = false;

		  if (attackHeavy.checkAnim()){
			  HA = false;
			  free = true;
			  reShape(216, 216, 192, 192);
			  hitCheck(100, 60, 85+ (int)(vengeCounter * (85*0.10)));  

		  }
	  }

	  if(stun){
		  HA = false;
		  attackHeavy.index = 0;
		  attackHeavy2.index = 0;
		  sAttackHeavy.index = 0;
		  sAttackHeavy2.index = 0;
		  return;
	  }     
  }
  
  @Override
  public void A1(){
    sprintLeft.tick();
    sprintRight.tick();
    move();
    
    if(playerNum == 1){
        if (handler.getKeyManager().up)
          yMove = -speed;
        if (handler.getKeyManager().down)
          yMove = speed; 
      } 
      if(playerNum == 2){
        if (handler.getKeyManager().up2)
          yMove = -speed;
        if (handler.getKeyManager().down2)
          yMove = speed;
      }
    
    if(dir == 1){
     x -= 9;
        int tx = (int)(x + xMove + bounds.x) / Tile.TILEWIDTH;
        
        if(collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
           collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) || x < 0){
            stampede = false;
            free = true;
            stun = true;
            affectedBy = 1;
            timeStack = 3;
            x += 64;
        }
    }else if(dir == 2){
      x += 9;
      int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
      
      if(collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
         collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT) || x + bounds.width > Launcher.runWidth - Tile.TILEWIDTH  * 2){
        stampede = false;
        free = true;
        stun = true;
        affectedBy = 1;
        timeStack = 3;
            x -= 64;
        }
    }

    for (Entity e : handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this)){
         continue;
        }else if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xMove, 0)) || e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(0, yMove))){
         stampede = false;
         free = true;
         if(e instanceof Player){
         hitLock(100, 100, 50, 3);
         knockback(100, 100, 0, 64);
         }else if(e instanceof StaticEntity){
         if(e.getHealth() > 300){
         stun = true;
         affectedBy = 1;
         timeStack = 3;
         }else{
         e.die();
         }
         }
         if(dir == 1){
             x += 64; 
         }else if(dir == 2){
          x -= 64;
         }
        }
       }
    
    if(stun || silenced){
      if(silenced){
      free = true;
      }
      stampede = false;
      return;
    } 
  }
  
  @Override
  public void A2(){
    adjust(300, 300);
    free = false;
    rend.tick();
    rend2.tick();
    
    if(rend.checkAnim()){
      reShape(300, 300, 192, 192);
      rending = false;
      free = true;
      hitSteal(120, 200, (int)(maxHealth - health)/2, 0.50f);
      }
    }
  
  @Override
  public void A3(){
   free = false;
   ringCast.tick();
   ringCast2.tick();

   if(ringCast.checkAnim()){
    ring = false;
    unholy = true;
    free = true;
   }else if(stun || silenced){
    ring = false;
    unholy = true;
    ringCast.index = 0;
    ringCast2.index = 0;
   }
  }
  
  @Override
  public void render (Graphics g){  
    
    int pshift = 0;
    
    if (playerNum == 2){
     pshift = 608; 
    }
    
    if(abilities[0] == cooldowns[0]){
      g.drawImage(Assets.ironAbils[0], 396 + pshift, 782, 32, 32, null);
    }else{
      g.drawImage(Assets.ironAbils[1], 396 + pshift, 782, 32, 32, null);
    }
    if(abilities[1] == cooldowns[1]){
      g.drawImage(Assets.ironAbils[2], 464 + pshift, 782, 32, 32, null);      
    }else{
      g.drawImage(Assets.ironAbils[5], 464 + pshift, 782, 32, 32, null);
    }
    if(abilities[2] == cooldowns[2]){
      g.drawImage(Assets.ironAbils[4], 530 + pshift, 782, 32, 32, null);
    }else{
      g.drawImage(Assets.ironAbils[3], 530 + pshift, 782, 32, 32, null);
    } 
    
    if(silenced){
     g.drawImage(Assets.silenced, 396 + pshift, 782, 32, 32, null);
     g.drawImage(Assets.silenced, 464 + pshift, 782, 32, 32, null);
     g.drawImage(Assets.silenced, 530 + pshift, 782, 32, 32, null);
    }else{
     
    }
    
//    g.setColor(Color.green);
//    g.fillRect((int) (x + bounds.x * 3/4), (int)(y + bounds.y / 2), bounds.width * 2, bounds.height * 2); 
//    g.setColor (Color.red);
//    g.fillRect ((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height); 
      
      g.drawImage (getCurrentAnimationFrame(),(int) (x),(int) (y) , width, height, null); 
      if(stampede){
        if(dir == 1){
          g.drawImage(sprintLeft.getCurrentFrame(),(int) (x),(int) (y) , width, height, null);  
        }else if(dir == 2){
          g.drawImage(sprintRight.getCurrentFrame(),(int) (x),(int) (y) , width, height, null); 
        }
      }
      
      if(unholy){
        beat.tick();
        speed = 4.2f;
        maxSpeed = 4.2f;
        heal(0.1f);  
        g.drawImage(beat.getCurrentFrame(),(int) (x),(int) (y) , width, height, null);  
        if(abilities[2] == 10){
         unholy = false;
         speed = 3.7f;
         maxSpeed = 3.7f;
        }
      }
  
      if(shield){
        if(dir == 1){
          g.drawImage (SG1.getCurrentFrame(),(int) (x),(int) (y) , width, height, null);           
        }else if(dir == 2){
          g.drawImage (SG2.getCurrentFrame(),(int) (x),(int) (y) , width, height, null);  
        }
      }
  }
      
    // g.fillRect(ar.x, ar.y, ar.width, ar.height);  
  
  private BufferedImage getCurrentAnimationFrame(){
    
    if(stun && dir == 1){
      return stunned.getCurrentFrame();
    }else if(stun && dir == 2){
      return stunned2.getCurrentFrame();      
    }
    // attacks
    else if (!attackLight.checkAnim() && LA && dir == 1 && !unholy){
      return attackLight.getCurrentFrame();
    }else if (!attackLight.checkAnim() && LA && dir == 2 && !unholy){
      return attackLight2.getCurrentFrame();
    }else if (!attackHeavy.checkAnim() && HA && dir == 1 && !unholy){
      return attackHeavy.getCurrentFrame();
    }else if (!attackHeavy.checkAnim() && HA && dir == 2 && !unholy){
      return attackHeavy2.getCurrentFrame();
    }
    
    else if (!sAttackLight.checkAnim() && LA && dir == 1 && unholy){
    	return sAttackLight.getCurrentFrame();
    }else if (!sAttackLight.checkAnim() && LA && dir == 2 && unholy){
    	return sAttackLight2.getCurrentFrame();
    }else if (!sAttackHeavy.checkAnim() && HA && dir == 1 && unholy){
    	return sAttackHeavy.getCurrentFrame();
    }else if (!sAttackHeavy.checkAnim() && HA && dir == 2 && unholy){
    	return sAttackHeavy2.getCurrentFrame();
    }
    
    else if(hit && dir == 1){
      return flinch.getCurrentFrame();
    }else if(hit && dir == 2){
      return flinch2.getCurrentFrame(); 
    }
    
    //abilities
    else if(rending && dir == 1){
      return rend.getCurrentFrame();
    }else if(rending && dir == 2){
      return rend2.getCurrentFrame(); 
    }
    
    else if(ring && dir == 2){
      return ringCast.getCurrentFrame();     
    }else if(ring && dir == 1){
      return ringCast2.getCurrentFrame();     
    }
      
    
    // movement
    else if(stampede && dir == 1){
        return left.getCurrentFrame();  
    }else if(stampede && dir == 2){
     return right.getCurrentFrame();
    }
    
    else if (handler.getKeyManager().left && playerNum == 1 && ! stampede|| handler.getKeyManager().left2 && playerNum == 2 && !stampede){
      dir = 1;
      return left.getCurrentFrame(); 
    }else if (handler.getKeyManager().right && playerNum == 1 && ! stampede|| handler.getKeyManager().right2 && playerNum == 2 && !stampede){
      dir = 2;
      return right.getCurrentFrame();
    }else if (handler.getKeyManager().down && playerNum == 1 && ! stampede|| handler.getKeyManager().down2 && playerNum == 2 && ! stampede){
      return down.getCurrentFrame();
    }else if (handler.getKeyManager().up && playerNum == 1 && ! stampede|| handler.getKeyManager().up2 && playerNum == 2 && ! stampede){
      return up.getCurrentFrame();
    }else if (dir == 2){
      return neutral2.getCurrentFrame(); 
    }
    else
      return neutral.getCurrentFrame();
  }

}
