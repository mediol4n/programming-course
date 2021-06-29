#include <iostream>
#include <cstring>
#include "arabrzym.hpp"
#include "arabrzymexception.hpp"
using namespace std; 

int ArabRzym::aliczby[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
std::string ArabRzym::rliczby[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

int ArabRzym::LetterValue(char letter)
{
    switch (letter)
    {
    case 'I':
        return 1;
    case 'V':
        return 5;
    case 'X':
        return 10;
    case 'L':
        return 50;
    case 'C':
        return 100;
    case 'D':
        return 500;
    case 'M':
        return 1000;
    }
    return -1;
}

std::string ArabRzym::arab2rzym(int arab)
{
    if (arab >= 4000 || arab < 0)
    {
        throw ArabRzymException("Liczba spoza zakresu!");
    }
    std::string rzym = "";
    for (int i = 12; i >= 0; i--)
    {
        while (arab >= aliczby[i])
        {
            rzym += rliczby[i];
            arab -= aliczby[i];
        }
    }
    return rzym;
}

int ArabRzym::rzym2arab(std::string rzym)
{
    for (unsigned int i = 0; i < rzym.length(); i++)
    {
        rzym[i] = toupper(rzym[i]);
    }
    int arab = 0;
    int compere = 0;
    int indx = (rzym.length() - 1);
    while (indx >= 0)
    {
        if (LetterValue(rzym[indx]) == -1)
        {
            throw ArabRzymException("To nie jest liczba w zapisie Rzymskim!");
        }
        if (LetterValue(rzym[indx]) >= compere)
        {
            arab += LetterValue(rzym[indx]);
        }
        else
        {
            arab -= LetterValue(rzym[indx]);
        }
        compere = LetterValue(rzym[indx]);
        indx -= 1;
    }

    if (rzym == arab2rzym(arab))
    { //sprawdzenie poprawności zapisu
        return arab;
    }
    else
    {
        throw ArabRzymException("Liczba została źle podana!");
    }
}