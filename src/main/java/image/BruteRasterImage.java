package image;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image {
    private Color[][] pixels;
    private int width;
    private int height;

    /*
     * Constructeur de l'objet
     * @param une couleur de type Color et deux entiers pour la largeur et la hauteur de la fenetre.
     */
    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentatiion();
        for (int row = 0; row < width; row++){
            for (int column = 0; column < height ; column++){
                this.pixels[row][column] = color;
            }
        }
    }

    public BruteRasterImage(Color[][] pixels){

    }

    /*
     * La fonction alloue la tableau pixels.
     */
    public void createRepresentatiion(){
        this.pixels = new Color[this.width][this.height];
    }

    /*
     * Modifie la valeur de width
     * @param un entier
     */
    protected void setWidth(int width){
        this.width = width;
    }

    /*
     * Modifie la valeur de height
     * @param un entier
     */
    protected void setHeight(int height){
        this.height = height;
    }

    /*
     * Change la valeur du pixel a la position donnee
     * @param une color, et la position donnee par x et y.
     */
    public void setPixelColor(Color color, int x, int y){
        this.pixels[x][y] = color;
    }

    /*
     * recopie la matrice passe en parametre.
     * @param matrice de Color
     */
    private void setPixelsColor(Color[][] pixels){
        this.pixels = pixels.clone();
    }

    /*
     * La fonction initialise tous les pixels de la matrice a la meme couleur.
     * @param une couleur de type Color.
     */
    private void setPixelsColor(Color color){
        for (int row = 0; row < this.width; row++ ){
            for (int column = 0; column < this.height; column++){
                this.pixels[row][column] = color;
            }
        }
    }

    /*
     * Rnvoie le pixel aux coordonne x, y.
     * @param Deux entiers qui represente l'abscisse et l'ordonnee.
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
