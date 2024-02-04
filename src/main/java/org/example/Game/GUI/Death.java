package org.example.Game.GUI;
import org.example.TestingLibrary.Graphics.*;
import org.example.TestingLibrary.Graphics.Shapes.*;
import java.awt.*;
public class Death extends AbstractDrawnGraphic{
  public static boolean characterDead;
  private static GraphicalImage image = new GraphicalImage(0, 20, "src/main/textures/DeathScreen.png");
  public static Death instance = new Death();

  
  public void draw(Graphics2D g){ 
    if (characterDead){
      image.draw(g);
      
    }
  }
}