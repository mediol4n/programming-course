#include <rectangle.hpp>


        Rectangle::Rectangle(int side1, int side2, int side3, int side4) {
            this->side1 = side1;
            this->side2 = side2;
            this->side3 = side3;
            this->side4 = side4;
        }

        double Rectangle::area() {
            if(side1 == side3) {
                return side1*side2;
            }
            return side1*side3;
        }

        double Rectangle::perimeter() {
            return side1 + side2 + side3 + side4;
        }
