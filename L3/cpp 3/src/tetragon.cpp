#include <tetragon.hpp>
#include <string>

std::string Tetragon::WhichTetragon(int side1, int side2, int side3, int side4, int angle) { //sprawdzanie jaki czworokat zostal podany

    if (side1 == side2 && side1 == side3 && side1 == side4 && angle == 90) {
        return "square";      
    }

    if (side1 == side2 && side3 == side4 && angle == 90) {
        return "rectangle";
    }

    if (side1 == side3 && side2 == side4 && angle == 90) {
        return "rectangle";
    }

    if (side1 == side4 && side2 == side3 && angle == 90) {
        return "rectangle";
    }

    if(side1 == side2 && side1 == side3 && side1 == side4 && angle > 0 && angle < 180) {
        return "rhombus";
    }

    return " ";
}

