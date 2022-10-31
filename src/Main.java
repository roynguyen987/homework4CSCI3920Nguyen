import edu.ucdenver.morse.Morse;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Morse helloMorse = new Morse();
        System.out.println(helloMorse.decode("hello world"));
        System.out.println(helloMorse.encode("....=..=...--="));
    }

}