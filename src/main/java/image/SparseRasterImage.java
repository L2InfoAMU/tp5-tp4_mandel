package image;

import javafx.scene.paint.Color;

import java.util.HashMap;

public class SparseRasterImage extends RasterImage {
    private HashMap<Point, Color> pixelsMap;

    /**
     * Constructeur de l'objet.
     * @param color de type Color
     * @param width de type entier
     * @param height de type entier
     */
    public SparseRasterImage(Color color, int width, int height){
        super(color, width, height);
        createRepresentation();
        setPixelsColor(color);
    }

    /**
     * Constructeur de l'objet SparseRasterImage.
     * @param pixels
     */
    public SparseRasterImage(Color[][] pixels){
        super(pixels);
        createRepresentation();
        setPixelsColor(pixels);
    }

    /**
     * Cree le dictionnaire HashMap
     */
    public void createRepresentation(){
        this.pixelsMap = new HashMap<>();
    }

    /**
     * La methode associe le point de coordonnées x, y a la couleur
     * @param color de type Color.
     * @param x de type entier.
     * @param y de type entier.
     */
    public void setPixelColor(Color color, int x, int y){
        if (!color.equals(Color.WHITE)) {
            this.pixelsMap.put(new Point(x, y), color);
        }
    }

    /**
     * La methode retourne la couleur d’un pixel.
     * @param x de type entier.
     * @param y de type entier.
     * @return retourne la couleur d'un pixel ou blanc si aucune couleur.
     */
    @Override
    public Color getPixelColor(int x, int y) {
        return pixelsMap.getOrDefault(new Point(x, y), Color.WHITE);
    }
}
