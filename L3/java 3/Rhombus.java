public class Rhombus extends Tetragon {


    private int side;
    private int angle;


    Rhombus(int side, int angle) {
        this.side = side;
        this.angle = angle;
    }


    public double area() {
        double angle1 = Math.toRadians(angle);
        return side*side*Math.sin(angle1);
    }

    public double perimeter() {
        return 4*side;
    }


}