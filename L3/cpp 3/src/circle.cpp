#include <circle.hpp>
#include <cmath>


        Circle::Circle(int radius) {
            this->radius = radius;
        }


        double Circle::area() {
            return radius*radius*M_PI;
        }

        
        double Circle::perimeter() {
            return 2*radius*M_PI;
        }