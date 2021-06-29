import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

/** Klasa tworząca okno z panelem z przyciskami oraz wątki
* @see MyButton
* @see ColorThread
* @see Main
 */
public class ColorFrame extends JFrame implements ActionListener {

    /** Zmienna mówiąca o liczbie wierzy w macierzy */
    int m;
    /** Zmienna mówiąca o liczbie wierzy w macierzy */
    int n;
    /** Zmienna mówiąca o szybkości działania */
    int k;
    /** Zmienna określająca prawdopodobieństwo zmiany koloru przycisku */
    double p;
    /** Macierz przycisków */
    MyButton colorButtons[][];

    /** Konstruktor planszy */
    ColorFrame(int m, int n, int k, double p) {

        this.m = m;
        this.k = k;
        this.n = n;
        this.p = p;
    

        setSize(800, 800); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(m, n));
        Random random = new Random();
        colorButtons = new MyButton[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /** Ustawienie przyciskom początkowego losowego koloru */
                MyButton mybutton = new MyButton(this);
                int r = random.nextInt(256);
                int g = random.nextInt(256);
                int b = random.nextInt(256);
                mybutton.setBackground(new Color(r, g, b));
                colorButtons[i][j] = mybutton;
                add(colorButtons[i][j]);
                /** Dodanie przycisku do nasłuchiwacza akcji */
                colorButtons[i][j].addActionListener(this);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /** Wywołanie wątku oraz uruchomienie go */
                ColorThread colorThread = new ColorThread(colorButtons[i][j], k, p, random, i, j);
                colorThread.start();
            }
        }

        setVisible(true);        

    }

    /** Metoda nasłuchiwająca akcji, sprawdzająca, czy przycisk trzeba zablokować, czy odblokować
    * @param e wykonana akcja
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            MyButton button = (MyButton) e.getSource();
            /** Jeśli klikniemy na przycisk, którego wątek jest uruchomiony, to go zatrzymujemy */
            synchronized(button) {
                if (button.isActive) {
                    button.isActive = false;
                } 
                /** Jeśli klikniemy na przycisk, którego wątek jest zatrzymany, to go uruchamiamy */
                else {
                    button.isActive = true;
                    button.notify();
                }
            }
        } catch (Exception ex) {}
    }





}
