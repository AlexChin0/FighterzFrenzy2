//This class uses a mouse manager that handles mouse clicks and movement in a similar way to the key manager.

package GameCore.managers;

import java.awt.event.*;

public class MouseManager implements MouseListener, MouseMotionListener {

 public boolean leftPressed, rightPressed;
 private int mouseX, mouseY;
 
 public MouseManager(){

 }
  
  public boolean isLeftPressed(){
   return leftPressed; 
  }
  
  public boolean isRightPressed(){
   return rightPressed; 
  }
  
 public int getMouseX(){
  return mouseX;
 }
 
 public int getMouseY(){
  return mouseY;
 } 
  
  @Override
  public void mousePressed(MouseEvent e) {
    if(e.getButton() == MouseEvent.BUTTON1) //left and right click buttons
      leftPressed = true;
    else if(e.getButton() == MouseEvent.BUTTON3)
      rightPressed = true;
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {
    if(e.getButton() == MouseEvent.BUTTON1)
      leftPressed = false;
    else if(e.getButton() == MouseEvent.BUTTON3)
      rightPressed = false;
  }

 @Override //keeps track of the mouse position on the screen
 public void mouseMoved(MouseEvent e) {
  mouseX = e.getX();
  mouseY = e.getY(); 
 }
 
 @Override
 public void mouseDragged(MouseEvent e) {
  
 }

 @Override
 public void mouseClicked(MouseEvent e) {
  
 }

 @Override
 public void mouseEntered(MouseEvent e) {
  
 }

 @Override
 public void mouseExited(MouseEvent e) {
  
 }
 
}