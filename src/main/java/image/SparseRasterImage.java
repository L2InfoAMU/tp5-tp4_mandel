package image;

import javafx.scene.paint.Color;

import java.util.HashMap;

public class SparseRasterImage implements Image {
    private int width;
    private int height;
    private Point point;
    private HashMap<Point, Color> pixelsMap;

    public SparseRasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    public void createRepresentation(){
        this.pixelsMap = new HashMap<>();
    }
    /**
     * Modifie la largeur de la fenetre.
     * @param width
     */
    protected void setWidth(int width){
        this.width = width;
    }

    /**
     * Renvoi la largeur de la fenetre.
     * @param height
     */
    protected void setHeight(int height){
        this.height = height;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
