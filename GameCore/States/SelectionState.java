//This is an extension of the State class. It is displayed when a match starts and allows both players to choose the character of their choice. 

package GameCore.States;
import GameCore.Handler;
import GameCore.gfx.Assets;
import GameCore.gfx.Animation;

import java.awt.Graphics;
import java.awt.Rectangle;

public class SelectionState extends State {
  
  public static int [] heroes = new int [2];
  
  public Animation sephiraN, graysonN, sephiraN2, graysonN2, luxaarN, luxaarN2, altaN, altaN2, ironfN, ironfN2, tafirahN, tafirahN2, laudaN, laudaN2, allistairN, allistairN2;
  private Rectangle h1, h2, h3, h4, switchNext, switchPrev;
  private int pChoice = 1, pg = 1;
  
 public SelectionState(Handler handler) {
  super(handler);
  
  sephiraN = new Animation (1000, Assets.sephN);
  graysonN = new Animation (1000, Assets.grayN);
  luxaarN = new Animation(1000, Assets.luxN);
  altaN = new Animation(1000, Assets.altN);
  ironfN = new Animation(1000, Assets.ironN);
  sephiraN2 = new Animation (1000, Assets.sephN2);
  graysonN2 = new Animation (1000, Assets.grayN2);
  luxaarN2 = new Animation(1000, Assets.luxN2);
  altaN2 = new Animation(1000, Assets.altN2);
  ironfN2 = new Animation(1000, Assets.ironN2);
  tafirahN = new Animation (1000, Assets.taN);
  tafirahN2 = new Animation (1000, Assets.taN2);
  laudaN = new Animation (1000, Assets.laN);
  laudaN2 = new Animation (1000, Assets.laN2);
  allistairN = new Animation (1000, Assets.alN);
  allistairN2 = new Animation (1000, Assets.alN2);
  
  //heroes
  h1 = new Rectangle(235, 115, 192, 192); //clickable objects
  h2 = new Rectangle(755, 100, 192, 192);
  h3 = new Rectangle(235, 445, 192, 192);
  h4 = new Rectangle(755, 445, 192, 192); 
  //buttons
  switchNext = new Rectangle(1065, 50, 120, 70);
  switchPrev = new Rectangle(45, 50, 120, 70);
 }

 @Override
 public void tick() {
   sephiraN.tick();
   graysonN.tick();
   sephiraN2.tick();
   graysonN2.tick();
   luxaarN.tick();
   luxaarN2.tick();//ticks the idle images
   altaN.tick();
   altaN2.tick();
   ironfN.tick();
   ironfN2.tick();
   tafirahN.tick();
   tafirahN2.tick();
   laudaN.tick();
   laudaN2.tick();
   allistairN.tick();
   allistairN2.tick();
   
   //switches the pages when clicked
   if(handler.getMouseManager().isLeftPressed() && switchNext.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
     if(pg == 1){
     selectSound.playSound();
     handler.getMouseManager().leftPressed = false;  
     }
     pg = 2;
   }
   if(handler.getMouseManager().isLeftPressed() && switchPrev.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
     if(pg == 2){    		
     selectSound.playSound();
     handler.getMouseManager().leftPressed = false;  
     }
     pg = 1;
   }
   
   //tracks the mouse and which character has been chosen
   if(pChoice == 1){
     if(handler.getMouseManager().isLeftPressed() && h1.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
         selectSound2.playSound();
       if(pg == 1){
       pChoice = 2;
       heroes[0] = 1;
       }else if(pg == 2){
         heroes[0] = 5;
         pChoice = 2;
         pg = 1;
       }
     }
     if(handler.getMouseManager().isLeftPressed() && h2.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
         selectSound2.playSound();
       if(pg == 1){
       pChoice = 2;
       heroes[0] = 2;
       }else if(pg == 2){
         heroes[0] = 6;
         pChoice = 2;
         pg = 1;
       }
     }
     if(handler.getMouseManager().isLeftPressed() && h3.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
         selectSound2.playSound();
    if(pg == 1){
       pChoice = 2;
       heroes[0] = 3;
    }
    else if(pg == 2){
    	pChoice = 2;
    	heroes[0] = 7;
    	pg = 1;
    }
     }
     if(handler.getMouseManager().isLeftPressed() && h4.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
    	 if(pg == 1){
         selectSound2.playSound();
       pChoice = 2;
       heroes[0] = 4;
    	 }else if(pg == 2){
             selectSound2.playSound();
             pChoice = 2;
             heroes[0] = 8; 
    	 }
   }
     handler.getMouseManager().leftPressed = false;  
   }else if (pChoice == 2){
   if(handler.getMouseManager().isLeftPressed() && h1.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
	     selectSound2.playSound();
     if(pg == 1){
     State.setState(handler.getGame().stageState);
          handler.getMouseManager().leftPressed = false;  
     pChoice = 1;
       heroes[1] = 1;
     }else if(pg == 2){
         State.setState(handler.getGame().stageState);
              handler.getMouseManager().leftPressed = false;  
         heroes[1] = 5;
         pChoice = 1;
         pg = 1;
       }
   }
   if(handler.getMouseManager().isLeftPressed() && h2.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
	     selectSound2.playSound();
     State.setState(handler.getGame().stageState);
     if(pg == 1){
       pChoice = 1;
       heroes[1] = 2;
            handler.getMouseManager().leftPressed = false;  
     }
     else if(pg == 2){
       State.setState(handler.getGame().stageState);
            handler.getMouseManager().leftPressed = false;  
       heroes[1] = 6;
       pChoice = 1;
       pg = 1;
     }
   }    
   if(handler.getMouseManager().isLeftPressed() && h3.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
	     selectSound2.playSound();
	   if(pg == 1){
     State.setState(handler.getGame().stageState);
          handler.getMouseManager().leftPressed = false;  
     pChoice = 1;
       heroes[1] = 3;
	   }
	   else if(pg == 2){
		   State.setState(handler.getGame().stageState);
		   handler.getMouseManager().leftPressed = false;  
		   pChoice = 1;
		   heroes[1] = 7;  
	   }
   }   
   if(handler.getMouseManager().isLeftPressed() && h4.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
	     selectSound2.playSound();
	     if(pg == 1){
	     State.setState(handler.getGame().stageState);
	     handler.getMouseManager().leftPressed = false;  
	     pChoice = 1;
	     heroes[1] = 4;
	     }else if(pg == 2){
	    	 State.setState(handler.getGame().stageState);
	    	 handler.getMouseManager().leftPressed = false;  
	    	 pChoice = 1;
	    	 heroes[1] = 8;
	     }
   }
   }
 }

 @Override
 public void render(Graphics g) {
   if (pChoice == 1){
     if(pg == 1){
       g.drawImage(Assets.pickscreen, 0, 0, null);
       g.drawImage(sephiraN2.getCurrentFrame(), 235, 100, null); //draws things to the screen
       g.drawImage(graysonN2.getCurrentFrame(), 755, 85, null);
       g.drawImage(luxaarN2.getCurrentFrame(), 235, 445, null);
       g.drawImage(altaN2.getCurrentFrame(), 755, 445, null);
     }else if(pg == 2){
       g.drawImage(Assets.pickscreen01, 0, 0, null);
       g.drawImage(ironfN2.getCurrentFrame(), 215, 75, null);
       g.drawImage(tafirahN2.getCurrentFrame(), 770, 85, null);
       g.drawImage(laudaN2.getCurrentFrame(), 235, 445, null);
       g.drawImage(allistairN2.getCurrentFrame(), 785, 450, null);
     }

   }else if(pChoice == 2){
     if(pg == 1){
     g.drawImage(Assets.pickscreen2, 0, 0, null);
     g.drawImage(sephiraN.getCurrentFrame(), 235, 100, null);
     g.drawImage(graysonN.getCurrentFrame(), 755, 85, null);
     g.drawImage(luxaarN.getCurrentFrame(), 235, 445, null);
     g.drawImage(altaN.getCurrentFrame(), 755, 445, null);
     }else if(pg == 2){
       g.drawImage(Assets.pickscreen02, 0, 0, null);
       g.drawImage(ironfN.getCurrentFrame(), 215, 75, null);
       g.drawImage(tafirahN.getCurrentFrame(), 770, 85, null);
       g.drawImage(laudaN.getCurrentFrame(), 235, 445, null);
       g.drawImage(allistairN.getCurrentFrame(), 785, 450, null);
     }
   }
   
   
   //displays the character card informations when the mouse hovers over the players
   if(pg == 1){
   if(h1.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
     g.drawImage (Assets.charCards[0], (h4.x + h4.width)/2, (h4.x + h4.width)/2 - 400, null);
   }
   if(h2.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
     g.drawImage (Assets.charCards[1], (h4.x + h4.width)/2, (h4.x + h4.width)/2 - 400, null);
   }
   if(h3.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
     g.drawImage (Assets.charCards[2], (h4.x + h4.width)/2, (h4.x + h4.width)/2, null);
   }
   if(h4.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
     g.drawImage (Assets.charCards[3], (h4.x + h4.width)/2, (h4.x + h4.width)/2, null);
   }
   }
   if(pg == 2){
     if(h1.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
       g.drawImage (Assets.charCards[4], (h4.x + h4.width)/2, (h4.x + h4.width)/2 - 400, null);
     }
     if(h2.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
       g.drawImage (Assets.charCards[5], (h4.x + h4.width)/2, (h4.x + h4.width)/2 - 400, null);
     }
     if(h3.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
         g.drawImage (Assets.charCards[6], (h4.x + h4.width)/2, (h4.x + h4.width)/2, null);
     }
     if(h4.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
         g.drawImage (Assets.charCards[7], (h4.x + h4.width)/2, (h4.x + h4.width)/2, null);
     }
   }
 }

}