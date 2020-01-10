//Sephira is another playable character in the game. This class keeps track of the characters hp, abilities, attacks, and graphics. 
// It is also an extension of the Player class.

package GameCore.heroes;

import GameCore.*;
import GameCore.States.GameState;
import GameCore.entities.Entity;
import GameCore.gfx.*;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

public class Sephira extends Player{

  private boolean blink = false, blinkEnd = false, daggerThrow = false, daggerHit = false, songStart = false, song = false, songStrike = false, dsStrike = false;
  private int blinkRange = 250;
  private Rectangle pb = new Rectangle ();
  
  public Animation neutral, neutral2, left, right, down, up, attackLight, attackLight2, attackLightCoS, attackLightCoS2, attackHeavy, attackHeavy2, attackHeavyCoS, attackHeavyCoS2, blinkInit, blinkInit2, blinkFinal, blinkFinal2, blinkStrike, blinkStrike2, 
    decept, decept2, tdProj, tdProj2, dagdrop, dagdrop2, songCast, songCast2, rohar, rohar2, flinch, flinch2, stunned, stunned2;
  
  private Projectile kunai;
  
  private ArrayList<Projectile> daggers;
  
  private AudioPlayer dash, toss, land;
  
  public Sephira(Handler handler, float x, float y) { 
    super (handler, x , y, Player.defaultWidth, Player.defaultHeight); 
    
    bounds.x = 64;
    bounds.y = 88;
    bounds.width = 48;
    bounds.height = 56;
    
    neutral = new Animation (1000, Assets.sephN); 
    neutral2 = new Animation (1000,Assets.sephN2);
    left = new Animation (100, Assets.sephML);
    right = new Animation (100, Assets.sephMR);
    down = new Animation (100, Assets.sephMD);
    up = new Animation (100, Assets.sephMU);
    
    attackLight = new Animation (60, Assets.sephLA);
    attackLight2 = new Animation (60, Assets.sephLA2);
    attackHeavy = new Animation (60, Assets.sephHA);
    attackHeavy2 = new Animation (60, Assets.sephHA2);     
    
    blinkInit = new Animation (75, Assets.sephBI);
    blinkInit2 = new Animation (75, Assets.sephBI2);
    blinkFinal = new Animation (75, Assets.sephBF);
    blinkFinal2 = new Animation (75, Assets.sephBF2);
    blinkStrike = new Animation(70, Assets.sephBS);
    blinkStrike2 = new Animation(70, Assets.sephBS2);
    
    decept = new Animation (120, Assets.sephDT);
    decept2 = new Animation (120, Assets.sephDT2);
    tdProj = new Animation (100, Assets.sephDag);
    tdProj2 = new Animation (100, Assets.sephDag2);
    dagdrop = new Animation (100, Assets.sephDA2);
    dagdrop2 = new Animation (100, Assets.sephDA);
    
    songCast = new Animation (80, Assets.sephSong);
    songCast2 = new Animation (80, Assets.sephSong2);
    
    rohar = new Animation (70, Assets.sephUlt);
    rohar2 = new Animation (70, Assets.sephUlt2);
    
    flinch = new Animation (100, Assets.sephF);
    flinch2 = new Animation (100, Assets.sephF2);
    stunned = new Animation (200, Assets.sephS);
    stunned2 = new Animation (200, Assets.sephS2);
    
    dash = new AudioPlayer("/se/sephira/blink.wav");
    toss = new AudioPlayer("/se/sephira/throw.wav");
    land = new AudioPlayer("/se/sephira/cut.wav");
    daggers = new ArrayList<Projectile>();
    
    kunai = new Projectile (20, 0, (int)(x), (int)(y), 40, 20, 96, 64, tdProj, 1);
    
    width = 192;
    height = 192;
    
    health = 360;
    maxHealth = 360;
    healthMod = health / 300;
    speed = 4.8f;
    maxSpeed = 4.8f;
    
    cooldowns[0] = 5; //5
    cooldowns[1] = 8; //8
    cooldowns[2] = 23; //23
    cooldowns[3] = 1; //1
    cooldowns[4] = 1; //1
  }
  
  @Override
  public void hurt(float amt){
    health -= amt;
    hit = true;
    System.out.println("Player " + playerNum + " Sephira." + health + " hp.");
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
  public void tick () {
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
    tdProj.tick();
    tdProj2.tick();
    effectCheck(timeStack, affectedBy); 
    
    for(int i = 0; i < daggers.size(); i++){
      daggers.get(i).tick();
      
      pb.x = daggers.get(i).projX + kunai.inX;
      pb.y = daggers.get(i).projY + kunai.inY;
      pb.width = daggers.get(i).projWidth;
      pb.height = daggers.get(i).projHeight;
    }
    
    if (free && !stun){
    //Moving
      getInput();
      move();
      if (handler.getKeyManager().attackLight && !song && playerNum == 1 && checkArmed(3) && !dsStrike || handler.getKeyManager().attackLight2 && !song && checkArmed(3) && playerNum == 2 && !dsStrike){
        LA = true;
        free = false;
        abilities[3] = 0;
      }
      if (handler.getKeyManager().attackHeavy && !song && playerNum == 1 && checkArmed(4) || handler.getKeyManager().attackHeavy2 && !song && checkArmed(4) && playerNum == 2){
        HA = true;
        free = false;
        abilities[4] = 0;
      }
      if (handler.getKeyManager().a1 && checkCooldowns(0) && playerNum == 1 || handler.getKeyManager().a4 && checkCooldowns(0) && playerNum == 2){
        blink = true;
        free = false;
        abilities[0] = 0;
      }
      if (handler.getKeyManager().a2 && checkCooldowns(1) && playerNum == 1 || handler.getKeyManager().a5 && checkCooldowns(1) && playerNum == 2){
       daggerThrow = true;
       free = false;
       toss.playSound();
       if (dir == 1){
         daggers.add(new Projectile (-16, 0, (int)(x), (int)(y + bounds.y * 0.25), 30, 15, 96, 64, tdProj, 1));
       }else if(dir == 2){
         daggers.add(new Projectile (16, 0, (int)(x + bounds.x), (int)(y + bounds.y * 0.25), 40, 20, 96, 64, tdProj2, 2));   
       }
       abilities[1] = 0;
      }
      if (handler.getKeyManager().a3 && checkCooldowns(2) && playerNum == 1 || handler.getKeyManager().a6 && checkCooldowns(2) && playerNum == 2){
       songStart = true;
       free = false;
       abilities[2] = 0;
      }
      if(song && abilities[2] == 5){
      song = false;
      System.out.println ("Song expired");
      }else if (handler.getKeyManager().attackLight && song && playerNum == 1|| handler.getKeyManager().attackHeavy && song && playerNum == 1 || handler.getKeyManager().attackLight2 && song && playerNum == 2|| handler.getKeyManager().attackHeavy2 && song && playerNum == 2){
       songStrike = true;
       free = false;
       abilities[3] = 0;
       abilities[4] = 0;
      }
    }else if (!free){
       
    }
    
    if (LA){
      LightAttack(); 
    }
    if (HA){
      HeavyAttack();
    }
    if (blink){    
     A1(); 
    }else if (blinkEnd){
     if(dsStrike){
     blinkStrike.tick();
     blinkStrike2.tick();
     }else if(!dsStrike){
      blinkFinal.tick();
      blinkFinal2.tick();
     }
        if(dsStrike){
         if(blinkStrike.checkAnim()){
          hitCheck(90, 70, 50); 
                blinkRange = 250;
                free = true;
                blinkEnd = false;
                dsStrike = false;
                reShape(300, 210, 192, 192);
         }
        }else{ 
         if(blinkFinal.checkAnim()){
         blinkRange = 250;
         free = true;
         blinkEnd = false;
         dsStrike = false;
         reShape(300, 210, 192, 192);
         }
        }
    }   
    if (daggerThrow){
      A2(); 
    }else if(daggerHit){
      dagdrop.tick();
      dagdrop2.tick();
      adjust(270, 345);
      if(dagdrop.checkAnim()){
     y+= height * 0.30;
     if(dir == 1){
     x -= 40;
     }else if(dir == 2){
     x += 40; 
     }
        pb.x = 0;
        pb.y = 0;
        daggerHit = false;
        free = true;
        reShape(270, 345, 192, 192);       
      }
    }
    if (songStart){
     A3(); 
    }
    if (songStrike){
      rohar.tick();
      rohar2.tick();
      adjust(480, 300);
      if(rohar.checkAnim()){
        songStrike = false;
        song = false;
        free = true;
        if(dir == 2)
        {
         hitCheck(360, 285, 175);  
        }else{
         rangedCheck((int)(x), (int)(y), 360, 285, 175, 0, 0);
        }
        reShape(480, 300, 192, 192);
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
    adjust(210, 210);    
    free = false;
    
    if (attackLight.checkAnim()){
      LA = false;
      free = true;
      reShape(210, 210, 192, 192);
      if(hitCheck(40, 50, 35)){
        if(proc(30)){
          getOpponent().timeStack+=3;
          getOpponent().affectedBy = 3;
          getOpponent().silenced();
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
    attackHeavy.tick();
    attackHeavy2.tick();
    adjust (210, 210);  
    free = false;
    
    if (attackHeavy.checkAnim()){
     HA = false;
     free = true;
     reShape(210, 210, 192, 192);
      if(hitCheck(60, 60, 75)){
        if(proc(50)){
          getOpponent().timeStack+=3;
          getOpponent().affectedBy = 3;
          getOpponent().silenced();
        }
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
    free = false;
    casting = true;
    blinkInit.tick();
    blinkInit2.tick();
    if(handler.getKeyManager().attackLight && !song && playerNum == 1 || handler.getKeyManager().attackLight2 && !song && playerNum == 2){
     dsStrike = true;
    }
    dash.playSound();
    adjust(300, 210);
    
    if (blinkInit.checkAnim()){
      if (dir == 1){
        x -= blinkRange;
      }else if (dir == 2){
        x+= blinkRange;
      }
      blink = false;
      blinkEnd = true;
    }
    if(stun || silenced){
      blink = false;
      blinkEnd = false;
      dsStrike = false;
      blinkInit.index = 0;
      blinkInit2.index = 0;
      adjust(192, 192);
      return;
    } 
  }
  
  @Override
  public void A2(){
    free = false;
    casting = true;
    decept.tick();
    decept2.tick();
    adjust(270, 270);
      
    if(dir == 1){

      for (Entity e : handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this))
          continue;
        if(e.getHitbox(0, 0).intersects(pb)){
         x = e.getX() - e.getWidth() * 0.5f;
         y = e.getY() - e.getHeight() * 0.75f; 
         land.playSound();
         e.timeStack += 4;
         e.affectedBy = 3;
         e.hurt(65);
         e.silenced();
         decept.index = 0;
         daggerHit = true;
         daggerThrow = false;
         daggers.clear();
            if(dir == 1)
            {
             dir = 2;
            }else if(dir == 2){
             dir = 1;
            }
        }
      }
    }else if(dir == 2){
      
      for (Entity e : handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this))
          continue;
        if(e.getHitbox(0, 0).intersects(pb)){
            x = e.getX() + e.getWidth() * 0.25f;
            y = e.getY() - e.getHeight() * 0.75f; 
            land.playSound();
            e.timeStack += 4;
            e.affectedBy = 3;
            e.hurt(65);
            e.silenced();
            decept.index = 0;
            daggerHit = true;
            daggerThrow = false;
            daggers.clear();
            if(dir == 1)
            {
             dir = 2;
            }else if(dir == 2){
             dir = 1;
            }
        }
      }
    }
    
    if (decept.checkAnim()){
      daggerThrow = false;
      free = true;
      reShape(270, 270, 192, 192);
      daggers.clear();
    }
    
    if(stun || silenced){
      daggerThrow = false;
      daggerHit = false;
      decept.index = 0;
      decept2.index = 0;
      return;
    } 
  }
  
  @Override
  public void A3(){
   free = false;
   songCast.tick();
   songCast2.tick();
   adjust(210, 225);
   
   if(songCast.checkAnim()){
    songStart = false;
    song = true;
    free = true;
    reShape(210, 225, 192, 192);
   }
   
   if(stun || silenced){
     songStart = false;
     song = false;
     songCast.index = 0;
     songCast2.index = 0;
     adjust(192, 192);
     return;
   } 
  }
  
  @Override
  public void render (Graphics g){  
    
    int pshift = 0;
    
    if (playerNum == 2){
     pshift = 608; 
    }
    
    if(abilities[0] == cooldowns[0]){
      g.drawImage(Assets.sephAbils[0], 396 + pshift, 782, 32, 32, null);
    }else{
      g.drawImage(Assets.sephAbils[1], 396 + pshift, 782, 32, 32, null);
    }
    if(abilities[1] == cooldowns[1]){
      g.drawImage(Assets.sephAbils[2], 464 + pshift, 782, 32, 32, null);      
    }else{
      g.drawImage(Assets.sephAbils[3], 464 + pshift, 782, 32, 32, null);
    }
    if(abilities[2] == cooldowns[2]){
      g.drawImage(Assets.sephAbils[4], 530 + pshift, 782, 32, 32, null);
    }else{
      g.drawImage(Assets.sephAbils[5], 530 + pshift, 782, 32, 32, null);
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
    
    for(int i = 0; i < daggers.size(); i++){
      daggers.get(i).render(g);
    }
    
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
    
    //abilities
    
    // blink
    else if(!blinkInit.checkAnim() && blink && dir == 1){
      return blinkInit.getCurrentFrame();
    }else if(!blinkInit2.checkAnim() && blink && dir == 2){
      return blinkInit2.getCurrentFrame();
    }else if (blinkEnd  && !dsStrike && dir == 1){
     return blinkFinal.getCurrentFrame();
    }else if (blinkEnd && !dsStrike && dir == 2){
     return blinkFinal2.getCurrentFrame(); 
    }else if (blinkEnd &&  dsStrike && dir == 1){
     return blinkStrike.getCurrentFrame(); 
    }else if (blinkEnd && dsStrike && dir == 2){
     return blinkStrike2.getCurrentFrame();      
    }
    
    //twisting deception
    else if(!decept.checkAnim() && daggerThrow && dir == 1){
      return decept.getCurrentFrame();
    }else if (!decept.checkAnim() && daggerThrow && dir == 2){
      return decept2.getCurrentFrame();
    }else if (!dagdrop.checkAnim() && daggerHit && dir == 1){
      return dagdrop.getCurrentFrame();
    }else if (!dagdrop.checkAnim() && daggerHit && dir == 2){
      return dagdrop2.getCurrentFrame();
    }
    
    //song of roharen
    else if (!songCast.checkAnim() && songStart && dir == 1){
      return songCast.getCurrentFrame();
    }else if(!songCast.checkAnim() && songStart && dir == 2){
     return songCast2.getCurrentFrame(); 
    }
    
    else if (!rohar.checkAnim() && songStrike && dir == 1){
      return rohar.getCurrentFrame();
    }else if (!rohar.checkAnim() && songStrike && dir == 2){
      return rohar2.getCurrentFrame();
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
