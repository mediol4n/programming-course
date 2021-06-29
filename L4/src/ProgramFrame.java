import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/** klasa tworzaca panel sterujacy edytora
 * @see DrawingArea
 * @see Shape
 * @see Rectangle
 * @see Triangle
 * @see Ellipse
 */
public class ProgramFrame extends JFrame implements ActionListener {

    /** panel sterujacy zawierajacy opcje wyboru figur, zapisywania, wczytywania, informacji o programie */
    private JMenuBar menuBar;
    /** przyciski pozwalajace wybrac opcje */
    private JRadioButton bEllipse, bRectangle, bTriangle, bDraw, bEdit;
    /** grupy laczace menu */
    private ButtonGroup group, mode;
    /** zmienne mowiace o obecnie rozpatrywanej figurze i dzialaniu */
    public String currentOperation = "null";
    public String currentFigure = "null";

    /** konstruktor okna */
    ProgramFrame() {

        super("Prosty edytor graficzny WS");
        setSize(1200, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        bEllipse = new JRadioButton("Ellipse");
        bRectangle = new JRadioButton("Rectangle");
        bTriangle = new JRadioButton("Triangle");
        bDraw = new JRadioButton("Draw");
        bEdit = new JRadioButton("Edit");
        JMenu figure = new JMenu("Figures");
        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");
        JMenu about = new JMenu("About");
        JMenuItem info = new JMenuItem("Info");
        mode = new ButtonGroup();
        mode.add(bDraw);
        mode.add(bEdit);
        figure.add(bEllipse);
        figure.add(bRectangle);
        figure.add(bTriangle);
        menuBar.add(figure);
        file.add(save);
        file.add(load);
        menuBar.add(file);
        about.add(info);
        menuBar.add(about);
        menuBar.add(bDraw);
        menuBar.add(bEdit);
        setJMenuBar(menuBar);
        group = new ButtonGroup();
        group.add(bEllipse);
        group.add(bRectangle);
        group.add(bTriangle);
        /** przypisanie komend wykorzystanych przy przechwytywaniu akcji */
        info.setActionCommand("info");
        load.setActionCommand("load");
        save.setActionCommand("save");
        bEllipse.setActionCommand("ellipse");
        bRectangle.setActionCommand("rectangle");
        bTriangle.setActionCommand("triangle");
        bEdit.setActionCommand("edit");
        bDraw.setActionCommand("draw");
        info.addActionListener(this);
        load.addActionListener(this);
        save.addActionListener(this);
        bEllipse.addActionListener(this);
        bRectangle.addActionListener(this);
        bTriangle.addActionListener(this);
        bEdit.addActionListener(this);
        bDraw.addActionListener(this);


        setLayout(new GridLayout());
        setVisible(true);

    }

    /** metoda przechwytujaca zdarzenia
     * @param e wykonane zdarzenie
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String reason = e.getActionCommand();
        /** ustawianie tymczasowej  rozpatrywanej figury */
        if (reason.equals("ellipse")) {
            currentFigure = "ellipse";
        } else if (reason.equals("rectangle")) {
            currentFigure = "rectangle";
        } else if (reason.equals("triangle")) {
            currentFigure = "triangle";
        }
        String whichMode = e.getActionCommand();
        /** ustawienie tymczasowej rozpatrywanej operacji */
        if (whichMode.equals("edit")) {
            currentOperation = "edit";
        } else if (whichMode.equals("draw")) {
            currentOperation = "draw";
        } else if (whichMode.equals("save")) {
            currentOperation = "save";
        } else if (whichMode.equals("load")) {
            currentOperation = "load";
        } else if (whichMode.equals("info")) {
            /** wyswietlenie okna z informacjami */
            ImageIcon info = new ImageIcon("Instr.png");
            JOptionPane.showMessageDialog(null, null, "Info", JOptionPane.INFORMATION_MESSAGE, info);
        }
    }

    /** metoda zwraca informacje o obecnie rozpatrywanej figurze
     * @return zwraca nazwe figury
     */
    public String figure() {
        return currentFigure;
    }

    /** metoda zwraca informacje o obecnie wykonywanej operacji
     * @return zwraca nazwe operacji
     */
    public String operation() {
        return currentOperation;
    }



}
