import java.awt.*;

/** klasa Rectangle odpowiada za edycje prostokatow
 * @see Shape
 */

public class Rectangle extends Shape {

    /** Konstruktor tworzacy prostokat
     * @param x wspolrzedna pozioma prostokata
     * @param y wspolrzedna pionowa prostokata
     * @param width szerokosc prostokata
     * @param height wysokosc prostokata
     * @param color kolor prostokata
     * @param fill zmienna mowia o tym, czy prostokat ma byc wypelniony
     */
    public Rectangle(int x, int y, int width, int height, Color color, String fill) {
        super(x, y, width, height, color, fill);
    }

    /** metoda rysujaca prostokat na panelu
     * @param g2 obiekt, ktory ma zostac narysowany
     */
    @Override
    public void paint(Graphics2D g2) {
        g2.setColor(getColor());
        if(getColor() == Color.WHITE)
        {
            g2.setColor(Color.BLACK);
            fill = "border";
        }
        if(fill.equals("border"))
        {
            g2.drawRect(getX(), getY(), getWidth(), getHeight());
        }
        else if(fill.equals("fill"))
        {
            g2.fillRect(getX(), getY(), getWidth(), getHeight());
        }
    }

    /** metoda sprawdzajaca czy dany punkt jest wewnatrz prostokata
     * @param point sprawdzany punkt
     * @return zwraca prawde w przypadku gdy punkt jest wewnatz
     */
    @Override
    boolean contains(Point point) {
        if((point.x > getX() && point.x < (getX() + getWidth())) && (point.y > getY() && point.y < (getY()+getHeight()))) {
            return true;
        }
        return false;
    }
}
