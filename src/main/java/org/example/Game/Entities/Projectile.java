package org.example.Game.Entities;

import org.example.TestingLibrary.Graphics.DrawingHandler;
import org.example.TestingLibrary.Graphics.Shapes.*;


import java.awt.*;

public class Projectile{
  private double x;
  private double y;
  private double vx;
  private double vy;
  
  private GraphicalCircle circle;

  public void draw(Graphics2D g){
    circle.draw(g);
  }
  
  public void addToHandler(DrawingHandler handler){
    handler.addDrawObject(circle);
  }

  public Projectile(double x, double y, double vx, double vy){
    circle = new GraphicalCircle((int) x, (int) y, 5);
    setX(x);
    setY(y);
    setVx(vx);
    setVy(vy);
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

  public void setVx(double vx){
    this.vx = vx;
  }

  public double getVx(){
    return vx;
  }

  public void setVy(double vy){
    this.vy = vy;
  }

  public double getVy(){
    return vy;
  }

  private void applyVelocity(){
    setX(x+vx);
    setY(y+vy);
  }

  public void update(){
    applyVelocity();
  }
}