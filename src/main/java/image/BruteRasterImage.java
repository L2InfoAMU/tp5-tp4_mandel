package image;

import util.Matrices;
import javafx.scene.paint.Color;

import static util.Matrices.*;

public class BruteRasterImage implements Image {
    private Color[][] pixels;
    private int width;
    private int height;

    /**
     * Constructeur de l'objet de type BruteRasterImage
     * @param color une couleur
     * @param width un entier
     * @param height un entier
     */
    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        for (int row = 0; row < width; row++){
            for (int column = 0; column < height ; column++){
                this.pixels[row][column] = color;
            }
        }
    }

    /**
     * Contrusteur de l'objet qui prend en parametre une matrice de type Color
     * @param pixels matrice de type color.
     */
    public BruteRasterImage(Color[][] pixels){
        requiresRectangularMatrix(pixels);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        setHeight(getColumnCount(pixels));
        setWidth(getRowCount(pixels));
        createRepresentation();
        this.pixels = pixels.clone();
    }

    /**
     * La fonction alloue la tableau pixels.
     */
    public void createRepresentation(){
        this.pixels = new Color[this.width][this.height];
    }

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
    public void setPixelColor(Color color, int x, int y){
        this.pixels[x][y] = color;
    }

    /**
     * recopie la matrice pixels passe en parametre.
     * @param pixels de Color
     */
    private void setPixelsColor(Color[][] pixels){
        this.pixels = pixels.clone();
    }

    /**
     * La fonction initialise tous les pixels de la matrice a la meme couleur.
     * @param color de type Color.
     */
    private void setPixelsColor(Color color){
        for (int row = 0; row < this.width; row++ ){
            for (int column = 0; column < this.height; column++){
                this.pixels[row][column] = color;
            }
        }
    }

    /**
     * Rnvoie le pixel aux coordonne x, y.
     * @param x un entier,
     * @param y un entier.
     * @return pixels[x][y].
     */
    @Override
    public Color getPixelColor(int x, int y) {
        return this.pixels[x][y];
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
