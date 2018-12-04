package image;

import javafx.scene.paint.Color;
import java.util.List;

public class PaletteRasterImage implements Image {
    int height;
    int width;
    int[][] indexesOfColors;
    List<Color> palette;


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
        return this.;
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
