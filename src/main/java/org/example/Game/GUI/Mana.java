package org.example.Game.GUI;

import org.example.TestingLibrary.Graphics.*;
import org.example.TestingLibrary.Graphics.Shapes.*;
import java.awt.*;
import java.lang.Math;

public class Mana extends AbstractDrawnGraphic{
  public static int mana = 25;
  public static int maxMana = 25;
  public static GraphicalRectangle rectangle1 = new GraphicalRectangle(335, 46, 55, 10);
  public static GraphicalRectangle rectangle2 = new GraphicalRectangle(335, 46, 55, 10);
  public static Mana instance = new Mana();

  private void init(){
    rectangle1.setFilled(true);
    rectangle2.setFilled(true);
    rectangle2.setColor(Color.BLUE);
  }
  private Mana(){
    init();
  }
  public void draw(Graphics2D g){
    int xModifier = 55*mana/25;
    int mxModifier = 55*maxMana/25;
    rectangle2.setWidth(xModifier);
    rectangle2.setX(400-5-xModifier);
    rectangle1.setWidth(mxModifier);
    rectangle1.setX(400-5-mxModifier);
    rectangle1.draw(g);
    rectangle2.draw(g);
  }
}