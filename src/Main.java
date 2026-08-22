import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager(new CaesarCipher());
        Validator validator = new Validator();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter path of input file");
            String inputPath = scanner.nextLine();
            System.out.println("Enter path of output file");
            String outputPath = scanner.nextLine();
            System.out.println("enter the key");
            int key = scanner.nextInt();
            if (!validator.isValidInputFile(inputPath)) {
                System.out.println("Wrong input path");
                return;
            }
            if (!validator.isValidOutputFile(outputPath)) {
                System.out.println("Wrong output path");
                return;
            }
            if (!validator.isValidKey(key)) {
                System.out.println("Wrong key");
                return;
            }

            System.out.println("Choose 1 for encrypt or 2 for decrypt the text");
            int mode = scanner.nextInt();

            try {
                switch (mode) {
                    case 1 -> {
                        fileManager.encryptFile(inputPath, outputPath, key);
                    }
                    case 2 -> {
                        fileManager.decryptFile(inputPath, outputPath, key);
                    }
                    default -> System.out.println("Wrong mode");
                }
            } catch (IOException e) {
                System.out.println("Error while working with file " + e.getMessage());
            }
        }
    }
}