import java.awt.*;

/** klasa Triangle odpowiada za edycje trojkatow
 * @see Shape
 */
public class Triangle extends Shape {


    /** konstruktor tworzacy trojkat
     * @param triangleX tablica wspolrzednych poziomych wierzcholkow trojkata
     * @param triangleY tablica wspolrzednych pionowych wierzcholkow trojkata
     * @param topNumber liczba wierzcholkow trojkata
     * @param color kolor trojkata
     * @param fill zmienna mowia o tym, czy trojkat ma byc wypelniony
     */
    public Triangle(int[] triangleX, int[] triangleY, int topNumber, Color color, String fill) {
        super(triangleX, triangleY, topNumber, color, fill);
    }

    /** metoda rysujaca trojkat na panelu
     * @param g2 obiekt, ktory ma zostac narysowany
     */
    @Override
    public void paint(Graphics2D g2) {
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
            g2.drawPolygon(triangleX, triangleY, topNumber);
        }
        else if(fill.equals("fill"))
        {
            g2.fillPolygon(triangleX, triangleY, topNumber);
        }
    }

    /** metoda sprawdzajaca czy dany punkt jest wewnatrz trojkata
     * @param point sprawdzany punkt
     * @return zwraca prawde w przypadku gdy punkt jest wewnatz
     */
    @Override
    boolean contains(Point point) {
        int x = point.x - getX0();
        int y = point.y - getY0();
        boolean p1 = (getX1()-getX0())*y-(getY1()-getY0())*x > 0;
        if((getX2()-getX0())*y-(getY2()-getY0())*x > 0 == p1)
        {
            return false;
        }
        if((getX2()-getX1())*(point.y-getY1())-(getY2()-getY1())*(point.x-getX1()) > 0 != p1)
        {
            return false;
        }
        return true;
    }

}
