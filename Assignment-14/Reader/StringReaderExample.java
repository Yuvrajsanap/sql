import java.io.StringReader;
import java.io.IOException;

public class StringReaderExample {
    public static void main(String[] args) {
        String string = "Hello, StringReader!";
        try (StringReader sr = new StringReader(string)) {
            int content;
            while ((content = sr.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
