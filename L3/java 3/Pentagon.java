public class Pentagon extends Figure {
    private int side;

    Pentagon(int side) {
        this.side = side;
    }

    public double area() {
        return side*side*Math.sqrt(25+10*Math.sqrt(5))/4;
    }

    public double perimeter() {
        return 5*side;
    }


}