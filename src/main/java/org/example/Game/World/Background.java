package org.example.Game.World;


import org.example.TestingLibrary.Graphics.*;
import org.example.TestingLibrary.Graphics.Shapes.*;
import java.awt.*;

public class Background extends AbstractDrawnGraphic{
  private static int x = 0;
  private static int y = 21;
  private static GraphicalImage image = new GraphicalImage(x, y, "src/main/textures/backround.png");
  private static final Background INSTANCE = new Background();

  private Background(){}

  public static Background getInstance(){return INSTANCE;}
  
  public void draw(Graphics2D g){
    image.draw(g);
  }

  
}