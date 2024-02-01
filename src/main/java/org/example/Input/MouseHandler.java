package org.example.Input;
import java.awt.event.MouseEvent;

public class MouseHandler{
  public void mousePressed(MouseEvent e){
    System.out.println("Mouse pressed");
  }
  public void mouseReleased(MouseEvent e){
    System.out.println("Mouse released");
  }
  public void mouseEntered(MouseEvent e){
    System.out.println("Mouse entered");
  }
  public void mouseExited(MouseEvent e){
    System.out.println("Mouse exited");
  }
  public void mouseClicked(MouseEvent e){
    System.out.println("Mouse clicked");
  }
  
}