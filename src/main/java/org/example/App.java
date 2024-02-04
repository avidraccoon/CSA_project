package org.example;

import java.awt.*;
import org.example.TestingLibrary.GraphicalWindow;
import org.example.TestingLibrary.Graphics.DrawingHandler;
import org.example.TestingLibrary.Graphics.Shapes.GraphicalRectangle;
import org.example.TestingLibrary.Graphics.Shapes.GraphicalCircle;



import org.example.Game.World.World;
import org.example.Game.Entities.Projectile;
import org.example.Game.Entities.Enemy;
import org.example.Game.World.Background;
import org.example.Game.World.Trees;
import org.example.Game.GUI.Hearts;
import org.example.Game.GUI.Mana;
import org.example.Game.GUI.Death;




import javax.swing.Timer;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Math;
import java.lang.Thread;
import java.util.ArrayList;

public class App
{

    public static boolean restart = false;
    public static int targetFrame = 0;
    public static int calculatedFrame = 0;
    public static int startTime = 0;
    public static String text = "Test";
    public static GraphicalWindow window;
    public static DrawingHandler drawingHandler;
    public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static GraphicalRectangle rectangle = new GraphicalRectangle(25, 25, 25, 25);
    public static World world = new World(5,5);
    public static double x = 25;
    public static double y = 25;
    public static double vx = 0;
    public static double vy = 0;
    public static boolean w = false;
    public static boolean a = false;
    public static boolean s = false;
    public static boolean d = false;
    public static boolean fTyped = false;
    public static double speed = .15;
    public static double speedCap = 2.5;
    public static double friction = 0.95;
    public static void update(){
        x = world.getPlayerX();
        y = world.getPlayerY();
        double vyChange = 0;
        double vxChange = 0;
        if (w) vyChange-=speed;
        if (a) vxChange-=speed;
        if (s) vyChange+=speed;
        if (d) vxChange+=speed;
        if ((vxChange > speed/2 || vxChange < -speed/2) && (vyChange > speed/2 || vyChange < -speed/2)){
          vxChange*=Math.sqrt(2)/2;
          vyChange*=Math.sqrt(2)/2;
        }
        vx+=vxChange;
        vy+=vyChange;
        if (vx > speedCap) vx = speedCap;
        if (vx < -speedCap) vx = -speedCap;
        if (vy > speedCap) vy = speedCap;
        if (vy < -speedCap) vy = -speedCap;
        x += vx;
        y += vy;
        //if (vx>friction) vx-=friction;
        //if (vx<-friction) vx+=friction;
        //if (vy>friction) vy-=friction;
        //if (vy<-friction) vy+=friction;
        vx*=friction;
        vy*=friction;
        world.setPlayerX(x);
        world.setPlayerY(y);
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        double xDist = Math.abs(mouseX-x);
        double yDist = Math.abs(mouseY-y);
        double totalDist = xDist + yDist;
        double xFrac = xDist/totalDist;
        double yFrac = yDist/totalDist;
        if (fTyped){
          world.playerShootProjectile(drawingHandler, xFrac* (mouseX<x?-1:1), yFrac*(mouseY<y?-1:1));
          //fTyped = false;
        }
        world.update();
        //System.out.println(x+" "+y);
        if (restart){
          System.out.println("dead");
          Death.characterDead = true;
          App.window.update(App.window.getGraphics());
          try{
            Thread.sleep(1000);
          }catch (Exception e){
            System.out.println(e);
          }
          Death.characterDead = false;
          drawingHandler.clear();
          world = new World(25,25);
          drawingHandler.addDrawObject(Background.getInstance());
          drawingHandler.addDrawObject(world);
          drawingHandler.addDrawObject(Hearts.getInstance());
          drawingHandler.addDrawObject(Mana.instance);
          drawingHandler.addDrawObject(Death.instance);
          restart = false;
        }
    }

    public static void main( String[] args )
    {
        App.startTime = (int) System.currentTimeMillis();
        System.out.println( "Hello World!" );
        window = GraphicalWindow.createWindow();
        window.setTitle("Test");
        window.setSize(400, 420);
        window.addKeyListener(window);
        window.addMouseListener(window);
        window.setMouseHandler(new TestMouseHandler());
        window.setKeyHandler(new TestKeyHandler());
        drawingHandler = window.getDrawingHandler();
        drawingHandler.addDrawObject(Background.getInstance());
        drawingHandler.addDrawObject(world);
        drawingHandler.addDrawObject(Hearts.getInstance());
        drawingHandler.addDrawObject(Mana.instance);
        drawingHandler.addDrawObject(Death.instance);
        int delay = 1000/60;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                App.checkForUpdate(delay);
                App.window.update(App.window.getGraphics());
            }
        };
        new Timer(delay, taskPerformer).start();
    }

  public static int calculateTargetFrame(int delay){
    int timeDiffrence = (int)(System.currentTimeMillis()-App.startTime);
    return (int)(timeDiffrence/delay);
  }

  public static void batchUpdate(int Count){
    for (int i = 0; i < Count; i++){
      update();
      //System.out.println(enemies);
    }
  }

  public static void checkForUpdate(int delay){
    App.targetFrame = App.calculateTargetFrame(delay);
    //System.out.println(targetFrame);
    //System.out.println(calculatedFrame);
    if (App.targetFrame != App.calculatedFrame){
      //System.out.println(Main.targetFrame+" "+ Main.calculatedFrame);
        App.batchUpdate(App.targetFrame - App.calculatedFrame);
      App.calculatedFrame = App.targetFrame;
    }
  }
}
