import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class makes data's validating.
 */
public class Validator {

    public boolean isValidKey(int shift) {
        if (shift >=0 && shift < Alphabet.getSize()) {
            return true;
        }
        return false;
    }

    public boolean isValidInputFile(String in) {
        Path path = Path.of(in);
        return Files.exists(path) && Files.isRegularFile(path);
    }

    public boolean isValidOutputFile(String out) {
        Path path = Path.of(out);
        if (path.getParent() == null) {
            return true;
        }
        return Files.exists(path.getParent());
    }
}
