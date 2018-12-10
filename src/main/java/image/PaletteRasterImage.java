package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static util.Matrices.*;
import static util.Matrices.getRowCount;

public class PaletteRasterImage implements Image {
   private int height;
   private int width;
   private int[][] indexesOfColors;
   private List<Color> palette;

    /**
     * Constructeur de l'objet.
     * @param color de type Color
     * @param width de type entier
     * @param height de type entier
     */
    public PaletteRasterImage(Color color, int width, int height) {
       this.width = width;
       this.height = height;
       createRepresentation();
       setPixelsColor(color);
    }

    /**
     * Constructeur de l'objet PaletteRasterImage.
     * @param pixels
     */
    public PaletteRasterImage(Color[][] pixels){
        requiresRectangularMatrix(pixels);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        setHeight(getColumnCount(pixels));
        setWidth(getRowCount(pixels));
        createRepresentation();
        setPixelsColor(pixels);
    }

    /**
     * La methode alloue le tableau d'entiers et cree la liste de couleur.
     */
    public void createRepresentation(){
        this.indexesOfColors = new int[this.width][this.height];
        this.palette = new ArrayList<>();
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
     * La methode fixe la couleur d'un pixel et ajoute la couleur a la palette si elle existe pas
     * @param color de type Color.
     * @param x de type entier.
     * @param y de type entier.
     */
    public void setPixelColor(Color color, int x, int y) {
        int tmp = palette.indexOf(color);
        if(tmp == -1)
        {
            palette.add(color);
            tmp = palette.size()-1;
        }
        indexesOfColors[x][y] = tmp;
    }

    /**
     * la methode vide la palette et rajoute la couleur dans la liste et fixe tous les pixels
     * de la couleur contenue dans la liste.
     * @param color
     */
    private void setPixelsColor(Color color){
        palette.clear();
        palette.add(color);
        for (int row = 0; row < this.width; row++){
            for (int column = 0; column < this.height; column++){
                this.indexesOfColors[row][column] = 0;
            }
        }
    }

    /**
     * Met à jour les valeurs de couleurs de l’image
     * en utilisant les valeurs de la matrice donnée en paramètre.
     * @param pixels de type Color
     */
    public void setPixelsColor(Color[][] pixels) {
        for (int row = 0; row < pixels.length; row++){
            for (int column = 0; column < pixels[0].length; column++){
                if (palette.indexOf(pixels[row][column]) == -1){
                    palette.add(pixels[row][column]);
                }
                indexesOfColors[row][column] = palette.indexOf(pixels[row][column]);
            }
        }
    }

    /**
     * La fonction renvoie la couleur contenue dans la liste au coordonnées x, y.
     * @param x un entier
     * @param y un entier
     * @return palette de type Color.
     */
    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColors[x][y]);
    }

    /**
     * Renvoi la largeur de la fenetre
     * @return this.width
     */
    @Override
    public int getWidth() {
        return this.width;
    }

    /**
     * Renvoi la hauteur de la fenetre
     * @return this.height
     */
    @Override
    public int getHeight() {
        return this.height;
    }
}
