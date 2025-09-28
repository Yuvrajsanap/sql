import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamExample {
    public static void main(String[] args) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            String data = "Hello, ByteArrayOutputStream!";
            baos.write(data.getBytes());
            String output = baos.toString();
            System.out.println("Data written: " + output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
