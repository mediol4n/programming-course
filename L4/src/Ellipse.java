import java.awt.*;

/** klasa Ellipse odpowiada za edycje elips
 * @see Shape
 */
public class Ellipse extends Shape {

    /** konstruktor tworzacy elipse
     * @param x wspolrzedna pozioma elipsy
     * @param y wspolrzedna pionowa elipsy
     * @param width szerokosc elipsy
     * @param height wysokosc elipsy
     * @param color kolor elips
     * @param fill zmienna mowia o tym, czy elipsa ma byc wypelniona
     */
    public Ellipse(int x, int y, int width, int height, Color color, String fill) {
        super(x, y, width, height, color, fill);
    }

    /** metoda rysujaca elipse na panelu
     * @param g2 obiekt, ktory ma zostac narysowany
     */
    @Override
    public void paint(Graphics2D g2)
    {
        if(getColor() == Color.WHITE)
        {
            g2.setColor(Color.BLACK);
            fill = "border";
        }
        else
        {
            g2.setColor(getColor());
        }
        if(fill.equals("border"))
        {
            g2.drawOval(getX(), getY(), getWidth(), getHeight());
        }
        else if(fill.equals("fill"))
        {
            g2.fillOval(getX(), getY(), getWidth(), getHeight());
        }
    }

    /** metoda sprawdzajaca czy dany punkt jest wewnatrz elipsy
     * @param point sprawdzany punkt
     * @return zwraca prawde w przypadku gdy punkt jest wewnatz
     */
    @Override
    boolean contains(Point point) {
        int radius = getWidth()/2;
        int x = getX() + radius;
        int y = getY() + radius;
        double distance = Math.sqrt((Math.pow(point.x - x, 2)) + (Math.pow(point.y - y, 2)));
        if (distance <= radius) {
            return true;
        }
        return false;
    }

}
