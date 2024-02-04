package org.example.TestingLibrary.Graphics;

import java.awt.*;
import java.util.ArrayList;
public class DrawingHandler {

    private ArrayList<DrawInterface> drawnObjects = new ArrayList<DrawInterface>();
    public void draw(Graphics g) {
        for (DrawInterface d : drawnObjects) {
            d.draw((Graphics2D) g);
        }
    }

    public DrawInterface getDrawnObject(int index){
        return drawnObjects.get(index);
    }

    public void addDrawObject(DrawInterface d){
        drawnObjects.add(d);
    }

    public void addDrawObject(int index, DrawInterface d){
        drawnObjects.add(index, d);
    }

    public void removeDrawnObject(DrawInterface d){
        drawnObjects.remove(d);
    }

    public DrawInterface removeDrawnObject(int index){
        return drawnObjects.remove(index);
    }

    public boolean contains(DrawInterface d){
        return drawnObjects.contains(d);
    }
    public void clear(){
      drawnObjects.clear();
    }

}
