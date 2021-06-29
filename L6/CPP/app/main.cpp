#include "consoleReader.hpp"
#include <iostream>
#include <string>
#include <cstdlib>
using std::string;
using std::cin;
using std::cout;
using std::endl;

/** Klasa uruhamia program
 * "Drzewka"
 * @author Wojciech Strzelecki
 * @version 1.0
 * @since 13.05.2020
*/

int main(int argc, char* argv[]) {
    /** Sprawdzanie jaki typ drzewa wybrał użytkownik 
     * Następnie tworzymy konsolę  od danego typu 
    */
    if (argc > 1) {
        string str(argv[1]);
        if (str == "integer") {
            ConsolReader<int> *console = new ConsolReader<int>();
            console->run();
            delete console;
        } else if (str == "double") {
            ConsolReader<double> *console = new ConsolReader<double>();
            console->run();
            delete console;
        } else if (str == "string") {
            ConsolReader<string> *console = new ConsolReader<string>();
            console->run();
            delete console;
        } else {
            return 0;
        }

    }

    return 0;
}









