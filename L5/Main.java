/**
* Klasa uruchamia program
* "Kolorowe przyciski"
* @author Wojciech Strzelecki
* @version 1.0
* @since 23.05.2020
 */

public class Main {

    /** Tworzenie planszy
    * @param args parametr funkcji main
     */
    
    public static void main(String[] args) {
        
        /** Sprawdzanie, czy została podana odpowiednia liczba agumentów */
        if (args.length == 4) {
            int paramArray[] = new int[args.length - 1];
            for (int i = 0; i < args.length - 1; i++) {
                /** Próba zamiany wartości wejściowych na liczby */
                try {
                    paramArray[i] = Integer.parseInt(args[i]);
                } catch (NumberFormatException ex) {
                    System.out.println("Złe dane początkowe");
                    return;
                }
            }
	        double p;
            try {
                p = Double.parseDouble(args[3]);
                if (p > 1) {
                    System.out.println("Złe dane początkowe");
                    return;
                }
            } catch (NumberFormatException exc) {
                System.out.println("Złe dane początkowe");
                return;
            }
            /** Tworzenie  planszy z przyciskami*/
            ColorFrame colorFrame = new ColorFrame(paramArray[0], paramArray[1], paramArray[2], p);
        }
        else {
            /** Wychwytywanie niepotrzebnej liczby argumentów */
            System.out.println("Zła liczba argumentów");
        } 
    }
}
