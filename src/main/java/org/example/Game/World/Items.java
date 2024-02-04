package org.example.Game.World;


import org.example.TestingLibrary.Graphics.*;
import org.example.TestingLibrary.Graphics.Shapes.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;

public class Items extends AbstractDrawnGraphic{
  private GraphicalImage image;
  private String type = "ruby";
  private int x = 0;
  private int y = 0;

  public Items(String type, int x, int y){
    this.type = type;
    this.x = x;
    this.y = y;
    createImage();
  }

  public void draw(Graphics2D g){
    image.draw(g);
  }


  public void createImage(){
    if (type.equals("gun")){
       image = new GraphicalImage(x, y, "src/main/textures/Gun.png");
    }
    if (type.equals("ruby")){
      image = new GraphicalImage(x, y, "src/main/textures/RubyRing (1).png");
    }
    if (type.equals("emerald")){
      image = new GraphicalImage(x, y, "src/main/textures/EmeraldRing.png");
    }
    if (type.equals("diamond")){
      image = new GraphicalImage(x, y, "src/main/textures/DiamondRing.png");
    }
  }

}