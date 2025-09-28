import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderExample {
    public static void main(String[] args) {
        char[] charArray = "Hello, CharArrayReader!".toCharArray();
        try (CharArrayReader car = new CharArrayReader(charArray)) {
            int content;
            while ((content = car.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
