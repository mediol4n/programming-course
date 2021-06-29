import java.awt.*;
import java.util.Random;

/** Klasa wątku 
* @see ColorFrame
* @see MyButton
* @see Main
 */
public class ColorThread extends Thread {

    /** Przycisk przypisany do danego wątku */
    MyButton threadButton;
    /** Prawdopodobieństwo zmiany koloru przycisku */
    double p;
    /** Szybkość działania wąstku */
    long k;
    /** Generator pseudolosowy */
    Random random;
    /** Położenie przycisku w macierzy w planszy */
    int i, j;

    /** Konstruktor wątku */
    ColorThread(MyButton threadButton, long k, double p, Random random, int i, int j) {
        this.threadButton = threadButton;
        this.k = k;
        this.p = p;
        this.random = random;
        this.i = i;
        this.j = j;
    }

    /** Metoda opisująca działanie wątku */
    public void run() {
        while (true) {

            /** Sprawdzam, czy nie wykonaliśmy akcji w celu zatrzymania wątku */
            if (!threadButton.isActive) {
                try {
                    synchronized(threadButton) {
                        /** Metoda uruchamiana w przypadku klinięcia przycisku */
                        threadButton.wait();
                    }
                } catch (InterruptedException e) {}
            } else {

                /** Tworzymy tablicę sąsiadów */
                MyButton[] neighbours = threadButton.neighbours(threadButton, i, j);
                double probabilityNum = p*100;
                int newNum = random.nextInt(100);
                /** Z podanym Prawdopodobieństwem p zmieniamy kolor przycisku na losowy lub pobieramy kolory sąsiadów 
                i ustawiamy kolor przycisku jako średni z nich */
                    if (newNum <= probabilityNum) {
                        setRandomColor(threadButton);
                    } else {
                        setAverageColor(threadButton, neighbours);
                    }
                  

        
                double sleepTime =  k * (0.5 + random.nextDouble());
                try {
                    /** Usypiamy wątek na czas z przedziału [0.5k, 1.5k] */
                    sleep((long) sleepTime);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /** Metoda ustawia przyciskowi losowy kolor */
    private void setRandomColor(MyButton button) {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        button.setBackground(new Color(r, g, b));
    }

    /** Metoda ustawiająca przyciskowi kolor jako średnią z kolorów jego sąsiadów */
    private void setAverageColor(MyButton button, MyButton[] neighbours) {
        int red = 0, green = 0, blue = 0;
        for (int i = 0; i < neighbours.length; i++) {
            synchronized(neighbours[i]) {
                if (neighbours[i].isActive) {
                    red += neighbours[i].getBackground().getRed();
                    green += neighbours[i].getBackground().getGreen();
                    blue += neighbours[i].getBackground().getBlue();
                }
            }
        }
        Color newColor = new Color(red/(neighbours.length), green/(neighbours.length), blue/(neighbours.length));
        /** Ustawiam kolor średni */
        synchronized(button) {
            button.setBackground(newColor);
        }
    }


}