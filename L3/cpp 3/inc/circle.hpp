#include <figure.hpp>

#ifndef CIRCLE_H
#define CIRCLE_H

class Circle: public Figure {
    private:
        int radius;


    public:
        double area();
        double perimeter();
        Circle(int radius);
        virtual ~Circle() = default;


};

#endif