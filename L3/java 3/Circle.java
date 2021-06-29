public class Circle extends Figure {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public double area() {
        return radius*radius*Math.PI;
    }

    public double perimeter() {
        return 2*radius*Math.PI;
    }
}