import java.awt.*;

/** klasa implementuje figury */

public abstract class Shape {

    /** zmienne danej figury dla elips i prostokatow */
    private int x, y;
    private int width, height;
    private Color color;
    /** zmienna fill mowi o tym czy figura jest wypelniona */
    public String fill = "border";
    /** wierzcholki trojkata */
    public int[] triangleX = {0, 0, 0};
    public int[] triangleY = {0, 0, 0};
    /** liczba wierzcholkow */
    public int topNumber = 0;

    /** Konstruktor dla prostokatow i elips
     * @param  x wspolrzedna pozioma
     * @param y wpolrzedna pionowa
     * @param width szerokosc
     * @param  height wysokosc
     * @param  color kolor
     * @param fill mówi o tym czy wypelniac figure
     */
    public Shape(int x, int y, int width, int height, Color color, String fill) {

        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    /** konstruktor dla trojkatow
     * @param  triangleX wspolrzedne poziome wierzcholkow
     * @param triangleY wspolrzedne pionowe
     * @param topNumber liczba wierzcholkow
     */
    public Shape(int[] triangleX, int[] triangleY, int topNumber, Color color, String fill) {

        for (int i = 0; i < 3; i++) {
            this.triangleX[i] = triangleX[i];
            this.triangleY[i] = triangleY[i];
        }
        this.topNumber = topNumber;
        this.color = color;
        this.fill = fill;
    }

    /** metoda sprawdza czy dany punkt jest w figurze
     * @param point dany punkt
     * @return zwraca prawde jesli punkt jest w figurze
     */
    abstract boolean contains(Point point);

    /** metoda obsluguje rysowanie figur
     * @param g2 obiekt
     */
    public abstract void paint(Graphics2D g2);

    /** metoda nadaje nowa wartosc wspolrzednej x dla elips i prostokatow
     * @param x1 nowa wartosc
     */
    public void setX(int x1) {
        x = x1;
    }

    /** metoda nadaje nowa wartosc wspolrzednej y dla elips i prostokatow
     * @param y1 nowa wartosc
     */
    public void setY(int y1) {
        y = y1;
    }

    /** metoda nadaje nowa wartosc szerokosci dla elips i prostokatow
     * @param width1 nowa wartosc
     */
    public void setWidth(int width1) {
        width = width1;
    }

    /** metoda nadaje nowa wartosc wysokosci dla elips i prostokatow
     * @param height1 nowa wysokosc
     */
    public void setHeight(int height1) {
        height = height1;
    }

    /** metoda zmienia kolor figury
     * @param c nowy kolor
     */
    public void setColor(Color c) {
        color = c;
    }

    /** metoda zmienia wypelnienie figury
     * @param f nowy tryb wypelniania
     */
    public void setFill(String f) {
        fill = f;
    }

    /** metoda informuje o trybie wypelniania
     * @return zwraca obecny tryb wypelniania
     */
    public String getFilling() {
        return fill;
    }

    /** metoda nadaje nowa wartosc wspolrzednej x pierwszego wierzcholka trojkata
     * @param x0 nowa wartosc
     */
    public void setX0(int x0) {
        triangleX[0] = x0;
    }

    /** metoda nadaje nowa wartosc wspolrzednej x drugiego wierzcholka trojkata
     * @param x1 nowa wartosc
     */
    public void setX1(int x1) {
        triangleX[1] = x1;
    }

    /** metoda nadaje nowa wartosc wspolrzednej x trzeciego wierzcholka trojkata
     * @param x2 nowa wartosc
     */
    public void setX2(int x2) {
        triangleX[2] = x2;
    }

    /** metoda nadaje nowa wartosc wspolrzednej y pierwszego wierzcholka trojkata
     * @param y0 nowa wartosc
     */
    public void setY0(int y0) {
        triangleY[0] = y0;
    }

    /** metoda nadaje nowa wartosc wspolrzednej y drugiego wierzcholka trojkata
     * @param y1 nowa wartosc
     */
    public void setY1(int y1) {
        triangleY[1] = y1;
    }

    /** metoda nadaje nowa wartosc wspolrzednej y trzeciego wierzcholka trojkata
     * @param y2 nowa wartosc
     */
    public void setY2(int y2) {
        triangleY[2] = y2;
    }


    /** metoda pobiera wartosc wysokosci figury dla
     * @return zwraca wysokosc
     */
    public int getHeight() {
        return height;
    }

    /** metoda pobiera wartosc szerokosci figury
     * @return zwraca szerokosc
     */
    public int getWidth() {
        return width;
    }

    /** metoda pobiera wartosc wspolrzednej x dla elips i prostokatow
     * @return zwraca wartosc x
     */
    public int getX() {
        return x;
    }

    /** metoda pobiera wartosc wspolrzednej y dla elips i prostokatow
     * @return zwraca wartosc y
     */
    public int getY() {
        return y;
    }

    /** metoda pobiera kolor figury
     * @return zwraca kolor
     */
    public Color getColor() {
        return color;
    }

    /** metoda pobiera wartosc wspolrzednej x pierwszego wierzcholka trojkata
     * @return zwraca wartosc x
     */
    public int getX0() {
        return triangleX[0];
    }

    /** metoda pobiera wartosc wspolrzednej x drugiego wierzcholka trojkata
     * @return zwraca wartosc x
     */
    public int getX1() {
        return triangleX[1];
    }

    /** metoda pobiera wartosc wspolrzednej x trzeciego wierzcholka trojkata
     * @return zwraca wartosc x
     */
    public int getX2() {
        return triangleX[2];
    }

    /** metoda pobiera wartosc wspolrzednej y pierwszego wierzcholka trojkata
     * @return zwraca wartosc y
     */
    public int getY0() {
        return triangleY[0];
    }

    /** metoda pobiera wartosc wspolrzednej y drugiego wierzcholka trojkata
     * @return zwraca wartosc y
     */
    public int getY1() {
        return triangleY[1];
    }

    /** metoda pobiera wartosc wspolrzednej y trzeciego wierzcholka trojkata
     * @return zwraca wartosc y
     */
    public int getY2() {
        return triangleY[2];
    }

}
