#include <tetragon.hpp>

#ifndef RHOMBUS_H
#define RHOMBUS_H

class Rhombus: public Tetragon {
    private:
    int side, angle;


    public:
        double area();
        double perimeter();
        Rhombus(int side, int angle);
        virtual ~Rhombus() = default;


};

#endif