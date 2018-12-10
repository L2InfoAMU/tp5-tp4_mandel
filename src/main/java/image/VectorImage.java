package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class VectorImage implements Image{
    private int height;
    private int width;
    private List<Shape> shapes;

    public VectorImage(List<Shape> shapes, int width, int height){
        setHeight(height);
        setWidth(width);
        this.shapes = new ArrayList<>();
        for (Shape shape : shapes){
            this.shapes.add(shape);
        }
    }

    protected void setHeight(int height){
        this.height = height;
    }

    protected void setWidth(int width){
        this.width = width;
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
        return this.height;
    }
}
