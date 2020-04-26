import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("Dad"));
        assertTrue(palindrome.isPalindrome("DAD"));
        assertTrue(palindrome.isPalindrome("D"));
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testisoboPalindrome() {
        CharacterComparator offByOne = new OffByOne();

        assertFalse(palindrome.isPalindrome("cat", offByOne));
        assertFalse(palindrome.isPalindrome("Dad", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("flke", offByOne));
        assertTrue(palindrome.isPalindrome("1", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
    }
}
