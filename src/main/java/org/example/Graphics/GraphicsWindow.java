package org.example.Graphics;
import javax.swing.*;
import java.awt.*;

public class GraphicsWindow extends JFrame {

    private int width = 100;
    private int height = 100;
    private String title = "Window";
    private boolean resizable = true;

    private DrawingHandler drawingHandler = new DrawingHandler();

    private GraphicsWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setResizable(resizable);
        setSize(width, height);
        setVisible(true);
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
        drawingHandler.draw(g);
    }

    public DrawingHandler getDrawingHandler(){
        return drawingHandler;
    }

    public void setDrawingHandler(DrawingHandler drawingHandler){
        this.drawingHandler = drawingHandler;
    }


    public void setSize(int width, int height){
        super.setSize(width, height);
        this.width = width;
        this.height = height;
    }
}
