package org.example.Game.Entities;

import org.example.Game.Entities.EntityGraphics.PlayerGraphics;
import org.example.TestingLibrary.Graphics.DrawingHandler;
import org.example.Game.Entities.Projectile;
import org.example.Game.GUI.Hearts;
import org.example.Game.GUI.Mana;

import java.awt.*;
import java.util.Map;
import java.util.EnumMap;
import java.util.ArrayList;
import org.example.App;

public class Player{
  private PlayerGraphics playerGraphics;
  private double x;
  private double y;
  private int cooldown = 0;
  private int health = 12;
  private int maxHealth = 12;
  private int mana = 25;
  private int manaCounter = 5;
  private static enum Stats {
    Damage,
    Resistence,
    Speed
  }

  private Map<Stats, Double> baseStats = new EnumMap<>(Stats.class);
  private Map<Stats, Double> statModifiers = new EnumMap<>(Stats.class);

  private void initStats(){
    baseStats.put(Stats.Damage, 3d);
    baseStats.put(Stats.Resistence, 3d);
    baseStats.put(Stats.Speed, 3d);
    
    statModifiers.put(Stats.Damage, 1d);
    statModifiers.put(Stats.Resistence, 1d);
    statModifiers.put(Stats.Speed, 1d);
  }
  
  public Player(){
    this(0, 0);
  }

  public void setHealth(int health){
    this.health = health;
    Hearts.setHealth(health);
  }

  public int getHealth(){
    return health;
  }

  public void addToHandler(DrawingHandler handler){
    handler.addDrawObject(playerGraphics);
  }

  public Player(double x, double y){
    playerGraphics = new PlayerGraphics((int) x, (int) y);
    initStats();
    setX(x);
    setY(y);
    Hearts.setHeartCount((maxHealth+3)%4);
    Hearts.setHealth(health);
  }

  public void setX(double x){
    playerGraphics.setX((int) x);
    this.x = x;
  }

  public double getX(){
    return x;
  }

  public void setY(double y){
    playerGraphics.setY((int) y);
    this.y = y;
  }

  public double getY(){
    return y;
  }


  public void update(){
    if (cooldown>0) cooldown--;
    if (manaCounter <= 0 & mana<25){
      mana++;
      manaCounter=30;
    }
    else if (mana<25){
      manaCounter--;
    }
    Mana.mana = mana;
    if (health <= 0) {App.restart = true;}
  }
  

  public void shootProjectile(DrawingHandler handler, double vx, double vy){
    if (cooldown==0 && mana>5){
      Projectile proj = new Projectile(getX(), getY(), vx, vy);
      App.world.shootProjectile(proj);
      cooldown+=30;
      mana-=5;
    }
    Mana.mana = mana;
  }
  public void draw(Graphics2D g){
    playerGraphics.draw(g);
  }
}