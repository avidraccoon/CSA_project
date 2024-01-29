package org.example.Graphics;
import javax.swing.*;
import java.awt.*;

public class GraphicsWindow extends JFrame {

    private int width = 100;
    private int height = 100;
    private String title = "Window";
    private boolean resizable = true;

    private DrawingManager drawingManager;

    private GraphicsWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setResizable(resizable);
        setSize(width, height);
        setVisible(true);
        drawingManager = new DrawingManager();
        drawingManager.addLayer(new DrawingHandler());
    }

    public static GraphicsWindow createWindow(){
        return new GraphicsWindow();
    }

    public static GraphicsWindow createWindow(int width, int height){
        GraphicsWindow w = new GraphicsWindow();
        w.setSize(width, height);
        return w;
    }

    public static GraphicsWindow createWindow(String title){
        GraphicsWindow w = new GraphicsWindow();
        w.setTitle(title);
        return w;
    }

    public static GraphicsWindow createWindow(String title, int width, int height){
        GraphicsWindow w = new GraphicsWindow();
        w.setTitle(title);
        w.setSize(width, height);
        return w;
    }

    public boolean getResizable(){
        return this.resizable;
    }

    public void paint(Graphics g){
        super.paint(g);
        drawingManager.Draw(g);
    }

    public DrawingManager getDrawingManager(){
        return drawingManager;
    }

    public void setDrawingManager(DrawingManager drawingManager){
        this.drawingManager = drawingManager;
    }


    public void setSize(int width, int height){
        super.setSize(width, height);
        this.width = width;
        this.height = height;
    }
}
