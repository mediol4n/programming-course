
/** Klasa tworząca parser konwerujący string do typu Integer
* @see Parser
* @see ParserGeneric
 */
public class ParserInteger implements ParserGeneric {
    @Override
    public Object parse(String s) {
        return (Object)Integer.parseInt(s);
    }
}