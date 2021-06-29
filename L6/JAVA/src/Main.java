import javax.swing.JOptionPane;
/** Klasa uruchamiająca program 
* "Drzewka"
* @author Wojciech Strzelecki
* @version 1.0
* @since 13.06.2020
 * @see Window
*/
public class Main {
    public static void main(String[] args) {
        String command = JOptionPane.showInputDialog("Jakiego typu ma być drzewo?");
        /** Tworzymy wskaźnik na drzewo danego typu */
        Window<?> window;
        switch(command) {
            /** W zależności od wybranego typu tworzymy drzewo tego typu */
            case "Integer": {
                window = new Window<Integer>(new ParserInteger());
                break;
            }
            case "Double": {
                window = new Window<Double>(new ParserDouble());
                break;
            }
            case "String": {
                window = new Window<String>(new ParserString());
                break;
            }
            default: {
                return;
            }
        }
    }
}