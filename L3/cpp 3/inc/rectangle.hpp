#include <tetragon.hpp>

#ifndef RECTANGLE_H
#define RECTANGLE_H

class Rectangle: public Tetragon {
    private:
        int side1, side2, side3, side4;


    public:
        double area();
        double perimeter();
        Rectangle(int side1, int side2, int side3, int side4);
        virtual ~Rectangle() = default;


};

#endif