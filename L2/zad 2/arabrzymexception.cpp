#include "arabrzymexception.hpp"

ArabRzymException::ArabRzymException(const char *msg) noexcept(true)
{
    errorMsg = msg;
}

const char *ArabRzymException::what() const noexcept(true)
{
    return errorMsg;
}
