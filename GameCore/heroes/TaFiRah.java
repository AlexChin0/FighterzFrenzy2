package GameCore.heroes;

import GameCore.*;
import GameCore.States.GameState;
import GameCore.entities.*;
import GameCore.gfx.*;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

public class TaFiRah extends Player{
  
  public Animation neutral, neutral2, left, right, down, up, attackLight, attackLight2, attackHeavy, attackHeavy2, flinch, flinch2, stunned, stunned2, fireballLight1, fireballLight2, fireballHeavy1, fireballHeavy2, spearLeft, spearRight, spearCast, spearCast2, explode, grasp, grasp2, flameCol, ultiCast, ultiCast2, 
  flightNeutral, flightNeutral2, flightAttack, flightAttack2, flightLance, flightLance2, flightCatch, flightCatch2, megafire, megafire2;
  private boolean lance = false, lanceStrike = false, lanceDet = false, burn = false, grapple = false, caught = false, fireCast = false;
  private int posInit= 0, posDelta = 0, posX, posY, opX, opY, deltaX, deltaY, fireCount, spearRange = 350;
  private float burnDmg = 35.0f;
  private ArrayList<Projectile> lFire;
  private ArrayList<Projectile> hFire;
  private ArrayList<Projectile> mFire;
  private ArrayList<Projectile> spears;
  private Entity opp;
  
  public TaFiRah(Handler handler, float x, float y) { 
    super (handler, x , y, Entity.defaultWidth, Entity.defaultHeight); 
    
    bounds.x = 64;
    bounds.y = 96; // hit box variables
    bounds.width = 52;
    bounds.height = 58;
    
    neutral = new Animation (1000, Assets.taN);
    neutral2 = new Animation (1000,Assets.taN2);
    left = new Animation (100, Assets.taML);
    right = new Animation (100, Assets.taMR);
    down = new Animation (100, Assets.taMD); //instances of the animation class
    up = new Animation (100, Assets.taMU);
    
    attackLight = new Animation (100, Assets.taLA);
    attackLight2 = new Animation (100, Assets.taLA2);
    attackHeavy = new Animation (140, Assets.taHA);
    attackHeavy2 = new Animation (140, Assets.taHA2);   
 
    spearCast = new Animation(100, Assets.taSP);
    spearCast2 = new Animation(100, Assets.taSP2);   
    spearLeft = new Animation(100, Assets.taSPP);
    spearRight = new Animation(100, Assets.taSPP2);   
    
    grasp = new Animation(110, Assets.taCC);
    grasp2 = new Animation(110, Assets.taCC2);
    flameCol = new Animation(100, Assets.taFC);
    
    ultiCast = new Animation(100, Assets.taPW);
    ultiCast2 = new Animation(100, Assets.taPW);
    flightNeutral = new Animation(100, Assets.taFN);
    flightNeutral2 = new Animation(100, Assets.taFN2);
    
    flightAttack = new Animation(100, Assets.taFLA);
    flightAttack2 = new Animation(100, Assets.taFLA2);
    
    flightLance = new Animation(100, Assets.taFL);
    flightLance2 = new Animation(100, Assets.taFL2);
    flightCatch = new Animation(100, Assets.taFG);
    flightCatch2 = new Animation(100, Assets.taFG2);
    
    flinch = new Animation (100, Assets.taF);
    flinch2 = new Animation (100, Assets.taF2);
    stunned = new Animation (200, Assets.taS);
    stunned2 = new Animation (200, Assets.taS2);
    
    fireballLight1 = new Animation(100, Assets.taFB);
    fireballLight2 = new Animation(100, Assets.taFB2);
    fireballHeavy1 = new Animation(100, Assets.taFBH);
    fireballHeavy2 = new Animation(100, Assets.taFBH2);
    megafire = new Animation(100, Assets.taMFB);
    megafire2 = new Animation(100, Assets.taMFB2);
       
    explode = new Animation(100, Assets.taSB);
    
    lFire = new ArrayList<Projectile>();       
    hFire = new ArrayList<Projectile>();       
    mFire = new ArrayList<Projectile>();     
    spears = new ArrayList<Projectile>();
    
    width = 192;
    height = 192;
    
    health = 420; //hero values
    maxHealth = 420;
    healthMod = health / 300;
    speed = 4.5f;
    maxSpeed = 4.5f;
    
    cooldowns[0] = 6; //6
    cooldowns[1] = 11; //11
    cooldowns[2] = 30; //30
    cooldowns[3] = 1; //1
    cooldowns[4] = 2; //2
  }

  @Override //method responsible for incoming damage calculations
  public void hurt(float amt){
    health -= amt;
    hit = true;
    System.out.println("Entity " + playerNum + " Ta-Fi-Rah." + health + " hp.");
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
    alive = false;//death method. Removes the entity from the game upon death. 
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

    opp = getOpponent();

    opX = (int)(opp.getX());
    opY = (int)(opp.getY());
    
    deltaX = Math.abs((int)(x) - opX);
    deltaY = Math.abs((int)(y) - opY);
    
    if(deltaX < 300 && deltaY < 300){
      fireCount += 1;
      opp.slowed(0.85f);
      for (Entity e : handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this)){
          continue;
        }
        if(!e.equals(this) && fireCount >= 80){
          e.hurt(1);
          fireCount = 0;
          break;
        }
      } 
    }else{
    opp.speed = opp.maxSpeed;
    opp.slowed = false; 
    }
    
    projCheck(lFire, 35, 0, 0);
    projCheck(hFire, 65, 0, 0);
    projCheck(mFire, 80, 0, 0);
    
     effectCheck(timeStack, affectedBy); 
  
    //Animation
    neutral.tick();
    neutral2.tick();
    spearLeft.tick();
    spearRight.tick();
    left.tick();
    right.tick();
    up.tick();
    down.tick();
    flinch.tick();
    flinch2.tick();
    stunned.tick();
    stunned2.tick();
    flightNeutral.tick();
    flightNeutral2.tick();
    fireballLight1.tick();
    fireballLight2.tick();
    fireballHeavy1.tick();
    fireballHeavy2.tick();
    
    //movement and abilities
    if (free && !stun){
      getInput();
      move();    
      
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
      if (handler.getKeyManager().a1 && checkCooldowns(0) && playerNum == 1 || handler.getKeyManager().a4 && checkCooldowns(0) && playerNum == 2){
        lance = true;
        free = false;
        abilities[0] = 0;
      }
      if (handler.getKeyManager().a2 && checkCooldowns(1) && playerNum == 1 || handler.getKeyManager().a5 && checkCooldowns(1) && playerNum == 2){
        free = false;
        grapple = true;
        abilities[1] = 0;
      }
      if (handler.getKeyManager().a3 && checkCooldowns(2) && playerNum == 1 || handler.getKeyManager().a6 && checkCooldowns(2) && playerNum == 2){
        fireCast = true;
        rangedCheck((int)(x - 40), (int)(y + 30), 250, 110, 65, 0, 0);
        y-=96;
        free = false;
        abilities[2] = 0;
      }
    }else if (!free){
      
    }
    
    if (LA){
      LightAttack(); 
    }
    if (HA){
      HeavyAttack();
    }
    if(lance){
      A1();
    }
      
    if(lanceDet){
     explode.tick();   
     posDelta = 0;
     if(explode.index >= 2){
      Rectangle pb = new Rectangle ();
      pb.x = (int)(posX - 100 * 0.25);
      pb.y = (int)(posY - 100 * 0.40);
      pb.width = 150;
      pb.height = 150;
      
      for (Entity e : handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this))
          continue;
        if(e.getHitbox(0, 0).intersects(pb)){
          burnDmg = 0;
          burn = true;
          return;
        }
      }
    }  
     if(explode.checkAnim()){
       lanceDet = false; 
       spears.clear();
     }
    }
    
    if(burn && burnDmg <= 25){
      for (Entity e : handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this)){
          continue;
        }else if(!e.equals(this)){
          e.hurt(0.5f);
          burnDmg += 0.5f;
          return;
        }
      }
    }else{
     burn = false; 
    }

    if (grapple){
     A2(); 
    }
    
    if(caught){     
      for (Entity e : handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this) || e instanceof StaticEntity){
          continue;
        }else if(e instanceof Player){
          if(e.timeStack <= 0){
            caught = false;
            break;
          }else if(e.timeStack > 0){
            e.hurt(0.2f); 
          }
        }
      }   
      for(int i = 0; i < spears.size(); i++){
        Rectangle pb = new Rectangle ();
        
        pb.x = spears.get(i).projX + spears.get(i).inX;
        pb.y = spears.get(i).projY + spears.get(i).inY;
        pb.width = spears.get(i).projWidth;
        pb.height = spears.get(i).projHeight;
        
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
          if (e.equals(this)){
            continue;
          }else if(e instanceof Player){
          if(e.getHitbox(0, 0).intersects(pb)){
            if(dir == 1){
            e.setX(e.getX()-100);
            }else if(dir == 2){
             e.setX(e.getX()+100); 
            }
            return;
          }
        }
        }   
      }
    }
    
    if(fireCast){
     A3(); 
    } 

    if(hit && flinch.checkAnim()){
      hit = false; 
    }
    
    if(lanceStrike){
      
    for(int i = 0; i < spears.size(); i++){
      Rectangle pb = new Rectangle ();
      spears.get(i).tick();
       
      pb.x = spears.get(0).projX + spears.get(0).inX;
      pb.y = spears.get(0).projY + spears.get(0).inY;
      pb.width = spears.get(0).projWidth;
      pb.height = spears.get(0).projHeight;
      
      for (Entity e : handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this))
          continue;
        if(e.getHitbox(0, 0).intersects(pb)){
          e.hurt(95);
          lanceDet = true;
          lanceStrike = false;
          posX = spears.get(0).projX + spears.get(0).inX;
          posY = spears.get(0).projY + spears.get(0).inY;
          spears.get(0).speedX = 0;
          break;
        }
      }    
    }
    if(!flying){
      posDelta = Math.abs(posInit - spears.get(0).projX);    
    }
      if(posDelta >= spearRange && spearRange > 0){
       lanceDet = true;
       lanceStrike = false;
       posX = spears.get(0).projX + spears.get(0).inX;
       posY = spears.get(0).projY + spears.get(0).inY;
       spears.get(0).speedX = 0;
      }
    }
        
  }
  
  @Override
  public void LightAttack(){
   if(!flying){
    attackLight.tick();  
    attackLight2.tick();  
    free = false;

    if (attackLight.checkAnim()){
     LA = false;
     free = true;
     if(dir == 2){
      lFire.add(new Projectile (16, 0, (int)(x + bounds.x), (int)(y - 20), 25, 18, 128, 72, fireballLight2, 2));
     }else if(dir == 1){
      lFire.add(new Projectile (-16, 0, (int)(x), (int)(y - 20), 25, 18, 128, 72, fireballLight1, 1));        
     }
    }    
   }else if(flying){
    flightAttack.tick();  
    flightAttack2.tick();  
    free = false;

    if (flightAttack.checkAnim()){
     LA = false;
     free = true;
     if(dir == 2){
      mFire.add(new Projectile (18, 0, (int)(x + bounds.x), (int)(y - 20), 40, 40, 128, 72, megafire, 2));
     }else if(dir == 1){
      mFire.add(new Projectile (-18, 0, (int)(x), (int)(y - 20), 40, 40, 128, 72, megafire2, 1));        
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
 if(!flying){
    attackHeavy.tick();  
    attackHeavy2.tick();
    free = false;
      
    if (attackHeavy.checkAnim()){
      HA = false;
      free = true;
      if(dir == 2){
        hFire.add(new Projectile (8, 0, (int)(x + bounds.x), (int)(y -30), 50, 70, 128, 72, fireballHeavy2, 2));
      }else if(dir == 1){
        hFire.add(new Projectile (-8, 0, (int)(x), (int)(y - 30), 50, 70, 128, 72, fireballHeavy1, 1));        
      }
    
    }
 }else if(flying){
     flightAttack.tick();  
     flightAttack2.tick();
     free = false;
       
     if (flightAttack.checkAnim()){
       HA = false;
       free = true;
       if(dir == 2){
         mFire.add(new Projectile (18, 0, (int)(x + bounds.x), (int)(y -30), 50, 70, 128, 72, megafire, 2));
       }else if(dir == 1){
         mFire.add(new Projectile (-18, 0, (int)(x), (int)(y - 30), 50, 70, 128, 72, megafire2, 1));        
       }
     
     }
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
 if(!flying){
    spearCast.tick();
    spearCast2.tick(); 
    free = false;
    
    if (spearCast.checkAnim()){
      if(dir == 2){
        spears.add(new Projectile (20, 0, (int)(x + bounds.x), (int)(y -30), 25, 40, 128, 72, spearLeft, 2));
        posInit = (int)(x + bounds.x);
      }else if(dir == 1){
        spears.add(new Projectile (-20, 0, (int)(x), (int)(y - 30), 25, 40, 128, 72, spearRight, 1));        
        posInit = (int)(x);
      } 
      lanceStrike = true;
      lance = false;
      free = true;
    }
 }else if(flying){
  adjust(330, 240);
     flightLance.tick();
     flightLance2.tick(); 
     free = false;
     
     if (flightLance.checkAnim()){
       if(dir == 2){
         spears.add(new Projectile (24, 0, (int)(x + bounds.x), (int)(y + 10), 25, 40, 128, 72, spearLeft, 2));
       }else if(dir == 1){
         spears.add(new Projectile (-24, 0, (int)(x), (int)(y + 10), 25, 40, 128, 72, spearRight, 1));        
       }          
         if(proc(50)){
           for(int f = 0; f <= abilities.length - 1; f++){
             if(abilities[f] > 0 && abilities[f] < cooldowns[f]){
             abilities[f] += 2;
             }
             if(abilities[f] >= cooldowns[f]){
               abilities[f] = cooldowns[f];
             }
           }
           heal(50);
         }
       reShape(330, 240, 192, 192);
       lanceStrike = true;
       lance = false;
       free = true;
     } 
 }
     
    if(stun || silenced){
     spearCast.index = 0;
     spearCast2.index = 0;
     adjust(192, 192);
      lance = false;
      free = false;
      lanceDet = false;
     return;
    }
  }
    
  @Override
  public void A2(){
   if(!flying){
    grasp.tick();
    grasp2.tick();
    adjust(300, 192);

    if(grasp.checkAnim()){
     if(hitLock(120, 80, 10, 5)){
      caught = true;
     }
     reShape(300, 192, 192, 192);
     grapple = false;
     free = true;
    }
   }else if(flying){
    flightCatch.tick();
    flightCatch2.tick();
    adjust(330, 240);

    if(flightCatch.checkAnim()){
     if(hitLock(130, 90, 50, 5)){
      caught = true;
     }         
     if(proc(50)){
      for(int f = 0; f <= abilities.length - 1; f++){
       if(abilities[f] > 0 && abilities[f] < cooldowns[f]){
        abilities[f] += 2;
       }
       if(abilities[f] >= cooldowns[f]){
        abilities[f] = cooldowns[f];
       }
      }
      heal(50);
     }
     reShape(330, 240, 192, 192);
     grapple = false;
     free = true;
    }  
   }
   
    if(stun || silenced){
      grasp.index = 0;
      grasp2.index = 0;
      grapple = false;
      caught = false;
      if(!flying){
      reShape(300, 192, 192, 192);
      }else{
      reShape(330, 240, 192, 192);      
      }
      return;
    }
  }
  
  @Override
  public void A3(){
    ultiCast.tick();
    ultiCast2.tick();
    adjust(192, 384);
    if(ultiCast.checkAnim()){
     fireCast = false;
     flying = true;
     free = true;
     reShape(192, 300, 192, 192);
    }
    
    if(stun || silenced){
      ultiCast.index = 0;
      ultiCast2.index = 0;
      flying = true;
      fireCast = false;
      reShape(192, 192, 192, 384);
      return;
    }
  }
  
  //renders the hero and their abilities
  @Override
  public void render (Graphics g){
//    g.setColor(Color.green);
//    g.fillRect((int) (x + bounds.x * 3/4), (int)(y + bounds.y / 2), bounds.width * 2, bounds.height * 2); 
//    g.setColor (Color.red);
//    g.fillRect ((int) (x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height); 
    //g.fillRect((int)(x - 40), (int)(y + 30), 250, 110);
    int pshift = 0;
    
    if (playerNum == 2){
      pshift = 608; 
    }
    
    if(abilities[0] == cooldowns[0]){
      g.drawImage(Assets.taAbils[0], 396 + pshift, 782, 32, 32, null);
    }else{
      g.drawImage(Assets.taAbils[1], 396 + pshift, 782, 32, 32, null);
    }
    if(abilities[1] == cooldowns[1]){
      g.drawImage(Assets.taAbils[4], 464 + pshift, 782, 32, 32, null);      
    }else{
      g.drawImage(Assets.taAbils[5], 464 + pshift, 782, 32, 32, null);
    }
    if(abilities[2] == cooldowns[2]){
      g.drawImage(Assets.taAbils[2], 530 + pshift, 782, 32, 32, null);
    }else{
      g.drawImage(Assets.taAbils[3], 530 + pshift, 782, 32, 32, null);
    } 
    
    if(silenced){
     g.drawImage(Assets.silenced, 396 + pshift, 782, 32, 32, null);
     g.drawImage(Assets.silenced, 464 + pshift, 782, 32, 32, null);
     g.drawImage(Assets.silenced, 530 + pshift, 782, 32, 32, null);
    }else{
     
    }
    
    for(int i = 0; i < lFire.size(); i++){
      lFire.get(i).render(g);
    }
    for(int i = 0; i < hFire.size(); i++){
      hFire.get(i).render(g);
    }            
    for(int i = 0; i < spears.size(); i++){
      spears.get(i).render(g);
    }    
    for(int i = 0; i < mFire.size(); i++){
     mFire.get(i).render(g);
    }    
        
    if(lanceDet){
      g.drawImage(explode.getCurrentFrame(), (int) (spears.get(0).projX - 105), (int) (spears.get(0).projY - 105), 420, 420,  null); 
    } 
    
    if(caught){
      flameCol.tick();
      for (Entity e : handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this)){
          continue;
        }else if(e instanceof Player){
          g.drawImage(flameCol.getCurrentFrame(),(int) (e.getX() - 192),(int) (e.getY() - 192), null); 
          break;
        }
      }
    }
    
    if(flying){
     spearRange = 0;
      if(abilities[2] >= 15){
     spearRange = 350;
        flying = false;
      }
    }
    
    if(stun && dir == 1){
      g.drawImage (stunned.getCurrentFrame(),(int) (x),(int) (y) , width, height, null); 
    }else if(stun && dir == 2){      
      g.drawImage (stunned2.getCurrentFrame(),(int) (x),(int) (y) , width, height, null); 
    }else{
      g.drawImage (getCurrentAnimationFrame(),(int) (x),(int) (y) , width, height, null); 
    }
    
    Rectangle hb = getHitbox(0, 0);
    Rectangle ar = new Rectangle ();
    int arWidth = 0, arHeight = 0;

    ar.width = arWidth;
    ar.height = arHeight;
    
    if (dir == 1){
      ar.x = hb.x - arWidth; // left
      ar.y = hb.y + hb.height / 2 - arHeight / 2;
    }else if (dir == 2){
      ar.x = hb.x + hb.width; // right
      ar.y = hb.y + hb.height / 2 - arHeight / 2;
    }
//      g.fillRect(ar.x, ar.y, ar.width, ar.height);   
  }
  
  private BufferedImage getCurrentAnimationFrame(){ //decides which animation to tick to the screen
    
    if(stun && dir == 1){
      return stunned.getCurrentFrame();
    }else if(stun && dir == 2){
      return stunned2.getCurrentFrame();      
    }
    
    // attacks
    if (!attackLight.checkAnim() && LA && dir == 1 && !flying){
      return attackLight.getCurrentFrame();
    }else if (!attackLight.checkAnim() && LA && dir == 2 && !flying){
      return attackLight2.getCurrentFrame();
    }else if (!attackHeavy.checkAnim() && HA && dir == 1 && !flying){
      return attackHeavy.getCurrentFrame();
    }else if (!attackHeavy.checkAnim() && HA && dir == 2 && !flying){
      return attackHeavy2.getCurrentFrame();
    }
    
    if (!flightAttack2.checkAnim() && LA && dir == 1 && flying){
        return flightAttack2.getCurrentFrame();
      }else if (!flightAttack2.checkAnim() && LA && dir == 2 && flying){
        return flightAttack.getCurrentFrame();
      }else if (!flightAttack2.checkAnim() && HA && dir == 1 && flying){
        return flightAttack2.getCurrentFrame();
      }else if (!flightAttack2.checkAnim() && HA && dir == 2 && flying){
        return flightAttack.getCurrentFrame();
      }
    
    //abilities
    else if(lance && dir == 1 && !flying){
      return spearCast.getCurrentFrame();
    }else if(lance && dir == 2 && !flying){
      return spearCast2.getCurrentFrame();
    }
    
    else if(lance && dir == 1 && flying){
     return flightLance.getCurrentFrame();
    }else if(lance && dir == 2 && flying){
     return flightLance2.getCurrentFrame();
    }
    
    else if(grapple && dir == 1 && !flying){
      return grasp.getCurrentFrame();
    }else if(grapple && dir == 2 && !flying){
      return grasp2.getCurrentFrame();
    }
    
    else if(grapple && dir == 1 && flying){
     return flightCatch.getCurrentFrame();
    }else if(grapple && dir == 2 && flying){
     return flightCatch2.getCurrentFrame();
    }
    
    else if(fireCast && dir == 1){
      return ultiCast.getCurrentFrame();
    }else if(fireCast && dir == 2){
      return ultiCast2.getCurrentFrame();
    }
    
    // movement    
    else if(hit && dir == 1){
      return flinch.getCurrentFrame();
    }else if(hit && dir == 2){
      return flinch2.getCurrentFrame(); 
    }
    
    else if (handler.getKeyManager().left && playerNum == 1 || handler.getKeyManager().left2 && playerNum == 2){
        dir = 1;
        if(!flying){
        return left.getCurrentFrame(); 
        }else{
        return flightNeutral2.getCurrentFrame();  
        }
      }else if (handler.getKeyManager().right && playerNum == 1|| handler.getKeyManager().right2 && playerNum == 2){
        dir = 2;
        if(!flying){
        return right.getCurrentFrame(); 
        }else{
        return flightNeutral.getCurrentFrame();  
        }
      }else if (handler.getKeyManager().down && playerNum == 1 && !flying || handler.getKeyManager().down2 && playerNum == 2 && !flying){
        return down.getCurrentFrame();
      }else if (handler.getKeyManager().up && playerNum == 1 && !flying || handler.getKeyManager().up2 && playerNum == 2 && !flying){
        return up.getCurrentFrame();
      }
      else
       if(dir == 1 && flying){
        return flightNeutral2.getCurrentFrame(); 
       }else if(dir == 2 && flying){
        return flightNeutral.getCurrentFrame();  
       }else if (dir == 2 && !flying){
             return neutral2.getCurrentFrame(); 
          }else
        return neutral.getCurrentFrame();
    }
  }
  