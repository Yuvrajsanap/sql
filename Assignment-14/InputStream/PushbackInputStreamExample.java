import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;
import java.io.IOException;

public class PushbackInputStreamExample {
    public static void main(String[] args) {
        byte[] bytes = "Hello, world!".getBytes();
        try (PushbackInputStream pbis = new PushbackInputStream(new ByteArrayInputStream(bytes))) {
            int content;
            while ((content = pbis.read()) != -1) {
                if ((char) content == ',') {
                    pbis.unread('!');
                }
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
