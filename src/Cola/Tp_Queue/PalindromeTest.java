package Cola.Tp_Queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    Palindrome palindrome = new Palindrome();

    @Test
    public void isPalindrome() {

        assertEquals(true, palindrome.isPalindrome("hola aloh") );

    }
}