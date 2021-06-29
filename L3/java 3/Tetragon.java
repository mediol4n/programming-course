abstract public class Tetragon extends Figure {


    public static String WhichTetragon(int side1, int side2, int side3, int side4, int angle) { //sprawdzam z jakim czworokątem mam do czynienia
        
        if(side1 == side2 && side1 == side3 && side1 == side4 && angle == 90) {
            return "square";
        }
        
        else if (side1 == side2 && side1 == side3 && side1 == side4 && angle > 0 && angle < 180) {
            return "rhombus";
        }

        if (side1 == side2 && side3 == side4 && angle == 90) {
            return "rectangle";
        }

        if (side1 == side3 && side2 == side4 && angle == 90) {
            return "rectangle";
        }

        if (side1 == side4 && side2 == side3 && angle == 90) {
            return "rectangle";
        }

        return "";

    }
}