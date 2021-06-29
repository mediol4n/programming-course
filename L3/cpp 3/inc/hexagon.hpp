#include <figure.hpp>

#ifndef HEXAGON_H
#define HEXAGON_H

class Hexagon: public Figure {
    private:
        int side;


    public:
        double area();
        double perimeter();
        Hexagon(int side);
        virtual ~Hexagon() = default;


};

#endif