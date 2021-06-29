#include <figure.hpp>
#include <iostream>

#ifndef TETRAGON_H
#define TETRAGON_H

class Tetragon: public Figure {

    public:
        static std::string WhichTetragon(int side1, int side2, int side3, int side4, int angle);
        virtual ~Tetragon() = default;
};

#endif