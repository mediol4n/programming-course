#include <pentagon.hpp>
#include <cmath>


        Pentagon::Pentagon(int side) {
            this->side = side;
        }

        double Pentagon::area() {
            return side*side*sqrt(25+10*sqrt(5))/4;
        }

        double Pentagon::perimeter() {
            return 5*side;
        }
