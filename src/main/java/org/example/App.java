package org.example;


import org.example.Graphics.DrawingFunctions;
import org.example.Graphics.DrawingHandler;
import org.example.Graphics.GraphicsWindow;
import org.example.Graphics.DrawingManager;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        GraphicsWindow window = GraphicsWindow.createWindow();
        window.setTitle("Test");
        window.setSize(400, 300);
        DrawingManager manager = window.getDrawingManager();
        DrawingHandler handler = manager.getLayer(0);
        DrawingFunctions.setHandler(handler);
        DrawingFunctions.fillCircle(75, 238, 100, Color.BLACK);
        DrawingFunctions.drawRect(0, 34, 345, 300, Color.GREEN);
    }
}
