package image;

import javafx.scene.paint.Color;

import java.util.HashMap;

import static util.Matrices.*;

public class SparseRasterImage implements Image {
    private int width;
    private int height;
    private HashMap<Point, Color> pixelsMap;

    /**
     * Constructeur de l'objet.
     * @param color de type Color
     * @param width de type entier
     * @param height de type entier
     */
    public SparseRasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    /**
     * Constructeur de l'objet SparseRasterImage.
     * @param pixels
     */
    public SparseRasterImage(Color[][] pixels){
        requiresRectangularMatrix(pixels);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        setHeight(getColumnCount(pixels));
        setWidth(getRowCount(pixels));
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
     * La methode change tous les pixels de la hashMap en la couleur passe en parametre
     * @param color de type Color.
     */
    private void setPixelsColor(Color color){
        for (int row = 0; row < getWidth(); row++){
            for (int column = 0; column < getHeight(); column++){
                setPixelColor(color, row, column);
            }
        }
    }

    /**
     * LA methode met à jour les valeurs de couleurs de l’image en utilisant les valeurs de la
     * matrice donnée en paramètre.
     * @param pixels une matrice de type Color.
     */
    private void setPixelsColor(Color[][] pixels){
        for (int row = 0; row < getWidth(); row++){
            for (int column = 0; column < getHeight(); column++){
                setPixelColor(pixels[row][column], row, column);
            }
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

    /**
     * Renvoie la largeur de la fenetre.
     * @return this.width
     */
    @Override
    public int getWidth() {
        return this.width;
    }

    /**
     * Renvoie la hauteur de la fenetre.
     * @return this.height
     */
    @Override
    public int getHeight() {
        return this.height;
    }
}
