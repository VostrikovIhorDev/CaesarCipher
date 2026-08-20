/**
 * Provides access to the alphabet used by the Caesar cipher.
 */
public class Alphabet {

    private static final String ALPHABET = "абвгдежзийклмнопрстуфхцчшщъыьэя.,«»\"':!? ";

    /**
     * Returns the index of specified character
     */
    public static int getIndex(char letter) {
        int index = ALPHABET.indexOf(letter);
        if (index == -1) {
            throw new IllegalArgumentException("Alphabet doesn't contain this letter");
        }
        return index;
    }

    /**
     * Returns the character at the specified index
     */
    public static char getLetter(int index) {
        if (ALPHABET.length() - 1 < index || index < 0) {
            throw new IllegalArgumentException("Alphabet is shorter as index");
        }
        return ALPHABET.charAt(index);
    }
}
