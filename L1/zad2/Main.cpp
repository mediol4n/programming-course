#include <iostream>
#include <string>
#include <stdexcept>
#include "LiczbyPierwsze.h"

int main(int argc, char *argv[])
{
    if (argc >= 2)
    {
        int n;
        try
        {
            n = stoi(argv[1]);
        }
        catch (std::invalid_argument &ex)
        {
            cout << argv[1];
            cout << " - nieprawidłowy zakres " << endl;
            return 0;
        }
        if (n > 1)
        {
            LiczbyPierwsze *TablicaLiczbPierwszych = new LiczbyPierwsze(n);
            for (int i = 2; i < argc; i++)
            {
                int l;
                cout << argv[i];
                cout << " - ";
                try
                {
                    int l = stoi(argv[i]);
                    cout << TablicaLiczbPierwszych->liczba(l) << endl;
                }
                catch (string w)
                {
                    cout << w << endl;
                }
                catch (std::invalid_argument &ex)
                {
                    cout << "nieprawidłowa dana" << endl;
                }
            }
            delete TablicaLiczbPierwszych;
        }
        else
        {
            cout << "Brak liczb pierwszych mniejszych od 2!" << endl;
        }
    }
    return 0;
}