package org.example.Graphics;

import java.awt.*;
import java.util.ArrayList;
public class DrawingHandler {

    private ArrayList<DrawingFunctions> actions = new ArrayList<DrawingFunctions>();
    private Color color = Color.WHITE;

    public void draw(Graphics g) {
        for (DrawingFunctions action : actions) {
            action.execute((Graphics2D) g);
        }
    }

    public void addAction(DrawingFunctions action) {
        actions.add(action);
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }


}
