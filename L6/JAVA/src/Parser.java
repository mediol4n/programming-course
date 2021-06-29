
/** Klasa tworząca parser 
@see ParserGeneric
@see ParserInteger
@see ParserDouble
@see ParserString
*/
public class Parser<T> {
    private ParserGeneric parser;

    Parser(ParserGeneric parser) {
        this.parser = parser;
    }

    @SuppressWarnings("unchecked")
    public T parseValue(String s) {
        return (T)parser.parse(s);
    }
}