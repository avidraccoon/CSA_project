package org.example.TestingLibrary;
import javax.swing.*;
import java.awt.*;

import org.example.TestingLibrary.Graphics.DrawingHandler;
import org.example.TestingLibrary.Input.KeyboardHandler;
import org.example.TestingLibrary.Input.MouseHandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class GraphicalWindow extends JFrame implements MouseListener, KeyListener {

    private int width = 400;
    private int height = 420;
    private String title = "Window";
    private boolean resizable = false;
    Image backBuffer;
    Graphics bBG;
    private DrawingHandler drawingHandler = new DrawingHandler();
    private KeyboardHandler keyboardHandler = new KeyboardHandler();
    private MouseHandler mouseHandler = new MouseHandler();
  
    private GraphicalWindow(){
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setResizable(resizable);
        setVisible(true);
    }

    public static GraphicalWindow createWindow(){
        return new GraphicalWindow();
    }

    public static GraphicalWindow createWindow(int width, int height){
        GraphicalWindow w = new GraphicalWindow();
        w.setSize(width, height);
        return w;
    }

    public static GraphicalWindow createWindow(String title){
        GraphicalWindow w = new GraphicalWindow();
        w.setTitle(title);
        return w;
    }

    public static GraphicalWindow createWindow(String title, int width, int height){
        GraphicalWindow w = new GraphicalWindow();
        w.setTitle(title);
        w.setSize(width, height);
        return w;
    }

    public boolean getResizable(){
        return this.resizable;
    }

    public void paint(Graphics g){
        //super.paint(g);
        if( backBuffer == null )
        {
            backBuffer = createImage( getWidth(), getHeight() );
            bBG = backBuffer.getGraphics();
        }
        drawingHandler.draw(bBG);
        g.drawImage( backBuffer, 0, 0, this );
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

    

    public KeyboardHandler getKeyHandler(){
      return keyboardHandler;
    }

    public void setKeyHandler(KeyboardHandler keyboardHandler){
      this.keyboardHandler = keyboardHandler;
    }

    public MouseHandler getMouseHandler(){
      return mouseHandler;
    }

    public void setMouseHandler(MouseHandler mouseHandler){
      this.mouseHandler = mouseHandler;
    }

    public void mousePressed(MouseEvent e){
      mouseHandler.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e){
      mouseHandler.mouseReleased(e);
    }

    public void mouseEntered(MouseEvent e){
      mouseHandler.mouseEntered(e);
    }

    public void mouseExited(MouseEvent e){
      mouseHandler.mouseExited(e);
    }

    public void mouseClicked(MouseEvent e){
      mouseHandler.mouseClicked(e);
    }

    public void keyPressed(KeyEvent e){
      keyboardHandler.keyPressed(e);
    }

    public void keyReleased(KeyEvent e){
      keyboardHandler.keyReleased(e);
    }

    public void keyTyped(KeyEvent e){
      keyboardHandler.keyTyped(e);
    }
}
