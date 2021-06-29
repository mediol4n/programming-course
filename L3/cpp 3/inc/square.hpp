#include <tetragon.hpp>

#ifndef SQUARE_H
#define SQUARE_H

class Square: public Tetragon {
    private:
        int side;


    public:
        double area();
        double perimeter();
        Square(int side);
        virtual ~Square() = default;


};

#endif