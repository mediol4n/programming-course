#include "binaryTree.hpp"
#include <exception>
#include <string>
#ifndef CONSOLEREADER_H
#define CONSOLEREADER_H

/** Klasa czytnika konsoli
 * @tparam typ drzewa na którym wykonujemy operacje */
template <typename T>
class ConsolReader {
    private:
        /** Drzewo na którym pracujemy */
        BinaryTree<T> *tree;

    public:
        /** Konstruktor czytnika */
        ConsolReader() {
            tree = new BinaryTree<T>();
        }

        /** Metoda pozwalająca wypisać w konsoli operacje jakie chcemy zrobić na drzewie */
        void run() {
            while(true) {
                /** Komenda mówiąca o operacji */
                std::string command;
                std::cin >> command;

                if (command == "draw") {
                    try {
                        /** Drukowanie drzewa */
                        tree->inOrder(tree->getRoot());
                        std::cout << " " << std::endl;
                    } catch (const std::exception &e) {}
                } 

                else if (command == "exit") {
                    try {
                        /** Koniec pracy */
                        return;
                    } catch (const std::exception &e) {}

                } else {
                    /** Wartość jaką chcemy wprowadzić/sprawdzić/usunąć */
                    T value;
                    std::cin >> value;
                    /** Obrona przed niewłaściwym wpisywaniem do konsoli */
                    while(std::cin.fail()) {
                        std::cin.clear();
                        std::cin.ignore();
                        std::cin >> value;
                    }

                    if (command == "insert") {
                        /** Wpisywanie wartości do drzewa */
                        tree->addNode(value);
                    }
                    else if (command == "delete") {
                        try {
                            /** Usuwanie wartości z drzewa */
                            tree->remove(value);
                        } catch (const std::exception &e) {}                    
                    }

                    else if (command == "search") {
                        try {
                            /**Szukanie wartości w drzewie */
                            Node<T>* node = tree->search(value);
                            if (node != nullptr) {
                                std::cout << "Znalazlem" << std::endl;
                            } else {
                                std::cout << "Nie znalazlem" << std::endl;   
                            }
                        } catch (const std::exception &e) {}
                    }

               }
            }
        }

        /** Destruktor */
        ~ConsolReader<T>() {
            delete tree;
        }
};

#endif