#ifndef ARABRZYM_H
#define ARABRZYM_H

#include <string>

class ArabRzym
{
private:
    static std::string rliczby[13];
    static int aliczby[13];

private:
    static int LetterValue(char letter);

public:
    static int rzym2arab(std::string rzym);
    static std::string arab2rzym(int arab);
};

#endif