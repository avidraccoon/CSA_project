package org.example;


import org.example.Graphics.DrawingFunctions;
import org.example.Graphics.DrawingHandler;
import org.example.Graphics.GraphicsWindow;
import javax.swing.Timer;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String text = "Test";
    public static GraphicsWindow window;
    public static double x = 25;
    public static double y = 25;
    public static double vx = 0;
    public static double vy = 0;
    public static boolean w = false;
    public static boolean a = false;
    public static boolean s = false;
    public static boolean d = false;
    public static double speed = .45;
    public static double speedCap = 6.5;
    public static double friction = 0;
    public static void update(){
      if (w) vy-=speed;
      if (a) vx-=speed;
      if (s) vy+=speed;
      if (d) vx+=speed;
      if (vx > speedCap) vx = speedCap;
      if (vx < -speedCap) vx = -speedCap;
      if (vy > speedCap) vy = speedCap;
      if (vy < -speedCap) vy = -speedCap;
      x += vx;
      y += vy;
      if (vx>friction) vx-=friction;
      if (vx<-friction) vx+=friction;
      if (vy>friction) vy-=friction;
      if (vy<-friction) vy+=friction;
      vx*=0.85;
      vy*=0.85;
    }
  
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        window = GraphicsWindow.createWindow();
        window.setTitle("Test");
        window.setSize(400, 300);
        window.addKeyListener(window);
        window.addMouseListener(window);
        window.setMouseHandler(new TestMouseHandler());
        window.setKeyHandler(new TestKeyHandler());
        paint();
        int delay = 1000/30;
          ActionListener taskPerformer = new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  //...Perform a task...
                  App.paint();
                  App.update();
                  //System.out.println(Main.projectiles.size());
                  //Main.checkForUpdate();
                //if (Main.calculatedFrame%250 == 0){
                //  Enemy enemy = new Enemy(100, 100, path);
                //window.enemies.add(enemy);
                //}
              }
          };
          new Timer(delay, taskPerformer).start();
    }

    public static void paint(){
      DrawingHandler handler = window.getDrawingHandler();
      handler.clear();
      DrawingFunctions.setHandler(handler);
      DrawingFunctions.fillRect(0, 34, 345, 300, Color.GREEN);
      DrawingFunctions.drawRect(0, 0, 50, 50, Color.RED);
      DrawingFunctions.fillCircle((int) x, (int) y, 15, Color.BLACK);
      //DrawingFunctions.fillRect(25, 25, 100, 100, Color.BLACK);
      //DrawingFunctions.drawText(50, 50, text, Color.BLUE, true);
      window.repaint();
    }
}
