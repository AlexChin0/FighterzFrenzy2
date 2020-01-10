//this class uses a key manager to handle all keyboard inputs and assigns them to the proper key binds.

package GameCore.managers; 
import java.awt.event.*;
  
public class KeyManager implements KeyListener{
  
private boolean [] keys;
public boolean up, down, left, right, up2, down2, left2, right2;
public boolean attackLight, attackHeavy, attackLight2, attackHeavy2; //key control variables
public boolean a1, a2, a3, a4, a5, a6;
public boolean reset;

public KeyManager (){
 keys = new boolean [256]; //creates a boolean for every key 
}

public void tick (){
  //key bindings may be changed to the user preferance
  up = keys[KeyEvent.VK_W]; 
  down = keys[KeyEvent.VK_S]; 
  left = keys[KeyEvent.VK_A]; //player 1 move keys
  right = keys[KeyEvent.VK_D];  
  
  up2 = keys[KeyEvent.VK_UP];
  down2 = keys[KeyEvent.VK_DOWN]; //player 2 move keys
  left2 = keys[KeyEvent.VK_LEFT]; 
  right2 = keys[KeyEvent.VK_RIGHT];
  
  attackLight = keys[KeyEvent.VK_F];  
  attackHeavy = keys[KeyEvent.VK_C]; //player 1 attack keys
  
  attackLight2 = keys[KeyEvent.VK_L];  
  attackHeavy2 = keys[KeyEvent.VK_SEMICOLON]; //player 2 attack keys
  
  a1 = keys[KeyEvent.VK_Q];
  a2 = keys[KeyEvent.VK_E];//player 1 ability keys
  a3 = keys[KeyEvent.VK_R];
  
  a4 = keys[KeyEvent.VK_I];
  a5 = keys[KeyEvent.VK_O];//player 2 ability keys
  a6 = keys[KeyEvent.VK_P];
  
  reset = keys[KeyEvent.VK_Y];
}

@Override
public void keyPressed (KeyEvent e){
 keys [e.getKeyCode()] = true; 
}

@Override
public void keyReleased (KeyEvent e){
  keys [e.getKeyCode()] = false;
}

@Override
public void keyTyped (KeyEvent e) {
  
}

}
