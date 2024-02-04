package org.example.Game.Entities;

import org.example.TestingLibrary.Graphics.DrawingHandler;
import org.example.TestingLibrary.Graphics.Shapes.*;
import org.example.App;

import java.awt.*;

public class Boss{
  private double x;
  private double y;
  public boolean shouldDelete = false;
  private GraphicalImage image;
  private String type = "KingSlime";
  private int damageCooldown = 10;
  public int health = 50;

  public void createImage(){
    if (type.equals("KingSlime")){
       image = new GraphicalImage((int) x, (int) y, "src/main/textures/KingSlime.png");
    }
    if (type.equals("KingSlime1")){
      health = 30;
      damageCooldown = 5;
      image = new GraphicalImage((int) x, (int) y, "src/main/textures/KingSlime1.png");
    }
    if (type.equals("KingSlime2")){
      health = 80;
      damageCooldown = 20;
      image = new GraphicalImage((int) x, (int) y, "src/main/textures/KingSlime2.png");
    }
  }
  public void draw(Graphics2D g){
    image.draw(g);
  }

  public Boss(String type, double x, double y){
    this.type = type;
    this.x = x;
    this.y = y;
    createImage();
  }

  public void setX(double x){
    image.setX((int) x);
    this.x = x;
  }

  public double getX(){
    return x;
  }

  public void setY(double y){
    image.setY((int) y);
    this.y = y;
  }

  public double getY(){
    return y;
  }

  public void update(double targetX, double targetY){
    if (x<0){shouldDelete = true;}
    if (x>400){shouldDelete = true;}
    if (y<0){shouldDelete = true;}
    if (y>400){shouldDelete = true;}
    double xDist = Math.abs(targetX-x);
    double yDist = Math.abs(targetY-y);
    double totalDist = xDist + yDist;
    double xFrac = xDist/totalDist;
    double yFrac = yDist/totalDist;
    setX(x+xFrac*.5*(targetX<x?-1:1));
    setY(y+yFrac*.5*(targetY<y?-1:1));
    if (damageCooldown>0){
      damageCooldown--;
    }else{
      if (Math.sqrt(Math.pow(xDist, 2)+Math.pow(yDist, 2))<20){
        App.world.damagePlayer(1);
        damageCooldown = 30;
      }
    }
    if (health<=0) shouldDelete = true;
  }
}