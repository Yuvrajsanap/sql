import java.io.IOException;
import java.io.StringWriter;

public class StringWriterExample {
    public static void main(String[] args) {
        try (StringWriter sw = new StringWriter()) {
            sw.write("Hello, StringWriter!");
            String output = sw.toString();
            System.out.println("Data written: " + output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
