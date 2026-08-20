import java.util.HashMap;
import java.util.Map;

/**
 * Provides access to the alphabet used by the Caesar cipher.
 */
public class Alphabet {

    private static final String ALPHABET = "абвгдежзийклмнопрстуфхцчшщъыьэя.,«»\"':!? ";
    private static final Map<Character, Integer> ALPHABET_MAP = getMap();


    private static Map<Character, Integer> getMap() {
        Map<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            alphabet.put(ALPHABET.charAt(i), i);
        }
        return alphabet;
    }

    /**
     * Returns the index of specified character.
     */
    public static int getIndex(char letter) {
        return ALPHABET_MAP.getOrDefault(letter, -1);
    }

    /**
     * Returns the character at the specified index.
     */
    public static char getLetter(int index) {
        if (ALPHABET.length() - 1 < index || index < 0) {
            throw new IllegalArgumentException("Alphabet is shorter as index");
        }
        return ALPHABET.charAt(index);
    }
}
