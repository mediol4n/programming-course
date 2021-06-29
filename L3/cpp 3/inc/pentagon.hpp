#include <figure.hpp>

#ifndef PENTAGON_H
#define PENTAGON_H

class Pentagon: public Figure {
    private:
        int side;


    public:
        double area();
        double perimeter();
        Pentagon(int side);
        virtual ~Pentagon() = default;


};

#endif