package GameCore.heroes;

import GameCore.*;
import GameCore.States.GameState;
import GameCore.entities.Entity;
import GameCore.gfx.*;

import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class Lauda extends Player{
  
  public Animation neutral, neutral2, left, right, down, up, attackLight, attackLight2, attackHeavy, attackHeavy2, flinch, flinch2, stunned, stunned2, jumpCast, jumpCast2, jumpHit, jumpHit2, shadeEffect, shadeEffect2, claw, claw2
  ,neutralFlight, neutralFlight2, flightLeft, flightRight, flightDown, flightUp, ultiCast, ultiCast2, deathDrop, deathDrop2, slice, slice2;
  

  private int shade = 0, shadeCharge = 4;
  private ArrayList<Long> shadeTick = new ArrayList<Long>();
  private boolean jump = false, land = false, regen = false, boost = false, fang = false, flight = false;
  
  public Lauda(Handler handler, float x, float y) { 
    super (handler, x , y, Player.defaultWidth, Player.defaultHeight); 
    
    bounds.x = 64;
    bounds.y = 96; // hit box variables
    bounds.width = 52;
    bounds.height = 58;
    
    neutral = new Animation (1000, Assets.laN);
    neutral2 = new Animation (1000,Assets.laN2);
    left = new Animation (100, Assets.laML);
    right = new Animation (100, Assets.laMR);
    down = new Animation (100, Assets.laMD); //instances of the animation class
    up = new Animation (100, Assets.laMU);
    
    neutralFlight = new Animation (1000, Assets.laFN);
    neutralFlight2 = new Animation (1000,Assets.laFN2);
    
    shadeEffect = new Animation (250, Assets.shade1);
    shadeEffect2 = new Animation (250, Assets.shade2);
    
    attackLight = new Animation (100, Assets.laLA);
    attackLight2 = new Animation (100, Assets.laLA2);
    attackHeavy = new Animation (100, Assets.laHA);
    attackHeavy2 = new Animation (100, Assets.laHA2);   
    
    jumpCast = new Animation(100, Assets.laST);
    jumpCast2 = new Animation(100, Assets.laST2);
    jumpHit = new Animation(100, Assets.laSH);
    jumpHit2 = new Animation(100, Assets.laSH2);
    
    deathDrop = new Animation(100, Assets.laDD);
    deathDrop2 = new Animation(100, Assets.laDD2);
    
    slice = new Animation(100, Assets.laFR);
    slice2 = new Animation(100, Assets.laFR2);
    
    claw = new Animation(80, Assets.laC);
    claw2 = new Animation(80, Assets.laC2);
    
    flinch = new Animation (100, Assets.laF);
    flinch2 = new Animation (100, Assets.laF2);
    
    stunned = new Animation (200, Assets.laS);
    stunned2 = new Animation (200, Assets.laS2);
    
    ultiCast = new Animation(120, Assets.laUC);
    ultiCast2 = new Animation(120, Assets.laUC2);
    
    width = 192;
    height = 192;
    
    health = 435; //hero values
    maxHealth = 435;
    healthMod = health / 300;
    speed = 4.4f;
    maxSpeed = 4.4f;
    
    cooldowns[0] = 6; //6
    cooldowns[1] = 8; //8
    cooldowns[2] = 3; //1
    cooldowns[3] = 1; //1
    cooldowns[4] = 1; //1
  }
  
  @Override
  public void stunned(){
	  if(fang){
		affectedBy = 0;
		timeStack = 0;
		return;  
	  }else{
		  affectedBy = 1;
		  free = false;
		  stun = true;
		  adjust(192, 192);
	  }
  }
  
  @Override
  public void slowed(float percent){
	  if(fang){
		affectedBy = 0;
		timeStack = 0;
		return;  
	  }else{
		  affectedBy = 2;
		  if(speed == maxSpeed){
			  speed = speed * percent;
			  slowed = true;
		  }
	  }
  }

  @Override
  public void silenced(){
	  if(fang){
		affectedBy = 0;
		timeStack = 0;
		return;  
	  }else{
      affectedBy = 3;
      free = true;
      silenced = true;
	  }
  }

  @Override
  public void bleed()
  {
	  if(fang){
		  affectedBy = 0;
		  timeStack = 0;
		  return;  
	  }else{
		  affectedBy = 4;
		  free = true;
		  bleeding = true;
		  if(speed == maxSpeed){
			  speed = speed * 0.8f;
		  }
	  }
  }

  @Override //method responsible for incoming damage calculations
  public void hurt(float amt){
	  if(fang){
		  amt = 0;
		  return;
	  }
    health -= amt;
    if(amt > 10){
    shade -= 30;
    }
    if(shade <= 0){
     shade = 0;
    }
    hit = true;
    System.out.println("Player " + playerNum + " Lauda." + health + " hp.");
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
    alive = false; //death method. Removes the entity from the game upon death. 
    GameState.end = true;
  }
  
  //player movement method
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
  
  //ticks every value for the hero
  @Override
  public void tick(){
    tickCooldowns();   
    inBounds();

    effectCheck(timeStack, affectedBy); 
    
    long toSeconds = abTimer / 500;
    if (!shadeTick.contains(toSeconds)){
      shadeTick.add(toSeconds);
      if (shade < 300){
        shade+= shadeCharge;
      }else if(shade >= 300){
        shade = 300;
      }
    }
    
    if(shade >= 150){
    regen = true;
    heal(0.03f);
    }else{
    regen = false; 
    }
    if(shade >= 255){
    boost = true; 
    }else{
    boost = false;
    }
    
    //Animation
    neutral.tick();
    neutral2.tick();
    left.tick();
    right.tick();
    up.tick();
    down.tick();
    neutralFlight.tick();
    neutralFlight2.tick();
    flinch.tick();
    flinch2.tick();
    stunned.tick();
    stunned2.tick();
    shadeEffect.tick();
    shadeEffect2.tick();
    
    //movement and abilities
    if (free && !stun){
      getInput();
      move();    
      
      if(!flying){
      if (handler.getKeyManager().attackLight && playerNum == 1 && checkArmed(3) || handler.getKeyManager().attackLight2 && playerNum == 2 && checkArmed(3)){
        LA = true;
        free = false;
        abilities[3] = 0;
      }
      if (handler.getKeyManager().attackHeavy && playerNum == 1  && checkArmed(4) || handler.getKeyManager().attackHeavy2 && playerNum == 2 && checkArmed(4)){
        HA = true;
        free = false;
        abilities[4] = 0;
      }
      }
      if (handler.getKeyManager().a1 && checkCooldowns(0) && playerNum == 1 || handler.getKeyManager().a4 && checkCooldowns(0) && playerNum == 2){
        free = false;
        jump = true;
        abilities[0] = 0;
      }
      if (handler.getKeyManager().a2 && checkCooldowns(1) && playerNum == 1 || handler.getKeyManager().a5 && checkCooldowns(1) && playerNum == 2){
        fang = true;
        abilities[1] = 0;
      }
      if (handler.getKeyManager().a3 && checkCooldowns(2) && playerNum == 1 && !flying || handler.getKeyManager().a6 && checkCooldowns(2) && playerNum == 2 && !flying){
        free = false;
        flight = true;
        abilities[2] = 0;
        cooldowns[1] = 2;
        abilities[1] = 0;
      }
      if (handler.getKeyManager().a3 && checkCooldowns(2) && playerNum == 1 && flying || handler.getKeyManager().a6 && checkCooldowns(2) && playerNum == 2 && flying){
    flying = false;
    shadeCharge = 3;
    speed = 4.4f;
    abilities[2] = 0;
    cooldowns[1] = 8;
    abilities[1] = 0;
    adjust(192, 192);
  }     
    }else if (!free){
      
    }
    
    if (LA){
      LightAttack(); 
    }
    if (HA){
      HeavyAttack();
    }
    if(jump){
      A1();
    }else if(land){
      jumpHit.tick();
      jumpHit2.tick();
      adjust(192, 288);
      
      if(jumpHit.checkAnim()){
       land = false;
       free = true;
      reShape(192, 288, 192, 192); 
      }
    }
    if (fang){
     A2(); 
    }
    if(flight){
     A3(); 
    }else if(flying){
    shadeCharge = -7;
    speed = 4.8f;
    if(shade <= 0){
    shadeCharge = 3;
    speed = 4.4f;
    flying = false;
    claw.index = 0;
    claw2.index = 0;
    jumpCast.index = 0;
    jumpCast2.index = 0;
    jump = false;
    fang = false;
    free = true;
    cooldowns[1] = 8;
    abilities[1] = 0;
    adjust(192, 192);
    }
    }
    if(hit && flinch.checkAnim()){
      hit = false; 
    }
  }
  
  @Override
  public void LightAttack(){
    attackLight.tick();  
    attackLight2.tick();  
    free = false;
    if (attackLight.checkAnim()){
      LA = false;
      free = true;
      if(!boost){
      hitCheck(75, 40, 35);
      }else if(boost){
      hitCheck(75, 40, 40);   
      }
    }
    
    if(stun){
      LA = false;
      attackLight.index = 0;
      attackLight2.index = 0;
      return;
    }     
  }
  
  @Override
  public void HeavyAttack(){
    attackHeavy.tick();  
    attackHeavy2.tick();
    adjust(216, 192);
    free = false;
    
    if (attackHeavy.checkAnim()){
      HA = false;
      free = true;
      reShape(216, 192, 192, 192);
      if(!boost){
      hitCheck(85, 30, 60);
      }else if(boost){
      hitCheck(85, 30, 70);       
      }
    }
    
    if(stun){
      attackHeavy.index = 0;
      attackHeavy2.index = 0;
      return;
    }     
  }
  
  @Override
  public void A1(){
   if(!flying){
   jumpCast.tick();
   jumpCast2.tick();
   if(dir == 1){
    x -= 7;
   }else if(dir == 2){
    x += 7;
   }
    
    if(jumpCast.checkAnim()){
     free = true;
     jump = false;
    }   
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
         if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(0, 0)) && e instanceof Player){
          if (e.equals(this)){
            continue;
          }else{
         jump = false;
         land = true;
         jumpCast.index = 0;
         jumpCast2.index = 0;
         if(!boost){
         e.hurt(70);
         }else if(boost){
         e.hurt(80); 
         }         
         e.timeStack += 5;
         e.affectedBy = 2;
         e.silenced();
         return;
          }
        }
       }
  }else if(flying){
  deathDrop.tick();
  deathDrop2.tick();
  adjust(300, 360);
  
  if(deathDrop.checkAnim()){
   if(!boost){
   rangedCheck((int)(x + width/2), (int)(y + height * 0.7), 110, 120, 100, 1, 3);
   }else if(boost){
      rangedCheck((int)(x + width/2), (int)(y + height * 0.7), 110, 120, 115, 1, 3);    
   }
   reShape(300, 360, 192, 192);
   free = true;
   jump = false;
  }   
  }
    if(stun || silenced){
     jump = false;
        adjust(192, 192);
        return;
      } 
  }
  
  @Override
  public void A2(){
	  if(!flying){
		  free = false;
		  adjust(330,192);
		  claw.tick();
		  claw2.tick();
		  bounds.width = 0;
		  bounds.height = 0;

		  if(claw.checkAnim()){
			  if(dir == 1){
				  dir = 2;
			  }else if(dir == 2){
				  dir = 1;
			  }
			  fang = false;
			  free = true;
			  bounds.width = 52;
			  bounds.height = 58;
			  reShape(330, 192, 192 ,192);
			  if(!boost){
				  hitCheck(100, 30, 50);
			  }else if(boost){
				  hitCheck(100, 30, 58); 
			  }

		  }
	  }else if(flying){
		  adjust(330, 192);
		  slice.tick();
		  slice2.tick();

		  if(slice.checkAnim()){
			  fang = false;
			  free = true;
			  reShape(330, 192, 192 ,192);
			  if(!boost){
				  hitSteal(180, 75, 75, 0.25f);
			  }else if(boost){
				  hitSteal(180, 75, 86, 0.25f); 
			  } 
		  }
	  }

	  if(stun || silenced){
		  claw.index = 0;
		  claw2.index = 0;
		  fang = false;
		  adjust(192, 192);
		  return;
	  } 
  }
  
  @Override
  public void A3(){
   ultiCast.tick();
   ultiCast2.tick();
  
 if(ultiCast.checkAnim()){
   flight = false;   
   flying = true;
   free = true;
   shade -= 5;
   return;
 }

    if(stun || silenced){
     adjust(192, 192);
     flight = false;
     ultiCast.index = 0;
     ultiCast2.index = 0;
     return;
    }
  }
  
  //renders the hero and their abilities
  @Override
  public void render (Graphics g){
  /*  g.setColor(Color.green);
    g.fillRect((int) (x + bounds.x * 3/4), (int)(y + bounds.y / 2), bounds.width * 2, bounds.height * 2); 
    g.setColor (Color.red);
    g.fillRect ((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height); */

    int pshift = 0;
    
    if (playerNum == 2){
      pshift = 608; 
    }
    
    if(abilities[0] == cooldowns[0]){
      g.drawImage(Assets.laAbils[0], 396 + pshift, 782, 32, 32, null);
    }else{
      g.drawImage(Assets.laAbils[1], 396 + pshift, 782, 32, 32, null);
    }
    if(abilities[1] == cooldowns[1]){
      g.drawImage(Assets.laAbils[4], 464 + pshift, 782, 32, 32, null);      
    }else{
      g.drawImage(Assets.laAbils[5], 464 + pshift, 782, 32, 32, null);
    }
    if(abilities[2] == cooldowns[2]){
      g.drawImage(Assets.laAbils[2], 530 + pshift, 782, 32, 32, null);
    }else{
      g.drawImage(Assets.laAbils[3], 530 + pshift, 782, 32, 32, null);
    }
    
    if(silenced){
     g.drawImage(Assets.silenced, 396 + pshift, 782, 32, 32, null);
     g.drawImage(Assets.silenced, 464 + pshift, 782, 32, 32, null);
     g.drawImage(Assets.silenced, 530 + pshift, 782, 32, 32, null);
    }else{
     
    }
    
    if(regen){
     g.drawImage(shadeEffect.getCurrentFrame(), (int)(x), (int)(y), null); 
    } 
    if(boost){
     g.drawImage(shadeEffect2.getCurrentFrame(), (int)(x), (int)(y), null); 
    }
    g.drawImage (getCurrentAnimationFrame(),(int) (x),(int) (y) , width, height, null);  
    
    if(playerNum == 1){
      g.setColor(Color.black);
      g.fillRect (44, 804, shade, 8); 
    }
    if(playerNum == 2){
      g.setColor(Color.black);
      g.fillRect (652, 804, shade, 8); 
    }
  }
  
  private BufferedImage getCurrentAnimationFrame(){ //decides which animation to tick to the screen
      if(stun && dir == 1){
      return stunned.getCurrentFrame();
    }else if(stun && dir == 2){
      return stunned2.getCurrentFrame();      
    }
    
    // attacks
    else if (!attackLight.checkAnim() && LA && dir == 1){
      return attackLight.getCurrentFrame();
    }else if (!attackLight.checkAnim() && LA && dir == 2){
      return attackLight2.getCurrentFrame();
    }else if (!attackHeavy.checkAnim() && HA && dir == 1){
      return attackHeavy.getCurrentFrame();
    }else if (!attackHeavy.checkAnim() && HA && dir == 2){
      return attackHeavy2.getCurrentFrame();
    }
    
    //abilities
      
    else if(jump && dir == 1 && !flying){
    return jumpCast.getCurrentFrame();
    }else if(jump && dir == 2 && !flying){
    return jumpCast2.getCurrentFrame(); 
    }else if(land && dir == 1){
    return jumpHit.getCurrentFrame();
    }else if(land && dir == 2){
    return jumpHit2.getCurrentFrame();
    } else if(jump && dir == 1 && flying){
     return deathDrop.getCurrentFrame();
    }else if(jump && dir == 2 && flying){
     return deathDrop2.getCurrentFrame(); 
    }

    else if(fang && dir == 1 && !flying){
     return claw.getCurrentFrame();
    }else if(fang && dir == 2 && !flying){
     return claw2.getCurrentFrame();
    }else if(fang && dir == 1 && flying){
     return slice.getCurrentFrame();
    }else if(fang && dir == 2 && flying){
     return slice2.getCurrentFrame();
    }
      
    else if(flight && dir == 1){
     return ultiCast.getCurrentFrame();
    }else if(flight && dir == 2){
     return ultiCast2.getCurrentFrame();
    }
    
    else if(hit && dir == 1){
      return flinch.getCurrentFrame();
    }else if(hit && dir == 2){
     return flinch2.getCurrentFrame(); 
    }
    
    // movement
    else if (handler.getKeyManager().left && playerNum == 1 || handler.getKeyManager().left2 && playerNum == 2){
      dir = 1;
      if(!flying){
      return left.getCurrentFrame(); 
      }else{
      return neutralFlight.getCurrentFrame();  
      }
    }else if (handler.getKeyManager().right && playerNum == 1|| handler.getKeyManager().right2 && playerNum == 2){
      dir = 2;
      if(!flying){
      return right.getCurrentFrame(); 
      }else{
      return neutralFlight2.getCurrentFrame();  
      }
    }else if (handler.getKeyManager().down && playerNum == 1 && !flying || handler.getKeyManager().down2 && playerNum == 2 && !flying){
      return down.getCurrentFrame();
    }else if (handler.getKeyManager().up && playerNum == 1 && !flying || handler.getKeyManager().up2 && playerNum == 2 && !flying){
      return up.getCurrentFrame();
    }
    else
     if(dir == 1 && flying){
      return neutralFlight.getCurrentFrame(); 
     }else if(dir == 2 && flying){
      return neutralFlight2.getCurrentFrame();  
     }else if (dir == 2 && !flying){
           return neutral2.getCurrentFrame(); 
        }else
      return neutral.getCurrentFrame();
  }
  
}