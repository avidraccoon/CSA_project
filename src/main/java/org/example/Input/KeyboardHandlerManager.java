package org.example.Input;

import java.awt.event.KeyEvent;

import java.util.ArrayList;

public class KeyboardHandlerManager extends KeyboardHandler{
  private ArrayList<KeyboardHandler> keyboardHandlers = new ArrayList<KeyboardHandler>();

  public void addKeyboardHandler(KeyboardHandler keyboardHandler){
    keyboardHandlers.add(keyboardHandler);
  }

  public void removeKeyboardHandler(KeyboardHandler keyboardHandler){
    keyboardHandlers.remove(keyboardHandler);
  }

  public KeyboardHandler removeKeyboardHandler(int index){
    return keyboardHandlers.remove(index);
  }

  public ArrayList<KeyboardHandler> getKeyboardHandlers(){
    return keyboardHandlers;
  }

  public KeyboardHandler getKeyboardHandler(int index){
    return keyboardHandlers.get(index);
  }

  public void setKeyboardHandlers(ArrayList<KeyboardHandler> keyboardHandlers){
    this.keyboardHandlers = keyboardHandlers;
  }

  public void setKeyboardHandler(int index, KeyboardHandler keyboardHandler){
    this.keyboardHandlers.set(index, keyboardHandler);
  }

  public void keyPressed(KeyEvent e){
    super.keyPressed(e);
    for (KeyboardHandler keyboardHandler : keyboardHandlers) {
      keyboardHandler.keyPressed(e);
    }
  }

  public void keyReleased(KeyEvent e){
    super.keyReleased(e);
    for (KeyboardHandler keyboardHandler : keyboardHandlers) {
      keyboardHandler.keyReleased(e);
    }
  }

  public void keyTyped(KeyEvent e){
    super.keyTyped(e);
    for (KeyboardHandler keyboardHandler : keyboardHandlers) {
      keyboardHandler.keyTyped(e);
    }
  }
}