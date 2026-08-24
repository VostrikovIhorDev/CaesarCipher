import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherTest {

    private final CaesarCipher cipher = new CaesarCipher();

    @Test
    void shouldReturnEncryptedText() {
        assertEquals("b", cipher.encrypt("a", 1));
        assertEquals("cde", cipher.encrypt("abc", 2));
    }

    @Test
    void shouldNotEncryptUnknownCharacters() {
        assertEquals("A", cipher.encrypt("A", 2));
        assertEquals("ABC", cipher.encrypt("ABC", 2));
        assertEquals("123", cipher.encrypt("123", 3));
    }

    @Test
    void shouldReturnDecryptedText() {
        assertEquals("a", cipher.decrypt("b", 1));
        assertEquals("abc", cipher.decrypt("cde", 2));
    }

    @Test
    void shouldNotDecryptUnknownCharacters() {
        assertEquals("A", cipher.decrypt("A", 2));
        assertEquals("ABC", cipher.decrypt("ABC", 2));
    }

    @Test
    void shouldHandleAlphabetBoundaryWhenEncrypting() {
        assertEquals("abc", cipher.encrypt("!? ", 3));
    }

    @Test
    void shouldHandleAlphabetBoundaryWhenDecrypting() {
        assertEquals("!? ", cipher.decrypt("abc", 3));
    }


    @Test
    void shouldReturnCorrectIfShiftIsZero() {
        assertEquals("abc", cipher.encrypt("abc", 0));
        assertEquals("abc", cipher.decrypt("abc", 0));
    }

    @Test
    void shouldCorrectEncryptAfterDecrypt() {
        assertEquals("abc", cipher.encrypt(cipher.decrypt("abc", 3), 3));
    }

    @Test
    void shouldCorrectDecryptAfterEncrypt() {
        assertEquals("abc", cipher.decrypt(cipher.encrypt("abc", 3), 3));
    }


}
