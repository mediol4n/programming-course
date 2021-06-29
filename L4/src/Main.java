/** Klasa uruchamia program
 * "Prosty edytor graficzny WS"
 * @author Wojciech Strzelecki
 * @version 1.0
 * @since 01.05.2020
 */

public class Main {

    /** Tworzenie obiektu
     * tworzenie okna i oraz panelu rysujacego
     * @param args parametr funkcji main
     */

    public static void main(String[] args) {
        ProgramFrame frame = new ProgramFrame();
        frame.add(new DrawingArea(frame));
    }
}
