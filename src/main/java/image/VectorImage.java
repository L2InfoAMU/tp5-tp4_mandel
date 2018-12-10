package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class VectorImage implements Image{
    private int height;
    private int width;
    private List<Shape> shapes;

    /**
     * Constructeur de la classe VectorImage
     * @param shapes de type List<Shape>.
     * @param width de type entier.
     * @param height de type entier.
     */
    public VectorImage(List<Shape> shapes, int width, int height){
        setHeight(height);
        setWidth(width);
        this.shapes = new ArrayList<>();
        for (Shape shape : shapes){
            this.shapes.add(shape);
        }
    }

    /**
     * Renvoi la largeur de la fenetre.
     * @param height
     */
    protected void setHeight(int height){
        this.height = height;
    }

    /**
     * Modifie la largeur de la fenetre.
     * @param width
     */
    protected void setWidth(int width){
        this.width = width;
    }

    /**
     * La methode retourne la couleur d’un pixel.
     * @param x de type entier
     * @param y de type entier
     * @return la couleur contenue dans la forme
     */
    @Override
    public Color getPixelColor(int x, int y) {
        Point toSearch = new Point(x, y);
        for (Shape shape : shapes){
            if (shape.contains(toSearch)){
                return shape.getColor();
            }
        }
        return Color.WHITE;
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
