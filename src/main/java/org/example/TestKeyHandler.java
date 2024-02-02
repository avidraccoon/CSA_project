package org.example;

import java.awt.event.KeyEvent;
import org.example.TestingLibrary.Input.KeyboardHandler;

public class TestKeyHandler extends KeyboardHandler{
  public void keyPressed(KeyEvent e){//super.keyPressed(e);
    if ((""+e.getKeyChar()).equals("w")) App.w=true;
    if ((""+e.getKeyChar()).equals("a")) App.a=true;
    if ((""+e.getKeyChar()).equals("s")) App.s=true;
    if ((""+e.getKeyChar()).equals("d")) App.d=true;
  }
  public void keyReleased(KeyEvent e){
    if ((""+e.getKeyChar()).equals("w")) App.w=false;
    if ((""+e.getKeyChar()).equals("a")) App.a=false;
    if ((""+e.getKeyChar()).equals("s")) App.s=false;
    if ((""+e.getKeyChar()).equals("d")) App.d=false;
  }
  public void keyTyped(KeyEvent e){
    if ((""+e.getKeyChar()).equals("f")) App.fTyped = true;
    //super.keyTyped(e);
    /*
    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == KeyEvent.VK_DELETE){
      App.text = App.text.substring(0,App.text.length()-1);
    }
    else{
      App.text += e.getKeyChar();
    }
    */
    //System.out.println(App.x+"  "+ App.y);
  }
}