package org.example.Game.Entities.EntityGraphics;

import org.example.TestingLibrary.Graphics.AbstractDrawnGraphic;
import org.example.TestingLibrary.Graphics.Shapes.*;

import java.awt.*;


public class PlayerGraphics extends AbstractDrawnGraphic{
  
  private GraphicalImage image;

  
  public void draw(Graphics2D g){
      image.draw(g);
  }

  public PlayerGraphics(){
    this(0, 0);
  }
  
  public PlayerGraphics(int x, int y){
    image = new GraphicalImage(x, y, "src/main/textures/slimer.png");
    setX(x);
    setY(y);
  }


  public void setX(int x){
    super.setX(x);
      image.setX(x);
  }

  public int getX(){
    return getX();
  }

  public void setY(int y){
    super.setY(y);
      image.setY(y);
  }

  public int getY(){
    return getY();
  }

  
}