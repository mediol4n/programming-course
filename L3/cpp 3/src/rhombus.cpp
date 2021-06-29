#include <rhombus.hpp>
#include <cmath>


        Rhombus::Rhombus(int side, int angle) {
            this->side = side;
            this->angle = angle;
        }

        double Rhombus::area() {
            double angle1 = angle*M_PI/180;
            return side*side*sin(angle1);
        }

        double Rhombus::perimeter() {
            return 4*side;
        }

