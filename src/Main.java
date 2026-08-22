//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CaesarCipher a = new CaesarCipher();
        System.out.println( a.encrypt("а", 3));
        System.out.println( a.encrypt("я", 3));
        System.out.println(a.  encrypt("привет", 3));
        System.out.println(a.encrypt("A", 3));
        System.out.println(a.decrypt(a.encrypt("привет", 3), 3));


    }
    // большая буква , сдвиг
}