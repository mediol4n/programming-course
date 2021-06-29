public class Main {
    public static void main(String[] args) {


        int ParArray[] = new int[args.length-1];
        for (int i = 0; i < args.length-1; i++) {
            try {
                ParArray[i] = Integer.parseInt(args[i+1]);
                if (ParArray[i] <= 0) {
                    System.out.println("Nieprawidłowe długości!");
                    return;
                }
            }

            catch (NumberFormatException ex) {
                System.out.println("Złe argumenty!");
                return;
            }
        }


        if (args.length == 2) {
            switch (args[0]) {
                case "k":
                    Circle circle = new Circle(ParArray[0]);
                    System.out.println("Pole - " + circle.area());
                    System.out.println("Obwód - " + circle.perimeter());
                    return;
                case "s":
                    Hexagon hexagon = new Hexagon(ParArray[0]);
                    System.out.println("Pole - " + hexagon.area());
                    System.out.println("Obwód - " + hexagon.perimeter());
                    return;
                case "p":
                    Pentagon pentagon = new Pentagon(ParArray[0]);
                    System.out.println("Pole - " + pentagon.area());
                    System.out.println("Obwód - " + pentagon.perimeter());
                    return;
                default:
                    System.out.println("Źle podana pierwsza dana!");
                    return;
            }
        }



        if (args.length == 6 && args[0].equals("c")) {
            
            switch (Tetragon.WhichTetragon(ParArray[0], ParArray[1], ParArray[2], ParArray[3], ParArray[4])) {
                case "square":
                    Square square = new Square(ParArray[0]);
                    System.out.println("Pole - " + square.area());
                    System.out.println("Obwód - " + square.perimeter());
                    return;
                case "rectangle":
                    Rectangle rectangle = new Rectangle(ParArray[0], ParArray[1], ParArray[2], ParArray[3]);
                    System.out.println("Pole - " + rectangle.area());
                    System.out.println("Obwód - " + rectangle.perimeter());
                    return;
                case "rhombus":
                    Rhombus rhombus = new Rhombus(ParArray[0], ParArray[4]);
                    System.out.println("Pole - " + rhombus.area());
                    System.out.println("Obwód - " + rhombus.perimeter());
                    return;
                default:
                    System.out.println("Nie dam rady obliczyć!");
                    return;
            }
        }

        if (args.length != 2 && args.length != 6) {
            System.out.println("Nieprawidłowa liczba argumentów!");
        }

        else {
            System.out.println("Źle podana pierwsza dana");
        }
        

    }
}