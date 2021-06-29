#include <iostream>
#include <square.hpp>
#include <circle.hpp>
#include <rectangle.hpp>
#include <rhombus.hpp>
#include <pentagon.hpp>
#include <hexagon.hpp>
#include <tetragon.hpp>
#include <string>
using std::cout;
using std::endl;
#define Array_length 5 //maksymalna liczba argumentów potrzebnych do obliczenia pola i obwodu


int main(int argc, char* argv[]) {


    int ParArray[Array_length];
    for (int i = 0; i < argc - 2; i++) {
        std::string str(argv[i+2]);
        try {
            ParArray[i] = stoi(str);
            if (ParArray[i] <= 0) {
                cout << "Niedodatnie argumenty!" << endl;
                return 0;
            }
        }

            catch (std::invalid_argument& ex) {
                cout << "Złe argumenty!" << endl;
                return 0;
            }
        }


    if (argc == 3) {


         if (*argv[1] == 'k') {
            Circle* circle = new Circle(ParArray[0]);
            cout << "Pole - " << circle->area() << endl;
            cout << "Obwód - " << circle->perimeter() << endl;
            delete circle;
            return 0;
        }

        if (*argv[1] == 's') {
            Hexagon* hexagon = new Hexagon(ParArray[0]);
            cout << "Pole - " << hexagon->area() << endl;
            cout << "Obwód - " << hexagon->perimeter() << endl;
            delete hexagon;
            return 0;
        }            

        if (*argv[1] == 'p') {
            Pentagon* pentagon = new Pentagon(ParArray[0]);
            cout << "Pole - " << pentagon->area() << endl;
            cout << "Obwód - " << pentagon->perimeter() << endl;
            delete pentagon;
            return 0;
        }
    }

    if (argc ==  7 && *argv[1] == 'c') {

        std::string tetra = Tetragon::WhichTetragon(ParArray[0], ParArray[1], ParArray[2], ParArray[3], ParArray[4]);
        if (tetra == "square") {
            Square* square = new Square(ParArray[0]);
            cout << "Pole - " << square->area() << endl;
            cout << "Obwód - " << square->perimeter() << endl;
            delete square;
            return 0;
        }

        else if (tetra == "rectangle") {
            Rectangle* rectangle = new Rectangle(ParArray[0], ParArray[1], ParArray[2], ParArray[3]);
            cout << "Pole - " << rectangle->area() << endl;
            cout << "Obwód - " << rectangle->perimeter() << endl;
            delete rectangle;
            return 0;
        }

        else if (tetra == "rhombus") {
            Rhombus* rhombus = new Rhombus(ParArray[0], ParArray[4]);
            cout << "Pole - " << rhombus->area() << endl;
            cout << "Obwód - " << rhombus->perimeter() << endl;
            delete rhombus;
            return 0;
        }

        else {
            cout << "Nie dam rady obliczyć!" << endl;
            return 0;
        }
    }

    if (argc != 3 && argc != 7) {
        cout << "Nieprawidłowa liczba argumentów!" << endl;
        return 0;
    }

    else {
        cout << "Źle podana pierwsza dana!" << endl;
    }


}