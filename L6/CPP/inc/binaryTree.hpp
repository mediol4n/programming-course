#include "node.hpp"
#include <string>
#include <iostream>
#ifndef BINARYTREE_H
#define BINARYTREE_H

/** Klasa drzewa binarnego
 * @see Node<T>
 * @tparam Typ tworzonego drzewa
 */
template <typename T>
class BinaryTree {
    private:
        /** Wierzchołek drzewa */
        Node<T>* root;
    public:
        /** Konstruktor drzewa */
        BinaryTree() {
            root = nullptr;
        }

        /** Metoda dodająca wierzchołek w drzewie 
         * @param key Klucz który przypiszemy do nowego węzła
         * */
        void addNode(T key) {
            Node<T>* node = new Node<T>(key);

            if(root == nullptr) {
                root = node;
                return;
            } else {  

                Node<T> *focusNode = root;
                Node<T> *parent = root;

                while(true) {
                    parent = focusNode;

                    if (key < focusNode->getKey()) {
                        focusNode = focusNode->getLeft();
                        if (focusNode == nullptr) {
                            parent->setLeft(node);
                            return;
                        }
                    }
                    else {
                        focusNode = focusNode->getRight();
                        if (focusNode == nullptr) {
                            parent->setRight(node);
                            return;
                        }
                    }
                }  
            }
        }

        /** Metoda drukująca drzewo metodą in order
         * @param focusNode Wierzchołek od którego zaczynamy wypisywanie */
        void inOrder(Node<T>* focusNode) {
            if (focusNode->isLeft()) {
                std::cout << "(";
                /** rekurencyjnie uruchamiamy metodę dla lewego poddrzewa */
                inOrder(focusNode->getLeft());
                std::cout << ")";
            }
            if (root != nullptr) {
                std::cout << focusNode->getKey();
            }
            if (focusNode->isRight()) {
                std::cout << "(";
                /** Następnie wywołujemy metodę dla prawego poddrzewa */
                inOrder(focusNode->getRight());
                std::cout << ")";
            }
        }

        /** Metoda szukająca wierzchołka o danym kluczu
         * @param key Klucz, dla którego szukamy wierzchołek
         * @returns Wierzchołęk o podanym kluczu lub NULL */
        Node<T>* search(T key) {
            if (root == nullptr) {
                return nullptr;
            }

            Node<T>* focusNode = root;

            while (focusNode->getKey() != key) {
                if (key < focusNode->getKey()) {
                    focusNode = focusNode->leftChild;
                } else {
                    focusNode = focusNode->rightChild;
                }

                if (focusNode == nullptr) {
                    return nullptr;
                }
            }

            return focusNode;
        }

        /** Metoda usuwająca wierzchołek z drzewa 
         * @param key Klucz który chcemy w drzewa usunąć */
        void remove(T key) {
            if (root == nullptr) {
                return;
            }

            Node<T> *ptr = root;
            Node<T> *parent = root;
            bool isItALeftChild = true;

            /** Szukamy wierzchołka o podanym kluczu */
            while (ptr->getKey() != key) {
                parent = ptr;

                if (key < ptr->getKey()) {
                    isItALeftChild = true;
                    ptr = ptr->getLeft();
                }
                else {
                    isItALeftChild = false;
                    ptr = ptr->getRight();
                }

                if (ptr == nullptr) {
                    return;
                }
            }

            /** Sprawdzamy, czy dany wierzchołek ma potomków aby złożyć drzewo w całość */
            if (!ptr->isLeft() && !ptr->isRight()) {
                if (ptr == root) {
                    root = nullptr;
                    delete root;    
                } else if (isItALeftChild) {
                    parent->setLeft(nullptr);
                    delete parent->getLeft();
                } else {
                    parent->setRight(nullptr);
                    delete parent->getRight();
                }
            }
                    
            else if (!ptr->isRight()) {
                if (ptr == root) {
                    root = ptr->getLeft();
                } else if (isItALeftChild) {
                    parent->setLeft(ptr->getLeft());
                } else {
                    parent->setRight(ptr->getLeft());
                }
                delete ptr;
            }

            else if (!ptr->isLeft()) {
                if (ptr == root) {
                    root = ptr->getRight();
                } else if (isItALeftChild) {
                    parent->setLeft(ptr->getRight());
                } else {
                    parent->setLeft(ptr->getRight());
                }
                delete ptr;
            }

            /** W przypadku, gdy drzewo ma oboje potomków wywołujemy metodę getReplacementNode */
            else {
                Node<T> *replacement = getReplacementNode(ptr);

                if (ptr == root) {
                    root = replacement;
                } else if (isItALeftChild) {
                    parent->setLeft(replacement);
                } else {
                    parent->setRight(replacement);
                }

                replacement->setLeft(ptr->getLeft());
                delete ptr;
            }

        }

        /** Metoda służąca do zastępowania usuwanego wierzchołka
         * @param replacedNode Usuwany wierzchołek
         * @returns Wierzchołek którym zastąpimy usuwany wierzchołek */
        Node<T>* getReplacementNode(Node<T> *replacedNode) {
            Node<T> *replacementParent = replacedNode;
            Node<T> *replacement = replacedNode;
            Node<T> *focusNode = replacedNode->getRight();

            while (focusNode != nullptr) {
                replacementParent = replacement;
                replacement = focusNode;
                focusNode = focusNode->getLeft();
            }

            if (replacement != replacedNode->getRight()) {
                replacementParent->setLeft(replacement->getRight());
                replacement->setRight(replacedNode->getRight());
            }

            delete replacementParent;
            return replacement;
        }
       
        /** Metoda zwraca korzeń drzewa 
         * @returns Korzeń drzewa */
        Node<T>* getRoot() {
            return root;
        }

          /** Destruktor */
        ~BinaryTree<T>() {
            deleteTree(root);
        }

    private:
        /** Metoda usuwa wszystkie wierzchołki drzewa
         * @param node Wierzchołek od którego zaczynamy usuwanie */
        void deleteTree(Node<T>* node) {  
            if (node == nullptr) { 
                return;  
            }
            deleteTree(node->leftChild);  
            deleteTree(node->rightChild);  
            delete node; 
        } 

      
};

#endif