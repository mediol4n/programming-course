#include <iostream>

#ifndef NODE_H
#define NODE_H
/** Klasa wierzchołka w drzewie 
 * @tparam Typ klucza wierzchołka 
 * */
template <typename T>
class Node {
    private:
        /** klucz wierzchołka */
        T key;
    public:
        /** Lewy potomek wierzchołka */
        Node<T> *leftChild;
        /** Prawy potomek wierzchołka */
        Node<T> *rightChild;

        /** Konstruktor
         * @param key Klucz */
        Node(T key) {
            this->key = key;
            leftChild = nullptr;
            rightChild = nullptr;
        }

        /** Metoda zwracjąca klucz
         * @returns Klucz wierzchołka */
        T getKey() {
            return key;
        }

        /** Metoda ustawiająca nowego lewego potomka
         * @param l Wskaźnik na nowego potomka */
        void setLeft(Node<T> *l) {
            leftChild = l;
        }

        /** Metoda ustawiająca nowego prawego potomka
         * @param r Wskaźnik na nowego potomka */
        void setRight(Node<T> *r) {
            rightChild = r;
        }

        /** Metoda ustawiająca nową wartość klucza 
         * @param d Nowy klucz */
        void setKey(T d) {
            key = d;
        }

        /** Metoda sprawdzająca czy wierzchołek ma lewego syna
         * @returns Prawdę, jeśli lewy syn istnieje. W przeciwnym wypadku fałsz */
        bool isLeft() {
            if(leftChild == nullptr) {
                return false;
            }
            return true;
        }

        /** Metoda sprawdzająca czy wierzchołek ma prawego syna
         * @returns Prawdę, jeśli prawy syn istnieje. W przeciwnym wypadku fałsz */
        bool isRight() {
            if(rightChild == nullptr) {
                return false;
            }
            return true;
        }

        /** Metoda zwracająca wskaźnik na lewego syna
         * @returns Wskaźnik na lewego syna */
        Node<T>* getLeft() {
             return leftChild;
        }

        /** Metoda zwracająca wskaźnik na prawego syna
         * @returns Wskaźnik na prawego syna */
        Node<T>* getRight() {
             return rightChild;
        }

        /** Destruktor */
        ~Node<T>() {
        }
};

#endif