import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class PushbackReaderExample {
    public static void main(String[] args) {
        String string = "Hello, PushbackReader!";
        try (PushbackReader pbr = new PushbackReader(new StringReader(string))) {
            int content;
            while ((content = pbr.read()) != -1) {
                if ((char) content == ',') {
                    pbr.unread('!');
                }
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
