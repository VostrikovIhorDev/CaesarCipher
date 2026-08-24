import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlphabetTest {

    @Test
    void shouldReturnCorrectIndexForLetter() {
        assertEquals(0,Alphabet.getIndex('a'));
        assertEquals(1,Alphabet.getIndex('b'));
        assertEquals(25,Alphabet.getIndex('z'));
    }

    @Test
    void  shouldReturnCorrectLetterByIndex() {
        assertEquals('a',Alphabet.getLetter(0));
        assertEquals('b', Alphabet.getLetter(1));
        assertEquals('z', Alphabet.getLetter(25));
    }

    @Test
    void shouldReturnCorrectSize() {
        assertEquals(36, Alphabet.getSize());
    }

    @Test
    void shouldReturnMinusOneIfUnknownChar() {
        assertEquals(-1,Alphabet.getIndex('2'));
    }

    @Test
    void shouldThrowExceptionForNegativeIndex() {
        assertThrows(IllegalArgumentException.class, ()->Alphabet.getLetter(-1));
    }

    @Test
    void shouldThrowExceptionForTooLargeIndex() {
        assertThrows(IllegalArgumentException.class, ()->Alphabet.getLetter(1000));

    }
}
