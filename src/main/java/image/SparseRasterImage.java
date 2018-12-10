package image;

import javafx.scene.paint.Color;

import java.util.HashMap;

import static util.Matrices.*;


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

    public SparseRasterImage(Color[][] pixels){
        requiresRectangularMatrix(pixels);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        setHeight(getColumnCount(pixels));
        setWidth(getRowCount(pixels));
        createRepresentation();
        setPixelsColor(pixels);
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

    public void setPixelColor(Color color, int x, int y){
        this.pixelsMap.put(new Point(x, y), color);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixelsMap.get(new Point(x, y));
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
