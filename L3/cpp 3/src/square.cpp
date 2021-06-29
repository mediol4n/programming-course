#include <square.hpp>



        Square::Square(int side) {
            this->side = side;
        }


        double Square::area() {
            return side*side;
        }

        double Square::perimeter() {
            return 4*side;
        }

