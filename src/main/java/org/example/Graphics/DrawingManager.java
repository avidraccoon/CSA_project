package org.example.Graphics;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class DrawingManager {
    private ArrayList<DrawingHandler> layers = new ArrayList<DrawingHandler>();


    public DrawingManager() {

    }

    public void addLayer(DrawingHandler layer) {
        layers.add(layer);
    }

    public void addLayer(DrawingHandler layer, int index) {
        layers.add(index, layer);
    }

    public void removeLayer(DrawingHandler layer) {
        layers.remove(layer);
    }

    public DrawingHandler removeLayer(int index) {
        return layers.remove(index);
    }

    public ArrayList<DrawingHandler> getLayers(){
        return layers;
    }

    public DrawingHandler getLayer(int index){
      return layers.get(index);
    }

    public void setLayers(ArrayList<DrawingHandler> layers) {
        this.layers = layers;
    }

    public void Draw(Graphics g){
        for (DrawingHandler layer : layers) {
            layer.draw(g);
        }
    }
}
