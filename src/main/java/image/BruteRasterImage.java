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

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
