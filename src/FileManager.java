import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class reads from file than encrypt/decrypt and write into another.
 */
public class FileManager {

    private final CaesarCipher cipher;

    public FileManager(CaesarCipher cipher) {
        this.cipher = cipher;
    }

    /**
     * Read, encrypt, write.
     */
    public void encryptFile(String in, String out, int shift) throws IOException {
        Path inPath = Path.of(in);
        Path outPath = Path.of(out);
        try (BufferedReader bufferedReader = Files.newBufferedReader(inPath);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(outPath)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(cipher.encrypt(line, shift));
                bufferedWriter.newLine();
            }
        }
    }

    /**
     * Read, decrypt, write.
     */
    public void decryptFile(String in, String out, int shift) throws IOException {
        Path inPath = Path.of(in);
        Path outPath = Path.of(out);
        try (BufferedReader bufferedReader = Files.newBufferedReader(inPath);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(outPath)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(cipher.decrypt(line, shift));
                bufferedWriter.newLine();
            }
        }
    }
}
