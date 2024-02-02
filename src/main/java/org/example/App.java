package org.example;


import org.example.TestingLibrary.GraphicalWindow;
import org.example.TestingLibrary.Graphics.DrawingHandler;
import org.example.TestingLibrary.Graphics.Shapes.GraphicalRectangle;

import javax.swing.Timer;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Hello world!
 *
 */
public class App
{
    public static String text = "Test";
    public static GraphicalWindow window;
    public static DrawingHandler drawingHandler;
    public static GraphicalRectangle rectangle = new GraphicalRectangle(25, 25, 25, 25);
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
        rectangle.setX((int) x);
        rectangle.setY((int) y);
        App.window.paint(App.window.getGraphics());
        System.out.println(x+" "+y);
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
        int delay = 1000/60;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                App.update();
            }
        };
        new Timer(delay, taskPerformer).start();
    }
}
