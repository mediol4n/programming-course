import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Klasa okna służąca do wykonywania operacji na drzewie
@see BinaryTree
@see Node
@param <T> typ naszego drzewa */
public class Window<T extends Comparable<T>> extends JFrame implements ActionListener {
    /** Przyciski w interfejsie */
    JButton insert, delete, search, draw;
    /** Drzewo na którym wykonujemy operacje */
    BinaryTree<T> tree;
    /** Parser służacy do dobierania typów */
    private Parser<T> parser;

    /** Konstruktor okna */
    Window(ParserGeneric parser) {

        setLayout(new GridLayout());
        this.parser = new Parser<T>(parser);
        tree = new BinaryTree<T>();
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /** Dodawanie przycisków */
        insert = new JButton("INSERT");
        insert.addActionListener(this);
        add(insert);
        delete = new JButton("DELETE");
        add(delete);
        delete.addActionListener(this);
        search = new JButton("SEARCH");
        add(search);
        search.addActionListener(this);
        draw = new JButton("DRAW");
        add(draw);
        draw.addActionListener(this);

        setVisible(true);
    }


    /** Metoda służąca do nasłuuchiwania akcji */
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        /** Sprawdzamy który przycisk został wciśnięty i wykonujemy operacje
        W przypadku nieudanej operacji wyświetlamy okno dialogowe z błędem */
        if (button == insert) {
            String command = JOptionPane.showInputDialog("Co dodać szefie?");
            try {
                tree.addNode(parser.parseValue(command));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Nie udało się wprowadzić danej");
            }
        } else if (button == delete) {
            String command = JOptionPane.showInputDialog("Co usunąć szefie?");
            try {
                tree.delete(parser.parseValue(command));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Szefie złe dane usuwasz");
            }
        } else if (button == search) {
            String command = JOptionPane.showInputDialog("Co znaleźć szefie?");
            try {
                Node<T> focusNode = tree.search(parser.parseValue(command));
                /** Sprawdzamy, czy wierzchołek nie jest pusty */
                if (focusNode != null) {
                    JOptionPane.showMessageDialog(this, "Znalazłem szefie");
                } else {
                    JOptionPane.showMessageDialog(this, "Nie znalazłem szefie");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Szefie złych danych szukasz");
            }
        } else if (button == draw) {
            if (tree.getRoot() != null) {
                JOptionPane.showMessageDialog(this, "In Order: " + tree.inOrder(tree.getRoot()));
            } else {
                JOptionPane.showMessageDialog(this, "Drzewo jest puste szefie");
            }
        }
    }
}
