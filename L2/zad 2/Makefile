all: main

main: Main.o arabrzym.o arabrzymexception.o
	g++ Main.o arabrzym.o arabrzymexception.o -o main

main.o: main.cpp
	g++ -c -Wall -Wextra main.cpp

arabrzym.o: arabrzym.cpp arabrzym.hpp
	g++ -c -Wall -Wextra arabrzym.cpp

arabrzymexception.o: arabrzymexception.cpp arabrzymexception.hpp
	g++ -c -Wall -Wextra arabrzymexception.cpp

clean:
	rm -rf *o main