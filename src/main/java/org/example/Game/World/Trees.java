package org.example.Game.World;


import org.example.TestingLibrary.Graphics.*;
import org.example.TestingLibrary.Graphics.Shapes.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;

public class Trees extends AbstractDrawnGraphic{
  private ArrayList<GraphicalImage> images = new ArrayList<GraphicalImage>();
  private int rndm = (int) (Math.random()*8) + 1 ;

  
  public Trees(){
    randomizeTrees();
  }
  
  public void draw(Graphics2D g){
    for (GraphicalImage image : images){
      image.draw(g);
    }
  }


  public void randomizeTrees(){
    images.clear();
    for (int i = 0; i < rndm; i++){
      int x = ((int) (Math.random()*32))*10;
      int y = ((int) (Math.random()*32))*10 + 20;
      GraphicalImage image = new GraphicalImage(x, y, "src/main/textures/WoodlandTree.png");
      images.add(image);
    }
  }
  

}