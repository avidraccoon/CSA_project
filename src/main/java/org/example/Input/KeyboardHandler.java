package org.example.Input;
import java.awt.event.KeyEvent;
public class KeyboardHandler{
  public void keyPressed(KeyEvent e){
    System.out.println("Key pressed: " + e.getKeyCode());
  }
  public void keyReleased(KeyEvent e){
    System.out.println("Key released: " + e.getKeyCode());
  }
  public void keyTyped(KeyEvent e){
    System.out.println("Key typed: " + e.getKeyChar());
  }
}