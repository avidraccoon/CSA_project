package org.example.Graphics;

import java.util.ArrayList;
public class DrawerManager {
    private ArrayList<Drawer> layers = new ArrayList<Drawer>();

    private final DrawerManager INSTANCE = new DrawerManager();

    private DrawerManager() {

    }

    public DrawerManager getDrawerManager() {
        return INSTANCE;
    }

    public void addLayer(Drawer layer) {
        layers.add(layer);
    }

    public void addLayer(Drawer layer, int index) {
        layers.add(index, layer);
    }

    public void removeLayer(Drawer layer) {
        layers.remove(layer);
    }

    public Drawer removeLayer(int index) {
        return layers.remove(index);
    }

    public ArrayList<Drawer> getLayers(){
        return layers;
    }

    public void setLayers(ArrayList<Drawer> layers) {
        this.layers = layers;
    }

    public void Draw(){
        for (Drawer layer : layers) {
            layer.draw();
        }
    }
}
