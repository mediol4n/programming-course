
/** Klasa tworząca parser konwerujący string do typu Double
* @see Parser
* @see ParserGeneric 
*/
public class ParserString implements ParserGeneric {
    @Override
    public Object parse(String s) {
        return (Object)s;
    }
}