import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

/** klasa tworzaca panel rysujacy, pozwalajaca na modyfikowanie figur
 * @see ProgramFrame
 * @see Shape
 * @see Rectangle
 * @see Ellipse
 * @see Triangle
 * @see Main
 */
public class DrawingArea extends JPanel implements ActionListener {

    /** tworzymy nowe okno z panelem sterujacym */
    private  ProgramFrame frame;
    /** wspolrzedne punktow poczatkowego i koncowego przy rysowaniu figur */
    private int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    /** wspolrzedne tymczasowe figur */
    private int currX = 0, currY = 0, currX0 = 0, currY0 = 0, currX1 = 0, currY1 = 0,
    currX2 = 0, currY2 = 0;
    /** zmienna sluzaca do zapisywania plikow */
    private int fileCounter = 1;
    /** etykieta wyswietlajaca obraz */
    JLabel lLoad;

    /** wspolrzedne wierzcholkow trojkata */
    private int[] triangleX = {0, 0, 0};
    private int[] triangleY = {0, 0, 0};
    /** informuje metody o tym czy myszka jest przeciagana wraz ze wcisnietym lewym przyciskiem */
    private boolean mouseDragged = false;
    /** tablica wszystkich obiektow na panelu */
    private List<Shape> shapes = new ArrayList<>();
    /** aktualnie rozpatrywana figura */
    private Shape currShape;
    /** paleta kolorow ktorymi mozemy wypelnic figure */
    JPopupMenu colorPalette;
    /** przyciski odpowiadajace ze wypelnianie figury kolorem */
    JButton bRed, bOrange, bYellow, bGreen, bBlue, bPink, bBlack;

    /** konstruktor panelu */
    DrawingArea(ProgramFrame frame) {

        /**ustawienie tla na bialo */
        setBackground(Color.WHITE);
        colorPalette = new JPopupMenu();
        bRed = new JButton();
        bOrange = new JButton();
        bYellow = new JButton();
        bGreen = new JButton();
        bBlue = new JButton();
        bPink = new JButton();
        bBlack = new JButton();
        bRed.setBackground(Color.RED);
        bOrange.setBackground(Color.ORANGE);
        bYellow.setBackground(Color.YELLOW);
        bGreen.setBackground(Color.GREEN);
        bBlue.setBackground(Color.BLUE);
        bPink.setBackground(Color.PINK);
        bBlack.setBackground(Color.BLACK);

        colorPalette.add(bRed);
        colorPalette.add(bOrange);
        colorPalette.add(bYellow);
        colorPalette.add(bGreen);
        colorPalette.add(bBlue);
        colorPalette.add(bPink);
        colorPalette.add(bBlack);

        /** przypisanie komend wykorzystanych przy przechwytywaniu akcji */
        bRed.setActionCommand("red");
        bOrange.setActionCommand("orange");
        bYellow.setActionCommand("yellow");
        bGreen.setActionCommand("green");
        bBlue.setActionCommand("blue");
        bPink.setActionCommand("pink");
        bBlack.setActionCommand("black");

        bRed.addActionListener(this);
        bOrange.addActionListener(this);
        bYellow.addActionListener(this);
        bGreen.addActionListener(this);
        bBlue.addActionListener(this);
        bPink.addActionListener(this);
        bBlack.addActionListener(this);

        this.frame = frame;

        /** nasluchiwanie akcji */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                /** w przypadku klikniecia myszki paleta znika */
                colorPalette.setVisible(false);
                String mode = frame.operation();
                if (mode.equals("draw")) {
                    x1 = e.getX();
                    y1 = e.getY();
                    mouseDragged = true;
                }
            }

            public void mouseReleased(MouseEvent e) {
                String mode = frame.operation();
                if (mode.equals("draw")) {
                    x2 = e.getX();
                    y2 = e.getY();
                    mouseDragged = false;
                    draw();
                }
            }

            public void mouseClicked(MouseEvent e) {
                /** sprawdzamy aktualna operacje */
                String mode = frame.operation();

                if (mode.equals("edit")) {
                    /** jesli edytujemy to odwracamy tablice figur i szukamy pierwszej do ktorej nalezy punkt */
                    Collections.reverse(shapes);
                    for (Shape shape : shapes) {
                        if (shape.contains(e.getPoint())) {
                            currShape = shape;
                            editing(e.getX(), e.getY(), shape, e.getButton());
                            break;
                        }
                    }
                    Collections.reverse(shapes);
                }

                else if (mode.equals("save")) {
                    /** zapisujemy panel jak plik png */
                    try {
                        save();
                        JOptionPane.showMessageDialog(getRootPane(), "Image is saved");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(getRootPane(), "Failed");
                    }
                }

                else if (mode.equals("load")) {
                    /** ladujemy zdjecie do panelu */
                    load();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                /** pobieranie aktualnych wspolrzednych kursora */
                String mode = frame.operation();
                if (mode.equals("draw")) {
                    x2 = e.getX();
                    y2 = e.getY();
                    repaint();
                }
            }
        });
    }

    /** metoda wykonujaca modyfikacje figur w panelu
     * @param x wspolrzedna pozioma figury
     * @param y wspolrzedna pionowa figury
     * @param shape aktualnie modyfikowana figura
     * @param button informacja na temat aktualnie wcisnietego przycisku myszy
     */
    public void editing(int x, int y, Shape shape, int button) {
        /** przypisanie parametrow akrualnie modyfikowanej figury */
        int tempX = shape.getX();
        int tempY = shape.getY();
        int tempHeight = shape.getHeight();
        int tempWidth = shape.getWidth();
        /** przechwytywanie tymczasowych informacji o wykonywanych akcjach */
        MouseListener mouseListener;
        MouseMotionListener mouseMotionListener;


        /** jesli kliknieto prawy przycisk myszy wyswietla sie paleta */
        if (button == MouseEvent.BUTTON3) {
            colorPalette.setLocation(x, y);
            colorPalette.setVisible(true);
        }

        /** jesli kliknieto scroll figura powiekszy się */
        else if (button == MouseEvent.BUTTON2) {
            if (shape instanceof Triangle) {
                shape.setX0(shape.getX0()-10);
                shape.setX1(shape.getX1()+10);
                shape.setX2(shape.getX2());
                shape.setY0(shape.getY0()+10);
                shape.setY1(shape.getY1()+10);
                shape.setY2(shape.getY2()-10);
            } else {
                tempX = tempX - 15;
                if(tempX < 0) {
                    tempX = 0;
                }
                tempY = tempY - 15;
                if(tempY < 0) {
                    tempY = 0;
                }
                tempHeight = tempHeight + 30;
                tempWidth = tempWidth + 30;
                shape.setX(tempX);
                shape.setY(tempY);
                shape.setWidth(tempWidth);
                shape.setHeight(tempHeight);
            }
            repaint();
        }

        /** Jesli kliknieto lewy przycisk myszy mamy mozliwosc przesuwania figury */
        else if (button == MouseEvent.BUTTON1) {
            addMouseListener(mouseListener = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String mode = frame.operation();
                    if (mode.equals("edit") && shape.contains(e.getPoint())) {
                        x1 = e.getX();
                        y1 = e.getY();
                        if (shape instanceof Triangle) {

                            currX0 = shape.getX0();
                            currX1 = shape.getX1();
                            currX2 = shape.getX2();
                            currY0 = shape.getY0();
                            currY1 = shape.getY1();
                            currY2 = shape.getY2();
                        } else {

                            currX = shape.getX();
                            currY = shape.getY();
                        }
                    }
                }

            });

            addMouseMotionListener(mouseMotionListener = new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    String mode = frame.operation();
                    if (mode.equals("edit") && shape.contains(e.getPoint())) {
                        x2 = e.getX();
                        y2 = e.getY();
                        /** figure przesuwamy przypisujac jej wspolrzednym nowe wartosci */
                        if (shape instanceof Triangle) {

                            shape.setX0(currX0 + (x2 - x1));
                            shape.setX1(currX1 + (x2 - x1));
                            shape.setX2(currX2 + (x2 - x1));
                            shape.setY0(currY0 + (y2 - y1));
                            shape.setY1(currY1 + (y2 - y1));
                            shape.setY2(currY2 + (y2 - y1));
                        } else {
                            shape.setX(currX + (x2 - x1));
                            shape.setY(currY + (y2 - y1));
                        }
                        repaint();
                    }
                    return;
                }
            });
            /** konczymy proces nasluchiwania akcji poprzez usuniecie sluchaczy */
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    removeMouseListener(mouseListener);
                    removeMouseMotionListener(mouseMotionListener);
                }
            });
        }
    }

    /** metoda dodaje wybrana figure do listy wszystkich figur */
    public void draw() {
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);
            String figure = frame.figure();

            if (figure.equals("rectangle")) {
                addShape(new Rectangle(x, y, width, height, Color.BLACK, "border"));
            }

            else if (figure.equals("ellipse")) {
                addShape(new Ellipse(x, y, width, height, Color.BLACK, "border"));
            }

            else if (figure.equals("triangle")) {
                triangleX[0] = x;
                triangleX[1] = x + width;
                triangleX[2] = x + width/2;
                triangleY[0] = y + height;
                triangleY[1] = y + height;
                triangleY[2] = y;
                addShape(new Triangle(triangleX, triangleY, 3, Color.BLACK, "border"));
            }
    }

    /** metoda wypelnia figure danym kolorem
     * @param e akcja wykonana przez przycisniecie przycisku
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        currShape.setFill("fill");
        String reason = e.getActionCommand();

        if (reason.equals("red")) {
            currShape.setColor(Color.RED);
        } else if (reason.equals("orange")) {
            currShape.setColor(Color.ORANGE);
        } else if (reason.equals("yellow")) {
            currShape.setColor(Color.YELLOW);
        } else if (reason.equals("green")) {
            currShape.setColor(Color.GREEN);
        } else if (reason.equals("blue")) {
            currShape.setColor(Color.BLUE);
        } else if (reason.equals("pink")) {
            currShape.setColor(Color.PINK);
        } else if (reason.equals("black")) {
            currShape.setColor(Color.BLACK);
        }
        repaint();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    /** metoda zapisuje obraz panelu do plików
     * @throws Exception niepowodzenie zapisu
     */
    public void save() throws Exception {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        paint(image.getGraphics());
        ImageIO.write(image, "png", new File("file" + fileCounter + ".png"));
        fileCounter += 1;
        repaint();
    }

    /** metoda pozwala zaladowac tlo do panelu przy uzyciu JFileChooser */
    public void load() {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "png", "jpg");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lLoad = new JLabel();
            lLoad.setBounds(0, 0, getWidth(), getHeight());
            add(lLoad);
            /** po zaladowaniu pliku ustawia sie go jako etykiete */
            lLoad.setIcon(resizeImage(path));
            repaint();
        }
    }

    /** metoda zmienia rozmiar pliku tak aby pasowal do etykiety */
    public Icon resizeImage(String path) {
        ImageIcon myImage = new ImageIcon(path);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lLoad.getWidth(), lLoad.getHeight(), Image.SCALE_SMOOTH);
        Icon image = new ImageIcon(newImg);
        return image;
    }

    /** metoda zwraca preferowane rozmiary panelu */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 900);
    }

    /** metoda odpowiedzialna za tworzenie figur w panelu
     * @param g aktualnie rozpatrywana figura
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        String figure = frame.figure();

        if (mouseDragged == true) {
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);
            if (figure.equals("rectangle")) {
                g.drawRect(x, y, width, height);
            } else  if (figure.equals("ellipse")) {
                g.drawOval(x, y, width, height);
            } else if (figure.equals("triangle")); {
                triangleX[0] = x;
                triangleX[1] = x + width;
                triangleX[2] = x + width/2;
                triangleY[0] = y + height;
                triangleY[1] = y + height;
                triangleY[2] = y;
                g.drawPolygon(triangleX, triangleY, 3);
            }
        }

        /** rysowanie wszystkich figur w liscie */
        for (Shape shape : shapes) {
            Graphics2D g2 = (Graphics2D) g.create();
            shape.paint(g2);
            g2.dispose();
        }
    }

}
