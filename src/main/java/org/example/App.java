package org.example;


import org.example.TestingLibrary.GraphicalWindow;
import org.example.TestingLibrary.Graphics.DrawingHandler;
import org.example.TestingLibrary.Graphics.Shapes.GraphicalRectangle;
import org.example.TestingLibrary.Graphics.Shapes.GraphicalCircle;



import org.example.Game.Entities.Player;
import org.example.Game.Entities.Projectile;
import org.example.Game.Entities.Enemy;



import javax.swing.Timer;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Math;

import java.util.ArrayList;

public class App
{
    public static String text = "Test";
    public static GraphicalWindow window;
    public static DrawingHandler drawingHandler;
    public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static GraphicalRectangle rectangle = new GraphicalRectangle(25, 25, 25, 25);
    public static Player player = new Player(25,25);
    public static double x = 25;
    public static double y = 25;
    public static double vx = 0;
    public static double vy = 0;
    public static boolean w = false;
    public static boolean a = false;
    public static boolean s = false;
    public static boolean d = false;
    public static boolean fTyped = false;
    public static double speed = .25;
    public static double speedCap = 4.5;
    public static double friction = 0.92;
    public static void update(){
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
        player.setX(x);
        player.setY(y);
        if (fTyped){
          player.shootProjectile(drawingHandler);
          fTyped = false;
        }
        player.update();
        App.window.paint(App.window.getGraphics());
        //System.out.println(x+" "+y);
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        window = GraphicalWindow.createWindow();
        window.setTitle("Test");
        window.setSize(400, 300);
        window.addKeyListener(window);
        window.addMouseListener(window);
        window.setMouseHandler(new TestMouseHandler());
        window.setKeyHandler(new TestKeyHandler());
        drawingHandler = window.getDrawingHandler();
        drawingHandler.addDrawObject(rectangle);
        player.addToHandler(drawingHandler);
        int delay = 1000/40;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                App.update();
            }
        };
        new Timer(delay, taskPerformer).start();
    }
}
