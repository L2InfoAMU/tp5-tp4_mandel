package image;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image {
    private Color[][] pixels;
    private int width;
    private int height;

    public BruteRasterImage(Color color, int width, int height){

    }

    public BruteRasterImage(Color[][] pixels){

    }

    public void createRepresentatiion(){

    }

    protected void setWidth(int width){

    }

    protected void setHeight(int height){

    }

    public void setPixelColor(Color color, int x, int y){

    }

    private void setPixelsColor(Color[][] pixels){

    }

    private void setPixelsColor(Color color){

    }

    /*
    * Rnvoie le pixel aux coordonne x, y.
    * @return pixel[x][y].
     */
    @Override
    public Color getPixelColor(int x, int y) {
        return this.pixels[x][y];
    }

    /*
    * Renvoie la largeur de la fenetre.
    * @return this.width
     */
    @Override
    public int getWidth() {
        return this.width;
    }

    /*
     * Renvoie la hauteur de la fenetre.
     * @return this.height
     */
    @Override
    public int getHeight() {
        return this.height;
    }
}
