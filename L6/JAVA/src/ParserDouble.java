
/** KLasa tworząca parser konwertujący dane do typu Double
* implementująca interfejs ParserGeneric
* @see ParserGeneric
* @see Parser
 */
public class ParserDouble implements ParserGeneric {
    @Override
    public Object parse(String s) {
        return (Object)Double.parseDouble(s);
    }
}