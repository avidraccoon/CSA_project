package org.example.Game.World;

import org.example.TestingLibrary.Graphics.*;
import org.example.TestingLibrary.Graphics.Shapes.*;
import org.example.Game.World.WorldTile;
import org.example.Game.Entities.Player;
import org.example.Game.Entities.Projectile;
import java.awt.*;

public class World extends AbstractDrawnGraphic{
  private WorldTile[][] tiles;
  private int width;
  private int height;
  private int x = 2;
  private int y = 2;
  private Player player;
  public World(int width, int height){
    player = new Player(25, 25);
    this.width = width;
    this.height = height;
    tiles = new WorldTile[height][width];
    for (int i = 0; i<height; i++){
      for (int j = 0; j<width; j++){
        tiles[i][j] = new WorldTile();
      }
    }
  }

  public void setPlayerX(double xChange){
    int xTileChange = 0;
    while (xChange>400){
      xTileChange++;
      xChange-=400;
    }
    while (xChange<0){
      xTileChange--;
      xChange+=400;
    }
    if (xTileChange!=0){
      x=(x+xTileChange)%width;
      if (x < 0) x=width-1;
      tiles[y][x].setEnemyTimer(120);
    }
    player.setX(xChange);
  }

  public void setPlayerY(double yChange){
    int yTileChange = 0;
    while (yChange>400){
      yTileChange++;
      yChange-=400;
    }
    while (yChange<0){
      yTileChange--;
      yChange+=400;
    }
    if (yTileChange!=0){
      y=(y+yTileChange)%height;
      if (y < 0) y=width-1;
      tiles[y][x].setEnemyTimer(30);
    }
    player.setY(yChange);
  }

  public void draw(Graphics2D g){
    tiles[y][x].draw(g, player);
  }

  public double getPlayerX(){
    return player.getX();
  }
  public double getPlayerY(){
    return player.getY();
  }
  public void update(){
    playerUpdate();
    tiles[y][x].update(player.getX(), player.getY());
  }
  public void playerUpdate(){
    player.update();
  }
  public void playerShootProjectile(DrawingHandler handler, double vx, double vy){
    player.shootProjectile(handler, vx, vy);
  }
  public void shootProjectile(Projectile proj){
    tiles[y][x].addProjectile(proj);
  }
  public void damagePlayer(int health){
    player.setHealth(player.getHealth()-health);
  }

  public Player getPlayer(){
    return player;
  }
}