#ifndef ARAB_RZYM_EXCEPTION_H
#define ARAB_RZYM_EXCEPTION_H
#include <exception>

class ArabRzymException : public std::exception
{
private:
    const char *errorMsg;

public:
    ArabRzymException(const char *msg) noexcept(true);
    const char *what() const noexcept(true);
};

#endif