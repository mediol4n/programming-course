public class Square extends Tetragon {

    private int side;


    Square(int side) {
        this.side = side;
    }


    public double area() {
        return side*side;
    }

    public double perimeter() {
        return 4*side;
    }

}