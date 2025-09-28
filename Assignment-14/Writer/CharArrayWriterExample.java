import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayWriterExample {
    public static void main(String[] args) {
        try (CharArrayWriter caw = new CharArrayWriter()) {
            caw.write("Hello, CharArrayWriter!");
            String output = caw.toString();
            System.out.println("Data written: " + output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
