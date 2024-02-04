package org.example.TestingLibrary.Graphics.Shapes;

import java.awt.*;

public class GraphicalRectangle extends AbstractShape {

    private int width = 0;
    private int height = 0;

    public GraphicalRectangle(){

    }

    public GraphicalRectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public GraphicalRectangle(int x, int y, int width, int height){
        this.width = width;
        this.height = height;
        setX(x);
        setY(y);
    }
    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getColor());
        if (isFilled()){
            g.fillRect(getX(), getY(), width, height);
        }else{
            g.drawRect(getX(), getY(), width, height);
        }
    }

  

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
