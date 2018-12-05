package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {
    int height;
    int width;
    int[][] indexesOfColors;
    List<Color> palette;

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
        for (int row = 0; row < width; row++){
            for (int column = 0; column < height; column++){
                this.indexesOfColors[row][column] = 0;
            }
        }
    }

    public void setPixelsColor(Color[][] pixels)
    {

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
