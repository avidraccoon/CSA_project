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
  private int maxMana = 25;
  private double manaSpeed = 45;
  private int manaCounter = 5;
  private int cooldownTime = 30;
  private double projectileSpeed = 2.5;
  private int damage = 1;
  private double damageModifier = 1;
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
    Hearts.setHeartCount((maxHealth+3)/4);
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
    if (manaCounter <= 0 & mana<maxMana){
      mana++;
      manaCounter=(int)manaSpeed;
    }
    else if (mana<maxMana){
      manaCounter--;
    }
    Mana.mana = mana;
    if (health <= 0) {App.restart = true;}
  }
  

  public void shootProjectile(DrawingHandler handler, double xModifier, double yModifier){
    if (cooldown==0 && mana>5){
      Projectile proj = new Projectile(getX(), getY(), projectileSpeed*xModifier, projectileSpeed*yModifier);
      App.world.shootProjectile(proj);
      cooldown=cooldownTime;
      mana-=5;
    }
    Mana.mana = mana;
  }
  public void draw(Graphics2D g){
    playerGraphics.draw(g);
  }
  public void modify(String type, double amount){
    if (type.equals("damage")){
      damageModifier*=amount;
    }
    if (type.equals("health")){
      maxHealth+=2;
      Hearts.setHeartCount((maxHealth+3)/4);
    }
    if (type.equals("heal")){
      health+=2;
      if (health > maxHealth) {health = maxHealth;} 
      Hearts.setHealth(health);
    }
    if (type.equals("mana")){
      maxMana+=amount;
      manaSpeed/=1.125;
      Mana.maxMana = maxMana;
      if (manaSpeed<1) manaSpeed = 1;
    }
    if (type.equals("velocity")){
      cooldownTime/=amount;
      if (cooldownTime<1) cooldownTime = 1;
      projectileSpeed*=amount;
    }
  }
  public int getDamage(){
    return (int)(damage*damageModifier);
  }
}