#include <hexagon.hpp>
#include <cmath>


        Hexagon::Hexagon(int side) {
            this->side = side;
        }

        double Hexagon::area() {
            return 3*side*side*sqrt(3)/2;
        }

        double Hexagon::perimeter() {
            return 6*side;
        }