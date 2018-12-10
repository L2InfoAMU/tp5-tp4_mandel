package image;

import javafx.scene.paint.Color;

import static util.Matrices.*;

public abstract class RasterImage implements Image {
    private int width;
    private int height;

    /**
     * Constructeur de l'objet de type BruteRasterImage
     * @param color une couleur
     * @param width un entier
     * @param height un entier
     */
    public RasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);
    }

    /**
     * Contrusteur de l'objet qui prend en parametre une matrice de type Color
     * @param pixels matrice de type color.
     */
    public RasterImage(Color[][] pixels){
        requiresRectangularMatrix(pixels);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        setHeight(getColumnCount(pixels));
        setWidth(getRowCount(pixels));
    }

    public abstract void createRepresentation();

    @Override
    public abstract Color getPixelColor(int x, int y);

    /**
     * Modifie la largeur de la fenetre
     * @param width un entier
     */
    protected void setWidth(int width){
        this.width = width;
    }

    /**
     * Modifie la hauteur de la fenetre
     * @param height un entier.
     */
    protected void setHeight(int height){
        this.height = height;
    }

    /**
     * Change la valeur du pixel a la position donnée
     * @param color de type color
     * @param x de type int
     * @param y de type int
     */
    public abstract void setPixelColor(Color color, int x, int y);

    /**
     * recopie la matrice pixels passe en parametre.
     * @param pixels de Color
     */
    protected void setPixelsColor(Color[][] pixels) {
        for (int row = 0; row < getWidth(); row++) {
            for (int column = 0; column < getHeight(); column++) {
                setPixelColor(pixels[row][column],row,column);
            }
        }
    }

    /**
     * La fonction initialise tous les pixels de la matrice a la meme couleur.
     * @param color de type Color.
     */
    protected void setPixelsColor(Color color){
        for (int row = 0; row < getWidth(); row++ ){
            for (int column = 0; column < getHeight(); column++){
                setPixelColor(color, row, column);
            }
        }
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
