#include <iostream>
#include <math.h>
#include <cstdlib>

using namespace std;
class LiczbyPierwsze
{
private:
    int rozmiar;
    int *tablica;

public:
    LiczbyPierwsze(int n)
    {
        rozmiar = 0;
        for (int i = 2; i <= n; i++)
        {
            if (pierwsza(i))
            {
                rozmiar++;
            }
        }
        tablica = new int[rozmiar];
        int licznik = 0;
        for (int i = 2; i <= n; i++)
        {
            if (pierwsza(i))
            {
                tablica[licznik] = i;
                licznik++;
            }
        }
    }
    int liczba(int m)
    {
        if (m < rozmiar && m >= 0)
        {
            return tablica[m];
        }
        throw(string) "liczba spoza zakresu";
    }
    ~LiczbyPierwsze()
    {
        delete[] tablica;
    };

private:
    bool pierwsza(int p)
    {
        for (int i = 2; i <= sqrt(p); i++)
        {
            if (p % i == 0)
            {
                return false;
            }
        }
        return true;
    }
};