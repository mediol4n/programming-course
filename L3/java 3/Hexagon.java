public class Hexagon extends Figure {

    private int side;

    Hexagon(int side) {
        this.side = side;
    }

    public double area() {
        return 3*side*side*Math.sqrt(3)/2;
    }

    public double perimeter() {
        return 6*side;
    }
}