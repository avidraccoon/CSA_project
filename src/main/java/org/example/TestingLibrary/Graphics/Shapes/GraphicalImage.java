package org.example.TestingLibrary.Graphics.Shapes;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

import org.example.App;

public class GraphicalImage extends AbstractShape {

    private BufferedImage image;

    private GraphicalImage(){}

    public GraphicalImage(String path){
      try{
        File input = new File(path);
        this.image = ImageIO.read(input);
      } catch (IOException ie) {
        System.out.println("Error:"+ie.getMessage());
      }
    }

    public GraphicalImage(int x, int y, String path){
        this(path);
        setX(x);
        setY(y);
    }
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(image, getX(), getY(), App.window);
    }
}
