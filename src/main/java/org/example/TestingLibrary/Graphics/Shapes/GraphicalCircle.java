package org.example.TestingLibrary.Graphics.Shapes;

import java.awt.*;

public class GraphicalCircle extends AbstractShape {

    private int radius = 0;

    public GraphicalCircle(){

    }

    public GraphicalCircle(int radius){
        this.radius = radius;
    }

    public GraphicalCircle(int x, int y, int radius){
        this.radius = radius;
        setX(x);
        setY(y);
    }
    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getColor());
        if (isFilled()){
            g.fillOval(getX()+radius, getY()+radius, radius, radius);
        }else{
            g.fillOval(getX()+radius, getY()+radius, radius, radius);
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
