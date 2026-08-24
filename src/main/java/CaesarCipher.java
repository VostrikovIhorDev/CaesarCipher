/**
 * Provides encryption and decryption using the Caesar cipher.
 */
public class CaesarCipher {

    /**
     * Encrypts the given text using entry shift.
     */
    public String encrypt(String text, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int indexOfChar = Alphabet.getIndex(text.charAt(i));
             if (indexOfChar == -1) {
                stringBuilder.append(text.charAt(i));
                continue;
            }
            stringBuilder.append(Alphabet.getLetter((indexOfChar + shift) % Alphabet.getSize()));
        }
        return stringBuilder.toString();
    }

    /**
     * Decrypts the given text using entry shift.
     */
    public String decrypt(String text, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
           int  indexOfChar = Alphabet.getIndex(text.charAt(i));
            if (indexOfChar == -1) {
                stringBuilder.append(text.charAt(i));
                continue;
            }
            indexOfChar =  indexOfChar - shift >= 0 ? indexOfChar - shift : Alphabet.getSize() + indexOfChar - shift;
            stringBuilder.append(Alphabet.getLetter(indexOfChar));
        }
        return stringBuilder.toString();
    }
}
