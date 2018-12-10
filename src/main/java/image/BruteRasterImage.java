package image;

import util.Matrices;
import javafx.scene.paint.Color;

import static util.Matrices.*;

public class BruteRasterImage extends RasterImage{
    private Color[][] pixels;

    /**
     * Constructeur de l'objet de type BruteRasterImage
     * @param color une couleur
     * @param width un entier
     * @param height un entier
     */
    public BruteRasterImage(Color color, int width, int height){
        super(color, width, height);
        createRepresentation();
        setPixelsColor(color);
    }

    /**
     * Contrusteur de l'objet qui prend en parametre une matrice de type Color
     * @param pixels matrice de type color.
     */
    public BruteRasterImage(Color[][] pixels){
        super(pixels);
        createRepresentation();
        setPixelsColor(pixels);
    }

    /**
     * La fonction alloue la tableau pixels.
     */
    public void createRepresentation(){
        this.pixels = new Color[getWidth()][getHeight()];
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
     * Rnvoie le pixel aux coordonne x, y.
     * @param x un entier,
     * @param y un entier.
     * @return pixels[x][y].
     */
    @Override
    public Color getPixelColor(int x, int y) {
        return this.pixels[x][y];
    }

}
