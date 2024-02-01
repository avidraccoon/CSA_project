package org.example.Input;

import java.awt.event.MouseEvent;

import java.util.ArrayList;

public class MouseHandlerManager extends MouseHandler{
  private ArrayList<MouseHandler> mouseHandlers = new ArrayList<MouseHandler>();

  public void addMouseHandler(MouseHandler mouseHandler){
    mouseHandlers.add(mouseHandler);
  }

  public void removeMouseHandler(MouseHandler mouseHandler){
    mouseHandlers.remove(mouseHandler);
  }

  public MouseHandler removeMouseHandler(int index){
    return mouseHandlers.remove(index);
  }

  public ArrayList<MouseHandler> getMouseHandlers(){
    return mouseHandlers;
  }

  public MouseHandler getMouseHandler(int index){
    return mouseHandlers.get(index);
  }

  public void setMouseHandlers(ArrayList<MouseHandler> mouseHandlers){
    this.mouseHandlers = mouseHandlers;
  }

  public void setMouseHandler(int index, MouseHandler mouseHandler){
    this.mouseHandlers.set(index, mouseHandler);
  }

  public void mousePressed(MouseEvent e){
    super.mousePressed(e);
    for (MouseHandler mouseHandler : mouseHandlers) {
      mouseHandler.mousePressed(e);
    }
  }

  public void mouseReleased(MouseEvent e){
    super.mouseReleased(e);
    for (MouseHandler mouseHandler : mouseHandlers) {
      mouseHandler.mouseReleased(e);
    }
  }

  public void mouseEntered(MouseEvent e){
    super.mouseEntered(e);
    for (MouseHandler mouseHandler : mouseHandlers) {
      mouseHandler.mouseEntered(e);
    }
  }

  public void mouseExited(MouseEvent e){
    super.mouseExited(e);
    for (MouseHandler mouseHandler : mouseHandlers) {
      mouseHandler.mouseExited(e);
    }
  }

  public void mouseClicked(MouseEvent e){
    super.mouseClicked(e);
    for (MouseHandler mouseHandler : mouseHandlers){
      mouseHandler.mouseClicked(e);
    }
  }
}