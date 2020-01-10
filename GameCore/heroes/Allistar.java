package GameCore.heroes;

import GameCore.*;
import GameCore.States.GameState;
import GameCore.entities.*;
import GameCore.gfx.*;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

public class Allistar extends Player{

   private boolean flaskThrow = false, flaskBreak = false, flaskLand = false, dive = false, prime = false, quickDraw = false, ignite = false;
   private Rectangle ab = new Rectangle ();
   private int posX, range = 250, acidCounter, charges = 4, mineCount = 0;
   private float hSpeed = 0.2f, vSpeed = 0.2f, initY = (y + height/3), initX;
   private Entity opp;
   
   public Animation neutral, neutral2, left, right, down, up, attackLight, attackLight2, attackHeavy, attackHeavy2, flinch, flinch2, stunned, stunned2, projectileL, throwLeft, throwRight, bottle, bottleBreak, acidPool, acidIgnite, backRoll, backRoll2, plant, plant2;
   
   private ArrayList<Projectile> bullets, scatters, flasks, shards;
   
   public Allistar(Handler handler, float x, float y) { 
     super (handler, x , y, Player.defaultWidth, Player.defaultHeight); 
     
     bounds.x = 64;
     bounds.y = 88;
     bounds.width = 48;
     bounds.height = 56;
     
     neutral = new Animation (1000, Assets.alN); 
     neutral2 = new Animation (1000,Assets.alN2);
     left = new Animation (100, Assets.alML);
     right = new Animation (100, Assets.alMR);
     down = new Animation (100, Assets.alMD);
     up = new Animation (100, Assets.alMU);
     
     attackLight = new Animation (100, Assets.alLA);
     attackLight2 = new Animation (100, Assets.alLA2);
     attackHeavy = new Animation (75, Assets.alHA);
     attackHeavy2 = new Animation (75, Assets.alHA2);     
     
     flinch = new Animation (100, Assets.alF);
     flinch2 = new Animation (100, Assets.alF2);
     stunned = new Animation (200, Assets.alS);
     stunned2 = new Animation (200, Assets.alS2);
     
     throwLeft = new Animation(100, Assets.alT);
     throwRight = new Animation(100, Assets.alT2);
     
     bottle = new Animation(100, Assets.aFlask);
     bottleBreak = new Animation(100, Assets.aBreak);
     acidPool = new Animation(100, Assets.acid);
     acidIgnite = new Animation(100, Assets.acidFire);
     
     projectileL = new Animation(100, Assets.bullet);
     
     backRoll = new Animation(75, Assets.alSR);
     backRoll2 = new Animation(75, Assets.alSR2);
     plant = new Animation(100, Assets.alMP);
     plant2 = new Animation(100, Assets.alMP2);

     bullets = new ArrayList<Projectile>();
     scatters = new ArrayList<Projectile>();
     flasks = new ArrayList<Projectile>();
     shards = new ArrayList<Projectile>();
     
     width = 192;
     height = 192;
     
     health = 400;
     maxHealth = 400;
     healthMod = health / 300;
     speed = 4.8f;
     maxSpeed = 4.8f;
     
     cooldowns[0] = 11; //11
     cooldowns[1] = 6; //6
     cooldowns[2] = 6; //6, 8 charges
     cooldowns[3] = 1; //1
     cooldowns[4] = 2; //1
   }
   
   @Override
   public void hurt(float amt){
     health -= amt;
     hit = true;
     System.out.println("Player " + playerNum + " Sir Allistar." + health + " hp.");
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
   public void stunned(){
     free = false;
     stun = true;
     adjust(192, 192);
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
   public void tickCooldowns(){
    abTimer += System.currentTimeMillis() - lastUse;
    lastUse = System.currentTimeMillis(); //clock timer for abilities
    
    long toSeconds = (int)(abTimer / 1000);
    if (!a1tick.contains(toSeconds)){
      a1tick.add(toSeconds);
      if (abilities[0] < cooldowns[0]){
      abilities[0] ++;
      }
    }
    
    if (!a2tick.contains(toSeconds)){
      a2tick.add(toSeconds);
      if (abilities[1] < cooldowns[1]){
        abilities[1] ++;
      }
    }
    
    if (!a3tick.contains(toSeconds)){
      a3tick.add(toSeconds);
      if (abilities[2] < cooldowns[2]){
        abilities[2]++;
      }else if(abilities[2] == cooldowns[2] && charges < 8 && mineCount < 8){
        abilities[2] = 0;  
        charges++;
      }
    }
    
    if(!lightTick.contains(toSeconds)){
     lightTick.add(toSeconds);
     if (abilities[3] < cooldowns[3]){
      abilities[3] ++; 
     }
    }
    
    if(!heavyTick.contains(toSeconds)){
      heavyTick.add(toSeconds);
      if (abilities[4] < cooldowns[4]){
        abilities[4]++; 
      }
    }
  }
   
   @Override 
   public void tick () {
     inBounds(); 
     tickCooldowns();
     
     opp = getOpponent();
     projectileL.tick();
     mineCount = handler.getWorld().getEntityManager().mineCount();
     
     projCheck(bullets, 30, 0, 0);
     projCheck(scatters, 30, 0, 0);
     projCheck(shards, 30, 4, 3);
     
     for(int i = 0; i < flasks.size(); i++){
      flasks.get(i).tick();
      
            Rectangle pb = new Rectangle ();            
            pb.x = flasks.get(i).projX + flasks.get(i).inX;
            pb.y = flasks.get(i).projY + flasks.get(i).inY;
            pb.width = flasks.get(i).projWidth;
            pb.height = flasks.get(i).projHeight;
            
      flasks.get(i).speedY += 0.3;
      if(flasks.get(i).projY >= initY){
       flaskLand = true;
       initX = flasks.get(i).projX;
       flasks.remove(i);
      }
            
            for (Entity e : handler.getWorld().getEntityManager().getEntities()){
              if (e.equals(this))
                continue;
              if(e.getHitbox(0, 0).intersects(pb) && e.playerNum + 2 != playerNum){
                flaskLand = true;
                if(e instanceof Player){
                e.hurt(30);
                }else if(e instanceof StaticEntity){
                  continue;
                }
                initX = e.getX();
                initY = e.getY();
                if(flasks.size() > 0){
                flasks.remove(i);
                }
              }
            }   
      
     }
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
    	 flaskThrow = true;
         free = false;
         abilities[0] = 0;
       }
       if (handler.getKeyManager().a2 && checkCooldowns(1) && playerNum == 1 || handler.getKeyManager().a5 && checkCooldowns(1) && playerNum == 2){
        dive = true;
        free = false;
        if(dir == 1){
         x += 100;
        }else if(dir == 2){
         x -= 100; 
        }       
        abilities[1] = 0;
       }
       if (handler.getKeyManager().a3 && charges > 0 && playerNum == 1 || handler.getKeyManager().a6 && charges > 0 && playerNum == 2){
        prime = true;
        free = false;
       }
     }else if (!free){
        
     }
     
     if (LA){
       LightAttack(); 
     }
     if (HA){
       if(quickDraw){
        attackHeavy.index = 5;
        attackHeavy2.index = 5;
       }
       HeavyAttack();
     }
     if (flaskThrow){    
      A1(); 
     }
     if (dive){
       A2(); 
     }
     if (prime){
      A3(); 
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
     if(dir == 2){
      if(proc(40))
      {
          shards.add(new Projectile (44, 0, (int)(x + bounds.x), (int)(y - 30), 25, 25, 32, 88, projectileL, 2));
      }
      else
      {
          bullets.add(new Projectile (44, 0, (int)(x + bounds.x), (int)(y - 30), 25, 25, 32, 88, projectileL, 2));
      }
     }else if(dir == 1){
    	 if(proc(40))
    	 {
             shards.add(new Projectile (-44, 0, (int)(x), (int)(y - 30), 20, 8, 32, 88, projectileL, 1));  
    	 }
         else
         {
             bullets.add(new Projectile (-44, 0, (int)(x), (int)(y - 30), 20, 8, 32, 88, projectileL, 1)); 
         }
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
   quickDraw = false;
   int scatterY = 0;
   posX = (int)(x);
  
     attackHeavy.tick();
     attackHeavy2.tick();
     free = false;
     
     if (attackHeavy.checkAnim()){
      HA = false;
      free = true;
      if(dir == 2){
       for(int i = 0; i<=5; i++){
    	   scatterY = (int) (Math.floor(Math.random() * 6) - 2);
    	   scatters.add(new Projectile (50, scatterY, (int)(x + bounds.x), (int)(y - 30), 20, 8, 32, 88, projectileL, 2));   
       }
      }else if(dir == 1){
    	  for(int i = 0; i<=5; i++){
    		  scatterY = (int) (Math.floor(Math.random() * 6) - 2);
              scatters.add(new Projectile (-50, scatterY, (int)(x), (int)(y - 30), 20, 8, 32, 88, projectileL, 1));  
    	  }
      }
     }
     
     if (attackHeavy.checkAnim()){
      HA = false;
      free = true;
     }
     
     if(stun){
    	 HA = false;
    	 attackHeavy.index = 0;
    	 attackHeavy2.index = 0;
    	 return;
     }
   }
   
   @Override
   public void A1(){
     free = false;
     
       if (handler.getKeyManager().a1 && playerNum == 1  && throwLeft.index >= 5 && vSpeed <= 8|| handler.getKeyManager().a4 && playerNum == 2 && throwLeft.index >= 5 && vSpeed <= 8){
         if(dir == 1){
         throwLeft.index = 5;
         }else if(dir == 2){
         throwRight.index = 5;
         }
         hSpeed += 0.2f;
         vSpeed += 0.2f;
         initY = y + height/3;
       }else{
        throwLeft.tick();
        throwRight.tick();
           initY = y + height/3;
       }
     
     if(throwLeft.checkAnim()){ 
      if(dir == 2 && flasks.size() < 1){
       flasks.add(new Projectile (hSpeed, -vSpeed, (int)(x + bounds.x), (int)(y - 30), 20, 8, 32, 88, bottle, 2));
      }else if(dir == 1 && flasks.size() < 1){
       flasks.add(new Projectile (-hSpeed, -vSpeed, (int)(x), (int)(y - 30), 20, 8, 32, 88, bottle, 1));        
      }
       free = true;
       flaskThrow = false;
       vSpeed = 0.2f;
       hSpeed = 0.2f;
     }

     if(stun || silenced){
       adjust(192, 192);
       return;
     } 
   }
   
   @Override
   public void A2(){
     backRoll.tick();
     backRoll2.tick();
     adjust(540, 192);
     dive = true;
     
     if(backRoll.index >= 6){
      if(knockback(275, 10, 0, -(3000/(int)(getOpponent().getMaxHealth())))){
      getOpponent().stunned();
      }
     }
     
     if(backRoll.checkAnim()){
      getOpponent().freedom();
      quickDraw = true;
      dive = false;
      free = true;
      reShape(540, 192, 192, 192);

      if(dir == 2){
       x -= 75;
      }else if(dir == 1){
       x += 75;
      }
     
     }

     if(stun || silenced){
       dive = false;
       reShape(540, 192, 192, 192);
       return;
     } 
   }
   
   @Override
   public void A3(){
    plant.tick();
    plant2.tick();
    
    if(plant.checkAnim()){
     if(dir == 2){
    handler.getWorld().getEntityManager().addEntity(new Mine(handler, x + width/2, y + height/2, 64, 64), playerNum + 2);   
     }else if(dir == 1){
    handler.getWorld().getEntityManager().addEntity(new Mine(handler, x + 5, y + height/2, 64, 64), playerNum + 2);         
     }
    charges --;
    prime = false;
    free = true;
    }
    
    if(stun || silenced){
      prime = false;
      return;
    } 
   }
   
   @Override
   public void render (Graphics g){  
     
     int pshift = 0;
     
     for(int i = 0; i < bullets.size(); i++){
        bullets.get(i).render(g);
      }
     for(int i = 0; i < scatters.size(); i++){
        scatters.get(i).render(g);
        if(Math.abs((scatters.get(i).projX - posX)) >= range){
       scatters.remove(i);
        }
      }
     for(int i = 0; i < shards.size(); i++){
       shards.get(i).render(g);
     }
     
     for(int i = 0; i < flasks.size(); i++){
      flasks.get(i).render(g);
     }
     
     if(flaskLand){
      bottleBreak.tick();
       g.drawImage(bottleBreak.getCurrentFrame(), (int)(initX), (int)(initY), null);
       if(bottleBreak.checkAnim()){
        flaskLand = false;
        flaskBreak = true;
       }        
     }
     
     if(flaskBreak){      
      acidCounter++;
      acidPool.tick();
      ab = new Rectangle((int)(initX) - 220, (int)(initY) + 50, 570, 120);
      
      for (Entity e : handler.getWorld().getEntityManager().getEntities()){
     if(e.equals(this)){
     continue;
     }else if(e instanceof Mine){
     if(e.getHitbox(0, 0).intersects(opp.getHitbox(0, 0))){
      rangedCheck(ab.x, ab.y - 80, ab.width, 200, 50, 0, 0);
      ignite = true;
     }
     }
      }
      
      if(opp.getHitbox(0, 0).intersects(ab)){
       if(acidCounter % 20 == 0){
        opp.slowed(0.40f);    
        opp.affectedBy = 2; 
        opp.slowed = true;   
        opp.hurt(10.0f);  
        opp.timeStack = 1;
       }               
      }else if(opp.slowed && !opp.getHitbox(0, 0).intersects(ab)){
       opp.speed = opp.maxSpeed;
       opp.slowed = false;        
      }
      if(acidCounter >= 400){
         flaskBreak = false;
         ignite = false;
         getOpponent().slowed = false;
         getOpponent().speed = getOpponent().maxSpeed;
         acidCounter = 0;
      }
      if(!ignite){
      g.drawImage(acidPool.getCurrentFrame(), ab.x, ab.y, ab.width, ab.height, null);        
      }else if(ignite){
      acidIgnite.tick();
      g.drawImage(acidIgnite.getCurrentFrame(), ab.x, ab.y - 80, ab.width, 200, null);
      if(acidIgnite.checkAnim()){
     ignite = false;  
        flaskBreak = false;
        getOpponent().slowed = false;
        getOpponent().speed = getOpponent().maxSpeed;
        acidCounter = 0;
      }
      }
     } 
     
     if (playerNum == 2){
      pshift = 608; 
     }
     
     if(abilities[0] == cooldowns[0]){
       g.drawImage(Assets.alAbils[0], 396 + pshift, 782, 32, 32, null);
     }else{
       g.drawImage(Assets.alAbils[5], 396 + pshift, 782, 32, 32, null);
     }
     if(abilities[1] == cooldowns[1]){
       g.drawImage(Assets.alAbils[4], 464 + pshift, 782, 32, 32, null);      
     }else{
       g.drawImage(Assets.alAbils[1], 464 + pshift, 782, 32, 32, null);
     }
     if(charges > 0){
       g.drawImage(Assets.alAbils[2], 530 + pshift, 782, 32, 32, null);
     }else{
       g.drawImage(Assets.alAbils[3], 530 + pshift, 782, 32, 32, null);
     }
     
     if(silenced){
      g.drawImage(Assets.silenced, 396 + pshift, 782, 32, 32, null);
      g.drawImage(Assets.silenced, 464 + pshift, 782, 32, 32, null);
      g.drawImage(Assets.silenced, 530 + pshift, 782, 32, 32, null);
     }else{
      
     }
     
     g.drawString("" +charges, 540 + pshift, 795);
     
//     g.setColor(Color.green);
//     g.fillRect((int) (x + bounds.x * 3/4), (int)(y + bounds.y / 2), bounds.width * 2, bounds.height * 2); 
//     g.setColor (Color.red);
//     g.fillRect ((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height); 
     
    g.drawImage (getCurrentAnimationFrame(),(int) (x),(int) (y) , width, height, null);  
     
   }
   
   private BufferedImage getCurrentAnimationFrame(){
     
     if(stun && dir == 1){
       return stunned.getCurrentFrame();
     }else if(stun && dir == 2){
       return stunned2.getCurrentFrame();      
     }
     
     // attacks
     if (!attackLight.checkAnim() && LA && dir == 1){
       return attackLight.getCurrentFrame();
     }else if (!attackLight.checkAnim() && LA && dir == 2){
       return attackLight2.getCurrentFrame();
     }else if (!attackHeavy.checkAnim() && HA && dir == 1){
       return attackHeavy.getCurrentFrame();
     }else if (!attackHeavy.checkAnim() && HA && dir == 2){
       return attackHeavy2.getCurrentFrame();
     }
     
     else if(!throwLeft.checkAnim() && flaskThrow && dir == 1){
      return throwLeft.getCurrentFrame();
     }else if(!throwLeft.checkAnim() && flaskThrow && dir == 2){
      return throwRight.getCurrentFrame();
     }
     
     else if(!backRoll.checkAnim() && dive && dir == 1){
      return backRoll.getCurrentFrame();
     }else if(!backRoll2.checkAnim() && dive && dir == 2){
      return backRoll2.getCurrentFrame();
     }
     
     else if(!plant.checkAnim() && prime && dir == 1){
      return plant.getCurrentFrame();
     }else if(!plant2.checkAnim() && prime && dir == 2){
      return plant2.getCurrentFrame();
     }
     
     else if(hit && dir == 1){
       return flinch.getCurrentFrame();
     }else if(hit && dir == 2){
      return flinch2.getCurrentFrame(); 
     }
     
     // movement
     else if (handler.getKeyManager().left && playerNum == 1 || handler.getKeyManager().left2 && playerNum == 2){
       dir = 1;
       return left.getCurrentFrame(); 
     }else if (handler.getKeyManager().right && playerNum == 1 || handler.getKeyManager().right2 && playerNum == 2){
       dir = 2;
       return right.getCurrentFrame();
     }else if (handler.getKeyManager().down && playerNum == 1 || handler.getKeyManager().down2 && playerNum == 2){
       return down.getCurrentFrame();
     }else if (handler.getKeyManager().up && playerNum == 1 || handler.getKeyManager().up2 && playerNum == 2){
       return up.getCurrentFrame();
     }else if (dir == 2){
       return neutral2.getCurrentFrame(); 
     }
     else
       return neutral.getCurrentFrame();
   }

}
