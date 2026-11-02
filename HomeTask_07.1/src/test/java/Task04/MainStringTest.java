package Task04;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MainStringTest {
 @Test void constructors() { assertEquals(0,new MainString().getLength()); assertEquals("x",new MainString('x').toString()); }
 @Test void length() { assertEquals(3,new MainString("abc").getLength()); }
 @Test void search() { MainString value=new MainString("abba");assertEquals(1,value.indexOf('b'));assertEquals(-1,value.indexOf('z')); }
 @Test void clear() { MainString value=new MainString("abc");value.clear();assertEquals(0,value.getLength());assertEquals("",value.toString());assertThrows(IllegalArgumentException.class,()->new MainString((String)null)); }
}
