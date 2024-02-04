package org.example.Game.World;


import org.example.TestingLibrary.Graphics.*;
import org.example.TestingLibrary.Graphics.Shapes.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;

public class Items extends AbstractDrawnGraphic{
  private GraphicalImage image;
  private String type = "gun";
  private int x = 0;
  private int y = 0;
  public boolean shouldDelete = false;

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
    if (type.equals("heart")){
      image = new GraphicalImage(x, y, "src/main/textures/MiniHeart.png");
    }
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public String getModifiedStat(){
    if (type.equals("gun")){
      return "damage";
    }
    if (type.equals("ruby")){
      return "health";
    }
    if (type.equals("emerald")){
        return "velocity";
    }
    if (type.equals("diamond")){
      return "mana";
    }
    if (type.equals("heart")){
      return "heal";
    }
    return "none";
  }

  public double getAmount(){
    if (type.equals("gun")){
      return 1.2;
    }
    if (type.equals("ruby")){
      return 2;
    }
    if (type.equals("emerald")){
      return 1.125;
    }
    if (type.equals("diamond")){
      return 5;
    }
    if (type.equals("heart")){
      return 2;
    }
    return 0;
  }
}