/** Klasa tworząca wierzchołki
* @see BinaryTree
* @param <T> typ klucza wierzchołka */
public class Node<T> {

    /** Klucz wierzchołka */
    private T key;
    /** Potomkowie wierzchołka */
    Node<T> leftChild, rightChild;

    /** Konstruktor wierzchołka */
    Node(T key) {
        this.key = key;
    }

    /** Metoda zwracająca klucz wierzchołka
    @return Klucz wierzchołka */
    public T getKey() {
        return key;
    }
}

