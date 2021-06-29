#include<iostream>
#include<string>
#include"arabrzym.hpp"
#include"arabrzymexception.hpp"
using std::cout;
using std::endl;
using std::atoi;

int main(int argc, char* argv[]) {
    if (argc >= 2) { 
        for (int i = 1; i < argc; i++) {
            std::string str(argv[i]);
            try {
                int n = stoi(str);
                cout << n << " - ";
                cout << ArabRzym::arab2rzym(n) << endl;
            }
            catch (const ArabRzymException& errorMsg) {
                cout << errorMsg.what() << endl;
            }
            catch (std::invalid_argument& ex) {
                try {
                    cout << str + " - ";
                    cout <<  ArabRzym::rzym2arab(str) << endl;
                }
                catch (const ArabRzymException& msg) {
                    cout << msg.what() << endl;
                }
            }
        }
    }
    return 0;
}