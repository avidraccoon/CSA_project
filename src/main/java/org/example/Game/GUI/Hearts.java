package org.example.Game.GUI;


import org.example.TestingLibrary.Graphics.*;
import org.example.TestingLibrary.Graphics.Shapes.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;

public class Hearts extends AbstractDrawnGraphic{
  private static ArrayList<GraphicalImage> blankHearts = new ArrayList<GraphicalImage>();
  private static ArrayList<GraphicalImage> quarterHearts = new ArrayList<GraphicalImage>();
  private static ArrayList<GraphicalImage> halfHearts = new ArrayList<GraphicalImage>();
  private static ArrayList<GraphicalImage> threeQuartersHearts = new ArrayList<GraphicalImage>();
  private static ArrayList<GraphicalImage> fullHearts = new ArrayList<GraphicalImage>();
  private static int healthAmount = 3;
  private static int heartCount = 0;
  private static int x = 375;
  private static int y = 25;
  private static int distance = 20;
  private static final Hearts INSTANCE = new Hearts();


  private Hearts(){
    setHeartCount(2);
  }

  public void draw(Graphics2D g){
    int index = 0;
    int healthAmountStore = healthAmount;
    while (index<heartCount){
      if (healthAmountStore >= 4){
        fullHearts.get(index).draw(g);
          healthAmountStore-=4;
      }else if (healthAmountStore == 3){
        threeQuartersHearts.get(index).draw(g);
          healthAmountStore-=3;
      }else if (healthAmountStore == 2){
        halfHearts.get(index).draw(g);
          healthAmountStore-=2;
      }else if (healthAmountStore == 1){
        quarterHearts.get(index).draw(g);
          healthAmountStore-=1;
      }else{
        blankHearts.get(index).draw(g);
      }
      index++;
    }
  }

  public static void setHeartCount(int count){
    while (count>heartCount){
      blankHearts.add(new GraphicalImage(x-distance*heartCount, y, "src/main/textures/Heart-5.png"));
      quarterHearts.add(new GraphicalImage(x-distance*heartCount, y, "src/main/textures/Heart-4.png"));
      halfHearts.add(new GraphicalImage(x-distance*heartCount, y, "src/main/textures/Heart-3.png"));
      threeQuartersHearts.add(new GraphicalImage(x-distance*heartCount, y, "src/main/textures/Heart-2.png"));
      fullHearts.add(new GraphicalImage(x-distance*heartCount, y, "src/main/textures/Heart-1.png"));
      heartCount++;
    }
    while (count<heartCount){
      blankHearts.remove(heartCount-1);
      quarterHearts.remove(heartCount-1);
      halfHearts.remove(heartCount-1);
      threeQuartersHearts.remove(heartCount-1);
      fullHearts.remove(heartCount-1);
      heartCount--;
    } 
  }

  public static int getHeartCount(){
    return heartCount;
  }

  public static void setHealth(int health){
    healthAmount = health;
  }

  public static int getHealth(){
    return healthAmount;
  }

  public static Hearts getInstance(){return INSTANCE;}


}