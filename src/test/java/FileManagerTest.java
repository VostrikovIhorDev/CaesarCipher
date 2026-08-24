import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileManagerTest {
    private final CaesarCipher cipher = new CaesarCipher();
    private final FileManager fileManager = new FileManager(cipher);

    @Test
    void shouldDecryptFileCorrect(@TempDir Path tempDir) throws IOException {
        Path inputFilePath = tempDir.resolve("inputTest.txt");
        Path outputFilePath = tempDir.resolve("outputTest.txt");
        Files.writeString(inputFilePath,"ghi\ndef\nabc");
        fileManager.decryptFile(inputFilePath.toString(),outputFilePath.toString(),3);
        String line = Files.readString(outputFilePath);
        assertEquals("def" + System.lineSeparator() + "abc" + System.lineSeparator() + "!? " + System.lineSeparator(), line);
    }

    @Test
    void shouldEncryptFileCorrect(@TempDir Path tempDir) throws IOException {
        Path inputFilePath = tempDir.resolve("inputTest.txt");
        Path outputFilePath = tempDir.resolve("outputTest.txt");
        Files.writeString(inputFilePath, "!? \nabc\ndef");
        fileManager.encryptFile(inputFilePath.toString(),outputFilePath.toString(),3);
        String line = Files.readString(outputFilePath);
        assertEquals("abc" + System.lineSeparator() + "def" + System.lineSeparator() + "ghi" + System.lineSeparator(),line);
    }

    @Test
    void shouldThrowExceptionWhenEncryptFileNotExist(@TempDir Path tempDir) {
        Path inputFilePath = tempDir.resolve("inputTest.txt");
        Path outputFilePath = tempDir.resolve("outputTest.txt");
        assertThrows(IOException.class, () ->fileManager.encryptFile(inputFilePath.toString(),outputFilePath.toString(),3));
    }

    @Test
    void shouldThrowExceptionWhenDecryptFileNotExist(@TempDir Path tempDir) {
        Path inputFilePath = tempDir.resolve("inputTest.txt");
        Path outputFilePath = tempDir.resolve("outputTest.txt");
        assertThrows(IOException.class, () ->fileManager.decryptFile(inputFilePath.toString(),outputFilePath.toString(),3));
    }
}
