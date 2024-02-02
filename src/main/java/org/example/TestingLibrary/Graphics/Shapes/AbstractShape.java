package org.example.TestingLibrary.Graphics.Shapes;

import org.example.TestingLibrary.Graphics.AbstractDrawnGraphic;

import java.awt.*;

public abstract class AbstractShape extends AbstractDrawnGraphic {
    private Color color = Color.BLACK;
    private boolean filled;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
