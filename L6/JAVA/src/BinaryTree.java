/** Klasa tworząca drzewo danego typ
@param <T> typ danego drzewa  */

public class BinaryTree<T extends Comparable<T>> {

    /** Korzeń drzewa */
    private Node<T> root;


     /** Metoda dodająca wierzchołek w drzewie 
     * @param key Klucz który przypiszemy do nowego węzła
     * */
    public void addNode(T key) {

        Node<T> newNode = new Node<T>(key);

        if (root == null) {
            root = newNode;
        } else {
            Node<T> focusNode = root;
            Node<T> parent;

            while(true) {
                parent = focusNode;

                if (newNode.getKey().compareTo(focusNode.getKey()) < 0) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /** Metoda zwracająca napis będący zapis drzewa w formie inOrder
    @param focusNode Wierzchołek od którego zaczynamy wypisywanie
    @return Napis kluczy w drzewie */
    public String inOrder(Node<T> focusNode) {
        String leftS, rightS;
        if (focusNode.leftChild != null) {
            /** Wywołujemy rekurencyjnie dla lewego poddrzewa */
            leftS = "(" + inOrder(focusNode.leftChild) + ")";
        } else {
            leftS = "";
        } 

        if (focusNode.rightChild != null) {
            /** Następnie wywołujemy rekurencyjnie dla prawego poddrzewa */
            rightS = "(" + inOrder(focusNode.rightChild) + ")";
        } else {
            rightS = "";
	}
        return leftS + focusNode.getKey() + rightS;
    }

    
    /** Metoda szukająca wierzchołka o danym kluczu
     * @param key Klucz, dla którego szukamy wierzchołek
     * @return Wierzchołek o podanym kluczu lub NULL */
    public Node<T> search(T key) {
        Node<T> focusNode = root;

        while (focusNode.getKey().compareTo(key) != 0) {

            if (key.compareTo(focusNode.getKey()) < 0) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return null;
            }
        }

        return focusNode;
    }


    /** Metoda usuwająca wierzchołek z drzewa 
     * @param key Klucz który chcemy w drzewa usunąć */
    public void delete(T key) {

        Node<T> focusNode = root;
        Node<T> parent = root;

        boolean isLeftChild = true;

        while (focusNode.getKey().compareTo(key) != 0) {
            parent = focusNode;

            if (key.compareTo(focusNode.getKey()) < 0) {
                isLeftChild = true;
                focusNode = focusNode.leftChild;
            } else {
                isLeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return;
            }
        }

        /** Sprawdzamy ilu potomków ma wierzchołek który chcemy usunąć */
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        }

        else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.rightChild;
            }
        }

        /** W przypadku, gdy wierzchołek ma obu synów wywołujemy metodę odpowiednio zamieniającą miejscami pozostałe wierzchołki */
        else {
            Node<T> replacement = getReplacementNode(focusNode);

            if (focusNode == root) {
                root = replacement;
            } else if (isLeftChild) {
                parent.leftChild = replacement;
            } else {
                parent.rightChild = replacement;
            }

            replacement.leftChild = focusNode.leftChild;
        }

    }

    /** Metoda służąca do zastępowania usuwanego wierzchołka
     * @param replacedNode Usuwany wierzchołek
     * @return Wierzchołek którym zastąpimy usuwany wierzchołek */    
    public Node<T> getReplacementNode(Node<T> replacedNode) {
        Node<T> replacementParent = replacedNode;
        Node<T> replacement = replacedNode;
        Node<T> focusNode = replacedNode.rightChild;

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }

    /** Metoda zwracająca Korzeń drzewa
    @return Korzeń drzewa */
    public Node<T> getRoot() {
        return root;
    }


}
