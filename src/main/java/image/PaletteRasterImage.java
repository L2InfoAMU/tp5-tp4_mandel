package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static util.Matrices.*;
import static util.Matrices.getRowCount;

public class PaletteRasterImage extends RasterImage {
   private int[][] indexesOfColors;
   private List<Color> palette;

    /**
     * Constructeur de l'objet.
     * @param color de type Color
     * @param width de type entier
     * @param height de type entier
     */
    public PaletteRasterImage(Color color, int width, int height){
        super(color, width, height);
        createRepresentation();
        setPixelsColor(color);
    }

    /**
     * Constructeur de l'objet PaletteRasterImage.
     * @param pixels
     */
    public PaletteRasterImage(Color[][] pixels){
        super(pixels);
        createRepresentation();
        setPixelsColor(pixels);
    }

    /**
     * La methode alloue le tableau d'entiers et cree la liste de couleur.
     */
    public void createRepresentation(){
        this.indexesOfColors = new int[getWidth()][getHeight()];
        this.palette = new ArrayList<>();
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
     * La fonction renvoie la couleur contenue dans la liste au coordonnées x, y.
     * @param x un entier
     * @param y un entier
     * @return palette de type Color.
     */
    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColors[x][y]);
    }
}
