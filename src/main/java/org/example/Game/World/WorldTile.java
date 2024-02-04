package org.example.Game.World;

import org.example.Game.World.Trees;
import org.example.Game.World.World;
import org.example.Game.Entities.Player;
import org.example.Game.Entities.Enemy;
import org.example.Game.Entities.Projectile;
import org.example.Game.World.Items;
import org.example.App;
import java.awt.*;

import java.util.ArrayList;
import java.lang.Math;
class WorldTile{
  private Trees trees = new Trees();
  private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
  private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private ArrayList<Items> items = new ArrayList<Items>();
  private ArrayList<String> ItemsAll = new ArrayList<String>();
  private int disableTimer = 60;
  private int enemyTimer = 600;
  public WorldTile(){
    ItemsAll.add("ruby");
    ItemsAll.add("emerald");
    ItemsAll.add("diamond");
    ItemsAll.add("heart");
    ItemsAll.add("gun");
  }
  public void setEnemyTimer(int time){
    enemyTimer = time;
  }
  public void spawnEnemies(int count, double playerX, double playerY){
    String type;
    int x;
    int y;
    for (int i = 0; i<count; i++){
      type = Math.random()>0.5?"enemy1":"enemy2";
      x = (int)(Math.random()*400);
      y = (int)(Math.random()*400);
      while (calculateDistance(x, y, playerX, playerY) < 50){
        x = (int)(Math.random()*400);
        y = (int)(Math.random()*400);
      }
      enemies.add(new Enemy(type, x, y));
    }
  }
  
  public double calculateDistance(double x1, double y1, double x2, double y2){
    double xDist = Math.abs(x1-x2);
    double yDist = Math.abs(y1-y2);
    return Math.sqrt(Math.pow(xDist, 2)+Math.pow(yDist, 2));
  }
  
  public void draw(Graphics2D g, Player player){
    player.draw(g);
    for (Enemy enemy : enemies){
      enemy.draw(g);
    }
    for (Projectile proj : projectiles){
      proj.draw(g);
    }
    for (Items item : items){
      item.draw(g);
    }
    trees.draw(g);
  }

  public void addProjectile(Projectile proj){
    projectiles.add(proj);
  }

  public void update(double playerX, double playerY){
    World world = App.world;
    if (disableTimer == 0){
      for (Projectile proj : projectiles){
        proj.update();
      }
      for (Enemy enemy : enemies){
          enemy.update(playerX, playerY);
      }
      for (Projectile proj : projectiles){
        for (Enemy enemy : enemies){
          double xDist = Math.abs(enemy.getX()-proj.getX()+8);
          double yDist = Math.abs(enemy.getY()-proj.getY()+8);
          if (Math.sqrt(Math.pow(xDist, 2)+Math.pow(yDist, 2))<20){
            proj.shouldDelete = true;
            enemy.health-=world.getPlayer().getDamage();
          }
        }
      }
      for (Items item : items){
        if (calculateDistance(playerX, playerY, item.getX(), item.getY())<20){
          item.shouldDelete = true;
          String type = item.getModifiedStat();
          double amount = item.getAmount();
          world.getPlayer().modify(type, amount);
        } 
      }
      for (int i = 0; i<enemies.size(); i++){
        if (enemies.get(i).shouldDelete){
          int random = (int)(Math.random()*ItemsAll.size());
            items.add(new Items(ItemsAll.get(random), (int) enemies.get(i).getX(), (int) enemies.get(i).getY()));
            enemies.remove(i);
            i--;
        }
      }
      for (int i = 0; i<projectiles.size(); i++){
        if (projectiles.get(i).shouldDelete){
          projectiles.remove(i);
          i--;
        }
      }
      for (int i = 0; i<items.size(); i++){
        if (items.get(i).shouldDelete){
          items.remove(i);
          i--;
        }
      }
      if (enemyTimer == 0){
        spawnEnemies((int) (Math.random()*4), playerX, playerY);
        enemyTimer = 600;
      }else{
        enemyTimer--;
      }
    }else{
      disableTimer--;
    }
  }
  
}