import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamExample {
    public static void main(String[] args) {
        byte[] byteArray = "Hello, world!".getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);

        int data;
        while ((data = bais.read()) != -1) {
            System.out.print((char) data);
        }
    }
}
