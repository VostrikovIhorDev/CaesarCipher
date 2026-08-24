import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;
public class ValidatorTest {


    private final Validator validator = new Validator();
    @Test
    void shouldValidateKeys() {
        assertAll(
                () ->assertFalse(validator.isValidKey(-1)),
                () ->assertTrue(validator.isValidKey(0)),
                () ->assertTrue(validator.isValidKey(35)),
                () -> assertFalse(validator.isValidKey(40))
        );
    }

    @Test
    void shouldReturnTrueForExistingInputFile(@TempDir Path tempDir) throws IOException {
        Path filePath =tempDir.resolve("input.txt");
        Files.createFile(filePath);
        assertTrue(validator.isValidInputFile(filePath.toString()));
    }

    @Test
    void shouldReturnFalseForNotExistingInputFile(@TempDir Path tempDir) {
        Path filePath = tempDir.resolve("notExisting.txt");
        assertFalse(validator.isValidInputFile(filePath.toString()));
    }

    @Test
    void shouldReturnTrueForOutputFileInExistingDirectory(@TempDir Path tempDir) throws IOException {
        Path filePath = tempDir.resolve("output.txt");
        Files.createFile(filePath);
        assertTrue(validator.isValidOutputFile(filePath.toString()));
    }

    @Test
    void shouldReturnFalseForOutputFileInNotExistingDirectory(){
        assertFalse(validator.isValidOutputFile("notExistingDirectory/output.txt"));
    }
}
