package org.example.Game.Entities;

import org.example.TestingLibrary.Graphics.DrawingHandler;
import org.example.TestingLibrary.Graphics.Shapes.*;


import java.awt.*;

public class Enemy{
  private double x;
  private double y;

  private GraphicalCircle circle;

  public void draw(Graphics2D g){
    circle.draw(g);
  }

  public void addToHandler(DrawingHandler handler){
    handler.addDrawObject(circle);
  }

  public Enemy(double x, double y){
    circle = new GraphicalCircle((int) x, (int) y, 15);
    circle.setColor(Color.GREEN);
    setX(x);
    setY(y);
  }

  public void setX(double x){
    circle.setX((int) x);
    this.x = x;
  }

  public double getX(){
    return x;
  }

  public void setY(double y){
    circle.setY((int) y);
    this.y = y;
  }

  public double getY(){
    return y;
  }

  public void update(){
    
  }
}