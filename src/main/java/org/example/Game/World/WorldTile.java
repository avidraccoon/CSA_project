package org.example.Game.World;

import org.example.Game.World.Trees;
import org.example.Game.Entities.Player;
import org.example.Game.Entities.Enemy;
import org.example.Game.Entities.Projectile;
import java.awt.*;

import java.util.ArrayList;
import java.lang.Math;
class WorldTile{
  private Trees trees = new Trees();
  private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
  private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  
  public WorldTile(){
    int randNum = (int) (Math.random()*3)+1;
    String type;
    int x;
    int y;
    for (int i = 0; i<randNum; i++){
      type = Math.random()>0.5?"enemy1":"enemy2";
      x = (int)(Math.random()*400);
      y = (int)(Math.random()*400);
      enemies.add(new Enemy(type, x, y));
    }
  }
  public void draw(Graphics2D g, Player player){
    player.draw(g);
    for (Enemy enemy : enemies){
      enemy.draw(g);
    }
    for (Projectile proj : projectiles){
      proj.draw(g);
    }
    trees.draw(g);
  }

  public void addProjectile(Projectile proj){
    projectiles.add(proj);
  }

  public void update(double playerX, double playerY){
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
          enemy.health--;
        }
      }
    }
    for (int i = 0; i<enemies.size(); i++){
      if (enemies.get(i).shouldDelete){
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
  }
  
}