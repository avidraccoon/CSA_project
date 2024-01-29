package org.example.Graphics;
import java.awt.*;
import java.util.ArrayList;
public class DrawingFunctions {

    public static class DrawingFunctionsParameters {
        private final ArrayList<Object> parameters = new ArrayList<Object>();
        public DrawingFunctionsParameters() {}

        public void writeColor(Color color){
            parameters.add(color);
        }

        public Color readColor(int index){
            return (Color) parameters.get(index);
        }

        public void writeInt(int i){
            parameters.add(i);
        }

        public int readInt(int index){
            return (Integer) parameters.get(index);
        }
    }
    private static DrawingHandler handler;
    private String drawFunction = "";
    private DrawingFunctionsParameters parameters = new DrawingFunctionsParameters();
    public DrawingFunctions(String function, DrawingFunctionsParameters parameters){
        this.drawFunction = function;
        this.parameters = parameters;
    }

    public void execute(Graphics2D g){
        switch(drawFunction) {
            case "FillRectangle":
                fillRect(g);
                break;
            case "FillCircle":
                fillCircle(g);
                break;
            case "FillSquare":
                fillSquare(g);
                break;
            case "DrawRectangle":
                drawRect(g);
                break;
            case "DrawCircle":
                drawCircle(g);
                break;
            case "DrawSquare":
                drawSquare(g);
                break;
        }
    }

    public static void setHandler(DrawingHandler h){
        handler = h;
    }

    private void fillRect(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.fillRect(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(4));
    }

    public static void fillRect(int x, int y, int width, int height, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(width);
        params.writeInt(height);
        handler.addAction(new DrawingFunctions("FillRectangle", params));
    }

    public static void fillRect(int x, int y, int width, int height){
        fillRect(x,y,width,height,handler.getColor());
    }

    public void fillCircle(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.fillOval(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(3));
    }
    
    public static void fillCircle(int x, int y, int radius, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(radius);
        handler.addAction(new DrawingFunctions("FillCircle", params));
    }

    public static void fillCircle(int x, int y, int radius){
        fillCircle(x,y,radius,handler.getColor());
    }

    public void fillSquare(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.fillRect(parameters.readInt(1), parameters.readInt(2), parameters.readInt(3), parameters.readInt(3));
    }
    public static void fillSquare(int x, int y, int length, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(length);
        handler.addAction(new DrawingFunctions("FillSquare", params));
    }
    public static void fillSquare(int x, int y, int length){
        fillSquare(x,y,length,handler.getColor());
    }

    public void drawRect(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.drawRect(parameters.readInt(1), parameters.readInt(2), parameters.readInt(3), parameters.readInt(4));
    }
    public static void drawRect(int x, int y, int width, int height, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(width);
        params.writeInt(height);
        handler.addAction(new DrawingFunctions("DrawRectangle", params));
    }
    public static void drawRect(int x, int y, int width, int height){
        drawRect(x,y,width,height,handler.getColor());
    }
    public void drawCircle(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.drawOval(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(3));
    }

    public static void drawCircle(int x, int y, int radius, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(radius);
        handler.addAction(new DrawingFunctions("DrawCircle", params));
    }

    public static void drawCircle(int x, int y, int radius){
        drawCircle(x,y,radius,handler.getColor());
    }

    public void drawSquare(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.drawRect(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(3));
    }

    public static void drawSquare(int x, int y, int length, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(length);
        handler.addAction(new DrawingFunctions("DrawSquare", params));
    }

    public static void drawSquare(int x, int y, int length){
        drawSquare(x,y,length,handler.getColor());
    }

    public void setColor(Color color){
        handler.setColor(color);
    }



}
