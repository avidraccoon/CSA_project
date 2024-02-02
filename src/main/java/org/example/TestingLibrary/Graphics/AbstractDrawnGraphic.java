package org.example.TestingLibrary.Graphics;

public abstract class AbstractDrawnGraphic implements DrawInterface {
    private int x = 0;
    private int y = 0;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
