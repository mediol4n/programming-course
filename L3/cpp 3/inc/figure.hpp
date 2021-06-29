#pragma once
#ifndef FIGURE_H
#define FIGURE_H

class Figure {
    public:
        virtual double area() = 0;
        virtual double perimeter() = 0;
        virtual ~Figure() = default;


};

#endif