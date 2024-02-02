package org.example.Game.Entities;

import org.example.Game.Entities.EntityGraphics.PlayerGraphics;
import org.example.TestingLibrary.Graphics.DrawingHandler;
import org.example.Game.Entities.Projectile;

import java.util.Map;
import java.util.EnumMap;
import java.util.ArrayList;


public class Player{
  private PlayerGraphics playerGraphics;
  private double x;
  private double y;
  private int cooldown = 0;
  
  private ArrayList<Projectile> shootProjectiles = new ArrayList<Projectile>();
  private static enum Stats {
    Health,
    Damage,
    Resistence,
    Speed
  }

  private Map<Stats, Double> baseStats = new EnumMap<>(Stats.class);
  private Map<Stats, Double> statModifiers = new EnumMap<>(Stats.class);

  private void initStats(){
    baseStats.put(Stats.Health, 3d);
    baseStats.put(Stats.Damage, 3d);
    baseStats.put(Stats.Resistence, 3d);
    baseStats.put(Stats.Speed, 3d);
    
    statModifiers.put(Stats.Health, 1d);
    statModifiers.put(Stats.Damage, 1d);
    statModifiers.put(Stats.Resistence, 1d);
    statModifiers.put(Stats.Speed, 1d);
  }
  
  public Player(){
    this(0, 0);
  }

  public void addToHandler(DrawingHandler handler){
    handler.addDrawObject(playerGraphics);
  }

  public Player(double x, double y){
    playerGraphics = new PlayerGraphics((int) x, (int) y);
    initStats();
    setX(x);
    setY(y);
    System.out.println(getHealth());
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

  public double getHealth(){
    return     baseStats.get(Stats.Health)*statModifiers.get(Stats.Health);
  }

  public double getBaseHealth(){
    return baseStats.get(Stats.Health);
  }

  public double getHealthMulti(){
    return statModifiers.get(Stats.Health);
  }

  public void update(){
    updateProjectiles();
    if (cooldown>0) cooldown--;
  }
  
  private void updateProjectiles(){
   for (Projectile p: shootProjectiles){
     p.update();
   }
  }

  public void shootProjectile(DrawingHandler handler, double vx, double vy){
    if (cooldown==0){
      Projectile proj = new Projectile(getX(), getY(), vx, vy);
      proj.addToHandler(handler);
      shootProjectiles.add(proj);
      cooldown+=10;
    }
  }
}