import javax.swing.*;

/** klasa tworząca przyciski, zmieniające kolory. Przyciski tworzone są w klasie ColorFrame
* @see Main
* @see ColorFrame
 */
public class MyButton extends JButton {

    /** Panel na którym przyciski się znajdują */
    ColorFrame frame;
    /** Zmienna mówiąca, czy wątek przypisany do przycisku jest unieruchomiony */
    boolean isActive = true;

    /** Konstruktor przycisku */
    MyButton(ColorFrame frame) {
       
       this.frame = frame;
       
    }
    /** Metoda służąca do znalezienia sąsiadów przycisku, odpowiednio sprawdzamy czy przyciski nie są na brzegach macierzy
    * @param button Przycisk dla którego szukamy sąsiadów
    * @param i Pierwsza współrzędna położenia przycisku w macierzy przycisków
    * @param j Druga współrzędna położenia przycisku w macierzy przycisków
    * @return Tablica sąsiadów
     */
    public MyButton[] neighbours(MyButton button, int i, int j) {
        int m = button.frame.m;
        int n = button.frame.n;
        if (i == (m - 1) && j < (n - 1)) {
            MyButton[] neighbours = {button.frame.colorButtons[(m+i+1)%m][j], button.frame.colorButtons[(m+i-1)%m][j], button.frame.colorButtons[i][(n+j-1)%n], button.frame.colorButtons[i][(n+j+1)%n]};
            return neighbours;
        } else if (j == (n - 1) && i < (m-1)) {
            MyButton[] neighbours = {button.frame.colorButtons[(m+i-1)%m][j], button.frame.colorButtons[(m+i+1)%m][j], button.frame.colorButtons[i][(n+j+1)%n], button.frame.colorButtons[i][(n+j-1)%n]};
            return neighbours;
        } else if (j == (n - 1) && i == (m - 1)) {
            MyButton[] neighbours = {button.frame.colorButtons[(m+i+1)%m][j], button.frame.colorButtons[(m+i-1)%m][j], button.frame.colorButtons[i][(n+j+1)%n], button.frame.colorButtons[i][(n+j-1)%n]};
            return neighbours;
        } else {
            MyButton[] neighbours = {button.frame.colorButtons[(m+i-1)%m][j], button.frame.colorButtons[(m+i+1)%m][j], button.frame.colorButtons[i][(n+j-1)%n], button.frame.colorButtons[i][(n+j+1)%n]};
            return neighbours;
        }
    }
}
