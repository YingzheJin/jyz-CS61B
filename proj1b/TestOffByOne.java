import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testequalChars() {
    assertFalse(offByOne.equalChars('a', 'e'));
    assertFalse(offByOne.equalChars('z', 'a'));
    assertFalse(offByOne.equalChars('a', 'a'));
    assertTrue(offByOne.equalChars('r', 'q'));
    assertTrue(offByOne.equalChars('a', 'b'));
    assertTrue(offByOne.equalChars('&', '%'));
    }
}
